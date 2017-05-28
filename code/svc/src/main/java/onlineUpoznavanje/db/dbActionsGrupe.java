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
      		_description_ = _description.replace("%2C",",");
          	statement = connect.createStatement();
          	PreparedStatement statement = connect.prepareStatement("INSERT INTO " + database + ".chatgroup ( name, description ) VALUES ( ?, ? )");
          	statement.setString(1,_name_);
          	statement.setString(2,_description_);
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
                         Grupa grupa = new Grupa();
                         grupa.setName(name);
                         grupa.setDescription(description);
                         grupe.add(grupa);
                         
                 }
                 return grupe;
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
                         System.out.println(name);
                         Grupa grupa = new Grupa();
                         grupa.setName(name);
                         grupa.setDescription(desc);
                         groups.add(grupa);
                 }
                 return groups;
         } catch (Exception e) {
                 throw e;
         }
 }

     
     
     
}
