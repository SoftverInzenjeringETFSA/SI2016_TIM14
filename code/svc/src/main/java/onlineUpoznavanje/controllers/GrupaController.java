package onlineUpoznavanje.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
//import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import onlineUpoznavanje.services.UserService;
import onlineUpoznavanje.services.izuzetak.ServiceException;
import onlineUpoznavanje.db.dbActions;
import onlineUpoznavanje.dto.LoginDataRequest;
import onlineUpoznavanje.models.Invite;
import onlineUpoznavanje.models.User;
import onlineUpoznavanje.repositories.UserRepository;
import onlineUpoznavanje.db.dbActionsGrupe;
import onlineUpoznavanje.models.Grupa;
import onlineUpoznavanje.services.GrupaService;
import onlineUpoznavanje.db.dbActionsGrupe;
import onlineUpoznavanje.models.Grupa;
import onlineUpoznavanje.repositories.GrupaRepository;
import onlineUpoznavanje.services.GrupaService;



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
    
    @RequestMapping(value = "/searchGroups")
    public @ResponseBody List<Grupa> searchGroups(@RequestParam("searchTerm") String searchTerm)
    {
		//System.out.println(searchTerm);
		try {
			dbActions db = new dbActions();
	        db.connectToDB();
	        grupeToReturn = db.searchGroups(searchTerm);
	        db.close();
		}
		catch (Exception e) {
			return GrupaRepository.findAll();
		}
			 
	        return grupeToReturn;

    }
	
    
    @RequestMapping(value = "/obrisigrupu", method = RequestMethod.POST)
    public void obrisiGrupu(@RequestBody String podatak)
    {
		 try {
		dbActionsGrupe db = new dbActionsGrupe();
        db.connectToDB();
        System.out.println(podatak);
        db.obrisiGrupuDB(podatak);
        db.close();
		 }
		 catch (Exception e)
		 {
			// return GrupaRepository.findAll();
		 }
		 

    }
	

}
