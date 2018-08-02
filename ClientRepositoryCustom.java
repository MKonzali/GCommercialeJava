package com.gc.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
public interface ClientRepositoryCustom {
	
	
	/**
	 * chercherClient : fait une recherche des clients selon les criteres choisis 
	 * @param filter String : le filtre qui contient les criteres
	 * @param pageable Pageable : la page definit par son numero et sa taille
	 * 
	 * @return page des clients
	 */
	public Page<Client> chercherClient(String filter, Pageable pageable);
	
	/**
	 * getCateg : retourne une categorie a trevers son id
	 * 
	 * @param id
	 * 
	 * @return CategorieClient
	 */
	public CategorieClient getCateg(Integer id);
	
	
	
	/**
	 * getCategories
	 * 
	 * @return liste des categories client
	 */
	public List<CategorieClient> getCategories();
	
	/**
	 * getPays
	 * 
	 * @return liste des pays
	 */
	
	public List<Pays> getPays();
	
	/**
	 * getVilles
	 * 
	 * @return liste des villes existantes
	 */
	public List<String> getVilles();
	
	/**
	 * getDomaine
	 * 
	 * @return liste des domaine d'activite client
	 */
	public List<DomaineActivite> getDomaine();
	
	/**
	 * getModePaie
	 * 
	 * @return liste des Modes de Paiement 
	 */
	public List<ModePaiement> getModePaie();
	
	/**
	 * getCurrency
	 * 
	 * @return liste des Devises
	 */
	public List<Devise> getCurrency();
	
}
