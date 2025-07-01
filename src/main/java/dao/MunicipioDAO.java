package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexao;
import model.Municipio;

public class MunicipioDAO {
	private static MunicipioDAO instancia;
	private MunicipioDAO() {}
	public static MunicipioDAO getInstancia() {
		if (instancia == null) {
			instancia = new MunicipioDAO();
		}	
		return instancia;
	}
	public void inserir(Municipio municipio) throws SQLException {
		String sql = "INSERT INTO MUNICIPIO (COD_ESTADO, MUN_NOME) VALUES (?, ?)";

		try (Connection conn = Conexao.getInstancia().getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, municipio.getCod_estado());
			stmt.setString(2, municipio.getMun_nome());

			stmt.executeUpdate();
		}
	}

	public Municipio buscarPorId(int id) throws SQLException {
		String sql = "SELECT * FROM MUNICIPIO WHERE MUN_COD = ?";
		try (Connection conn = Conexao.getInstancia().getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return extrairEndereco(rs);
			}
		}
		return null;
	}

	public List<Municipio> listarTodos() throws SQLException {
		List<Municipio> lista = new ArrayList<>();
		String sql = "SELECT * FROM MUNICIPIO";
		try (Connection conn = Conexao.getInstancia().getConexao();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				lista.add(extrairEndereco(rs));
			}
		}
		return lista;
	}
	
	private Municipio extrairEndereco(ResultSet rs) throws SQLException {
		Municipio e = new Municipio();
        e.setMun_cod(rs.getInt("MUN_COD"));
        e.setCod_estado(rs.getInt("COD_ESTADO"));
        e.setMun_nome(rs.getString("MUN_NOME"));
        return e;
    }
}
