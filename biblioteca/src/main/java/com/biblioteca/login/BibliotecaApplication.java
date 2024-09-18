package com.biblioteca.login;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BibliotecaApplication {
	public static int tentativas = 3;
	public static Pessoa usuarioLogado;
		public static void main(String[] args) {
			SpringApplication.run(BibliotecaApplication.class, args);

			Biblioteca biblioteca = new Biblioteca();
			InicializarDados.inicializar(biblioteca);


			while(tentativas > 0){
				System.out.println("       .--.                   .---.");
				System.out.println("   .---|__|           .-.     |~~~|");
				System.out.println(".--|===|--|_          |_|     |~~~|--.");
				System.out.println("|  |===|  |'\\     .---!~|  .--|   |--|");
				System.out.println("|%%|   |  |.'\\    |===| |--|%%|   |  |");
				System.out.println("|%%|   |  |\\.'\\   |   | |__|  |   |  |");
				System.out.println("|  |   |  | \\  \\  |===| |==|  |   |  |");
				System.out.println("|  |   |__|  \\.'\\ |   |_|__|  |~~~|__|");
				System.out.println("|  |===|--|   \\.'\\|===|~|--|%%|~~~|--|");
				System.out.println("^--^---'--^    `-'`---^-^--^--^---'--'");
		
				System.out.println("          ,..........   ..........,         ");
				System.out.println("     ,..,'          '.'          ',..,     ");
				System.out.println("    ,' ,'            :            ', ',    ");
				System.out.println("   ,' ,'             :             ', ',   ");
				System.out.println("  ,' ,'              :              ', ',  ");
				System.out.println(" ,' ,'............., : ,.............', ', ");
				System.out.println(",'  '............   '.'   ............'  ',");
				System.out.println(" '''''''''''''''''';''';'''''''''''''''''' ");
				System.out.println("                    '''                      ");

				System.out.println("╔════════════════════════════════════════════════════╗");
				System.out.println("║                                                    ║");
				System.out.println("║            ╔═══╗ BEM-VINDO À BIBLIOTECA            ║");
				System.out.println("║            ║ B ║ LOGIN                             ║");
				System.out.println("║            ╚═══╝                                   ║");
				System.out.println("║                                                    ║");
				System.out.println("║         Por favor, insira suas credenciais         ║");
				System.out.println("║                                                    ║");
				System.out.println("╚════════════════════════════════════════════════════╝");
				
				Scanner leia = new Scanner(System.in);
				System.out.println(" - Login - ");
				System.out.print("Usuário: ");
				String loginDigitado = leia.nextLine();
				System.out.print("Senha: ");
				String senhaDigitada = leia.nextLine();
				
				if( autorizaCredenciais(loginDigitado, senhaDigitada) ){
					tentativas=3;
					usuarioLogado.login();
				} else if ( tentativas > 1){
					System.out.println("Login ou senha incorretos!");
					tentativas--;
					System.out.println(tentativas + " tentativas restantes");
				} else {
					tentativas--;
					System.out.println("Cadastro bloqueado!");
			}
		}
	}

	public static boolean autorizaCredenciais(String loginDigitado, String senhaDigitada) {
		
		for (Pessoa p : Pessoa.listaDeUsuarios) {
			
			if (p.getLogin().equals(loginDigitado) && p.getSenha().equals(senhaDigitada)) {
				usuarioLogado = p;
				return true;
			}
		}
		return false;

	
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
