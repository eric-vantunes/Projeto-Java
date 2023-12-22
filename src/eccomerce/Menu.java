package eccomerce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import controller.Controller;
import model.produto.Produto;
import model.produto.ProdutoEletronico;
import model.produto.ProdutoLivros;
import repository.produto.ProdutoRepository;

public class Menu {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		Controller produtos = new Controller();
		int opcao, numero, qtdPaginas = 0;
		String nome, tipo, nomeLivro, modelo = null;

		ProdutoLivros p1 = new ProdutoLivros(produtos.gerarNumero(), 100, "JavaScript", "Livro", "Editora collins");
		produtos.adicionarProduto(p1);

		ProdutoEletronico p2 = new ProdutoEletronico(produtos.gerarNumero(), "Notebook", "Eletronico", "LG");
		produtos.adicionarProduto(p2);

		while (true) {
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                ECCOMERCE                            ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("\n(1) Adicionar produto");
			System.out.println("\n(2) Buscar produto por número");
			System.out.println("\n(3) Listar todos os produtos");
			System.out.println("\n(4) Atualizar produto");
			System.out.println("\n(5) Deletar produto");
			System.out.println("\n(0) Sair");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				opcao = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros! ");
				input.nextLine();
				opcao = 100;
			}

			if (opcao == 0) {
				System.out.println("\nEccomerce Eletrônico - Obrigado por utilizar o nosso sistema");
				input.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Adicionar Produto\n\n");

				System.out.println("Digite o tipo do Produto (Eletrônico ou Livro): ");
				input.skip("\\R");
				tipo = input.nextLine();

				switch (tipo) {
				case "Livro":
					System.out.println("Digite o nome do Livro: ");
					nomeLivro = input.nextLine();
					System.out.println("Digite a quantidade de páginas: ");
					qtdPaginas = input.nextInt();
					produtos.adicionarProduto(new ProdutoLivros(produtos.gerarNumero(), 2 ,nomeLivro, tipo, modelo));
					break;
				case "Eletronico":
					System.out.println("Digite o produto Eletrônico: ");
					nome = input.nextLine();
					produtos.adicionarProduto(new ProdutoEletronico(produtos.gerarNumero(), nome, tipo, modelo));
					break;
				}

				break;

			case 2:
				System.out.println("Listar todos os Produtos\n\n");
				produtos.listarTodosProdutos();

				keyPress();
				break;
			case 3:
				System.out.println("Buscar produto por número\n\n");

				System.out.println("Digite o número do produto: ");
				numero = input.nextInt();

				produtos.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar Produto\n\n");

				System.out.println("Digite o número do Produto: ");
				numero = input.nextInt();

				Optional<Produto> produto = produtos.buscarNaCollection(numero);

				if (produto.isPresent()) {
					System.out.println("Digite o nome do Produto: ");
					input.skip("\\R");
					nome = input.nextLine();

					tipo = produto.get().getTipo();

				} else
					System.out.println("O produto de número: " + numero + " não foi encontrado");

				keyPress();
				break;

			case 5:
				System.out.println("Deletar Produto\n\n");

				System.out.println("Digite o numero do produto que deseja deletar: ");
				numero = input.nextInt();

				produtos.deletarProduto(numero);

				keyPress();
				break;
			}

		}

	}

	public static void keyPress() {

		try {

			System.out.println("\n\nPressione a tecla Enter para continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla inválida!");

		}
	}
}
