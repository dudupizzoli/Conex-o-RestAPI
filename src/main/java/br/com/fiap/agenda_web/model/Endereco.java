package br.com.fiap.agenda_web.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {
    private int codigo;
    private String logradouro;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String uf;
    private String numero;
    private String complemento;

    @Override
    public String toString() {
        return "Endereco: " +
                "\nCódigo: " + codigo +
                " | Logradouro: " + logradouro +
                " | CEP: " + cep +
                " | Bairro: " + bairro+
                " | Cidade: " + cidade+
                " | Estado: " + estado +
                " | UF: " + uf +
                " | Número: " + numero +
                " | Complemento: " + complemento;
    }
}
