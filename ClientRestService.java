package com.gc.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gc.dao.ClientRepository;
import com.gc.dao.ClientRepositoryCustom;
import com.gc.dao.impl.ClientRepositoryImpl;
import com.gc.entities.CategorieClient;
import com.gc.entities.Client;
import com.gc.entities.Devise;
import com.gc.entities.DomaineActivite;
import com.gc.entities.ModePaiement;
import com.gc.entities.Pays;

/**
 * @author mkonzali
 * 20-07-2018
 */
@RestController
@CrossOrigin("*")
public class ClientRestService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientRepositoryCustom customClientRepository;
	
	@RequestMapping(value="/clients",method=RequestMethod.GET)
	public List<Client> getClients (){
		return clientRepository.findAll();
	}
	@RequestMapping(value="/clients/{id}",method=RequestMethod.GET)
	public Client getClient (@PathVariable(name="id") Integer id){
		return clientRepository.findById(id).get();
	}
	
	@PostMapping(value="/clients", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public Client save (@RequestBody Client c){
		return clientRepository.save(c);
	}
	
	@RequestMapping(value="/clients/{id}",method=RequestMethod.DELETE)
	public boolean supprimer (@PathVariable Integer id){
		clientRepository.deleteById(id);
		return true;
	}

	@RequestMapping(value="/clients/{id}",method=RequestMethod.PUT)
	public Client save (@PathVariable Integer id, @RequestBody Client c){
		c.setId_client(id);
		return  clientRepository.save(c);
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/chercherClients",method=RequestMethod.GET)
	public Page<Client> chercherClient (@RequestParam(name="filter") String filter,
										@RequestParam(name="page", defaultValue="0") int page,
										@RequestParam(name="size", defaultValue="5") int size){
		return customClientRepository.chercherClient(filter, new PageRequest(page-1, size));
	}
	
	@GetMapping(value="categories")
	public List<CategorieClient> getCategories(){
		return customClientRepository.getCategories();
	}
	
	@GetMapping(value="villes")
	public List<String> getVilles(){
		return customClientRepository.getVilles();
	}
		
	@GetMapping(value="pays")
	public List<Pays> getPays(){
		return customClientRepository.getPays();
	}
	@GetMapping(value="domaines")
	public List<DomaineActivite> getDomaine(){
		return customClientRepository.getDomaine();
	}
	
	@GetMapping(value="devises")
	public List<Devise> getDevise (){
		return customClientRepository.getCurrency();
	}
	@GetMapping(value="modesPaie")
	public List<ModePaiement> getModePaie(){
		return customClientRepository.getModePaie();
	}

}
