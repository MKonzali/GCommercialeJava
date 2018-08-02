package com.gc.entities;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name ="Facture")
public class Facture {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_facture;
	private String Code;
	private Date dateCommande;
	private Date dateLivraison;
	private String observation;
	private String adresse_livraison;
	private String adresse_facturation;
	private String depuis;
	private Integer numero;
	
	
	@OneToMany(mappedBy = "facture", cascade = {CascadeType.ALL })
	private List<DetailFacture> listdetail = new ArrayList<DetailFacture>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_client", nullable = false)
	private Client client;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_devise")
	private Devise devise;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_modePaiement")
	private ModePaiement modePaiement;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_type")
	private TypeFacture type;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_fournisseur", nullable = false)
	private Fournisseur fournisseur;
	
	@OneToMany(mappedBy = "facture", cascade = { CascadeType.ALL })
	private List<Livraison> listBL = new ArrayList<Livraison>();
	
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Date getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getAdresse_livraison() {
		return adresse_livraison;
	}
	public void setAdresse_livraison(String adresse_livraison) {
		this.adresse_livraison = adresse_livraison;
	}
	public String getAdresse_facturation() {
		return adresse_facturation;
	}
	public void setAdresse_facturation(String adresse_facturation) {
		this.adresse_facturation = adresse_facturation;
	}

	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getDepuis() {
		return depuis;
	}
	public void setDepuis(String depuis) {
		this.depuis = depuis;
	}
	public int getId_facture() {
		return id_facture;
	}
	public void setId_facture(int id_facture) {
		this.id_facture = id_facture;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	
	
	
}

