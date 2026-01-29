/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Cliente;
import util.Conexao;


/**
 *
 * @author jogom
 */
public class ClienteDAO {
     public boolean cadastrar(Cliente cliente) {

        String sql = "INSERT INTO cliente (email, senha) VALUES (?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getEmail());
            stmt.setString(2, cliente.getSenha());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
         return false;
     }

    public void cadastrarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
