package onlineUpoznavanje.repositories;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;


import onlineUpoznavanje.models.User;

public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
	public User findByUsername(String username);
	public User findByIdKorisnika(Integer id);
	
	public List<User> findAll();
}
/*import org.springframework.data.repository.CrudRepository;

import onlineUpoznavanje.models.User;
public  interface UserRepository extends CrudRepository<User, Long> {

}
 
>>>>>>> Stashed changes*/
