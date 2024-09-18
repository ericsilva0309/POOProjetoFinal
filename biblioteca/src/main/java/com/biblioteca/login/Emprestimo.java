package com.biblioteca.login;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import lombok.Data;

import java.util.ArrayList;

public class Emprestimo {
    Scanner scanner = new Scanner(System.in);

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
        if (livro != null && livro.isDisponivel()) { // Verificando se o livro não é null
            Emprestimo e = new Emprestimo(usuario, livro, diasParaDevolucao);
            e.setUsuario(usuario);
            e.setLivro(livro);
            e.setDataLimite(LocalDateTime.now().plusDays(diasParaDevolucao));
            e.setDevolvido(false);
            livro.setDisponivel(false); // Marca o livro como indisponível
            Emprestimo.emprestimos.add(e);
            System.out.println("Livro " + livro.getTitulo() + " emprestado para " + usuario.getNome());
        } else if (livro != null) {
            System.out.println("O livro " + livro.getTitulo() + " já está emprestado.");
        } else {
            System.out.println("Livro inválido.");
        }
    }

    // Método para devolver um livro
    public void devolverLivro(Usuario usuario, Livro livro) {
        for (Emprestimo e : Emprestimo.emprestimos) {
            if (e.getLivro() != null && e.getLivro().equals(livro) && e.getUsuario().equals(usuario) && !e.isDevolvido()) {
                e.setDevolvido(true);
                e.getLivro().setDisponivel(true); // Marca o livro como disponível
                historicoEmprestimos.add(e);  // Move o empréstimo para o histórico
                emprestimos.remove(e);        // Remove da lista de empréstimos ativos
                System.out.println("Livro " + livro.getTitulo() + " devolvido por " + usuario.getNome());
                return;
            }
        }
        System.out.println("Empréstimo não encontrado para esse livro e usuário.");
    }

    // Exibe o histórico de empréstimos devolvidos
    public static void exibirHistoricoEmprestimos() {
        System.out.println("=== Histórico de Empréstimos ===");
        if (historicoEmprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo foi devolvido ainda.");
        } else {
            for (Emprestimo e : historicoEmprestimos) {
                e.exibirDetalhesEmprestimo();
            }
        }
    }

    public void exibirDetalhesEmprestimo() {
        if (livro != null) {  // Verificação para evitar NullPointerException
            System.out.println("Usuário: " + usuario.getNome());
            System.out.println("Livro: " + livro.getTitulo());
            System.out.println("Data de Empréstimo: " + dataEmprestimo);
            System.out.println("Data Limite: " + dataLimite);
            System.out.println("Devolvido: " + (devolvido ? "Sim" : "Não"));
            System.out.println("Atrasado: " + (isAtrasado() ? "Sim" : "Não"));
        } else {
            System.out.println("Erro: Livro inválido.");
        }
    }

    public boolean isAtrasado() {
        return !devolvido && LocalDateTime.now().isAfter(dataLimite);
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
