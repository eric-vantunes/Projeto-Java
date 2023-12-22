package repository.produto;

import java.util.List;

import model.produto.Produto;

public interface ProdutoRepository {

    public void adicionarProduto(Produto produto);
    public void procurarPorNumero(int numero);
    public void listarTodosProdutos();
    public void atualizarProduto(Produto produto);
    public void deletarProduto(int numero);
}
