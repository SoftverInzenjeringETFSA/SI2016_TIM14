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

                public List<User> readUsers() throws Exception {
                        try {
                                statement = connect.createStatement();
                                resultSet = statement
                                                .executeQuery("select * from " + database + ".user");
                                List<User> users = new ArrayList<User>();
                                while (resultSet.next()) {
                                        String username = resultSet.getString("username");
                                        String email = resultSet.getString("email");
                                        User user = new User();
                                        user.setUsername(username);
                                        user.setEmail(email);
                                        users.add(user);
                                        
                                }
                                return users;
                        } catch (Exception e) {
                                throw e;
                        }
                }
                
                public List<User> searchUserPerEmail(String emailToSearchFor) throws Exception {
                    try {
                    	emailToSearchFor = emailToSearchFor.substring(0, emailToSearchFor.length()-1);
                        System.out.println(emailToSearchFor);

                    	/*SELECT * FROM onlinemeet.user where email like '%and%';*/
                            /*statement = connect.createStatement();
                            resultSet = statement
                                            .executeQuery("select * from " + database + ".user");*/
                        statement = connect.createStatement();

                    	PreparedStatement statement = connect.prepareStatement("select * from " + database + ".user WHERE email like ?");
                    	statement.setString(1, "%" + emailToSearchFor + "%");
                        resultSet = statement.executeQuery();
                            List<User> users = new ArrayList<User>();
                            //System.out.print("Hellp");
                            while (resultSet.next()) {
                            	
                                //System.out.print("Hell2");
                                    String username = resultSet.getString("username");
                                    String email = resultSet.getString("email");
                                    System.out.println(email);

                                    User user = new User();
                                    user.setUsername(username);
                                    user.setEmail(email);
                                    users.add(user);
                                    
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
                
                public void inviteUser(String email) throws Exception {
                    try {
                    		System.out.println(email);
                            statement = connect.createStatement();
                            /*resultSet = statement
                                            .executeQuery("INSERT INTO" + database + ".user");
                             `onlinemeet`.`user` (`username`, `password`, `firstName`, `lastName`, `email`) VALUES ('1123456', 'SISUCK', 'Andrej', 'Milojevic', 'amilojevic@123212.com');*/
                            PreparedStatement statement = connect.prepareStatement("SELECT * FROM " + database + ".user WHERE email = ?");
                            statement.setString(1, email);
                            resultSet = statement.executeQuery();
                            String idOfInvitee = null;
                            String usernameOfInvitee = null;
                            while (resultSet.next()) {
                            	idOfInvitee = resultSet.getString("id");
                            	usernameOfInvitee = resultSet.getString("username");
                                
                        }
                           
                            /*SELECT * FROM onlinemeet.user where email like '%and%';*/
                            statement = connect.prepareStatement("INSERT INTO " + database + ".invites ( idOfInvitee, usernameOfInvitee) VALUES ( ?, ?)");
                            statement.setString(1, idOfInvitee);
                            statement.setString(2, usernameOfInvitee);
                            statement.execute();
                    } catch (Exception e) {
                            throw e;
                    }
                }
                
                public User searchUserForLogin(String username, String password) throws Exception {
                    try {

                        statement = connect.createStatement();
                        //System.out.println(username + " 1.1 " + password);
                    	PreparedStatement statement = connect.prepareStatement("select * from " + database + ".user WHERE username=? AND password=?");
                    	statement.setString(1,username);
                    	statement.setString(2,password);
                        resultSet = statement.executeQuery();
    
                        String _username = null;
                        String _password = null;
                        while (resultSet.next()) {
                         _username = resultSet.getString("username");
                          _password = resultSet.getString("password");    
                        }
                        
                        //System.out.println(_username + " 1.5 " + _password);
                        if(_username != null && _password != null){
                        	
                        	User user = new User();
                            user.setUsername(_username);
                            user.setPassword(_password);
                            return user;
                        }
                        else
                        	return null;

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


