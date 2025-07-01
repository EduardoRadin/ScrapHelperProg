package dao;

import db.Conexao;
import model.Permissao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PermissaoDAO {
    private static PermissaoDAO instancia;
	private PermissaoDAO() {}
	public static PermissaoDAO getInstancia() {
		if (instancia == null) {
			instancia = new PermissaoDAO();
		}
		return instancia;
	}
    public void inserir(Permissao permicao) throws SQLException {
        String sql = "INSERT INTO PERMISSAO (PER_DESCRICAO) VALUES (?)";

        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, permicao.getPer_descricao());
            stmt.executeUpdate();
        }
    }
    
    public Permissao buscarPorId(int id) throws SQLException { 
    	String sql = "SELECT * FROM PERMISSAO WHERE PER_COD = ?";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extrairDescricao(rs);
            }
        }
        return null;
    }

    public List<Permissao> listarTodos() throws SQLException {
        List<Permissao> lista = new ArrayList<>();
        String sql = "SELECT * FROM PERMISSAO";
        try (Connection conn = Conexao.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(extrairDescricao(rs));
            }
        }
        return lista;
    }


    private Permissao extrairDescricao(ResultSet rs) throws SQLException {
        Permissao e = new Permissao();
        e.setId(rs.getInt("PER_COD"));
        e.setPer_descricao(rs.getString("PER_DESCRICAO"));
        return e;
    }
}
