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
import onlineUpoznavanje.models.Invite;

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
                                    String firstName=resultSet.getString("firstName");
                                    String lastName=resultSet.getString("lastName");
                                    User user = new User();
                                    user.setUsername(username);
                                    user.setEmail(email);
                                   if(firstName==null) 
                                   {  
                                    user.setFirstName("  /");
                                    }
                                   else
                                   {
                                	user.setFirstName(firstName);}
                                   
                                   if(lastName==null) 
                                   {   
                                    user.setLastName("  /");
                                    }
                                   else
                                   {user.setLastName(lastName); }
                                    
                             users.add(user);
                                    
                            }
                            return users;
                    } catch (Exception e) {
                            throw e;
                    }
            }
                
                public List<User> readUsersButMe(int data) throws Exception {
                    try {
                    	 statement = connect.createStatement();
                         PreparedStatement statement = connect.prepareStatement("select * from " + database + ".user WHERE id!=?");
                         statement.setInt(1, data);
                         resultSet = statement.executeQuery();
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
                
                public List<Invite> readInvites(int data) throws Exception {
                    try {
                    	
                            statement = connect.createStatement();
                            PreparedStatement statement = connect.prepareStatement("select * from " + database + ".invites WHERE idOfInvitee=?");
                            statement.setInt(1, data);
                            resultSet = statement.executeQuery();
                            List<Invite> invites = new ArrayList<Invite>();
                            while (resultSet.next()) {
                            		String usernameOfInvitee = resultSet.getString("usernameOfInvitee");
                                    Integer idOfInvitee = resultSet.getInt("idOfInvitee");
                                    String usernameOfInviter = resultSet.getString("usernameOfInviter");
                                    Integer idOfInviter = resultSet.getInt("idOfInviter");
                                    Invite invite = new Invite();
                                    invite.setIdOfInvitee(idOfInvitee);
                                    invite.setIdOfInviter(idOfInviter);
                                    invite.setUsernameOfInviter(usernameOfInviter);
                                    invite.setUsernameOfInvitee(usernameOfInvitee);
                                    invites.add(invite);
                                    
                            }
                            return invites;
                    } catch (Exception e) {
                            throw e;
                    }
                	}
                
                public List<User> searchUsers(String searchTerm) throws Exception {
                    try {
                        statement = connect.createStatement();

                    	PreparedStatement statement = connect.prepareStatement("select * from " + database + ".user WHERE username like ?");
                    	statement.setString(1, "%" + searchTerm + "%");
                        resultSet = statement.executeQuery();
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
                
                public void storeUser(String username, String password, String email) throws Exception {
                    try {
                    		
                            statement = connect.createStatement();
                            PreparedStatement statement = connect.prepareStatement("INSERT INTO " + database + ".user (username, password, email) VALUES ( ?, ?, ?)");
                            statement.setString(1, username);
                            statement.setString(2, password);
                            statement.setString(3, email);
                            statement.execute();
                    } catch (Exception e) {
                            throw e;
                    }
                }
                
                public void inviteUser(String data) throws Exception {
                    try {
                        JSONObject jsonObject=new JSONObject();

                    	try
                        {
                            String query=data;
                            String queryArray[]=query.split("&");

                            String id[]=queryArray[0].split("=");
                            String usernameInviter[]=queryArray[1].split("=");
                            String usernameInvitee[]=queryArray[2].split("=");
                            jsonObject.put(id[0],id[1]);
                            jsonObject.put(usernameInviter[0],usernameInviter[1]);
                            jsonObject.put(usernameInvitee[0],usernameInvitee[1]);

                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    		String usernameOfInvitee = (String) jsonObject.get("usernameOfInvitee");
                    		String usernameOfInviter = (String) jsonObject.get("usernameOfInviter");
                    		String idOfInviter = (String) jsonObject.get("idOfInviter");
                    		
                            statement = connect.createStatement();
                            PreparedStatement statement = connect.prepareStatement("SELECT * FROM " + database + ".user WHERE username = ?");
                            statement.setString(1, usernameOfInvitee);
                            resultSet = statement.executeQuery();
                            String idOfInvitee = null;
                            while (resultSet.next()) {
                            	idOfInvitee = resultSet.getString("id");
                            	usernameOfInvitee = resultSet.getString("username");
                                
                        }
                            statement = connect.prepareStatement("SELECT * FROM " + database + ".invites WHERE idOfInviter=? AND idOfInvitee=?");
                            statement.setString(1, idOfInviter);
                            statement.setString(2, idOfInvitee);
                            resultSet = statement.executeQuery();
                            String flag = null;
                            while (resultSet.next()) {
                            	flag = "Test";
                            }
                            if(flag == null) {
                            statement = connect.prepareStatement("INSERT INTO " + database + ".invites ( idOfInvitee, usernameOfInvitee, idOfInviter, usernameOfInviter) VALUES ( ?, ?, ?, ?)");
                            statement.setString(1, idOfInvitee);
                            statement.setString(2, usernameOfInvitee);
                            statement.setString(3, idOfInviter);
                            statement.setString(4, usernameOfInviter);
                            statement.execute();
                            }
                    } catch (Exception e) {
                            throw e;
                    }
                }
                
                public User searchUserForLogin(String username, String password) throws Exception {
                    try {
                        statement = connect.createStatement();
                    	PreparedStatement statement = connect.prepareStatement("select * from " + database + ".user WHERE username=? AND password=?");
                    	statement.setString(1,username);
                    	statement.setString(2,password);
                        resultSet = statement.executeQuery();
                        Integer _id = null;
                        String _username = null;
                        String _password = null;
                        String _firstName = null;
                        String _lastName = null;
                        String _email = null;
                        String _gender = null;
                        String _zanimanje = null;
                        String _omeni = null;
                        String _interesovanja = null;
                        String _lokacija = null;
                       // Date _datumRodjenja = null;
                        Boolean _isAdmin = null;
     
                        while (resultSet.next()) {
                        	_id = resultSet.getInt("id");
                        	_username = resultSet.getString("username");
                            _password = resultSet.getString("password");
                        	_firstName = resultSet.getString("firstName");
                            _lastName = resultSet.getString("lastName");
                            _email = resultSet.getString("email");
                            _gender = resultSet.getString("gender");
                            _zanimanje = resultSet.getString("zanimanje");
                            _omeni = resultSet.getString("omeni");
                            _interesovanja = resultSet.getString("interesovanja");
                            _lokacija = resultSet.getString("location");
                            _isAdmin = resultSet.getBoolean("isAdmin");
                           // _datumRodjenja = resultSet.getDate("dateOfBirth");
                        }
                       // user.setDateOfBirth(_datumRodjenja);
                        User user = new User();
                        if(_username != null && _password != null){
                        	
                        	
                        	user.setUsername(_username);
                            user.setPassword(_password);
                            user.setId(_id);
                            user.setFirstName(_firstName);
                            user.setLastName(_lastName);
                            user.setEmail(_email);
                            user.setGender(_gender);
                            user.setZanimanje(_zanimanje);
                            user.setOmeni(_omeni);
                            user.setInteresovanja(_interesovanja);
                            user.setLocation(_lokacija);
                            user.setIsAdmin(_isAdmin);
                            
                            
                        }
                        else
                        	return null;
                        return user;

                    } catch (Exception e) {
                            throw e;
                    }
            }
                
                public void changePasswordDB(String data) throws Exception {
                	
                 	try {

                	 JSONObject jsonObject=new JSONObject();
                    	try {
                    		
                    		String query=data;
                            String queryArray[]=query.split("&");
                            String id[]=queryArray[0].split("=");
                            String password[]=queryArray[1].split("=");
                            jsonObject.put(id[0],id[1]);
                            jsonObject.put(password[0],password[1]);
     
                    	
                    	}
                    	catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    	
                    	String _username = (String) jsonObject.get("username");
                		String _password = (String) jsonObject.get("password");
                    	statement = connect.createStatement();
                    	PreparedStatement statement = connect.prepareStatement("update " + database + ".user SET password=? WHERE username=?");
                    	statement.setString(1,_password);
                    	statement.setString(2,_username);
                    	statement.execute();
                    	
                      }
                 	catch (Exception e) {
                        throw e;
                     }
                  }
                
public void editKorisnikDB(String data) throws Exception {
                	
                 	try {

                	 JSONObject jsonObject=new JSONObject();
                    	try {
                    		
                    		String query=data;
                            String queryArray[]=query.split("&");
                            String ime[]=queryArray[0].split("=");
                            String prezime[]=queryArray[1].split("=");
                            String zanimanje[]=queryArray[2].split("=");
                            String grad[]=queryArray[3].split("=");
                            String email[]=queryArray[4].split("=");
                            String interesovanje[]=queryArray[5].split("=");
                            String omeni[]=queryArray[6].split("=");
                            String username[]=queryArray[7].split("=");

                            jsonObject.put(ime[0],ime[1]);
                            jsonObject.put(prezime[0],prezime[1]);
                            jsonObject.put(zanimanje[0],zanimanje[1]);
                            jsonObject.put(grad[0],grad[1]);
                            jsonObject.put(email[0],email[1]);
                            jsonObject.put(interesovanje[0], interesovanje[1]);
                            jsonObject.put(omeni[0], omeni[1]);
                            jsonObject.put(username[0], username[1]); 


                    	}
                    	catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    	
                    	String _ime = (String) jsonObject.get("ime");
                		String _prezime = (String) jsonObject.get("prezime");
                		String _zanimanje = (String) jsonObject.get("zanimanje");
                		String _grad = (String) jsonObject.get("grad");
                		String _email = (String) jsonObject.get("email");
                		String _interesovanje = (String) jsonObject.get("interesovanje");
                		String _omeni = (String) jsonObject.get("omeni");
                		String _username = (String) jsonObject.get("username");
                		System.out.println("1 " + _ime);
                		String _ime_ = _ime.replace("%20"," ");
                		String _prezime_ = _prezime.replace("%20"," ");
                		String _zanimanje_ = _zanimanje.replace("%20"," ");
                		String _grad_ = _grad.replace("%20"," ");
                		String _email_ = _email.replace("%40","@");
                		String _interesovanje_ = _interesovanje.replace("%20"," ");
                		String _omeni_ = _omeni.replace("%20"," ");
                		String _username_ = _username.replace("%20"," ");
                		System.out.println("2 " +_email_);
                		
                		
                		
                		statement = connect.createStatement();
                    	PreparedStatement statement = connect.prepareStatement("update " + database + ".user SET firstName=?, lastName=?, email=?, location=?, omeni=?, zanimanje=?, interesovanja=? WHERE username=?");
                    	statement.setString(1,_ime_);
                    	statement.setString(2,_prezime_);
                    	statement.setString(3,_email_);
                    	statement.setString(4,_grad_);
                    	statement.setString(5,_omeni_);
                    	statement.setString(6,_zanimanje_);
                    	statement.setString(7,_interesovanje_);
                    	statement.setString(8,_username_);
                    	statement.execute();
                      }
                 	catch (Exception e) {
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


