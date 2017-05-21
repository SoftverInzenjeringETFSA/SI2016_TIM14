package onlineUpoznavanje.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import onlineUpoznavanje.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
 