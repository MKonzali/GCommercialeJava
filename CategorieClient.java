package com.gc.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author mkonzali
 * 20-07-2018
 */
@Entity
@Table(name="categorieclient")
public class CategorieClient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id_categorieClient;
	//Nom de la categorie
	private String nom_categorie;
	
	//Jointures JPA	
	@JsonBackReference
	@OneToMany(mappedBy="categorieClient")
	private List<Client> client=new ArrayList<Client>();
	
	public Integer getId_categorieClient() {
		return id_categorieClient;
	}

	public void setId_categorieClient(Integer idCategorieClient) {
		id_categorieClient = idCategorieClient;
	}

	public String getNom_categorie() {
		return nom_categorie;
	}

	public void setNom_categorie(String nomCategorie) {
		nom_categorie = nomCategorie;
	}

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}
	
}
