package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Livro;
import util.Conexao;

public class LivroDAO {

    // ➕ CADASTRAR LIVRO
    public boolean cadastrar(Livro livro) {
                
        
        String sql = "INSERT INTO livros (titulo, autor, categoria, quantidade) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            
            if (conn == null) {
            
            return false;
        }
           

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getCategoria());
            stmt.setInt(4, livro.getQuantidade());

            
            stmt.executeUpdate();
            
           
            return true ;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 📄 LISTAR LIVROS
    public List<Livro> listar() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setCategoria(rs.getString("categoria"));
                livro.setQuantidade(rs.getInt("quantidade"));

                livros.add(livro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return livros;
    }

    // ✏️ ATUALIZAR LIVRO
    public void atualizar(Livro livro) {
        String sql = "UPDATE livros SET titulo=?, autor=?, categoria=?, quantidade=? WHERE id=?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getCategoria());
            stmt.setInt(4, livro.getQuantidade());
            stmt.setInt(5, livro.getId());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🗑️ EXCLUIR LIVRO
    public boolean excluir(int id) {
    String sql = "DELETE FROM livros WHERE id = ?";

    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        int linhasAfetadas = stmt.executeUpdate();

        return linhasAfetadas > 0; // 🔑 sucesso real

    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }
}

    // 🔎 BUSCAR LIVRO (titulo, autor ou categoria)
    public List<Livro> buscar(String termo) {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros WHERE titulo LIKE ? OR autor LIKE ? OR categoria LIKE ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            String filtro = "%" + termo + "%";
            stmt.setString(1, filtro);
            stmt.setString(2, filtro);
            stmt.setString(3, filtro);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setCategoria(rs.getString("categoria"));
                livro.setQuantidade(rs.getInt("quantidade"));

                livros.add(livro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return livros;
    }

    public boolean cadastrarLivro(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor, categoria, quantidade) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getCategoria());
            stmt.setInt(4, livro.getQuantidade());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    }
   


    

