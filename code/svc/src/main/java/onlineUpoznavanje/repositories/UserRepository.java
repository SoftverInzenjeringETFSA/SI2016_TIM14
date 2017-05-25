package onlineUpoznavanje.repositories;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import onlineUpoznavanje.models.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
	public User findByIdKorisnika(Integer id);
	
	public List<User> findAll();
	
	@Query("select u from user u where username=? and password=?")
	public User findByUsernameAndPassword(String username, String password);

	
	

}
/*import org.springframework.data.repository.CrudRepository;

import onlineUpoznavanje.models.User;
public  interface UserRepository extends CrudRepository<User, Long> {

}
 
>>>>>>> Stashed changes*/
