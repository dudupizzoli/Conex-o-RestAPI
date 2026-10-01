package br.com.fiap.agenda_web.dao;

import br.com.fiap.agenda_web.model.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EnderecoDAO {
    private Connection conexao;

    public void cadastrar(Endereco endereco){
        //CRUD: C -> create
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try{
            String sql = "insert into endereco_agenda (CODIGO, LOGRADOURO, CEP, BAIRRO," +
                    "CIDADE, ESTADO, UF, NUMERO, COMPLEMENTO)" +
                    "values(?, ?,?,?,?, ?, ?, ?, ?)";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, endereco.getCodigo());
            comandoSql.setString(2, endereco.getLogradouro());
            comandoSql.setString(3, endereco.getCep());
            comandoSql.setString(4, endereco.getBairro());
            comandoSql.setString(5, endereco.getCidade());
            comandoSql.setString(6, endereco.getEstado());
            comandoSql.setString(7, endereco.getUf());
            comandoSql.setString(8, endereco.getNumero());
            comandoSql.setString(9, endereco.getComplemento());
            comandoSql.executeUpdate();
            conexao.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Endereco buscarPorId(Integer codigo){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        Endereco endereco = new Endereco();
        try{
            comandoSql = conexao.prepareStatement("select * from endereco_agenda where codigo = ?");
            comandoSql.setInt(1, codigo);
            ResultSet rs = comandoSql.executeQuery();
            if(rs.next()){
                endereco.setCodigo(rs.getInt(1));
                endereco.setLogradouro(rs.getString(2));
                endereco.setCep(rs.getString(3));
                endereco.setBairro(rs.getString(4));
                endereco.setCidade(rs.getString(5));
                endereco.setEstado(rs.getString(6));
                endereco.setUf(rs.getString(7));
                endereco.setNumero(rs.getString(8));
                endereco.setComplemento(rs.getString(9));
            }
            comandoSql.close();
            conexao.close();

        }catch(SQLException e){
            throw  new RuntimeException(e);
        }
        return endereco;
    }

    //CRUD -> Update
    public void alterar(Endereco endereco){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try{
            String sql = "update endereco_agenda set LOGRADOURO = ?," +
                    "CEP = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?, UF = ?, " +
                    "NUMERO = ?, COMPLEMENTO = ? where CODIGO = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, endereco.getLogradouro());
            comandoSql.setString(2, endereco.getCep());
            comandoSql.setString(3, endereco.getBairro());
            comandoSql.setString(4, endereco.getCidade());
            comandoSql.setString(5, endereco.getEstado());
            comandoSql.setString(6, endereco.getUf());
            comandoSql.setString(7, endereco.getNumero());
            comandoSql.setString(8, endereco.getComplemento());
            comandoSql.setInt(9, endereco.getCodigo());
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //CRUD -> Delete
    public void excluir(int codigo){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("Delete from endereco_agenda Where ID_CONTATO = ?");
            comandoSql.setInt(1, codigo);
            comandoSql.executeUpdate();
            comandoSql.close();
            conexao.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Endereco> buscarTodosEnderecos(){
        conexao = ConnectionFactory.obterConexao();
        PreparedStatement comandoSql = null;
        List<Endereco> enderecos = new ArrayList<>();
        try{
            comandoSql = conexao.prepareStatement("SELECT * FROM endereco_agenda");
            ResultSet rs = comandoSql.executeQuery();
            while (rs.next()){
                Endereco ende = new Endereco();
                ende.setCodigo(rs.getInt(1));
                ende.setLogradouro(rs.getString(2));
                ende.setCep(rs.getString(3));
                ende.setBairro(rs.getString(4));
                ende.setCidade(rs.getString(5));
                ende.setEstado(rs.getString(6));
                ende.setUf(rs.getString(7));
                ende.setNumero(rs.getString(8));
                ende.setComplemento(rs.getString(9));
                enderecos.add(ende);

                comandoSql.close();
                conexao.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enderecos;
    }
}
