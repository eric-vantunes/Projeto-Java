package model.produto;

public class ProdutoEletronico extends Produto{
	
	private String modelo;

	public ProdutoEletronico(int numero, String produto, String tipo, String modelo) {
		super(numero, produto, tipo);
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	
}
