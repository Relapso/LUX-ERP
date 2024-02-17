/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClientesDAO {

    private Connection con;

    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarCliente(Clientes obj) {
        try {
            String sql = "insert into tb_clientes (nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getRg());
                stmt.setString(3, obj.getCpf());
                stmt.setString(4, obj.getEmail());
                stmt.setString(5, obj.getTelefone());
                stmt.setString(6, obj.getCelular());
                stmt.setString(7, obj.getCep());
                stmt.setString(8, obj.getEndereco());
                stmt.setInt(9, obj.getNumero());
                stmt.setString(10, obj.getComplemento());
                stmt.setString(11, obj.getBairro());
                stmt.setString(12, obj.getCidade());
                stmt.setString(13, obj.getEstado());

                stmt.execute();
            }
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    public void alterarCliente(Clientes obj) {
        try {
            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, "
                    + "endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setString(1, obj.getNome());
                stmt.setString(2, obj.getRg());
                stmt.setString(3, obj.getCpf());
                stmt.setString(4, obj.getEmail());
                stmt.setString(5, obj.getTelefone());
                stmt.setString(6, obj.getCelular());
                stmt.setString(7, obj.getCep());
                stmt.setString(8, obj.getEndereco());
                stmt.setInt(9, obj.getNumero());
                stmt.setString(10, obj.getComplemento());
                stmt.setString(11, obj.getBairro());
                stmt.setString(12, obj.getCidade());
                stmt.setString(13, obj.getEstado());
                stmt.setInt(14, obj.getId());
                stmt.execute();
            }
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    public void excluirCliente(Clientes obj) {
        try {
            String sql = "delete from tb_clientes where id = ?";

            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, obj.getId());

                stmt.execute();
            }
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    public List<Clientes> listarClientes() {
        try {
            List<Clientes> lista = new ArrayList<>();
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    }
}
