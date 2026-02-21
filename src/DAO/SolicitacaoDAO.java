package DAO;

import model.Solicitacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import util.Conexao;


public class SolicitacaoDAO {

    public void salvar(Solicitacao s) {

        String sql = "INSERT INTO solicitacao (id_usuario, id_livro, data_solicitacao, status) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, s.getIdUsuario());
            stmt.setInt(2, s.getIdLivro());
            stmt.setDate(3, java.sql.Date.valueOf(s.getDataSolicitacao()));
            stmt.setString(4, s.getStatus());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public List<Solicitacao> listarPorUsuario(int idUsuario) {

        List<Solicitacao> lista = new ArrayList<>();

        String sql = "SELECT * FROM solicitacao WHERE id_usuario = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Solicitacao s = new Solicitacao();

                s.setId(rs.getInt("id"));
                s.setIdUsuario(rs.getInt("id_usuario"));
                s.setIdLivro(rs.getInt("id_livro"));
                s.setDataSolicitacao(rs.getDate("data_solicitacao").toLocalDate());
                s.setStatus(rs.getString("status"));

                lista.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        

        return lista;
    }
public boolean jaSolicitou(int idUsuario, int idLivro) {

    String sql = "SELECT COUNT(*) FROM solicitacao WHERE id_usuario = ? AND id_livro = ?";

    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idUsuario);
        stmt.setInt(2, idLivro);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0; // se contar > 0, já solicitou
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
}


