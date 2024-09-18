package com.biblioteca.login;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Livro {
    private String titulo;
    private String autor;
    private String categoria;
    private int ano;
    private boolean disponivel;
    private List<Avaliacao> avaliacoes;

    public Livro(String titulo, String autor, String categoria, int ano) {
        try {
            if (titulo == null || titulo.isEmpty()) {
                throw new IllegalArgumentException("O título do livro não pode ser vazio ou nulo.");
            }
            if (autor == null || autor.isEmpty()) {
                throw new IllegalArgumentException("O autor do livro não pode ser vazio ou nulo.");
            }
            if (categoria == null || categoria.isEmpty()) {
                throw new IllegalArgumentException("A categoria do livro não pode ser vazia ou nula.");
            }
            if (ano <= 0) {
                throw new IllegalArgumentException("O ano do livro deve ser maior que zero.");
            }

            this.titulo = titulo;
            this.autor = autor;
            this.categoria = categoria;
            this.ano = ano;
            this.disponivel = true;
            this.avaliacoes = new ArrayList<>();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar livro: " + e.getMessage());
        }
    }

    // Método para exibir informações do livro
    public void exibirDetalhes() {
        try {
            System.out.println("Título: " + titulo);
            System.out.println("Autor: " + autor);
            System.out.println("Categoria: " + categoria);
            System.out.println("Ano: " + ano);
            System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
            System.out.println("Média das avaliações : " + calcularMediaAvaliacoes());
            System.out.println("Avaliações:");
            if (avaliacoes.isEmpty()) {
                System.out.println("Nenhuma avaliação disponível.");
            } else {
                for (Avaliacao avaliacao : avaliacoes) {
                    System.out.println(avaliacao);
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao exibir detalhes do livro: " + e.getMessage());
        }
    }

    public double calcularMediaAvaliacoes() {
        if(avaliacoes.isEmpty()){
        return 0.0;
        }

        double soma = 0;
        for(Avaliacao avaliacao : avaliacoes){
        soma += avaliacao.getNota();
    }
    return soma / avaliacoes.size();
}

    // Método para adicionar uma avaliação ao livro
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        try {
            if (avaliacao == null) {
                throw new IllegalArgumentException("A avaliação não pode ser nula.");
            }
            avaliacoes.add(avaliacao);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar avaliação: " + e.getMessage());
        }
    }

    public static boolean isDisponivel(Livro livro) {
        for (Emprestimo e : Emprestimo.emprestimos) {
            if (e.getLivro().equals(livro)){
                return e.isDevolvido();
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Categoria: " + categoria + ", Ano: " + ano;
    }

}
