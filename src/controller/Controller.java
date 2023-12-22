package controller;

import java.util.ArrayList;
import java.util.Optional;

import model.produto.*;
import repository.produto.ProdutoRepository;

public class Controller implements ProdutoRepository {

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {

		Optional<Produto> produto = buscarNaCollection(numero);

		if (produto.isPresent())
			produto.get().visualizar();
		else
			System.out.println("O produto com o número: " + numero + " não foi encontrado!");
	}

	@Override
	public void listarTodosProdutos() {
		for (var produto : listaProdutos) {
			((Produto) produto).visualizar();
		}

	}

	@Override
	public void adicionarProduto(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("O produto: " + produto.getNumero() + " foi cadastrado com sucesso! ");

	}

	@Override
	public void atualizarProduto(Produto produto) {

		Optional<Produto> buscaProduto = buscarNaCollection(produto.getNumero());

		if (buscaProduto.isPresent()) {
			listaProdutos.set(listaProdutos.indexOf(buscaProduto.get()), produto);
			System.out.println("O produto numero: " + produto.getNumero() + " foi atualizado com sucesso!");
		} else
			System.out.println("O produto: " + produto.getNumero() + " não foi encontrado!");

	}

	@Override
	public void deletarProduto(int numero) {

		Optional<Produto> produto = buscarNaCollection(numero);

		if (produto.isPresent()) {
			if (listaProdutos.remove(produto.get()) == true)
				System.out.println("O produto: " + numero + " foi excluído com sucesso!");
		} else
			System.out.println("O produto: " + numero + " não foi encontrado!");

	}

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Produto> buscarNaCollection(int numero) {

		for (var conta : listaProdutos) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}

		return Optional.empty();
	}


}