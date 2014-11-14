package com.example.kpp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
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

        /*-
         * データベースの内容を事前にバックアップ
         */
        QueryDataSet partialDataSet = new QueryDataSet(databaseTester.getConnection());
        // バックアップを取りたいテーブルを列挙
        partialDataSet.addTable("HEALTH_INFO");

        // バックアップ内容を保持するファイルを生成
        backupFile = File.createTempFile("testdb_bak", ".xml");
        // テーブルの内容をファイルに書き込む
        FlatXmlDataSet.write(partialDataSet, new FileOutputStream(backupFile));

//        DataFileLoader loader = new FlatXmlDataFileLoader();
        String filename2 = DBunitSetup.class.getClassLoader().getResource(xlsFile).getPath();
        IDataSet dataSet2 = new FlatXmlDataSetBuilder().build(
                new FileInputStream(new File(filename2)));
        databaseTester.setDataSet(
//                loader.load(xlsFile)
                dataSet2
        );

        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.onSetup();

        //現状のDBバックアップを取得
        IDatabaseConnection connection = null;
        Connection conn = null;

//        try {
//            // Connectionの取得
//            AppConfig.getLocalTransaction().begin();
//            conn = (new AppConfig()).getDataSource().getConnection();
//            // IDatabaseConnectionの作成
//            connection = new DatabaseConnection(conn);
//
//            /*-
//             * データベースの内容を事前にバックアップ
//             */
//            QueryDataSet partialDataSet = new QueryDataSet(connection);
//
//            // バックアップを取りたいテーブルを列挙
//            partialDataSet.addTable("HEALTH_INFO");
//
//            // バックアップ内容を保持するファイルを生成
//            backupFile = File.createTempFile("testdb_bak", ".xml");
//            // テーブルの内容をファイルに書き込む
//            FlatXmlDataSet.write(partialDataSet, new FileOutputStream(backupFile));
//
//            /*-
//             * データの積み込み
//             */
//            String filename = DBunitSetup.class.getClassLoader().getResource(xlsFile).getPath();
////            IDataSet dataSet = new XlsDataSet(new File(filename));
//            IDataSet dataSet = new XmlDataSet(new FileReader(new File(filename)));
//            new InsertIdentityOperation(DatabaseOperation.CLEAN_INSERT).execute(connection, dataSet);
//
////            // データセットの取得
////            IDataSet dataset = new FlatXmlDataSetBuilder()
////                    .build(new FileInputStream(
////                            "src/test/resource/jp/co/net/genesis/service/商品_登録数３.xml"));
////            DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);
//
////            /*-
////             * データの積み込み
////             */
////            String filename = DBTestStep.class.getClassLoader().getResource(xlsFile).getPath();
////            IDataSet dataSet = new XlsDataSet(new File(filename));
////            new InsertIdentityOperation(DatabaseOperation.CLEAN_INSERT).execute(conn, dataSet);
//
//            // コミットさせたい場合はコミット
//            connection.getConnection().commit();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            if (connection != null) {
//                connection.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
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
        // バックアップファイルから戻す
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(backupFile);
        databaseTester.setDataSet(
                dataSet
        );
        backupFile = null;

        databaseTester.setTearDownOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.onTearDown();

//        // テストの後かたづけを行う。
//        // 対象テーブルのバックアップデータをリストアする。
//        IDatabaseConnection connection =null;
//        Connection conn = null;
//
//        try {
//            // Connectionの取得
//            AppConfig.getLocalTransaction().begin();
//            conn = (new AppConfig()).getDataSource().getConnection();
//            // IDatabaseConnectionの作成
//            connection = new DatabaseConnection(conn);
//
//            // バックアップファイルから戻す
//            IDataSet dataSet = new FlatXmlDataSetBuilder().build(backupFile);
//            new InsertIdentityOperation(DatabaseOperation.CLEAN_INSERT).execute(connection, dataSet);
//            backupFile = null;
//
//            // 必要に応じてコミット
//            connection.getConnection().commit();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            if (connection != null) {
//                connection.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
    }
}
