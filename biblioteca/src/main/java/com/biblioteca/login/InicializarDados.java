package com.biblioteca.login;

public class InicializarDados {

    public static void inicializar(Biblioteca biblioteca) {

        // Inicializar a instância de Biblioteca
        // Criar alguns endereços
        Endereco endereco1 = new Endereco();
        endereco1.setId(1);
        endereco1.setLogradouro("Rua das Flores");
        endereco1.setNumero("123");
        endereco1.setComplemento("Apto 301");
        endereco1.setBairro("Jardim Botânico");
        endereco1.setCidade("Cidade Exemplo");
        endereco1.setEstado(UnidadeFederal.SP); // Supondo que UnidadeFederal é um enum
        endereco1.setCep("12345-678");
        endereco1.setReferencia("Próximo ao parque");

        Endereco endereco2 = new Endereco();
        endereco2.setId(2);
        endereco2.setLogradouro("Avenida Central");
        endereco2.setNumero("456");
        endereco2.setComplemento("Sala 201");
        endereco2.setBairro("Centro");
        endereco2.setCidade("Cidade Exemplo");
        endereco2.setEstado(UnidadeFederal.RJ); // Supondo que UnidadeFederal é um enum
        endereco2.setCep("23456-789");
        endereco2.setReferencia("Ao lado da prefeitura");

        // Criar alguns usuários
        Usuario usuario1 = new Usuario(
            "João Silva",
            "123.456.789-00",
            "01/01/1990",
            endereco1,
            "joao.silva@email.com",
            "(11) 98765-4321",
            "joao",
            "senha123"
        );

        Usuario usuario2 = new Usuario(
            "Maria Oliveira",
            "234.567.890-11",
            "02/02/1985",
            endereco2,
            "maria.oliveira@email.com",
            "(21) 99876-5432",
            "maria",
            "senha456"
        );

        Usuario usuario3 = new Usuario(
            "Carlos Pereira",
            "345.678.901-23",
            "15/03/1978",
            endereco1,
            "carlos.pereira@email.com",
            "(31) 98765-4321",
            "carlos",
            "senha789"
        );

        Usuario usuario4 = new Usuario(
            "Ana Santos",
            "456.789.012-34",
            "22/07/1992",
            endereco2,
            "ana.santos@email.com",
            "(11) 91234-5678",
            "ana",
            "senha101"
        );

        // Adicionar os usuários à biblioteca
        biblioteca.cadastrarUsuario(usuario1);
        biblioteca.cadastrarUsuario(usuario2);
        biblioteca.cadastrarUsuario(usuario3);
        biblioteca.cadastrarUsuario(usuario4);
        
        // Criar e adicionar livros
        Livro livro1 = new Livro("O Alquimista", "Paulo Coelho", "Ficção", 1988);
        Livro livro2 = new Livro("Dom Casmurro", "Machado de Assis", "Romance", 1899);
        Livro livro3 = new Livro("A Moreninha", "Joaquim Manuel de Macedo", "Romance", 1844);
        Livro livro4 = new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", "Romance", 1881);
        Livro livro5 = new Livro("O Primo Basílio", "José de Alencar", "Romance", 1878);
        Livro livro6 = new Livro("Cem Anos de Solidão", "Gabriel García Márquez", "Ficção", 1967);

        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);
        biblioteca.cadastrarLivro(livro4);
        biblioteca.cadastrarLivro(livro5);
        biblioteca.cadastrarLivro(livro6);
    }
}