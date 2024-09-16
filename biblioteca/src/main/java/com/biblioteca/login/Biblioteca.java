package com.biblioteca.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Biblioteca {

    private Scanner sc = new Scanner(System.in);
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<String> devolucoes = new ArrayList<String>();

    // Método para cadastrar um livro
    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso: " + livro.getTitulo());
    }

    // Método para cadastrar um usuário
    public void cadastrarUsuario(Usuario usuario) {
        try {
            if (usuario == null) {
                throw new IllegalArgumentException("Usuário não pode ser nulo.");
            }
            usuarios.add(usuario);
            System.out.println("Usuário cadastrado com sucesso: " + usuario.getNome());
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    public void adicionarAvaliacao(Usuario usuario, Livro livro, int nota, String comentario) {
        Avaliacao avaliacao = new Avaliacao(usuario, livro, nota, comentario);
        livro.adicionarAvaliacao(avaliacao);
    }

    // Método para emprestar um livro
    public void emprestarLivro(Usuario usuario, Livro livro) {
        if (livro.isDisponivel()) {
            livro.setDisponivel(false);
            usuario.adicionarEmprestimo(livro);
            System.out.println("Livro " + livro.getTitulo() + " emprestado a " + usuario.getNome());
        } else {
            System.out.println("Livro indisponível.");
        }
    }

    // Método para devolver um livro
    public void devolverLivro(Usuario usuario, Livro livro) {
        Date now = new Date();
        try {
            livro.setDisponivel(true);
            System.out.println("Livro " + livro.getTitulo() + " devolvido por " + usuario.getNome());
            devolucoes.add(usuario.getNome() + " devolveu: " + livro.getTitulo() + " às " + now);
        } catch (Exception e) {
            System.out.println("Erro ao devolver livro: " + e.getMessage());
        }
    }

    public void exibirDevolucoes() {
        if (devolucoes.isEmpty()) {
            System.out.println("Nenhuma devolução registrada.");
        } else {
            System.out.println("=== Lista de Devoluções ===");
            for (String devolucao : devolucoes) {
                System.out.println(devolucao);
            }
        }
    }


    // Método para exibir todos os usuários cadastrados
    public void exibirUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("=== Usuários Cadastrados ===");
            for (Usuario usuario : usuarios) {
                System.out.println("Nome: " + usuario.getNome());
                System.out.println("CPF: " + usuario.getCpf());
                System.out.println("Data de Nascimento: " + usuario.getDataNascimento());
                System.out.println("Endereço: " + usuario.getEndereco().getLogradouro() + ", " +
                                   usuario.getEndereco().getNumero() + ", " +
                                   usuario.getEndereco().getCidade() + ", " +
                                   usuario.getEndereco().getEstado().getNomePorExtenso());
                System.out.println("Email: " + usuario.getEmail());
                System.out.println("Telefone: " + usuario.getTelefone());
                System.out.println("Login: " + usuario.getLogin());
                System.out.println("Senha: " + usuario.getSenha());
                System.out.println();
            }
        }
    }

    // Método para exibir todos os livros da biblioteca
    public void exibirLivros() {
        System.out.println("Lista de Livros na Biblioteca:");
        for (Livro livro : livros) {
            livro.exibirDetalhes();
        }
        System.out.println("""
                Pesquisar por:
                1- Autor.
                2- Livro.
                0- Voltar.
                Digite uma opção: 
                """);
        int opcao = sc.nextInt();
        sc.nextLine(); // Consumir quebra de linha após lerInt()
    
        switch (opcao) {
            case 1:
                buscarLivrosPorAutor();
                break;
            case 2:
                buscarLivrosPorTitulo();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida.");
                pausar();
                break;
        }
    }

    public void buscarLivrosPorAutor() {
        System.out.println("=== Buscar Livros por Autor ===");
        System.out.print("Nome do Autor: ");
        String autor = sc.nextLine();

        List<Livro> livros = buscarLivrosPorAutor(autor);

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado para o autor " + autor);
        } else {
            for (Livro livro : livros) {
                livro.exibirDetalhes();
            }
        }
    }

    public List<Livro> buscarLivrosPorAutor(String autor) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }
    public void buscarLivrosPorTitulo() {
        System.out.println("=== Buscar Livros por Título ===");
        System.out.print("Título do livro: ");
        String título = sc.nextLine();

        List<Livro> livros = buscarLivrosPorTitulo(título);

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado com título " + título);
        } else {
            for (Livro livro : livros) {
                livro.exibirDetalhes();
            }
        }
    }

    public List<Livro> buscarLivrosPorTitulo(String titulo) {
        List<Livro> resultado = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                resultado.add(livro);
            }
        }
        return resultado;
    }

    public void pausar() {
        System.out.println("Pressione Enter para continuar...");
        sc.nextLine();
    }
}