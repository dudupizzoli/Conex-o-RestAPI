package br.com.fiap.agenda_web.dto;

public record ViaCepResponse(
        String logradouro,
        String cep,
        String bairro,
        String cidade,
        String estado,
        String uf,
        String numero,
        String complemento
) {




}
