package com.biblioteca.login;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Avaliacao {
    private Usuario usuario;
    private Livro livro;
    private int nota; // Nota de 1 a 5
    private String comentario;

    public Avaliacao(Usuario usuario, Livro livro, int nota, String comentario) {
        this.usuario = usuario;
        this.livro = livro;
        this.nota = nota;
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Usuário: " + usuario.getNome() + "\nLivro: " + livro.getTitulo() + "\nNota: " + nota + "\nComentário: " + comentario;
    }
}
