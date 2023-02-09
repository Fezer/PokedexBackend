package bantads.auth.model;

import java.io.Serializable;

public class PokemonDTO implements Serializable {

	private long id;
	private String nome;
	private String tipo;
	private String habilidades;
	private String foto;
	private String usuario;

	public PokemonDTO() {
		super();
	}
	
	public PokemonDTO(long id, String nome, String tipo, String habilidades, String foto, String usuario) {
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
}
