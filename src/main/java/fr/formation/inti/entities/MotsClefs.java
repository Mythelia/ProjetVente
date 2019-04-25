package fr.formation.inti.entities;
// Generated 10 avr. 2019 10:51:44 by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * MotsClefs generated by hbm2java
 */
@Entity
@Table(name = "motsclefs", catalog = "projet")
public class MotsClefs implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6991792443920079516L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idMotClef;
	private String motClef;
	private Set<Annonces> annonceses = new HashSet<Annonces>(0);
	private Set<Alertes> alertes = new HashSet<Alertes>(0);

	public MotsClefs() {
	}

	public MotsClefs(int idMotClef, String motClef) {
		this.idMotClef = idMotClef;
		this.motClef = motClef;
	}

	public MotsClefs(int idMotClef, String motClef, Set<Annonces> annonceses, Set<Alertes> alertes) {
		this.idMotClef = idMotClef;
		this.motClef = motClef;
		this.annonceses = annonceses;
		this.alertes = alertes;
	}

	@Id


	@Column(name = "idMotClef", unique = true, nullable = false)
	public int getIdMotClef() {
		return this.idMotClef;
	}

	public void setIdMotClef(int idMotClef) {
		this.idMotClef = idMotClef;
	}

	@Column(name = "MotClef", nullable = false, length = 45)
	public String getMotClef() {
		return this.motClef;
	}

	public void setMotClef(String motClef) {
		this.motClef = motClef;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "annonces_has_motsclefs", catalog = "projet", joinColumns = {
			@JoinColumn(name = "motsclefs_idMotClef", updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Annonces_idAnnonces", nullable = false, updatable = false) })
	public Set<Annonces> getAnnonceses() {
		return this.annonceses;
	}

	public void setAnnonceses(Set<Annonces> annonceses) {
		this.annonceses = annonceses;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "motsclefs_has_alerte", catalog = "projet", joinColumns = {
			@JoinColumn(name = "motsclefs_idMotClef", updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "Alerte_idAlerte", nullable = false, updatable = false) })
	public Set<Alertes> getAlertes() {
		return this.alertes;
	}

	public void setAlertes(Set<Alertes> alertes) {
		this.alertes = alertes;
	}

}
