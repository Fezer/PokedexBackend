package bantads.auth.model;

public class TopPokemon {

	private String item;
	private int quantidade;
	
	public TopPokemon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TopPokemon(String item, int quantidade) {
		super();
		this.item = item;
		this.quantidade = quantidade;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
}
