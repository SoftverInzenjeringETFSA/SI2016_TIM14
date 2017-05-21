package onlineUpoznavanje.services;

import java.util.Collection;

//import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


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
