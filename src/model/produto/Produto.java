package model.produto;

public abstract class Produto {

	private int numero;
	private String produto;
	private String tipo;

	public Produto(int numero, String produto, String tipo) {
		this.numero = numero;
		this.produto = produto;
		this.tipo = tipo;
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;

	}
	
public void visualizar() {
		
		String tipo = "";
		
		switch(this.tipo) {
			case "Livro" -> tipo = "Livro";
			case "Eletronico" -> tipo = "Eletrônico";
		}
		
		System.out.println("\n\n***************************************");
		System.out.println("Dados do produto");
		System.out.println("***************************************");
		System.out.println("Número do produto: " + this.numero);
		System.out.println("Nome do produto: " + this.produto);
		System.out.println("Tipo do produto: " + this.tipo);

	}
}
