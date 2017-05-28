package onlineUpoznavanje.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import onlineUpoznavanje.models.BanRequest;
import onlineUpoznavanje.models.User;


public class dbActionsBanRequest {
	
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
    
    
    
    public List<BanRequest> readBanRequests() throws Exception {
        try {
        	    System.out.println("ban request 2");
                statement = connect.createStatement();
                PreparedStatement statement = connect.prepareStatement("select * from " + database + ".adminbanrequest");
                resultSet = statement.executeQuery();
                List<BanRequest> banovi = new ArrayList<BanRequest>();
                while (resultSet.next()) {
                        Integer requestedId = resultSet.getInt("requestedId");
                        Integer targetId = resultSet.getInt("targetId");
                        Integer chatGroupId=resultSet.getInt("chatGroupId");
                        String reason=resultSet.getString("reason");
                        
                        BanRequest ban = new BanRequest(); 
                        ban.setRequestedId(requestedId);
                        ban.setTargetId(targetId);
                        ban.setChatGroupId(chatGroupId);
                        ban.setReason(reason);
                        
                        resultSet = null;
                        statement = null;
                        
                        statement = connect.prepareStatement("select * from " + database + ".user WHERE id=?");
                        statement.setInt(1, requestedId);
                        resultSet = statement.executeQuery();
                       
                        while (resultSet.next()) {
                        	String sourceusername=resultSet.getString("username");
                        	 ban.setSourceusername(sourceusername);
                        }
                        
                        statement = connect.prepareStatement("select * from " + database + ".user WHERE id=?");
                        statement.setInt(1, targetId);
                        resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                        	String targetusername=resultSet.getString("username");
                        	 ban.setTargetusername(targetusername);
                        }
                        
                        statement = connect.prepareStatement("select * from " + database + ".chatgroup WHERE id=?");
                        statement.setInt(1, chatGroupId);
                        resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                        	String nazivgrupe =resultSet.getString("name");
                        	 ban.setGroupname(nazivgrupe);
                        }
                        
                       
                        
                   banovi.add(ban);      
                }
                return banovi;
        } catch (Exception e) {
                throw e;
        }
}
    
    public void acceptRequestDB(String data) throws Exception {
        try {
     	   JSONObject jsonObject=new JSONObject();
          	try {
          		System.out.println("uslo 2");
        		   String query=data;
                String queryArray[]=query.split("&");
                String idKorisnik[]=queryArray[0].split("=");
                String idGrupa[]=queryArray[1].split("=");
                String idBan[]=queryArray[2].split("=");
                jsonObject.put(idKorisnik[0],idKorisnik[1]);
                jsonObject.put(idGrupa[0],idGrupa[1]);
                jsonObject.put(idBan[0],idBan[1]); 
                System.out.println("uslo 3");
        	      }
        	catch (JSONException e)
            {
                e.printStackTrace();
            }
            
            String _idKorisnik = (String) jsonObject.get("idbanovikorisnik");
     	   String _idGrupa = (String) jsonObject.get("idgrupa");
     	   String _idBan = (String) jsonObject.get("idBan");
     	   
     	   System.out.println("korisnik: " + _idKorisnik + " grupa: " + _idGrupa);
     	   
     	   Integer korisnikId = Integer.valueOf(_idKorisnik);
     	   Integer grupaId = Integer.valueOf(_idGrupa);
     	   Integer banId = Integer.valueOf(_idBan);
     	   
     	 
     	   System.out.println("korisnik: " + korisnikId + " grupa: " + grupaId);
     	   //brisanje korisnika iz tabele UserChatGroup
     	   statement = connect.createStatement();
            PreparedStatement statement = connect.prepareStatement("DELETE FROM " + database + ".userchatgroup WHERE korisnikId=? AND groupId=?");
            statement.setInt(1,korisnikId);
        	   statement.setInt(2,grupaId);
        	   statement.execute();
        	   
        	   //brisanje zahtejva iz tabele adminbanrequest
        	   statement = connect.prepareStatement("DELETE FROM " + database + ".adminbanrequest WHERE id=?");
            statement.setInt(1,banId);
            
     	   statement.execute();
     	   
         	
         } catch (Exception e) {
         	
                 throw e;
         }
     
     }

     
     
     public void odbijRequestDB(String data) throws Exception {
        try {
     	   
     	   JSONObject jsonObject=new JSONObject();
         	try {
         	System.out.println("uslo 2");
       		  String query=data;
               String queryArray[]=query.split("&");
               String idBan[]=queryArray[0].split("=");
               jsonObject.put(idBan[0],idBan[1]); 
               System.out.println("uslo 3");
       	      }
       	catch (JSONException e)
           {
               e.printStackTrace();
           }
     	     
        	   //brisanje zahtejva iz tabele adminbanrequest
     	   String _idBan = (String) jsonObject.get("idBan");
     	   Integer banId = Integer.valueOf(_idBan);
     	   System.out.println("ban: " + banId); 
     	   statement = connect.createStatement();
     	   PreparedStatement statement = connect.prepareStatement("DELETE FROM " + database + ".adminbanrequest WHERE id=?");
            statement.setInt(1,banId);
     	   statement.execute(); 
         	
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
