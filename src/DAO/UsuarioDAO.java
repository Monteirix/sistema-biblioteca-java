/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Usuario;
import util.Conexao;

/**
 *
 * @author jogom
 */
public class UsuarioDAO {
    

    public boolean cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha, tipo) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            
            if (conn == null) {
            
            return false;
         
            }

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTipo());

            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("ERRO REAL DO BANCO");
            e.printStackTrace();
            throw new RuntimeException("Erro ao cadastrar usuário", e);
        }
    }

   
}

    

