package com.example.kpp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;

import com.example.kpp.doma.DomaConfig;

public class DBunitSetup {

    public static String xlsFile;

    /** データベースのバックアップ */
    private File backupFile;

    private IDatabaseTester databaseTester;

    /**
    * 各テストメソッドの事前処理
    * 本メソッドでテストで使用するDBのバックアップを行うこと
    *
    * @see junit.framework.TestCase#setUp()
    */
    @Before
    public void setUp() throws Exception {
        System.out.println("setup");
        databaseTester = new JdbcDatabaseTester(
                DomaConfig.DRIVER,
                DomaConfig.URL,
                DomaConfig.USER,
                DomaConfig.PASSWORD
        );

        // データベースの内容を事前にバックアップ
        QueryDataSet partialDataSet = new QueryDataSet(databaseTester.getConnection());
        // バックアップを取りたいテーブルを列挙
        partialDataSet.addTable("HEALTH_INFO");

        // バックアップ内容を保持するファイルを生成
        backupFile = File.createTempFile("testdb_bak", ".xml");
        // テーブルの内容をファイルに書き込む
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream(backupFile));

        String filename2 = DBunitSetup.class.getClassLoader().getResource(xlsFile).getPath();
        IDataSet dataSet2 = new FlatXmlDataSetBuilder().build(
                new FileInputStream(new File(filename2)));
        databaseTester.setDataSet(dataSet2);

        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.onSetup();
    }

    /**
    * 各テストメソッドの事後処理
    * 本メソッドでsetUpメソッドでバックアップしたファイルから
    * テストで使用するDBのリストアを行うこと
    *
    * @see junit.framework.TestCase#tearDown()
    */
    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
//        backupFile = new File("C:\\Users\\kawamoto\\AppData\\Local\\Temp\\testdb_bak8392156484774381651.xml");
        // バックアップファイルから戻す
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(backupFile);
        databaseTester.setDataSet(
                dataSet
        );
        backupFile = null;

        databaseTester.setTearDownOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.onTearDown();
    }
}
