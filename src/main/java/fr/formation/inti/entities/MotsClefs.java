package fr.formation.inti.entities;
// Generated 26 avr. 2019 11:17:57 by Hibernate Tools 5.1.10.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "motsclefs", catalog = "projet")
public class MotsClefs implements java.io.Serializable {

	private Integer idMotClef;
	private String motClef;
	private MotsclefsHasAlerte motsclefsHasAlerte;
	private Set<AnnoncesHasMotsclefs> annoncesHasMotsclefses = new HashSet<AnnoncesHasMotsclefs>(0);

	public MotsClefs() {
	}

	public MotsClefs(String motClef) {
		this.motClef = motClef;
	}

	public MotsClefs(String motClef, MotsclefsHasAlerte motsclefsHasAlerte,
			Set<AnnoncesHasMotsclefs> annoncesHasMotsclefses) {
		this.motClef = motClef;
		this.motsclefsHasAlerte = motsclefsHasAlerte;
		this.annoncesHasMotsclefses = annoncesHasMotsclefses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idMotClef", unique = true, nullable = false)
	public Integer getIdMotClef() {
		return this.idMotClef;
	}

	public void setIdMotClef(Integer idMotClef) {
		this.idMotClef = idMotClef;
	}

	@Column(name = "MotClef", nullable = false, length = 45)
	public String getMotClef() {
		return this.motClef;
	}

	public void setMotClef(String motClef) {
		this.motClef = motClef;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "motsclefs")
	public MotsclefsHasAlerte getMotsclefsHasAlerte() {
		return this.motsclefsHasAlerte;
	}

	public void setMotsclefsHasAlerte(MotsclefsHasAlerte motsclefsHasAlerte) {
		this.motsclefsHasAlerte = motsclefsHasAlerte;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "motsclefs")
	public Set<AnnoncesHasMotsclefs> getAnnoncesHasMotsclefses() {
		return this.annoncesHasMotsclefses;
	}

	public void setAnnoncesHasMotsclefses(Set<AnnoncesHasMotsclefs> annoncesHasMotsclefses) {
		this.annoncesHasMotsclefses = annoncesHasMotsclefses;
	}

}
