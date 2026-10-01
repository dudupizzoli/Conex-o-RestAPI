package br.com.fiap.agenda_web.controller;

import br.com.fiap.agenda_web.model.Endereco;
import br.com.fiap.agenda_web.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(){
        this.enderecoService = new EnderecoService();
    }

    @GetMapping
    public List<Endereco> listar(){
        return enderecoService.listar();
    }

    @GetMapping("/{id}")
    public Endereco buscarPorId(@PathVariable int id){
        var endereco = enderecoService.buscarPorId(id);
        return endereco;
    }

    @PostMapping
    public void cadastrar(@RequestBody Endereco endereco){
        System.out.println("Entrou");
        enderecoService.cadastrar(endereco);
    }

    @PutMapping("/{id}")
    public void atualizar(@PathVariable int id, @RequestBody Endereco endereco){
        try {
            enderecoService.atualizar(id, endereco);
        }catch(IllegalArgumentException e){
            System.out.println("Ocorreu um erro: " + e);
        }
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id){
        try {
            enderecoService.excluir(id);
        }catch(IllegalArgumentException e){
            System.out.println("Ocorreu um erro: " + e);
        }
    }

}