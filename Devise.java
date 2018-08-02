package com.gc.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="devise")
public class Devise implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_devise;
	private String libelle;
	private String code;
	//Jointures JPA
	@OneToMany(cascade = CascadeType.ALL,mappedBy="listeDevise")
	private List<ConversionDevise> conversionDevises=new ArrayList<ConversionDevise>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="devise")
	private List<Fournisseur> fournisseurs=new ArrayList<Fournisseur>();
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL,mappedBy="devise")
	private List<Client> clients=new ArrayList<Client>();
	
	
	public Devise() {
		
	}
	
	//getters and setters
	public Integer getId_devise() {
		return id_devise;
	}
	public void setId_devise(Integer idDevise) {
		id_devise = idDevise;
	}
	
	
	public List<ConversionDevise> getConversionDevises() {
		return conversionDevises;
	}
	public void setConversionDevises(List<ConversionDevise> conversionDevises) {
		this.conversionDevises = conversionDevises;
	}
	public List<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
	
}
