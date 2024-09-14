package com.biblioteca.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoginApplication {
	public static int tentativas = 3;
	public static Pessoa usuarioLogado;
		public static void main(String[] args) {

			Biblioteca biblioteca = new Biblioteca();
			InicializarDados.inicializar(biblioteca);
			Menu menu = new Menu(biblioteca);
			menu.exibirMenu();

	
			// Cadastrando os usuários na biblioteca
			/*biblioteca.cadastrarUsuario(usuario1);
			biblioteca.cadastrarUsuario(usuario2);
	
			// Emprestando um livro
			biblioteca.emprestarLivro(usuario1, livro1);
	
			// Exibindo os livros disponíveis
			biblioteca.exibirLivros();
	
			// Devolvendo um livro
			biblioteca.devolverLivro(usuario1, livro1);
	
			// Exibindo o histórico de empréstimos do usuário
			usuario1.exibirHistorico();*/
		}
	}
