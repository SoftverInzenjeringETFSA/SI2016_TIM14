package onlineUpoznavanje.db;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.*;
import org.json.simple.parser.JSONParser;

import onlineUpoznavanje.models.User;
import onlineUpoznavanje.models.Invite;
import onlineUpoznavanje.models.PrivateMessage;
import onlineUpoznavanje.models.Grupa;
import onlineUpoznavanje.models.SystemMessage;

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
                                    Integer id = resultSet.getInt("id"); 
                                    User user = new User();
                                    user.setUsername(username);
                                    user.setEmail(email);
                                    user.setId(id);
                                    
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
                            System.out.println(users.size());
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
                             String firstName=resultSet.getString("firstName");
                             String lastName=resultSet.getString("lastName");
                             Integer id = resultSet.getInt("id"); 
                             User user = new User();
                             user.setUsername(username);
                             user.setEmail(email);
                             user.setId(id);
                             
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
                
                public List<SystemMessage> findSystemMessages(int data) throws Exception {
                    try {
                    	
                            statement = connect.createStatement();
                            PreparedStatement statement = connect.prepareStatement("select * from " + database + ".ServerMessage WHERE idOfInvitee=? OR idOfInviter=?");
                            statement.setInt(1, data);
                            statement.setInt(2, data);
                            resultSet = statement.executeQuery();
                            List<SystemMessage> systemMessages = new ArrayList<SystemMessage>();
                            while (resultSet.next()) {
                            		String usernameOfInvitee = resultSet.getString("usernameOfInvitee");
                                    String idOfInvitee = resultSet.getString("idOfInvitee");
                                    String usernameOfInviter = resultSet.getString("usernameOfInviter");
                                    String idOfInviter = resultSet.getString("idOfInviter");
                                    String message = resultSet.getString("message");
                                    Timestamp ts = resultSet.getTimestamp("date");
                                    Date date = new Date();
                                    date.setTime(ts.getTime());
                                    String formattedDate = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss").format(date);
                                    SystemMessage systemMessage = new SystemMessage();
                                    systemMessage.setIdOfInvitee(idOfInvitee);
                                    systemMessage.setIdOfInviter(idOfInviter);
                                    systemMessage.setUsernameOfInviter(usernameOfInviter);
                                    systemMessage.setUsernameOfInvitee(usernameOfInvitee);
                                    systemMessage.setMessage(message);
                                    systemMessage.setDate(formattedDate);
                                    systemMessages.add(systemMessage);
                                    
                            }
                            return systemMessages;
                    } catch (Exception e) {
                            throw e;
                    }
                	}
                
                
                public void declineInvite(String data) throws Exception {
                    try {
                   	 JSONObject jsonObject=new JSONObject();

                    	try
                        {
                            String query=data;
                            String queryArray[]=query.split("&");
                            String idOfInviter[]=queryArray[0].split("=");
                            String idOfInvitee[]=queryArray[1].split("=");
                            jsonObject.put(idOfInviter[0],idOfInviter[1]);
                            jsonObject.put(idOfInvitee[0],idOfInvitee[1]);

                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    		String idOfInviter = (String) jsonObject.get("idOfInviter");
                    		String idOfInvitee = (String) jsonObject.get("idOfInvitee");
                    		String usernameOfInviter = "";
                    		String usernameOfInvitee = "";
                    		
                        statement = connect.createStatement();
                        PreparedStatement statement = connect.prepareStatement("select * from " + database + ".invites WHERE idOfInvitee=? AND idOfInviter=?");
                        statement.setString(1, idOfInvitee);
                    	statement.setString(2, idOfInviter);
                        resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                        		usernameOfInvitee = resultSet.getString("usernameOfInvitee");
                                usernameOfInviter = resultSet.getString("usernameOfInviter");
                                
                        }
                        if(usernameOfInvitee != "") {
                    	statement = connect.prepareStatement("DELETE FROM " + database + ".invites WHERE idOfInvitee=? AND idOfInviter=?");
                    	statement.setString(1, idOfInvitee);
                    	statement.setString(2, idOfInviter);
                    	statement.execute();
                    	String message = ("User " + usernameOfInvitee + " declined an invite from the user " + usernameOfInviter);
                       	statement = connect.prepareStatement("INSERT INTO " + database + ".ServerMessage (idOfInvitee, usernameOfInvitee, idOfInviter, usernameOfInviter, message) VALUES (?, ?, ?, ?, ?)");
                       	statement.setString(1, idOfInvitee);
                   		statement.setString(2, usernameOfInvitee);
                   		statement.setString(3, idOfInviter);
                    	statement.setString(4, usernameOfInviter);
                    	statement.setString(5, message);
                    	statement.execute();
                        }
                    } catch (Exception e) {
                            throw e;
                    }
                }
                
                public void acceptInvite(String data) throws Exception {
                    try {
                   	 JSONObject jsonObject=new JSONObject();

                    	try
                        {
                            String query=data;
                            String queryArray[]=query.split("&");
                            String idOfInviter[]=queryArray[0].split("=");
                            String idOfInvitee[]=queryArray[1].split("=");
                            jsonObject.put(idOfInviter[0],idOfInviter[1]);
                            jsonObject.put(idOfInvitee[0],idOfInvitee[1]);

                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    		String idOfInviter = (String) jsonObject.get("idOfInviter");
                    		String idOfInvitee = (String) jsonObject.get("idOfInvitee");
                    		String usernameOfInviter = "";
                    		String usernameOfInvitee = "";
                    		
                        statement = connect.createStatement();
                        PreparedStatement statement = connect.prepareStatement("select * from " + database + ".invites WHERE idOfInvitee=? AND idOfInviter=?");
                        statement.setString(1, idOfInvitee);
                    	statement.setString(2, idOfInviter);
                        resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                        		usernameOfInvitee = resultSet.getString("usernameOfInvitee");
                                usernameOfInviter = resultSet.getString("usernameOfInviter");
                                
                        }
                        if(usernameOfInvitee != "") {
                    	statement = connect.prepareStatement("DELETE FROM " + database + ".invites WHERE idOfInvitee=? AND idOfInviter=?");
                    	statement.setString(1, idOfInvitee);
                    	statement.setString(2, idOfInviter);
                    	statement.execute();
                    	String message = ("User " + usernameOfInvitee + " accepted an invite from the user " + usernameOfInviter);
                       	statement = connect.prepareStatement("INSERT INTO " + database + ".ServerMessage (idOfInvitee, usernameOfInvitee, idOfInviter, usernameOfInviter, message) VALUES (?, ?, ?, ?, ?)");
                       	statement.setString(1, idOfInvitee);
                   		statement.setString(2, usernameOfInvitee);
                   		statement.setString(3, idOfInviter);
                    	statement.setString(4, usernameOfInviter);
                    	statement.setString(5, message);
                    	statement.execute();
                        }
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
                		String _ime_ = _ime.replace("%20"," ");
                		String _prezime_ = _prezime.replace("%20"," ");
                		String _zanimanje_ = _zanimanje.replace("%20"," ");
                		String _grad_ = _grad.replace("%20"," ");
                		String _email_ = _email.replace("%40","@");
                		String _interesovanje_ = _interesovanje.replace("%20"," ");
                		String _omeni_ = _omeni.replace("%20"," ");
                		
                		String _omeni_2 = _omeni_.replace("%2C",", ");
                		String _interesovanje_2 = _interesovanje_.replace("%2C",", ");
                		
                		String _username_ = _username.replace("%20"," ");
                		
                		
                		
                		statement = connect.createStatement();
                    	PreparedStatement statement = connect.prepareStatement("update " + database + ".user SET firstName=?, lastName=?, email=?, location=?, omeni=?, zanimanje=?, interesovanja=? WHERE username=?");
                    	statement.setString(1,_ime_);
                    	statement.setString(2,_prezime_);
                    	statement.setString(3,_email_);
                    	statement.setString(4,_grad_);
                    	statement.setString(5,_omeni_2);
                    	statement.setString(6,_zanimanje_);
                    	statement.setString(7,_interesovanje_2);
                    	statement.setString(8,_username_);
                    	statement.execute();
                      }
                 	catch (Exception e) {
                        throw e;
                     }
                  }
