package com.gc.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="modepaiement")
public class ModePaiement implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code_modePay;
	private String libelle_modePay;
    
	//Jointures JPA
	
	@OneToMany(mappedBy="modePaiement",fetch=FetchType.LAZY,cascade = { CascadeType.ALL })
	private List<Fournisseur> listfournisseur=new ArrayList<Fournisseur>();
	
	@JsonBackReference
	@OneToMany(mappedBy="modePaiement",fetch=FetchType.LAZY,cascade = { CascadeType.ALL })
	private List<Client> listclient=new ArrayList<Client>();
	
	public ModePaiement() {
		
	}
	
	//getters and setters
	public Integer getCode_modePay() {
		return code_modePay;
	}

	public void setCode_modePay(Integer codeModePay) {
		code_modePay = codeModePay;
	}

	public List<Fournisseur> getListfournisseur() {
		return listfournisseur;
	}

	public void setListfournisseur(List<Fournisseur> listfournisseur) {
		this.listfournisseur = listfournisseur;
	}

	public String getLibelle_modePay() {
		return libelle_modePay;
	}
	public void setLibelle_modePay(String libelleModePay) {
		libelle_modePay = libelleModePay;
	}

	public List<Client> getListclient() {
		return listclient;
	}

	public void setListclient(List<Client> listclient) {
		this.listclient = listclient;
	}	
		
}
