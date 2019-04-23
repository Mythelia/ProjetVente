package fr.formation.inti.entities;
// Generated 10 avr. 2019 10:51:44 by Hibernate Tools 5.1.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Utilisateurs generated by hbm2java
 */
@Entity
@Table(name = "utilisateurs", catalog = "projet")
public class Utilisateurs implements java.io.Serializable {

	
	private Integer idUtilisateurs;

	
	private String nom;
	
	
	private String pr�nom;


	private Date dateNaissance;

	
	private int codePostal;

	
	private String login;

	
	private String password;

	
	private String mail;

	private Set<Alertes> alertes = new HashSet<Alertes>(0);
	private Set<Transactions> transactionses = new HashSet<Transactions>(0);
	private Set<Annonces> annonceses = new HashSet<Annonces>(0);
	private Set<Messageries> messagerieses = new HashSet<Messageries>(0);

	public Utilisateurs() {
	}

	public Utilisateurs(String nom, String pr�nom, Date dateNaissance, int codePostal, String login, String password,
			String mail) {
		this.nom = nom;
		this.pr�nom = pr�nom;
		this.dateNaissance = dateNaissance;
		this.codePostal = codePostal;
		this.login = login;
		this.password = password;
		this.mail = mail;
	}

	public Utilisateurs(String nom, String pr�nom, Date dateNaissance, int codePostal, String login, String password,
			String mail, Set<Alertes> alertes, Set<Transactions> transactionses, Set<Annonces> annonceses,
			Set<Messageries> messagerieses) {
		this.nom = nom;
		this.pr�nom = pr�nom;
		this.dateNaissance = dateNaissance;
		this.codePostal = codePostal;
		this.login = login;
		this.password = password;
		this.mail = mail;
		this.alertes = alertes;
		this.transactionses = transactionses;
		this.annonceses = annonceses;
		this.messagerieses = messagerieses;
	}

	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idUtilisateurs", unique = true, nullable = false)
	public Integer getIdUtilisateurs() {
		return this.idUtilisateurs;
	}

	public void setIdUtilisateurs(Integer idUtilisateurs) {
		this.idUtilisateurs = idUtilisateurs;
	}

	@Column(name = "Nom", nullable = false, length = 45)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "Pr�nom", nullable = false, length = 45)
	public String getPr�nom() {
		return this.pr�nom;
	}

	public void setPr�nom(String pr�nom) {
		this.pr�nom = pr�nom;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateNaissance", nullable = false, length = 10)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Column(name = "Code Postal", nullable = false)
	public int getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	@Column(name = "Login", nullable = false, length = 45)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "Password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Mail", nullable = false, length = 45)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateurs")
	public Set<Alertes> getAlertes() {
		return this.alertes;
	}

	public void setAlertes(Set<Alertes> alertes) {
		this.alertes = alertes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateurs")
	public Set<Transactions> getTransactionses() {
		return this.transactionses;
	}

	public void setTransactionses(Set<Transactions> transactionses) {
		this.transactionses = transactionses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateurs")
	public Set<Annonces> getAnnonceses() {
		return this.annonceses;
	}

	public void setAnnonceses(Set<Annonces> annonceses) {
		this.annonceses = annonceses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateurs")
	public Set<Messageries> getMessagerieses() {
		return this.messagerieses;
	}

	public void setMessagerieses(Set<Messageries> messagerieses) {
		this.messagerieses = messagerieses;
	}

}
