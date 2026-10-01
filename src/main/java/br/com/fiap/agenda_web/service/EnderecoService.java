package br.com.fiap.agenda_web.service;

import br.com.fiap.agenda_web.dao.EnderecoDAO;
import br.com.fiap.agenda_web.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoDAO enderecoDAO;

    public EnderecoService() {
        this.enderecoDAO = new EnderecoDAO();
    }

    public List<Endereco> listar(){
        return enderecoDAO.buscarTodosEnderecos();
    }

    public Endereco buscarPorId(int id){
        var endereco = enderecoDAO.buscarPorId(id);
        return endereco;
    }

    public void cadastrar(Endereco endereco){
        if(endereco.getCep() != null ) {
            enderecoDAO.cadastrar(endereco);
        } else{
            throw new RuntimeException("Endereço incompleto");
        }
    }

    public void atualizar(int id, Endereco endereco){
        if (id != endereco.getCodigo()) {
            throw new IllegalArgumentException("O código do endereço não corresponde ao código informado");
        }
        Endereco enderecoExiste = buscarPorId(id);
        if (enderecoExiste == null){
            throw new IllegalArgumentException("Endereço não encontrado.");
        }
        enderecoDAO.alterar(endereco);

    }
    /* colocar isso no banco de dados pra ver se funciona
    * insert into endereco_agenda (CODIGO, LOGRADOURO, CEP, BAIRRO, CIDADE, ESTADO, UF, NUMERO, COMPLEMENTO)
values(2, 'Avenida Conselheiro Carrão', '4567', 'Vila Carrão', 'São Paulo', 'São Paulo', 'SP', '54', '29');

insert into endereco_agenda (CODIGO, LOGRADOURO, CEP, BAIRRO, CIDADE, ESTADO, UF, NUMERO, COMPLEMENTO)
values(3, 'Rua Antônio de Barros', '8746', 'Tatuapé', 'São Paulo', 'São Paulo', 'SP', '42', '81');

insert into endereco_agenda (CODIGO, LOGRADOURO, CEP, BAIRRO, CIDADE, ESTADO, UF, NUMERO, COMPLEMENTO)
values(4, 'Rua João Frango', '7639', 'Mooca', 'São Paulo', 'São Paulo', 'SP', '87', '12');*/

    public void excluir(int id){
        Endereco enderecoExiste = buscarPorId(id);
        if(enderecoExiste == null)
            throw new IllegalArgumentException("Endereço não encontrado");

        enderecoDAO.excluir(id);
    }
}

