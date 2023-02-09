package bantads.auth.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_usuarios")
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id_usu")
	private Long id;
	@Column(name = "login_usu")
	private String login;
	@Column(name = "senha_usu")
	private String senha;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String login, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}

}
