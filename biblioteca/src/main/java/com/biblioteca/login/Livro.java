package com.biblioteca.login;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Livro {
    private String titulo;
    private String autor;
    private String categoria;
    private int ano;
    private boolean disponivel;
    private List<Avaliacao> avaliacoes;

    public Livro(String titulo, String autor, String categoria, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.ano = ano;
        this.disponivel = true;
        this.avaliacoes = new ArrayList<>();
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getAno() {
        return ano;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Método para exibir informações do livro
    public void exibirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Categoria: " + categoria);
        System.out.println("Ano: " + ano);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("Avaliações:");
        for (Avaliacao avaliacao : avaliacoes) {
            System.out.println(avaliacao);
        }
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacoes.add(avaliacao);
    }
    
    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Categoria: " + categoria + ", Ano: " + ano;
    }
}
