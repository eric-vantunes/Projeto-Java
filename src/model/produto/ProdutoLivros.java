package model.produto;

public class ProdutoLivros extends Produto{
	
	private String nomeLivro;
	private int qtdPaginas;

	public ProdutoLivros(int qtdPaginas, int numero, String produto, String nomeLivro, String tipo) {
		super(numero, produto, tipo);
		this.nomeLivro = nomeLivro;
		this.qtdPaginas = qtdPaginas;
	}
	
	public int getNomeLivro() {
		return getNomeLivro();
	}

	public void setNomeLivro(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}
	

	public int getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(int qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}
	
}
