package fr.formation.inti.Entities;
// Generated 26 avr. 2019 11:17:57 by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * AnnoncesHasMotsclefs generated by hbm2java
 */
@Entity
@Table(name = "annonces_has_motsclefs", catalog = "projet")
public class AnnoncesHasMotsclefs implements java.io.Serializable {

	private int annoncesIdAnnonces;
	private Annonces annonces;
	private Motsclefs motsclefs;

	public AnnoncesHasMotsclefs() {
	}

	public AnnoncesHasMotsclefs(Annonces annonces, Motsclefs motsclefs) {
		this.annonces = annonces;
		this.motsclefs = motsclefs;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "annonces"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "Annonces_idAnnonces", unique = true, nullable = false)
	public int getAnnoncesIdAnnonces() {
		return this.annoncesIdAnnonces;
	}

	public void setAnnoncesIdAnnonces(int annoncesIdAnnonces) {
		this.annoncesIdAnnonces = annoncesIdAnnonces;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Annonces getAnnonces() {
		return this.annonces;
	}

	public void setAnnonces(Annonces annonces) {
		this.annonces = annonces;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "motsclefs_idMotClef", nullable = false)
	public Motsclefs getMotsclefs() {
		return this.motsclefs;
	}

	public void setMotsclefs(Motsclefs motsclefs) {
		this.motsclefs = motsclefs;
	}

}