public void deleteKorisnikDB(String data) throws Exception{
	
	JSONObject jsonObject=new JSONObject();
  	try {
  	System.out.println("okej!");
		String query=data;
        String queryArray[]=query.split("&");
        String idKorisnik[]=queryArray[0].split("=");
        jsonObject.put(idKorisnik[0],idKorisnik[1]); 
        System.out.println("okej! 2");
	      }
	catch (JSONException e)
    {
        e.printStackTrace();
    }
	     

	   String _idKorisnik = (String) jsonObject.get("iduser");
	   Integer korisnikId = Integer.valueOf(_idKorisnik);
	   System.out.println("user: " + korisnikId); 
	   statement = connect.createStatement();
   //dodati jos za poruke
	 PreparedStatement statement = connect.prepareStatement("DELETE FROM " + database + ".userchatgroup WHERE korisnikId=?");
 statement.setInt(1,korisnikId);
   statement.execute(); 
 
	  statement = connect.prepareStatement("DELETE FROM " + database + ".adminbanrequest WHERE requestedId=?");
 statement.setInt(1,korisnikId);
 statement.execute();
 statement = connect.prepareStatement("DELETE FROM " + database + ".adminbanrequest WHERE targetId=?");
 statement.setInt(1,korisnikId);
 statement.execute();
 
 
	   statement = connect.prepareStatement("DELETE FROM " + database + ".user WHERE id=?");
   statement.setInt(1,korisnikId);
	   statement.execute();


}

