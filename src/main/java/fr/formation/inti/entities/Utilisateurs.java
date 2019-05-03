package fr.formation.inti.entities;
// Generated 26 avr. 2019 11:17:57 by Hibernate Tools 5.1.10.Final

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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Utilisateurs generated by hbm2java
 */
@Entity
@Table(name = "utilisateurs", catalog = "projet", uniqueConstraints = @UniqueConstraint(columnNames = "Login"))
public class Utilisateurs implements java.io.Serializable {

	private Integer idUtilisateurs;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private int codePostal;
	private String login;
	private int password;

	private String passwordString;

	private String mail;
	private Set<Alerte> alertes = new HashSet<Alerte>(0);
	private Set<Annonces> annonceses = new HashSet<Annonces>(0);
	private Set<Messages> messagesesForIdUtilisateurReceveur = new HashSet<Messages>(0);
	private Set<Messages> messagesesForIdUtilisateurExpediteur = new HashSet<Messages>(0);

	public Utilisateurs() {
	}

	public Utilisateurs(String nom, String prenom, Date dateNaissance, int codePostal, String login,
			String passwordString, String mail) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.codePostal = codePostal;
		this.login = login;
		this.password = passwordString.hashCode();
		this.mail = mail;
	}

	public Utilisateurs(String nom, String prenom, Date dateNaissance, int codePostal, String login,
			String passwordString, String mail, Set<Alerte> alertes, Set<Annonces> annonceses,
			Set<Messages> messagesesForIdUtilisateurReceveur, Set<Messages> messagesesForIdUtilisateurExpediteur) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.codePostal = codePostal;
		this.login = login;
		this.password = passwordString.hashCode();
		this.mail = mail;
		this.alertes = alertes;
		this.annonceses = annonceses;
		this.messagesesForIdUtilisateurReceveur = messagesesForIdUtilisateurReceveur;
		this.messagesesForIdUtilisateurExpediteur = messagesesForIdUtilisateurExpediteur;
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

	@Column(name = "Prenom", nullable = false, length = 45)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
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

	@Column(name = "CodePostal", nullable = false)
	public int getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	@Column(name = "Login", unique = true, nullable = false, length = 45)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "Password", nullable = false)
	public int getPassword() {
		return this.password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	@Transient
	public String getPasswordString() {
		return passwordString;
	}

	public void setPasswordString(String passwordString) {
		this.password = passwordString.hashCode();
	}

	@Column(name = "Mail", nullable = false, length = 45)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateurs")
	public Set<Alerte> getAlertes() {
		return this.alertes;
	}

	public void setAlertes(Set<Alerte> alertes) {
		this.alertes = alertes;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateurs")
	public Set<Annonces> getAnnonceses() {
		return this.annonceses;
	}

	public void setAnnonceses(Set<Annonces> annonceses) {
		this.annonceses = annonceses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateursByIdUtilisateurReceveur")
	public Set<Messages> getMessagesesForIdUtilisateurReceveur() {
		return this.messagesesForIdUtilisateurReceveur;
	}

	public void setMessagesesForIdUtilisateurReceveur(Set<Messages> messagesesForIdUtilisateurReceveur) {
		this.messagesesForIdUtilisateurReceveur = messagesesForIdUtilisateurReceveur;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "utilisateursByIdUtilisateurExpediteur")
	public Set<Messages> getMessagesesForIdUtilisateurExpediteur() {
		return this.messagesesForIdUtilisateurExpediteur;
	}

	public void setMessagesesForIdUtilisateurExpediteur(Set<Messages> messagesesForIdUtilisateurExpediteur) {
		this.messagesesForIdUtilisateurExpediteur = messagesesForIdUtilisateurExpediteur;
	}

	@Override
	public String toString() {
		return "Utilisateurs [idUtilisateurs=" + idUtilisateurs + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", codePostal=" + codePostal + ", login=" + login + ", password="
				+ password + ", mail=" + mail + "]";
	}

}
