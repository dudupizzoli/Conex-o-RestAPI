package br.com.fiap.agenda_web.dto;

import br.com.fiap.agenda_web.enums.TipoEnum;
import br.com.fiap.agenda_web.model.Endereco;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ContatoResponseDTO {
    private int id;
    private String nome;
    private String celular;
    private String email;
    private String instagram;
    private TipoEnum tipo;
    private Endereco endereco; //Relacionamento entre objetos




}
