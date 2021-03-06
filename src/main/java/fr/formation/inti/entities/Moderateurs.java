package fr.formation.inti.entities;
// Generated 29 avr. 2019 15:09:20 by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Moderateurs generated by hbm2java
 */
@Entity
@Table(name = "moderateurs", catalog = "projet")
public class Moderateurs implements java.io.Serializable {

	private Integer idModerateurs;
	private String login;
	private int password;
	private String mail;
	private String adresse;

	public Moderateurs() {
	}

	public Moderateurs(String login, int password, String mail, String adresse) {
		this.login = login;
		this.password = password;
		this.mail = mail;
		this.adresse = adresse;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idModerateurs", unique = true, nullable = false)
	public Integer getIdModerateurs() {
		return this.idModerateurs;
	}

	public void setIdModerateurs(Integer idModerateurs) {
		this.idModerateurs = idModerateurs;
	}

	@Column(name = "Login", nullable = false, length = 45)
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

	@Column(name = "Mail", nullable = false, length = 45)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name = "Adresse", nullable = false, length = 45)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
