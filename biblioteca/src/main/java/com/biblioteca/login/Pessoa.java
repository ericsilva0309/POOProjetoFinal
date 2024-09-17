package com.biblioteca.login;

import java.util.ArrayList;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Pessoa implements Login {

    public static ArrayList<Pessoa> listaDeUsuarios = new ArrayList<>();

    private int id;
    private String nome;
    private String cpf;
    private String dataNascimento; 
    private Endereco endereco;
    private String email;
    private String telefone;

    private String login;
    private String senha;
    

    
    public Pessoa(){

    }

    public void login() {

    }

}