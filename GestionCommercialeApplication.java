package com.gc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gc.dao.ClientRepository;
import com.gc.dao.ClientRepositoryCustom;
import com.gc.entities.CategorieClient;
import com.gc.entities.Client;

/**
 * @author mkonzali
 * 20-07-2018
 */
@SpringBootApplication
public class GestionCommercialeApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository cr;
	
	@Autowired
	private ClientRepositoryCustom crc;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionCommercialeApplication.class, args);
		
		
	}
	
	@Override
	public void run(String... args) throws Exception {

//		Client c = new Client();
//		c.setAdresse_client("ahmes jsnsuy ushnu");
//		c.setNom_client("sancf");
//		c.setTel_client("91453322");
//		c.setVille("Paris");
//		CategorieClient cat = crc.getCateg(2);
//		c.setCategorieClient(cat);
//		cr.save(c);
		cr.findAll().forEach(cl->{
			System.out.println(cl.getNom_client());
		});
	}
}
