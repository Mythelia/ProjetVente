package fr.formation.inti.Entities;
// Generated 26 avr. 2019 11:17:57 by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Alerte generated by hbm2java
 */
@Entity
@Table(name = "alerte", catalog = "projet")
public class Alerte implements java.io.Serializable {

	private Integer idAlerte;
	private Utilisateurs utilisateurs;
	private Set<MotsclefsHasAlerte> motsclefsHasAlertes = new HashSet<MotsclefsHasAlerte>(0);

	public Alerte() {
	}

	public Alerte(Utilisateurs utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Alerte(Utilisateurs utilisateurs, Set<MotsclefsHasAlerte> motsclefsHasAlertes) {
		this.utilisateurs = utilisateurs;
		this.motsclefsHasAlertes = motsclefsHasAlertes;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "alerte")
	public Set<MotsclefsHasAlerte> getMotsclefsHasAlertes() {
		return this.motsclefsHasAlertes;
	}

	public void setMotsclefsHasAlertes(Set<MotsclefsHasAlerte> motsclefsHasAlertes) {
		this.motsclefsHasAlertes = motsclefsHasAlertes;
	}

}
