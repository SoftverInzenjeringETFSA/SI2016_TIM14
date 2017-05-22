package onlineUpoznavanje.db;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.*;
import org.json.simple.parser.JSONParser;

import onlineUpoznavanje.models.User;

        public class dbActions {

                private Connection connect = null;
                private Statement statement = null;
                private PreparedStatement preparedStatement = null;
                private ResultSet resultSet = null;

                final private String host = "localhost:3306";
                final private String user = "EtfSI2016";
                final private String passwd = "2016SIEtf";
                final private String database = "onlinemeet";

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

                public List<User> readUsers() throws Exception {
                        try {
                                statement = connect.createStatement();
                                resultSet = statement
                                                .executeQuery("select * from " + database + ".user");
                                List<User> users = new ArrayList<User>();
                                while (resultSet.next()) {
                                        String firstName = resultSet.getString("firstName");
                                        String lastName = resultSet.getString("lastName");
                                        User user = new User();
                                        user.setFirstName(firstName);
                                        user.setLastName(lastName);
                                        users.add(user);
                                        System.out.println(String.format(
                                                        "firstname: %5s lastname: %5s  ", firstName, lastName));
                                }
                                return users;
                        } catch (Exception e) {
                                throw e;
                        }
                }
                
                public void storeUser(String username, String password, String email) throws Exception {
                    try {
                    		
                            statement = connect.createStatement();
                            /*resultSet = statement
                                            .executeQuery("INSERT INTO" + database + ".user");
                             `onlinemeet`.`user` (`username`, `password`, `firstName`, `lastName`, `email`) VALUES ('1123456', 'SISUCK', 'Andrej', 'Milojevic', 'amilojevic@123212.com');*/
                             PreparedStatement statement = connect.prepareStatement("INSERT INTO " + database + ".user (username, password, email) VALUES ( ?, ?, ?)");
                             statement.setString(1, username);
                             statement.setString(2, password);
                             statement.setString(3, email);
                             statement.execute();
                    } catch (Exception e) {
                            throw e;
                    }
                }
                


                // You need to close the resultSet
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


