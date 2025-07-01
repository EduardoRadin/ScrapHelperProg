package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexao;
import model.TipoEndereco;

public class TipoEnderecoDAO {
	private static TipoEnderecoDAO instancia;

	private TipoEnderecoDAO() {
	}

	public static TipoEnderecoDAO getInstancia() {
		if (instancia == null) {
			instancia = new TipoEnderecoDAO();
		}
		return instancia;
	}

	public void inserir(TipoEndereco tipoEndereco) throws SQLException {
		String sql = "INSERT INTO TIPO_ENDERECO (TIP_END_DESCRICAO) VALUES (?)";

		try (Connection conn = Conexao.getInstancia().getConexao();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, tipoEndereco.getTip_end_descricao());

			stmt.executeUpdate();
		}
	}

	public TipoEndereco buscarPorId(int id) throws SQLException {
		String sql = "SELECT * FROM TIPO_ENDERECO WHERE TIP_END_COD = ?";
		try (Connection conn = Conexao.getInstancia().getConexao();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return extrairEndereco(rs);
			}
		}
		return null;
	}

	public List<TipoEndereco> listarTodos() throws SQLException {
		List<TipoEndereco> lista = new ArrayList<>();
		String sql = "SELECT * FROM TIPO_ENDERECO";
		try (Connection conn = Conexao.getInstancia().getConexao();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				lista.add(extrairEndereco(rs));
			}
		}
		return lista;
	}

	public void deletar(int id) throws SQLException {
		String sql = "DELETE FROM TIPO_ENDERECO WHERE TIP_END_COD = ?";
		try (Connection conn = Conexao.getInstancia().getConexao();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
	}

	private TipoEndereco extrairEndereco(ResultSet rs) throws SQLException {
		TipoEndereco e = new TipoEndereco();
		e.setTip_end_cod(rs.getInt("TIP_END_COD"));
		e.setTip_end_descricao(rs.getString("TIP_END_DESCRICAO"));
		return e;
	}
}
