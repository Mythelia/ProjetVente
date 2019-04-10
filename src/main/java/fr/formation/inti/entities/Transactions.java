package fr.formation.inti.entities;
// Generated 10 avr. 2019 10:51:44 by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Transactions generated by hbm2java
 */
@Entity
@Table(name = "transactions", catalog = "projet")
public class Transactions implements java.io.Serializable {

	private int idTransactions;
	private Utilisateurs utilisateurs;
	private Set<Annonces> annonceses = new HashSet<Annonces>(0);

	public Transactions() {
	}

	public Transactions(int idTransactions, Utilisateurs utilisateurs) {
		this.idTransactions = idTransactions;
		this.utilisateurs = utilisateurs;
	}

	public Transactions(int idTransactions, Utilisateurs utilisateurs, Set<Annonces> annonceses) {
		this.idTransactions = idTransactions;
		this.utilisateurs = utilisateurs;
		this.annonceses = annonceses;
	}

	@Id

	@Column(name = "idTransactions", unique = true, nullable = false)
	public int getIdTransactions() {
		return this.idTransactions;
	}

	public void setIdTransactions(int idTransactions) {
		this.idTransactions = idTransactions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Utilisateurs_idUtilisateurs", nullable = false)
	public Utilisateurs getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(Utilisateurs utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transactions")
	public Set<Annonces> getAnnonceses() {
		return this.annonceses;
	}

	public void setAnnonceses(Set<Annonces> annonceses) {
		this.annonceses = annonceses;
	}

}
