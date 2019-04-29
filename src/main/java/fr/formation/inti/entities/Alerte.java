package fr.formation.inti.entities;
// Generated 29 avr. 2019 15:09:20 by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Alerte generated by hbm2java
 */
@Entity
@Table(name = "alerte", catalog = "projet")
public class Alerte implements java.io.Serializable {

	private Integer idAlerte;
	private Utilisateurs utilisateurs;
	private Set<MotsClefs> motsclefses = new HashSet<MotsClefs>(0);

	public Alerte() {
	}

	public Alerte(Utilisateurs utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Alerte(Utilisateurs utilisateurs, Set<MotsClefs> motsclefses) {
		this.utilisateurs = utilisateurs;
		this.motsclefses = motsclefses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idAlerte", unique = true, nullable = false)
	public Integer getIdAlerte() {
		return this.idAlerte;
	}

	public void setIdAlerte(Integer idAlerte) {
		this.idAlerte = idAlerte;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Utilisateurs_idUtilisateurs", nullable = false)
	public Utilisateurs getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(Utilisateurs utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "motsclefs_has_alerte", catalog = "projet", joinColumns = {
			@JoinColumn(name = "alerte_idAlerte", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "motsclefs_idMotClef", nullable = false, updatable = false) })
	public Set<MotsClefs> getMotsclefses() {
		return this.motsclefses;
	}

	public void setMotsclefses(Set<MotsClefs> motsclefses) {
		this.motsclefses = motsclefses;
	}

}
