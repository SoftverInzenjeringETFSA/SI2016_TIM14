package onlineUpoznavanje.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbActionsGrupe {
	 private Connection connect = null;
     private Statement statement = null;
     private PreparedStatement preparedStatement = null;
     private ResultSet resultSet = null;

     final private String host = "localhost:3306";
     final private String user = "EtfSI2016";
     final private String passwd = "2016SIEtf";
     final private String database = "tim14";

     public void connectToDB() throws Exception {
             try {
                     // This will load the MySQL driver, each DB has its own driver
                     Class.forName("com.mysql.jdbc.Driver");

                     // Setup the connection with the DB
                     connect = DriverManager.getConnection("jdbc:mysql://" + host + "/"
                                     + database + "?" + "user=" + user + "&password=" + passwd);

             } catch (Exception e) {
                     throw e;
             }
     }
     
     
     
     
     
     
     
     
     public void close() {
         try {
                 if (resultSet != null) {
                         resultSet.close();
                 }

                 if (statement != null) {
                         statement.close();
                 }

                 if (connect != null) {
                         connect.close();
                 }
         } catch (Exception e) {

         }
     }
     
     
     
}
