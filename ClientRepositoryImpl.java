package com.gc.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.gc.dao.ClientRepositoryCustom;
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
public class ClientRepositoryImpl implements ClientRepositoryCustom{
	
	@PersistenceContext
	EntityManager em;


	/**
	 * chercherClient : fait une recherche des clients selon les criteres choisis 
	 * @param filter String : le filtre qui contient les criteres
	 * @param pageable Pageable : la page definit par son numero et sa taille
	 * 
	 * @return page des clients
	 */
	
	public Page<Client> chercherClient(String filter,	Pageable pageable){
		
		String querytxt = "from Client c where 1=1 ";
		if(filter!=null && !filter.equals(""))
			querytxt += filter;
		
		Query query = em.createQuery(querytxt);	
		int totalRows = query.getResultList().size();
		query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
		query.setMaxResults(pageable.getPageSize());

		@SuppressWarnings("unchecked")
		Page<Client> page = new PageImpl<Client>( query.getResultList(), pageable,totalRows);
		
		
		return page;
		
	}

	/**
	 * getCateg : retourne une categorie a trevers son id
	 * 
	 * @param id
	 * 
	 * @return CategorieClient
	 */
	@Override
	public CategorieClient getCateg(Integer id) {
		// 
		CategorieClient categ = em.find(CategorieClient.class, id);
		return categ;
	}
	

	/**
	 * getCategories
	 * 
	 * @return liste des categories client
	 */
	@Override
	public List<CategorieClient> getCategories() {
		// 
		return em.createQuery("from CategorieClient").getResultList();
		 
	}

	@Override
	public List<Pays> getPays() {
		// 
		return em.createQuery("from Pays").getResultList();
	}

	@Override
	public List<String> getVilles() {
		// 
		return em.createQuery("select distinct ville from Client").getResultList();
	}

	@Override
	public List<DomaineActivite> getDomaine() {
		// 
		return em.createQuery("from DomaineActivite").getResultList();
	}
	
	/**
	 * getModePaie
	 * 
	 * @return liste des Modes de Paiement 
	 */
	public List<ModePaiement> getModePaie(){
		//
		return em.createQuery("from ModePaiement").getResultList();
	}

	@Override
	public List<Devise> getCurrency() {
		// 
		return em.createQuery("from Devise").getResultList();
	}
	
	
	
}
