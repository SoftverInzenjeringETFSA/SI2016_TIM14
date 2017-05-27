package onlineUpoznavanje.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PrinterLocation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import onlineUpoznavanje.db.dbActions;
import onlineUpoznavanje.db.dbActionsBanRequest;
import onlineUpoznavanje.models.BanRequest;
import onlineUpoznavanje.models.User;

@RestController 
@CrossOrigin
@RequestMapping(path="/banzahtjevi")  
public class BanRequestController {
	
	private static List<BanRequest> sviBanRequesti = new ArrayList<BanRequest>();
	
	@RequestMapping(value = "/all")
    public @ResponseBody List<BanRequest> findAllBanRequests()
    {
		try {
			System.out.println("ban request 1");
		dbActionsBanRequest db = new dbActionsBanRequest();
        db.connectToDB();
        sviBanRequesti = db.readBanRequests();
        db.close();
		 }
		 catch (Exception e)
		 {
			 //return UserRepository.findAll();
		 }
		 
        return sviBanRequesti;

    }
	

 }
