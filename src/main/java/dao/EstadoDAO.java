package dao;


import model.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexao;


public class EstadoDAO {
	private static EstadoDAO instancia;
	private EstadoDAO() {}
	public static EstadoDAO getInstancia() {
		if (instancia == null) {
			instancia = new EstadoDAO();
		}
		return instancia;
	}
	public Estado buscarPorId(int id) throws SQLException{
		String sql = "SELECT * FROM ESTADO WHERE ESTADO_COD = ?";
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
	public List<Estado> listarTodos() throws SQLException {
        List<Estado> lista = new ArrayList<>();
        String sql = "SELECT * FROM ESTADO";
        try (Connection conn = Conexao.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(extrairDescricao(rs));
            }
        }
        return lista;
	}
    public void inserir(Estado estado) throws SQLException {
        String sql = "INSERT INTO ESTADO (ESTADO_SIGLA, ESTADO_NOME) VALUES (?, ?)";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estado.getEstado_sigla());
            stmt.setString(2, estado.getEstado_nome());
            stmt.executeUpdate();
        }
    }
	 private Estado extrairDescricao(ResultSet rs) throws SQLException {
		 Estado e = new Estado();
	        e.setEstado_cod(rs.getInt("ESTADO_COD"));
	        e.setEstado_sigla(rs.getString("ESTADO_SIGLA"));
	        e.setEstado_nome(rs.getString("ESTADO_NOME"));
	        return e;
	    }

}