public void prihvatiZahtjevDB(String data) throws Exception{
	
	JSONObject jsonObject=new JSONObject();
  	try {
  	System.out.println("okej!");
		String query=data;
        String queryArray[]=query.split("&");
        String idSourceKorisnik[]=queryArray[0].split("=");
        String idTargetKorisnik[]=queryArray[1].split("=");
        jsonObject.put(idSourceKorisnik[0],idSourceKorisnik[1]);
        jsonObject.put(idTargetKorisnik[0],idTargetKorisnik[1]);
        
        System.out.println("okej! 2");
	      }
	catch (JSONException e)
    {
        e.printStackTrace();
    }
	     

	   String _idSourceKorisnik = (String) jsonObject.get("iduser");
	   Integer SourceKorisnik  = Integer.valueOf(_idSourceKorisnik);
	   
	   String _idTargetKorisnik = (String) jsonObject.get("idPrihvatioZahtjev");
	   Integer TargetKorisnik  = Integer.valueOf(_idTargetKorisnik);
	   System.out.println("user: " + TargetKorisnik ); 
	   statement = connect.createStatement();

     	PreparedStatement statement = connect.prepareStatement("INSERT INTO " + database + ".privatechat ( sourceId, targetId ) VALUES ( ?, ? )");
     	statement.setInt(1,SourceKorisnik);
     	statement.setInt(2,TargetKorisnik);
     	System.out.println("user: " + SourceKorisnik ); 
	   statement.execute();
	   
	   statement = connect.prepareStatement("DELETE FROM " + database + ".invites WHERE idOfInvitee=? AND idOfInviter=?");
    	statement.setInt(1,TargetKorisnik);
    	statement.setInt(2,SourceKorisnik);
    	System.out.println("user: " + SourceKorisnik ); 
	   statement.execute();

}

