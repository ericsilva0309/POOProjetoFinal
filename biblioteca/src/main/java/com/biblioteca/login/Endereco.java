package com.biblioteca.login;

import lombok.Data;

@Data
public class Endereco {
    private int id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private UnidadeFederal estado;
    private String cep;
    private String referencia;
}

