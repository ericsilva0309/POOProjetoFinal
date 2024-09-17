package com.biblioteca.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    public class Biblioteca {
    
        private Scanner sc = new Scanner(System.in);
        private List<Livro> livros = new ArrayList<>();
        private List<Usuario> usuarios = new ArrayList<>();
    
        // Método para cadastrar um livro
        public void cadastrarLivro(Livro livro) {
            try {
                if (livro == null) {
                    throw new IllegalArgumentException("O livro não pode ser nulo.");
                }
                livros.add(livro);
                System.out.println("Livro cadastrado com sucesso: " + livro.getTitulo());
            } catch (Exception e) {
                System.out.println("Erro ao cadastrar livro: " + e.getMessage());
            }
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
    
        // Método para adicionar avaliação
        public void adicionarAvaliacao(Usuario usuario, Livro livro, int nota, String comentario) {
            try {
                if (usuario == null || livro == null) {
                    throw new IllegalArgumentException("Usuário ou livro não podem ser nulos.");
                }
                if (nota < 1 || nota > 5) {
                    throw new IllegalArgumentException("A nota deve ser entre 1 e 5.");
                }
                Avaliacao avaliacao = new Avaliacao(usuario, livro, nota, comentario);
                livro.adicionarAvaliacao(avaliacao);
            } catch (Exception e) {
                System.out.println("Erro ao adicionar avaliação: " + e.getMessage());
            }
        }
    
        // Método para emprestar um livro
        public void emprestarLivro(Usuario usuario, Livro livro) {
            try {
                if (usuario == null || livro == null) {
                    throw new IllegalArgumentException("Usuário ou livro não podem ser nulos.");
                }
                if (livro.isDisponivel()) {
                    livro.setDisponivel(false);
                    usuario.adicionarEmprestimo(livro);
                    System.out.println("Livro " + livro.getTitulo() + " emprestado a " + usuario.getNome());
                } else {
                    System.out.println("Livro indisponível.");
                }
            } catch (Exception e) {
                System.out.println("Erro ao emprestar livro: " + e.getMessage());
            }
        }
    
        // Método para devolver um livro
        public void devolverLivro(Usuario usuario, Livro livro) {
            try {
                if (usuario == null || livro == null) {
                    throw new IllegalArgumentException("Usuário ou livro não podem ser nulos.");
                }
                livro.setDisponivel(true);
                System.out.println("Livro " + livro.getTitulo() + " devolvido por " + usuario.getNome());
            } catch (Exception e) {
                System.out.println("Erro ao devolver livro: " + e.getMessage());
            }
        }
    
        // Método para exibir todos os usuários cadastrados
        public void exibirUsuarios() {
            try {
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
            } catch (Exception e) {
                System.out.println("Erro ao exibir usuários: " + e.getMessage());
            }
        }
    
        // Método para exibir todos os livros da biblioteca
        public void exibirLivros() {
            try {
                System.out.println("Lista de Livros na Biblioteca:");
                if (livros.isEmpty()) {
                    System.out.println("Nenhum livro cadastrado.");
                } else {
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
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Digite um número.");
                sc.nextLine();  // Limpa a entrada inválida
            } catch (Exception e) {
                System.out.println("Erro ao exibir livros: " + e.getMessage());
            }
        }
    
        public void buscarLivrosPorAutor() {
            try {
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
            } catch (Exception e) {
                System.out.println("Erro ao buscar livros por autor: " + e.getMessage());
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
            try {
                System.out.println("=== Buscar Livros por Título ===");
                System.out.print("Título do livro: ");
                String titulo = sc.nextLine();

                List<Livro> livros = buscarLivrosPorTitulo(titulo);

                if (livros.isEmpty()) {
                    System.out.println("Nenhum livro encontrado com título " + titulo);
                } else {
                    for (Livro livro : livros) {
                        livro.exibirDetalhes();
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro ao buscar livros por título: " + e.getMessage());
            }
        }
    
        public List<Livro> buscarLivrosPorTitulo(String titulo) {
            List<Livro> resultado = new ArrayList<>();
            
            // Verifica se o título é nulo ou vazio
            if (titulo == null || titulo.trim().isEmpty()) { //O método .trim() em Java é usado para remover espaços em branco do início e do fim de uma String.
                System.out.println("Título inválido. Por favor, forneça um título não vazio.");
                return resultado;
            }
        
            try {
                for (Livro livro : livros) {
                    if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                        resultado.add(livro);
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro ao buscar livros: " + e.getMessage());
            }
            
            return resultado;
        }
        
    
        public void pausar() {
            System.out.println("Pressione Enter para continuar...");
            sc.nextLine();
        }

        

    }
    