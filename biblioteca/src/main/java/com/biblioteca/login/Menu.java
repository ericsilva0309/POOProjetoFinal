package com.biblioteca.login;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {

    public static void admin() throws InputMismatchException {

        System.out.print("Olá " + BibliotecaApplication.usuarioLogado.getNome() + ". \n\n");
    
        int opcao = 20;
        do {
            System.out.println("==== Sistema de Biblioteca ====");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Exibir Livros Disponíveis");
            System.out.println("6. Exibir Histórico de Empréstimos");
            System.out.println("7. Exibir Usuários");
            //System.out.println("8. Avaliar Livro");
            System.out.println("9. Exibir Avaliações de Livro");
            System.out.println("10. Exibir histórico de devoluções");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            Scanner leia = new Scanner(System.in);

            try{
            opcao = leia.nextInt();
            System.out.println("\n");

            switch (opcao) {
                case 1:
                    System.out.println("cadastrarLivro()");
                   //Livro.cadastrarLivro();
                    break;
                case 2:
                    System.out.println("cadastrarUsuario()");
                    //cadastrarUsuario();
                    break;
                case 3:
                    System.out.println("emprestarLivro()");
                    //emprestarLivro();
                    break;
                case 4:
                    System.out.println("devolverLivro()");
                    //devolverLivro();
                    break;
                case 5:
                    System.out.println("biblioteca.exibirLivros()");
                    //biblioteca.exibirLivros();
                    //pausar();
                    break;
                case 6:
                    System.out.println("exibirHistorico()");
                    //exibirHistorico();
                    //pausar();
                    break;
                case 7:
                    System.out.println("biblioteca.exibirUsuarios()");
                   //biblioteca.exibirUsuarios();
                    //pausar();
                    break;
                case 8:
                    System.out.println("avaliarLivro()");
                    //avaliarLivro();
                    //pausar();
                    break;
                case 9:
                    System.out.println("exibirAvaliacoes()");
                    //exibirAvaliacoes();
                    //pausar();
                    break;
                case 10:
                    System.out.println("biblioteca.exibirDevolucoes()");
                    //biblioteca.exibirDevolucoes();
                    //pausar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;  // Sai do programa
                default:
                    System.out.println("Opção inválida.");
                    //pausar();
                    break;
            }
        }catch (InputMismatchException e){
           
          
            System.out.println("\nDigite uma das opções válidas.\n");
        }
            
        } while (opcao !=0);

    }

    public static void usuario(){

        System.out.print("Olá " + BibliotecaApplication.usuarioLogado.getNome() + ". \n\n");
    
        int opcao = 20;
        do {
            System.out.println("==== Sistema de Biblioteca ====");
            //System.out.println("1. Cadastrar Livro");
            //System.out.println("2. Cadastrar Usuário");
            //System.out.println("3. Emprestar Livro");
            //System.out.println("4. Devolver Livro");
            System.out.println("5. Exibir Livros Disponíveis");
            //System.out.println("6. Exibir Histórico de Empréstimos");
            //System.out.println("7. Exibir Usuários");
            System.out.println("8. Avaliar Livro");
            System.out.println("9. Exibir Avaliações de Livro");
            //System.out.println("10. Exibir histórico de devoluções");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            Scanner leia = new Scanner(System.in);

            try{
            opcao = leia.nextInt();
            System.out.println("\n");
            
            switch (opcao) {
                case 1:
                    System.out.println("cadastrarLivro()");
                   //Livro.cadastrarLivro();
                    break;
                case 2:
                    System.out.println("cadastrarUsuario()");
                    //cadastrarUsuario();
                    break;
                case 3:
                    System.out.println("emprestarLivro()");
                    //emprestarLivro();
                    break;
                case 4:
                    System.out.println("devolverLivro()");
                    //devolverLivro();
                    break;
                case 5:
                    System.out.println("biblioteca.exibirLivros()");
                    //biblioteca.exibirLivros();
                    //pausar();
                    break;
                case 6:
                    System.out.println("exibirHistorico()");
                    //exibirHistorico();
                    //pausar();
                    break;
                case 7:
                    System.out.println("biblioteca.exibirUsuarios()");
                   //biblioteca.exibirUsuarios();
                    //pausar();
                    break;
                case 8:
                    System.out.println("avaliarLivro()");
                    //avaliarLivro();
                    //pausar();
                    break;
                case 9:
                    System.out.println("exibirAvaliacoes()");
                    //exibirAvaliacoes();
                    //pausar();
                    break;
                case 10:
                    System.out.println("biblioteca.exibirDevolucoes()");
                    //biblioteca.exibirDevolucoes();
                    //pausar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;  // Sai do programa
                default:
                    System.out.println("Opção inválida.");
                    //pausar();
                    break;
            }

        }catch (InputMismatchException e){
           
            System.out.println("\nDigite uma das opções válidas.\n");
        }
            

        } while (opcao !=0);

    }
}