package com.biblioteca.login;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.InputMismatchException;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Biblioteca biblioteca = new Biblioteca();   
    public void admin() throws InputMismatchException {
        InicializarDados.inicializar(biblioteca); 
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
            System.out.println("8. Exibir Avaliações de Livro");
            System.out.println("9. Exibir histórico de devoluções");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            Scanner leia = new Scanner(System.in);

            try{
            opcao = leia.nextInt();
            System.out.println("\n");

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
                    break;
                case 7:
                    biblioteca.exibirUsuarios();
                    pausar();
                    break;
                case 8:
                    exibirAvaliacoes();
                    pausar();
                    break;
                case 9:
                    System.out.println("biblioteca.exibirDevolucoes()");
                    //AINDA TEM QUE SER IMPLEMENTADO
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

    public void usuario(){
        InicializarDados.inicializar(biblioteca);
        System.out.print("Olá " + BibliotecaApplication.usuarioLogado.getNome() + ". \n\n");
    
        int opcao = 20;
        do {
            System.out.println("==== Sistema de Biblioteca ====");
            System.out.println("1. Pegar Livro");
            System.out.println("2. Exibir Livros Disponíveis");
            System.out.println("3. Avaliar Livro");
            System.out.println("4. Exibir Avaliações de Livro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            Scanner leia = new Scanner(System.in);

            try{
            opcao = leia.nextInt();
            System.out.println("\n");
            
            switch (opcao) {
                case 1:
                    emprestarLivro();
                    break;
                case 2:
                    biblioteca.exibirLivros();
                    break;
                case 3:
                    avaliarLivro();
                    break;
                case 4:
                    exibirAvaliacoes();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;  // Sai do programa
                default:
                    System.out.println("Opção inválida.");
                    pausar();
                    break;
            }

        }catch (InputMismatchException e){
           
            System.out.println("\nDigite uma das opções válidas.\n");
        }
            

        } while (opcao !=0);

    }
    // Método para pausar a tela até que o usuário pressione Enter
    public void pausar() {
        System.out.println("Pressione Enter para continuar...");
        scanner.nextLine();
    }
    

    // Métodos para cadastro e operações
    public void cadastrarLivro() {
    try {
        System.out.println("=== Cadastrar Livro ===");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        int ano = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.print("Ano: ");
                ano = scanner.nextInt();
                scanner.nextLine();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número inteiro para o ano.");
                scanner.nextLine(); // Limpar a entrada inválida do scanner
            }
        }

        Livro livro = new Livro(titulo, autor, categoria, ano);
        biblioteca.cadastrarLivro(livro);
    } catch (Exception e) {
        System.out.println("Erro ao cadastrar livro: " + e.getMessage());
    }
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
            UnidadeFederal estado;
        while (true) {
            System.out.print("Estado (UF): ");
            String estadoInput = scanner.nextLine();
            try {
                estado = UnidadeFederal.fromString(estadoInput);
                break; // Estado válido, sai do loop
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: Estado inválido. Tente novamente.");
            }
        }
            System.out.print("CEP: ");
            String cep = scanner.nextLine();
            System.out.print("Referência: ");
            String referencia = scanner.nextLine();
            String email;
        while (true) {
            System.out.print("Email: ");
            email = scanner.nextLine();
            if (email.endsWith("@gmail.com")) {
                break; // Email válido, sai do loop
            } else {
                System.out.println("Erro: O email deve terminar com '@gmail.com'. Tente novamente.");
            }
        }
            System.out.print("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Login: ");
            String login = scanner.nextLine();
            String senha;
            while (true) {
                System.out.print("Senha: ");
                senha = scanner.nextLine();
                System.out.println("Senha digitada: " + senha);  // Debug: Verificar a senha digitada
                if (isSenhaValida(senha)) {
                    break; // Senha válida, sai do loop
                } else {
                    System.out.println("Erro: A senha deve conter pelo menos uma letra maiúscula, 6 dígitos e um caractere especial.");
                }
            }
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

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar usuário: \n" + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
        pausar();
    }

    private boolean isSenhaValida(String senha) {
        // Expressão regular para validar a senha
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{6,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(senha);
        return matcher.matches();
    }

    public void emprestarLivro() {
        try {
            System.out.println("=== Emprestar Livro ===");
            System.out.print("Nome do Usuário: ");
            String nome = scanner.nextLine();
            System.out.print("Título do Livro: ");
            String titulo = scanner.nextLine();

            Usuario usuario = buscarUsuario(nome);
            Livro livro = buscarLivro(titulo);

            if (usuario == null) {
                System.out.println("Usuário não encontrado.");
            } else if (livro == null) {
                System.out.println("Livro não encontrado.");
            } else if (!livro.isDisponivel()) {
                System.out.println("O livro não está disponível para empréstimo.");
            } else {
                biblioteca.emprestarLivro(usuario, livro);
                System.out.println("Empréstimo realizado com sucesso.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar empréstimo: " + e.getMessage());
        } finally {
            pausar();
        }
    }

    public void devolverLivro() {
        try {
            System.out.println("=== Devolver Livro ===");
            System.out.print("Nome do Usuário: ");
            String nome = scanner.nextLine();
            System.out.print("Título do Livro: ");
            String titulo = scanner.nextLine();
    
            Usuario usuario = buscarUsuario(nome);
            Livro livro = buscarLivro(titulo);
    
            if (usuario == null) {
                System.out.println("Usuário não encontrado.");
            } else if (livro == null) {
                System.out.println("Livro não encontrado.");
            } else if (!usuario.getHistoricoEmprestimos().contains(livro)) {
                System.out.println("O livro não está no histórico de empréstimos deste usuário.");
            } else {
                biblioteca.devolverLivro(usuario, livro);
                System.out.println("Devolução realizada com sucesso.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao realizar devolução: " + e.getMessage());
        } finally {
            pausar();
        }
    }

    public void exibirHistorico() {
        try {
            System.out.println("=== Histórico de Empréstimos ===");
            System.out.print("Nome do Usuário: ");
            String nome = scanner.nextLine();
    
            Usuario usuario = buscarUsuario(nome);
    
            if (usuario != null) {
                usuario.exibirHistorico();
            }
        } catch (Exception e) {
            System.out.println("Erro ao exibir histórico: " + e.getMessage());
        } finally {
            pausar();
        }
    }

    public void avaliarLivro() {
        try {
            System.out.println("=== Avaliar Livro ===");

            Usuario usuario = null;
            String nomeDoUsuario;
            while (usuario == null) {
            try {
                System.out.print("Nome do Usuário: ");
                nomeDoUsuario = scanner.nextLine();
                usuario = buscarUsuario(nomeDoUsuario);

                if (nomeDoUsuario == null) {
                    System.out.println("Usuário não encontrado. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro ao buscar usuário: " + e.getMessage());
            }
        }
        Livro livro = null;
        String tituloLivro;
        while (livro == null) {
            try{
            System.out.print("Título do Livro: ");
            tituloLivro = scanner.nextLine();
            livro = buscarLivro(tituloLivro);

            if (livro == null){
                System.out.println("Livro nao encontrado. Tente novamente.");
            }
        }catch(Exception e){
            System.out.println("Erro ao buscar livro: " + e.getMessage());
        }
    }

            int nota = 0;
            boolean notavaliada = false;
            while(!notavaliada){
            System.out.print("Nota (1 a 5): ");
            try{
            nota = scanner.nextInt();
            scanner.nextLine();  // Consumir quebra de linha

            // Verificar se a nota está dentro do intervalo permitido
            if (nota < 1 || nota > 5) {
                System.out.println("Nota inválida. A nota deve estar entre 1 e 5.");
            }else{
                notavaliada = true; //nota válida, sai do loop
            }
        }
            catch(InputMismatchException e){
                System.out.println("Entrada inválida. Por favor, insira um número inteiro para nota");
                scanner.nextLine();
            }
        }
            System.out.print("Comentário: ");
            String comentario = scanner.nextLine();

            if (usuario != null && livro != null) {
                biblioteca.adicionarAvaliacao(usuario, livro, nota, comentario);
                System.out.println("Avaliação adicionada com sucesso.");
            } else {
                System.out.println("Usuário ou livro não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao avaliar livro: " + e.getMessage());
        }
    }

    public void exibirAvaliacoes() {
        try {
            System.out.print("Título do Livro: ");
            String tituloLivro = scanner.nextLine();
            Livro livro = buscarLivro(tituloLivro);
    
            if (livro != null) {
                livro.exibirDetalhes(); // Verifique se este método está exibindo as avaliações corretamente
            } else {
                System.out.println("Livro não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao exibir avaliações: " + e.getMessage());
        }
    }

    // Métodos auxiliares para buscar usuários e livros
    public Usuario buscarUsuario(String nome) {
        try {
            for (Usuario usuario : biblioteca.getUsuarios()) {
                if (usuario.getNome().equalsIgnoreCase(nome)) {
                    return usuario;
                }
            }
            System.out.println("Usuário não encontrado.");
            return null;  // Retorna null se o usuário não for encontrado
        } catch (Exception e) {
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
            return null;  // Retorna null em caso de erro
        }
    }

    public Livro buscarLivro(String titulo) {
        try {
            for (Livro livro : biblioteca.getLivros()) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    return livro;
                }
            }
            System.out.println("Livro não encontrado.");
            return null;  // Retorna null se o livro não for encontrado
        } catch (Exception e) {
            System.out.println("Erro ao buscar livro: " + e.getMessage());
            return null;  // Retorna null em caso de erro
        }
    }

    public void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}