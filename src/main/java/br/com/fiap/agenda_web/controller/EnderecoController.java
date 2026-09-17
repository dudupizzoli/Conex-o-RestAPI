package br.com.fiap.agenda_web.controller;

import br.com.fiap.agenda_web.dao.EnderecoDAO;
import br.com.fiap.agenda_web.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    @GetMapping
    public List<Endereco> listar(){
        return enderecoDAO.buscarTodosEnderecos();
    }

    //colocar enderecos no banco de dados

    @GetMapping("/{id}")
    public Endereco buscarPorId(int id){
        var endereco = enderecoDAO.buscarPorId(id);
        return endereco;
    }

    @PostMapping
    public void cadastrar(Endereco endereco){
        System.out.println("Entrou");
        enderecoDAO.cadastrar(endereco);
    }

}
