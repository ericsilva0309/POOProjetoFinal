package com.biblioteca.login;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Emprestimo {

    public static List<Emprestimo> emprestimos = new ArrayList<>();
    public static List<Emprestimo> historicoEmprestimos = new ArrayList<>();

    private Usuario usuario;
    private Livro livro;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataLimite;
    private boolean devolvido;

    public Emprestimo(Usuario usuario, Livro livro, int diasParaDevolucao) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = LocalDateTime.now();
        this.dataLimite = LocalDateTime.now().plusDays(diasParaDevolucao);
        this.devolvido = false;
        emprestimos.add(this);
    }

    // Método para registrar um novo empréstimo
    public void registrarEmprestimo(Usuario usuario, Livro livro, int diasParaDevolucao) {
        try {
            // Verificando se o livro não é null e está disponível
            if (livro != null && livro.isDisponivel()) {
                // Criando um novo empréstimo
                Emprestimo e = new Emprestimo(usuario, livro, diasParaDevolucao);
                e.setUsuario(usuario);
                e.setLivro(livro);
                e.setDataLimite(LocalDateTime.now().plusDays(diasParaDevolucao));
                e.setDevolvido(false);
                livro.setDisponivel(false); // Marca o livro como indisponível
                Emprestimo.emprestimos.add(e); // Adiciona o empréstimo à lista de emprestimos
                System.out.println("Livro " + livro.getTitulo() + " emprestado para " + usuario.getNome());
            } else if (livro != null) {
                System.out.println("O livro " + livro.getTitulo() + " já está emprestado.");
            } else {
                System.out.println("Livro inválido.");
            }
        } catch (Exception e) {
            // Captura qualquer exceção não tratada e imprime a mensagem de erro
            System.err.println("Ocorreu um erro ao registrar o empréstimo: " + e.getMessage());
            e.printStackTrace(); // Imprime o rastreamento da pilha para ajudar na depuração
        }
    }

    // Método para devolver um livro
    public void devolverLivro(Usuario usuario, Livro livro) {
        try {
            boolean encontrou = false;
    
            // Itera sobre a lista de empréstimos para encontrar o empréstimo correspondente
            for (Emprestimo e : Emprestimo.emprestimos) {
                if (e.getLivro() != null && e.getLivro().equals(livro) 
                    && e.getUsuario().equals(usuario) && !e.isDevolvido()) {
    
                    // Marca o livro como devolvido e o torna disponível novamente
                    e.setDevolvido(true);
                    e.getLivro().setDisponivel(true);
    
                    // Move o empréstimo para o histórico e remove da lista de empréstimos ativos
                    historicoEmprestimos.add(e);
                    emprestimos.remove(e);
    
                    System.out.println("Livro " + livro.getTitulo() + " devolvido por " + usuario.getNome());
                    encontrou = true;
                    break;
                }
            }
    
            // Mensagem caso o empréstimo não seja encontrado
            if (!encontrou) {
                System.out.println("Empréstimo não encontrado para esse livro e usuário.");
            }
    
        } catch (Exception e) {
            // Captura qualquer exceção não tratada e imprime a mensagem de erro
            System.err.println("Ocorreu um erro ao devolver o livro: " + e.getMessage());
            e.printStackTrace(); // Imprime o rastreamento da pilha para ajudar na depuração
        }
    }
    

    // Exibe o histórico de empréstimos devolvidos
    public static void exibirHistoricoEmprestimos() {
        System.out.println("=== Histórico de Empréstimos ===");
        try {
            if (historicoEmprestimos.isEmpty()) {
                System.out.println("Nenhum empréstimo foi devolvido ainda.");
            } else {
                for (Emprestimo e : historicoEmprestimos) {
                    try {
                        e.exibirDetalhesEmprestimo();
                    } catch (Exception ex) {
                        System.out.println("Erro ao exibir detalhes do empréstimo: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro ao exibir histórico de empréstimos: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    

    public static void emitirRelatorioAtrasos() {
        boolean encontrouAtrasos = false;
    
        System.out.println("\nRelatório de Livros com Devolução Atrasada:");
    
        // Verifica se há livros atrasados
        for (Emprestimo emprestimo : Emprestimo.emprestimos) {
            try {
                if (emprestimo.isAtrasado()) {
                    if (!encontrouAtrasos) {
                        encontrouAtrasos = true; // Marca que foram encontrados atrasos
                    }
    
                    Livro livro = emprestimo.getLivro();
                    Usuario usuario = emprestimo.getUsuario();
    
                    // Verifica se livro e usuário não são nulos antes de acessar seus métodos
                    if (livro != null) {
                        System.out.println("Livro: " + livro.getTitulo());
                    }
    
                    if (usuario != null) {
                        System.out.println("Usuário: " + usuario.getNome());
                    }
    
                    if (livro != null && usuario != null) {
                        System.out.println("Data de Empréstimo: " + emprestimo.getDataEmprestimo());
                        System.out.println("Data Limite: " + emprestimo.getDataLimite());
                        System.out.println("Atrasado: Sim");
                        System.out.println("-------------------------");
                    }
                }
            } catch (Exception ex) {
                // Captura e exibe exceções que possam ocorrer durante a verificação
                System.out.println("Erro ao emitir relatório de atrasos: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    
        // Mensagem exibida apenas se nenhum livro atrasado for encontrado
        if (!encontrouAtrasos) {
            System.out.println("Nenhum livro está atrasado.");
        }
    }
    

    public void exibirDetalhesEmprestimo() {
        try {
            if (livro != null) {  // Verificação para evitar NullPointerException
                System.out.println("Usuário: " + (usuario != null ? usuario.getNome() : "Usuário nulo"));
                System.out.println("Livro: " + (livro != null ? livro.getTitulo() : "Livro nulo"));
                System.out.println("Data de Empréstimo: " + dataEmprestimo);
                System.out.println("Data Limite: " + dataLimite);
                System.out.println("Devolvido: " + (devolvido ? "Sim" : "Não"));
                System.out.println("Atrasado: " + (isAtrasado() ? "Sim" : "Não"));
            } else {
                System.out.println("Erro: Livro inválido.");
            }
        } catch (Exception ex) {
            System.out.println("Erro ao exibir detalhes do empréstimo: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    

    public boolean isAtrasado() {
        try {
            return !devolvido && LocalDateTime.now().isAfter(dataLimite);
        } catch (Exception ex) {
            System.out.println("Erro ao verificar se o empréstimo está atrasado: " + ex.getMessage());
            ex.printStackTrace();
            return false; // Assume que não está atrasado em caso de erro
        }
    }
    

    // Getters e Setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDateTime dataLimite) {
        this.dataLimite = dataLimite;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}
