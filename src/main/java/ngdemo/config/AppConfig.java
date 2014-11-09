package ngdemo.config;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.DomaAbstractConfig;
import org.seasar.doma.jdbc.SimpleDataSource;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.seasar.doma.jdbc.tx.LocalTransaction;
import org.seasar.doma.jdbc.tx.LocalTransactionalDataSource;

public class AppConfig extends DomaAbstractConfig {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://54.64.148.100:3306/myappdb?useUnicode=true&characterEncoding=utf8&characterSetResults=UTF-8";
    public static final String USER = "kawamoto";
    public static final String PASSWORD = "passw0rd";

    protected static final LocalTransactionalDataSource dataSource = createDataSource();

    protected static final Dialect dialect = new MysqlDialect();
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    protected static LocalTransactionalDataSource createDataSource() {
        SimpleDataSource dataSource = new SimpleDataSource();
//        dataSource.setUrl("jdbc:mysql://54.64.148.100:3306/imaple?characterEncoding=UTF-8");
        dataSource.setUrl(URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return new LocalTransactionalDataSource(dataSource);
    }

    public static LocalTransaction getLocalTransaction() {
        return dataSource.getLocalTransaction(defaultJdbcLogger);
    }


}

