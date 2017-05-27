package onlineUpoznavanje.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
