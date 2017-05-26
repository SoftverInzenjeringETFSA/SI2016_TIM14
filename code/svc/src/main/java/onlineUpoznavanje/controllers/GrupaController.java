package onlineUpoznavanje.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import onlineUpoznavanje.db.dbActions;
import onlineUpoznavanje.db.dbActionsGrupe;

@RestController 
@CrossOrigin
@RequestMapping(path="/grupe") 
public class GrupaController {
	
	@RequestMapping(value = "/kreirajgrupu", method = RequestMethod.POST)
    public void kreirajGrupu(@RequestBody String podatak)
    {

	try {
	   dbActionsGrupe db = new dbActionsGrupe();
       db.connectToDB();
       System.out.println(podatak);
       db.kreirajGrupuDB(podatak);
       db.close();
	   }
	catch (Exception e)
	{
			// return UserRepository.findAll();
	}

    }
	

}
