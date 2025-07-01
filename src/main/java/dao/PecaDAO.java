package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexao;
import model.Peca;

public class PecaDAO {
    private static PecaDAO instancia;
    private PecaDAO() {}
    public static PecaDAO getInstancia() {
        if (instancia == null) {
            instancia = new PecaDAO();
        }
        return instancia;
    }
    public void inserir(Peca peca) throws SQLException {
        String sql = "INSERT INTO PECA (PECA_NOME, PECA_DESCRICAO, PECA_PRECO) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, peca.getPeca_nome());
            stmt.setString(2, peca.getPeca_descricao());
            stmt.setFloat(3, peca.getPeca_preco());
            stmt.executeUpdate();
        }
    }

    public Peca buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM PECA WHERE PECA_ID = ?";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extrairPeca(rs);
            }
        }
        return null;
    }

    public List<Peca> listarTodos() throws SQLException {
        List<Peca> lista = new ArrayList<>();
        String sql = "SELECT * FROM PECA";
        try (Connection conn = Conexao.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(extrairPeca(rs));
            }
        }
        return lista;
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM PECA WHERE PECA_ID = ?";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Peca extrairPeca(ResultSet rs) throws SQLException {
        Peca p = new Peca();
        p.setPeca_id(rs.getInt("PECA_ID"));
        p.setPeca_nome(rs.getString("PECA_NOME"));
        p.setPeca_descricao(rs.getString("PECA_DESCRICAO"));
        p.setPeca_preco(rs.getFloat("PECA_PRECO"));
        return p;
    }
}