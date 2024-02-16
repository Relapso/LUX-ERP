/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import java.sql.Connection;
import br.com.projeto.model.Clientes;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
public class ClientesDAO {
    private Connection con;

    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void cadastrarCliente(Clientes obj) {
        try {
            // Comando de inserção
            String sql = "insert into tb_clientes (nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // Conectar e organizar o banco de dados
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(1,obj.getRg());
            stmt.setString(1,obj.getCpf());
            stmt.setString(1,obj.getEmail());
            stmt.setString(1,obj.getTelefone());
            stmt.setString(1,obj.getCelular());
            stmt.setString(1,obj.getCep());
            stmt.setString(1,obj.getEndereco());
            stmt.setInt(1,obj.getNumero());
            stmt.setString(1,obj.getComplemento());
            stmt.setString(1,obj.getBairro());
            stmt.setString(1,obj.getCidade());
            stmt.setString(1,obj.getEstado());
            
            // Executando o comando Sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);// Isso vai imprimir o erro no console
        }
    }

    public void alterarCliente() {
        // Implementação do método de alterarCliente
    }

    public void excluirCliente() {
        // Implementação do método de excluirCliente
    }
}

