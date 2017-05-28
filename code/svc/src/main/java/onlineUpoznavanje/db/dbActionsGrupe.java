package onlineUpoznavanje.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.*;
import org.json.simple.parser.JSONParser;

import onlineUpoznavanje.models.Grupa;

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
     
     public void kreirajGrupuDB(String data) throws Exception {
      	
       	try {

      	 JSONObject jsonObject=new JSONObject();

          	try {
          		
          		String query=data;
                  String queryArray[]=query.split("&");
                  String name[]=queryArray[0].split("=");
                  String description[]=queryArray[1].split("=");
                  jsonObject.put(name[0],name[1]);
                  jsonObject.put(description[0],description[1]);
          	
          	}
          	catch (JSONException e)
              {
                  e.printStackTrace();
              }
          	String _name = (String) jsonObject.get("ime");
          	String _name_ = _name.replace("%20"," ");
      		String _description = (String) jsonObject.get("opis");
      		String _description_ = _description.replace("%20"," ");
      		String _description_2 = _description_.replace("%2C",",");
          	statement = connect.createStatement();
          	PreparedStatement statement = connect.prepareStatement("INSERT INTO " + database + ".chatgroup ( name, description ) VALUES ( ?, ? )");
          	statement.setString(1,_name_);
          	statement.setString(2,_description_2);
          	statement.execute();
            }
       	catch (Exception e) {
              throw e;
           }
        }
     
     public List<Grupa> readGroup() throws Exception {
         try {
                 statement = connect.createStatement();
                 resultSet = statement
                                 .executeQuery("select * from " + database + ".chatgroup");
                 List<Grupa> grupe = new ArrayList<Grupa>();
                 while (resultSet.next()) {
                         String name = resultSet.getString("name");
                         String description = resultSet.getString("description");
                         Integer id = resultSet.getInt("id");
                         Grupa grupa = new Grupa();
                         grupa.setName(name);
                         grupa.setId(id);
                         grupa.setDescription(description);
                         grupa.setId(id);
                         grupe.add(grupa);
                         
                 }
                 return grupe;
         } catch (Exception e) {
                 throw e;
         }
 }
     
     public List<Grupa> myGroups(String idUser) throws Exception {
         try {
                 statement = connect.createStatement();
                 PreparedStatement statement = connect.prepareStatement("select * from " + database + ".userchatgroup WHERE korisnikId=?");
              	statement.setString(1, idUser);

              	resultSet = statement.executeQuery();
                 List<Grupa> grupe = new ArrayList<Grupa>();
                 while (resultSet.next()) {
                         String idGroup = resultSet.getString("groupId");
                         statement = connect.prepareStatement("select * from " + database + ".chatgroup WHERE id=?");
                         statement.setString(1, idGroup);
                         ResultSet groupResultSet = statement.executeQuery();
                         while(groupResultSet.next())
                         {
                        	 String name = groupResultSet.getString("name");
                             String description = groupResultSet.getString("description");
                             Integer id = groupResultSet.getInt("id");
                             Grupa grupa = new Grupa();
                             grupa.setName(name);
                             grupa.setId(id);
                             grupa.setDescription(description);
                             grupe.add(grupa);
                         }
                 }
                 return grupe;
         } catch (Exception e) {
                 throw e;
         }
 }
     
     
     public void obrisiGrupuDB(String data) throws Exception {
         try {
      	   
      	   JSONObject jsonObject=new JSONObject();
          	try {
          	System.out.println("uslo 25");
        		String query=data;
                String queryArray[]=query.split("&");
                String idGrupa[]=queryArray[0].split("=");
                jsonObject.put(idGrupa[0],idGrupa[1]); 
                System.out.println("uslo 3");
        	      }
        	catch (JSONException e)
            {
                e.printStackTrace();
            }
      	     

      	   String _idGrupa = (String) jsonObject.get("idgrupa");
      	   Integer grupaId = Integer.valueOf(_idGrupa);
      	   System.out.println("grupa: " + grupaId); 
      	   statement = connect.createStatement();
           //doadti jos i za poruke
      	 PreparedStatement statement = connect.prepareStatement("DELETE FROM " + database + ".userchatgroup WHERE groupId=?");
         statement.setInt(1,grupaId);
  	   statement.execute(); 
  	   
      	  statement = connect.prepareStatement("DELETE FROM " + database + ".adminbanrequest WHERE chatGroupId=?");
         statement.setInt(1,grupaId);
  	   statement.execute();
  	   
      	   statement = connect.prepareStatement("DELETE FROM " + database + ".chatgroup WHERE id=?");
           statement.setInt(1,grupaId);
      	   statement.execute(); 
      	   
          	
          } catch (Exception e) {
          	
                  throw e;
          }
      
      }
     
     public void joinGroup(String data) throws Exception {
         try {
        	 JSONObject jsonObject=new JSONObject();

         	try
             {
                 String query=data;
                 String queryArray[]=query.split("&");
                 String idofUser[]=queryArray[0].split("=");
                 String idOfGroup[]=queryArray[1].split("=");
                 jsonObject.put(idofUser[0],idofUser[1]);
                 jsonObject.put(idOfGroup[0],idOfGroup[1]);

             }
             catch (JSONException e)
             {
                 e.printStackTrace();
             }
         		String idofUser = (String) jsonObject.get("idOfUser");
         		String idOfGroup = (String) jsonObject.get("idOfGroup");
         		
             statement = connect.createStatement();

         	PreparedStatement statement = connect.prepareStatement("SELECT * FROM " + database + ".userchatgroup WHERE korisnikId=? AND groupId=?");
         	statement.setString(1, idofUser);
         	statement.setString(2, idOfGroup);
         	
             resultSet = statement.executeQuery();
             String flag = null;
             while (resultSet.next()) {
             	flag = "Test";
             }
             if(flag == null) {
            	 statement = connect.prepareStatement("INSERT INTO " + database + ".userchatgroup ( korisnikId, groupId ) VALUES ( ?, ? )");
            		statement.setString(1, idofUser);
                 	statement.setString(2, idOfGroup);
                    statement.execute();

             }
                 
         } catch (Exception e) {
                 throw e;
         }
 }
     
     public void leaveGroup(String data) throws Exception {
         try {
        	 JSONObject jsonObject=new JSONObject();

         	try
             {
                 String query=data;
                 String queryArray[]=query.split("&");
                 String idofUser[]=queryArray[0].split("=");
                 String idOfGroup[]=queryArray[1].split("=");
                 jsonObject.put(idofUser[0],idofUser[1]);
                 jsonObject.put(idOfGroup[0],idOfGroup[1]);

             }
             catch (JSONException e)
             {
                 e.printStackTrace();
             }
         		String idofUser = (String) jsonObject.get("idOfUser");
         		String idOfGroup = (String) jsonObject.get("idOfGroup");
             statement = connect.createStatement();

         	PreparedStatement statement = connect.prepareStatement("DELETE FROM " + database + ".userchatgroup WHERE korisnikId=? AND groupId=?");
         	statement.setString(1, idofUser);
         	statement.setString(2, idOfGroup);
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
     
     public List<Grupa> searchGroups(String searchTerm) throws Exception {
         try {
             statement = connect.createStatement();

         	PreparedStatement statement = connect.prepareStatement("select * from " + database + ".chatgroup");
         	//statement.setString(1, "%" + searchTerm + "%");
             resultSet = statement.executeQuery();
                 List<Grupa> groups = new ArrayList<Grupa>();
                 while (resultSet.next()) {
                         String name = resultSet.getString("name");
                         String desc = resultSet.getString("description");
                         Integer id = resultSet.getInt("id");
                         Grupa grupa = new Grupa();
                         grupa.setName(name);
                         grupa.setId(id);
                         grupa.setDescription(desc);
                         groups.add(grupa);
                 }
                 return groups;
         } catch (Exception e) {
                 throw e;
         }
 }

     
     
     
}
