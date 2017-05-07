package dal;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;

public class DbHelper {
    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", DbConfiguration.USERNAME);
            properties.setProperty("password", DbConfiguration.PASSWORD);
            properties.setProperty("MaxPooledStatements", DbConfiguration.MAX_POOL);
        }
        return properties;
    }

    // connect database
    public Connection connect() {
        if (connection == null) {
            try {
                Class.forName(DbConfiguration.DATABASE_DRIVER);
                connection = DriverManager.getConnection(DbConfiguration.DATABASE_URL, getProperties());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // disconnect database
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
