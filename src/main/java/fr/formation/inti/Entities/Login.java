package fr.formation.inti.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Login implements java.io.Serializable {


    private static final long serialVersionUID = 2061732774328893839L;

    @Id
    private Integer idUtilisateurs;

    private String login;



    public Login() {}

    public Login(Integer idUtilisateurs, String login) {
        super();
        this.idUtilisateurs = idUtilisateurs;
        this.login = login;
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
    
    


}