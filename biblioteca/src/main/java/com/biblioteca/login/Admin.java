package com.biblioteca.login;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Admin extends Usuario {
    private List<Livro> historicoEmprestimos;
    public static List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
    Menu menu = new Menu();

    public Admin(String nome, String cpf, String dataNascimento, Endereco endereco, String email, String telefone, String login, String senha) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setDataNascimento(dataNascimento);
        this.setEndereco(endereco);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setLogin(login);
        this.setSenha(senha);
        this.historicoEmprestimos = new ArrayList<>(); // Inicializando o histórico de empréstimos
    }

    public boolean acessoPermitido(String login, String senha){
        
        if(login.equals(getLogin()) && senha.equals(getSenha())){
            return true;
        }
        return false;
    }
        public void login(){
            menu.admin();
    }
}
