package onlineUpoznavanje.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
//import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import onlineUpoznavanje.db.dbActions;
import onlineUpoznavanje.repositories.UserRepository;
import onlineUpoznavanje.services.izuzetak.ServiceException;

@Service
public class UserService implements UserDetailsService {

 
	
    @Autowired
    public static UserRepository repository;
	
    //korisnièki napravljena metoda - vraæanje svih korisnika
    public Iterable<onlineUpoznavanje.models.User> findAllUsers() {
        return repository.findAll();
    }
    
    //dodavanje korisnika sa njegovim atributima u bazu
    public Boolean addUsers(onlineUpoznavanje.models.User k) throws ServiceException {
    	
    	if(repository.findByUsername(k.getUsername()) != null) {
            throw new ServiceException("Korisnik sa datim username-om vec postoji!");
        }
    	  
    	onlineUpoznavanje.models.User kreiranKorisnik = repository.save(k);

        return kreiranKorisnik != null;
	}
    
    public static boolean storeUser(String User){
    	//System.out.print(User);
    	//JsonObject obj = new JsonParser().parse(User).getAsJsonObject();
    	StringBuilder jsonString = new StringBuilder();
    	jsonString.append(User);
    	JSONObject jsonObj = null;
		try {
			jsonObj = new JSONObject(jsonString.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.print("Well fuck 2");
			e.printStackTrace();
		}
    	try {
    		System.out.print("Yaya fuck");
			String username = jsonObj.getString("username");
			String password = jsonObj.getString("password");
			String email = jsonObj.getString("email");
			dbActions db = new dbActions();
	        try {
				db.connectToDB();
				db.storeUser(username, password, email);
		        db.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			 
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			System.out.print("Well fuck");
			e.printStackTrace();
		}
    	
    	return true;
    }
    
    public static boolean inviteUser(String data){
		dbActions db = new dbActions();
	        try {
				db.connectToDB();
				db.inviteUser(data);
		        db.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			 
		
    	return true;
    }
    
    
    //dodati update-ovanje korisnika 
    
    //dodati brisanje korisnika
    

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        onlineUpoznavanje.models.User korisnik = repository.findByUsername(s);
        if(korisnik == null) {
            throw new UsernameNotFoundException("Nije pronadjen korisnik s datim username-om");
        }
        return new User(korisnik.getUsername(), korisnik.getPassword(), getGrantedAuthorities(korisnik));
    }


	private Collection<? extends GrantedAuthority> getGrantedAuthorities(onlineUpoznavanje.models.User korisnik) {
		// TODO Auto-generated method stub
		return null;
	}
}
