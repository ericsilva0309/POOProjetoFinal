package com.biblioteca.login;

import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Biblioteca biblioteca;

    // Construtor para receber a instância da Biblioteca
    public Menu(Biblioteca biblioteca) {
        this.scanner = new Scanner(System.in);
        this.biblioteca = biblioteca;
    }

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.biblioteca = new Biblioteca();
    }

    public void exibirMenu() {
        while (true) {
            limparTela();
            System.out.println("==== Sistema de Biblioteca ====");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Cadastrar Usuário");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Exibir Livros Disponíveis");
            System.out.println("6. Exibir Histórico de Empréstimos");
            System.out.println("7. Exibir Usuários");
            System.out.println("8. Avaliar Livro");
            System.out.println("9. Exibir Avaliações de Livro");
            System.out.println("10. Exibir histórico de devoluções");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    cadastrarUsuario();
                    break;
                case 3:
                    emprestarLivro();
                    break;
                case 4:
                    devolverLivro();
                    break;
                case 5:
                    biblioteca.exibirLivros();
                    pausar();
                    break;
                case 6:
                    exibirHistorico();
                    pausar();
                    break;
                case 7:
                    biblioteca.exibirUsuarios();
                    pausar();
                    break;
                case 8:
                    avaliarLivro();
                    pausar();
                    break;
                case 9:
                    exibirAvaliacoes();
                    pausar();
                    break;
                case 10:
                    biblioteca.exibirDevolucoes();
                    pausar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;  // Sai do programa
                default:
                    System.out.println("Opção inválida.");
                    pausar();
                    break;
            }
        }
    }

    // Método para pausar a tela até que o usuário pressione Enter
    public void pausar() {
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }

    // Métodos para cadastro e operações
    public void cadastrarLivro() {
        System.out.println("=== Cadastrar Livro ===");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        scanner.nextLine();  // Consumir quebra de linha

        Livro livro = new Livro(titulo, autor, categoria, ano);
        biblioteca.cadastrarLivro(livro);
        pausar();
    }

    public void cadastrarUsuario() {
        try {
            System.out.println("=== Cadastrar Usuário ===");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Data de Nascimento: ");
            String dataNascimento = scanner.nextLine();
            System.out.print("Logradouro: ");
            String logradouro = scanner.nextLine();
            System.out.print("Número: ");
            String numero = scanner.nextLine();
            System.out.print("Complemento: ");
            String complemento = scanner.nextLine();
            System.out.print("Bairro: ");
            String bairro = scanner.nextLine();
            System.out.print("Cidade: ");
            String cidade = scanner.nextLine();
            System.out.print("Estado: ");
            UnidadeFederal estado = UnidadeFederal.fromString(scanner.nextLine());
            System.out.print("CEP: ");
            String cep = scanner.nextLine();
            System.out.print("Referência: ");
            String referencia = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Login: ");
            String login = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();
    
            Endereco endereco = new Endereco();
            endereco.setLogradouro(logradouro);
            endereco.setNumero(numero);
            endereco.setComplemento(complemento);
            endereco.setBairro(bairro);
            endereco.setCidade(cidade);
            endereco.setEstado(estado);
            endereco.setCep(cep);
            endereco.setReferencia(referencia);

            Usuario usuario = new Usuario(nome, cpf, dataNascimento, endereco, email, telefone, login, senha);
            biblioteca.cadastrarUsuario(usuario);
            biblioteca.cadastrarUsuario(usuario);
        System.out.println("Usuário cadastrado com sucesso.");
    } catch (IllegalArgumentException e) {
        System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Erro inesperado: " + e.getMessage());
    }
    pausar();
}

    public void emprestarLivro() {
        System.out.println("=== Emprestar Livro ===");
        System.out.print("Nome do Usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Título do Livro: ");
        String titulo = scanner.nextLine();

        Usuario usuario = buscarUsuario(nome);
        Livro livro = buscarLivro(titulo);

        if (usuario != null && livro != null) {
            biblioteca.emprestarLivro(usuario, livro);
        } else {
            System.out.println("Usuário ou livro não encontrado.");
        }
        pausar();
    }

    public void devolverLivro() {
        System.out.println("=== Devolver Livro ===");
        System.out.print("Nome do Usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Título do Livro: ");
        String titulo = scanner.nextLine();

        Usuario usuario = buscarUsuario(nome);
        Livro livro = buscarLivro(titulo);

        if (usuario != null && livro != null) {
            biblioteca.devolverLivro(usuario, livro);
        } else {
            System.out.println("Usuário ou livro não encontrado.");
        }
        pausar();
    }

    public void exibirHistorico() {
        System.out.println("=== Histórico de Empréstimos ===");
        System.out.print("Nome do Usuário: ");
        String nome = scanner.nextLine();

        Usuario usuario = buscarUsuario(nome);
        if (usuario != null) {
            usuario.exibirHistorico();
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void avaliarLivro() {
        System.out.println("=== Avaliar Livro ===");
        System.out.print("Nome do Usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Título do Livro: ");
        String tituloLivro = scanner.nextLine();
        System.out.print("Nota (1 a 5): ");
        int nota = scanner.nextInt();
        scanner.nextLine();  // Consumir quebra de linha
        System.out.print("Comentário: ");
        String comentario = scanner.nextLine();

        Usuario usuario = buscarUsuario(nomeUsuario);
        Livro livro = buscarLivro(tituloLivro);

        if (usuario != null && livro != null) {
            biblioteca.adicionarAvaliacao(usuario, livro, nota, comentario);
            System.out.println("Avaliação adicionada com sucesso.");
        } else {
            System.out.println("Usuário ou livro não encontrado.");
        }
    }

    public void exibirAvaliacoes() {
        System.out.print("Título do Livro: ");
        String tituloLivro = scanner.nextLine();
        Livro livro = buscarLivro(tituloLivro);

        if (livro != null) {
            livro.exibirDetalhes();
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    // Métodos auxiliares para buscar usuários e livros
    public Usuario buscarUsuario(String nome) {
        for (Usuario usuario : biblioteca.getUsuarios()) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null;
    }

    public Livro buscarLivro(String titulo) {
        for (Livro livro : biblioteca.getLivros()) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}