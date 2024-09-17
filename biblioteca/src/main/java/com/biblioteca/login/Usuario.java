package com.biblioteca.login;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Usuario extends Pessoa {
    private List<Livro> historicoEmprestimos;
    public static List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();

    public Usuario(String nome, String cpf, String dataNascimento, Endereco endereco, String email, String telefone, String login, String senha) {
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

    // Método para exibir o histórico de empréstimos
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

    // Método para adicionar livro ao histórico de empréstimos
    public void adicionarEmprestimo(Livro livro) {
        try {
            if (livro == null) {
                throw new IllegalArgumentException("Livro não pode ser nulo.");
            }
            if (historicoEmprestimos == null) {
                historicoEmprestimos = new ArrayList<>();
            }
            historicoEmprestimos.add(livro);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao adicionar empréstimo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao adicionar empréstimo: " + e.getMessage());
        }
    }

    public boolean acessoPermitido(String login, String senha) {

        if(login.equals(getLogin()) && senha.equals(getSenha())){
            return true;
        }
        return false;
    }

    public static void imprimeListaDeUsuarios(){
        
        if(!Usuario.listaDeUsuarios.isEmpty()){
            System.out.println("Lista de usuários:");
            for(int i=0; i<Usuario.listaDeUsuarios.size(); i++) {
                System.out.println( (i+1) + "- " + Usuario.listaDeUsuarios.get(i).getNome());
            }
        } else {
            System.out.println("Não há usuários cadastrados.\n\n");
        }

    }

    public Usuario() {

    }

    @Override
    public String toString() {
        return this.getNome();
    }

    public void login(){
        Menu.usuario();

    }

}
