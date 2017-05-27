package onlineUpoznavanje.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import onlineUpoznavanje.db.dbActions;
import onlineUpoznavanje.db.dbActionsGrupe;
import onlineUpoznavanje.models.Grupa;
import onlineUpoznavanje.models.Invite;
import onlineUpoznavanje.services.GrupaService;
import onlineUpoznavanje.db.dbActions;
import onlineUpoznavanje.db.dbActionsGrupe;
import onlineUpoznavanje.models.Grupa;
import onlineUpoznavanje.models.Invite;
import onlineUpoznavanje.models.User;
import onlineUpoznavanje.repositories.GrupaRepository;
import onlineUpoznavanje.repositories.UserRepository;
import onlineUpoznavanje.services.GrupaService;
import onlineUpoznavanje.services.UserService;

@RestController 
@CrossOrigin
@RequestMapping(path="/grupe") 
public class GrupaController {
	@Autowired
    private static GrupaService grupaService;
	
	@Autowired
	private static GrupaRepository GrupaRepository;
	
	private static List <Invite> invitesToReturn = new ArrayList<Invite>();

	
	private static List <Grupa> grupeToReturn = new ArrayList<Grupa>();
	private static Grupa _grupa = new Grupa();
	
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
	
	@RequestMapping(value = "/all")
    public @ResponseBody List<Grupa> findAll()
    {
		 try {
		dbActionsGrupe db = new dbActionsGrupe();
        db.connectToDB();
        grupeToReturn = db.readGroup();
        db.close();
		 }
		 catch (Exception e)
		 {
			// return GrupaRepository.findAll();
		 }
		 
        return grupeToReturn;

    }
	
	

}
