package onlineUpoznavanje.repositories;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import onlineUpoznavanje.models.Grupa;

public interface GrupaRepository extends CrudRepository<Grupa, Long> {

	public Grupa findByName(String name);
	
	public List<Grupa> findAll();
	
	@Query("select * from tim14.chatgroup")
	public Grupa nadjiSveJebemtiNanuEklipsovsku(String name);
}
