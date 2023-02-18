package bantads.auth.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tb_pokemon")
public class Pokemon implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "id_pok")
	private long id;
	@Column(name = "nome_pok", unique=true)
	private String nome;
	@Column(name = "tipo_pok")
	private String tipo;
	@Column(name = "hab_pok")
	private String habilidades;
	@Column(name = "foto_pok")
	private byte[] foto;
	@Column(name = "user_pok")
	private String usuario;

	public Pokemon() {
		super();
	}

	public Pokemon(long id, String nome, String tipo, String habilidades, byte[] foto, String usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.habilidades = habilidades;
		this.foto = foto;
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
