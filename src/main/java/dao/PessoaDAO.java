package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexao;
import model.Pessoa;

public class PessoaDAO {
	private static PessoaDAO instancia;
	private PessoaDAO() {}
	public static PessoaDAO getInstancia() {
		if (instancia == null) {
			instancia = new PessoaDAO();
		}
		return instancia;
	}

	public void inserir(Pessoa pessoa) throws SQLException {
		String sql = "INSERT INTO PESSOA (PES_NOME, PES_TIPO, PES_CPF_CNPJ, PES_GEN, PES_DATA_NAS) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = Conexao.getInstancia().getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, pessoa.getPes_nome());
			stmt.setString(2, pessoa.getPes_tipo());
			stmt.setString(3, pessoa.getPes_cpf_cnpj());
			stmt.setString(4, pessoa.getPes_gen());
			stmt.setString(5, pessoa.getPes_data_nas());

			stmt.executeUpdate();
		}
	}

	public Pessoa buscarPorId(int id) throws SQLException {
		String sql = "SELECT * FROM PESSOA WHERE PES_COD = ?";
		try (Connection conn = Conexao.getInstancia().getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return extrairEndereco(rs);
			}
		}
		return null;
	}

	public List<Pessoa> listarTodos() throws SQLException {
		List<Pessoa> lista = new ArrayList<>();
		String sql = "SELECT * FROM PESSOA";
		try (Connection conn = Conexao.getInstancia().getConexao();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				lista.add(extrairEndereco(rs));
			}
		}
		return lista;
	}

	public void atualizar(Pessoa pessoa) throws SQLException {
		String sql = "UPDATE PESSOA SET PES_NOME=?, PES_TIPO=?, PES_CPF_CNPJ=?, PES_GEN=?, PES_DATA_NAS=? WHERE PES_COD=?";

		try (Connection conn = Conexao.getInstancia().getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, pessoa.getPes_nome());
			stmt.setString(2, pessoa.getPes_tipo());
			stmt.setString(3, pessoa.getPes_cpf_cnpj());
			stmt.setString(4, pessoa.getPes_gen());
			stmt.setString(5, pessoa.getPes_data_nas());
			stmt.setInt(6, pessoa.getPes_cod());

			stmt.executeUpdate();
		}
	}

	public void deletar(int id) throws SQLException {
		String sql = "DELETE FROM PESSOA WHERE PES_COD = ?";
		try (Connection conn = Conexao.getInstancia().getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);
			stmt.executeUpdate();
		}
	}

	private Pessoa extrairEndereco(ResultSet rs) throws SQLException {
		Pessoa e = new Pessoa();
		e.setPes_cod(rs.getInt("PES_COD"));
		e.setPes_nome(rs.getString("PES_NOME"));
		e.setPes_tipo(rs.getString("PES_TIPO"));
		e.setPes_cpf_cnpj(rs.getString("PES_CPF_CNPJ"));
		e.setPes_gen(rs.getString("PES_GEN"));
		e.setPes_data_nas(rs.getString("PES_DATA_NAS"));

		return e;
	}
}
