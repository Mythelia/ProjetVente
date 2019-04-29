package fr.formation.inti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login implements java.io.Serializable {

	private static final long serialVersionUID = 2061732774328893839L;

	@Id
	private Integer idUtilisateurs;

	private String login;

	private int nbrMessage;

	public Login() {
	}

	public Login(Integer idUtilisateurs, String login) {
		super();
		this.idUtilisateurs = idUtilisateurs;
		this.login = login;
	}

	public Login(Integer idUtilisateurs, String login, int nbrMessage) {
		super();
		this.idUtilisateurs = idUtilisateurs;
		this.login = login;
		this.nbrMessage = nbrMessage;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getIdUtilisateurs() {
		return idUtilisateurs;
	}

	public void setIdUtilisateurs(Integer idUtilisateurs) {
		this.idUtilisateurs = idUtilisateurs;
	}

	public int getNbrMessage() {
		return nbrMessage;
	}

	public void setNbrMessage(int nbrMessage) {
		this.nbrMessage = nbrMessage;
	}

}