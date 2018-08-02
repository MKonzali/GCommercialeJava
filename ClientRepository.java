package com.gc.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gc.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	@Query("select c from Client c where c.nom_client like :nom")	
	public Page<Client> chercher(@Param("nom")String nom, Pageable pageable);
	
//	public Page<Client> chercherClient(@Param("nom")String nom,@Param("ville")String ville,
//			@Param("adresse")String adresse,@Param("categorie")Integer id_categorieClient,
//			Pageable pageable);
	
}
