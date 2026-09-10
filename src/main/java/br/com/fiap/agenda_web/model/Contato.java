package br.com.fiap.agenda_web.model;

import br.com.fiap.agenda_web.enums.TipoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Contato {
    private int id;
    private String nome;
    private String celular;
    private String email;
    private String instagram;
    private TipoEnum tipo;
    private Endereco endereco; //Relacionamento entre objetos
    private List<Endereco> enderecosEntrega = new ArrayList<>(); //Representa a relação N pra N

    @Override
    public String toString() {
        return "Contato: " +
                "\nNome: " + nome +
                " | Celular: " + celular +
                " | Email: " + email +
                " | Instagram: " + instagram +
                " | Tipo: " + tipo +
                " | " + endereco;
    }


}
