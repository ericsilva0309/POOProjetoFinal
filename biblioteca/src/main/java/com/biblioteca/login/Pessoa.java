package com.biblioteca.login;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pessoa {

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

}
