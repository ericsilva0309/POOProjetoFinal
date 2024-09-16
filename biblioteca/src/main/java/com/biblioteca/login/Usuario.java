package com.biblioteca.login;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Usuario extends Pessoa{
    private List<Livro> historicoEmprestimos;


    public Usuario(String nome, String cpf, String dataNascimento, Endereco endereco, String email, String telefone, String login, String senha) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setDataNascimento(dataNascimento);
        this.setEndereco(endereco);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setLogin(login);
        this.setSenha(senha);
    }

    // Método para adicionar livro ao histórico de empréstimos
    public void exibirHistorico() {
        try {
            if (historicoEmprestimos == null || historicoEmprestimos.isEmpty()) {
                System.out.println("Nenhum histórico de empréstimos.");
            } else {
                System.out.println("=== Histórico de Empréstimos ===");
                for (Livro livro : historicoEmprestimos) {
                    livro.exibirDetalhes();
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao exibir histórico: " + e.getMessage());
        }
    }
    
    
    

    public void adicionarEmprestimo(Livro livro) {
        if (historicoEmprestimos == null) {
            historicoEmprestimos = new ArrayList<>();
        }
        historicoEmprestimos.add(livro);
    }
}