public List<PrivateMessage> vratiPrivatneKontakteDB(String data) throws Exception{
	
	JSONObject jsonObject=new JSONObject();
  	try {
  	System.out.println("okej!");
		String query=data;
        String queryArray[]=query.split("&");
        String idKorisnik[]=queryArray[0].split("=");
        jsonObject.put(idKorisnik[0],idKorisnik[1]);
        
        System.out.println("okej! 2");
	      }
	catch (JSONException e)
    {
        e.printStackTrace();
    }
	     

	   String _idKorisnik = (String) jsonObject.get("id");
	   Integer idKorisnik = Integer.valueOf(_idKorisnik);
	   
	  
	   System.out.println("user: " + idKorisnik ); 
	   PreparedStatement statement = connect.prepareStatement("select * from " + database + ".privatechat WHERE targetId=?");
	   statement.setInt(1,idKorisnik);
       resultSet = statement.executeQuery();
       List<PrivateMessage> privatemessages = new ArrayList<PrivateMessage>();
       while (resultSet.next()) {
               Integer sourceId = resultSet.getInt("sourceId");
               Integer targetId = resultSet.getInt("targetId");
               
               PrivateMessage pm = new PrivateMessage(); 
               pm.setSourceId(sourceId);
               pm.setTargetId(targetId);

               
               resultSet = null;
               statement = null;
               
               statement = connect.prepareStatement("select * from " + database + ".user WHERE id=?");
               statement.setInt(1, sourceId);
               ResultSet resultSet2 = statement.executeQuery();
              
               while (resultSet2.next()) {
               	String sourceusername=resultSet2.getString("username");
               	 pm.setSourceusername(sourceusername);
               }
          
          privatemessages.add(pm);      
       }
       return privatemessages;

}

public User getProfileDB(int idKorisnik) throws Exception{
	
	
	   System.out.println("user: " + idKorisnik ); 
	   PreparedStatement statement = connect.prepareStatement("select * from " + database + ".user WHERE id=?");
	   statement.setInt(1,idKorisnik);
    resultSet = statement.executeQuery();
    String _username = null;
    String _firstName = null;
    String _lastName = null;
    String _email = null;
    String _zanimanje = null;
    String _omeni = null;
    String _interesovanja = null;
    String _lokacija = null;
    User user = new User();
    while (resultSet.next()) {
 	   
	       	   _username = resultSet.getString("username");
	         	_firstName = resultSet.getString("firstName");
	           _lastName = resultSet.getString("lastName");
	           _email = resultSet.getString("email");
	           _zanimanje = resultSet.getString("zanimanje");
	           _omeni = resultSet.getString("omeni");
	           _interesovanja = resultSet.getString("interesovanja");
	           _lokacija = resultSet.getString("location");    	   
                 
    }
    
    user.setUsername(_username);
    user.setFirstName(_firstName);
    user.setLastName(_lastName);
    user.setEmail(_email);
    user.setZanimanje(_zanimanje);
    user.setOmeni(_omeni);
    user.setInteresovanja(_interesovanja);
    user.setLocation(_lokacija);
    
    return user;

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
                
                public List<Grupa> searchGroups(String searchTerm) throws Exception {
                    try {
                        statement = connect.createStatement();

                    	PreparedStatement statement = connect.prepareStatement("select * from " + database + ".chatgroup WHERE name like ?");
                    	statement.setString(1, "%" + searchTerm + "%");
                        resultSet = statement.executeQuery();
                            List<Grupa> groups = new ArrayList<Grupa>();
                            while (resultSet.next()) {
                                    String name = resultSet.getString("name");
                                    String desc = resultSet.getString("description");
                                    Integer id = resultSet.getInt("id");
                                    Grupa grupa = new Grupa();
                                    grupa.setName(name);
                                    grupa.setDescription(desc);
                                    grupa.setId(id);
                                    groups.add(grupa);
                            }
                            return groups;
                    } catch (Exception e) {
                            throw e;
                    }
            }
        }


