package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexao;

import java.sql.Connection;

import model.EnderecoPes;

public class EnderecoPesDAO {
	private static EnderecoPesDAO instancia;
	private EnderecoPesDAO() {}
	public static EnderecoPesDAO getInstancia() {
		if (instancia == null) {
			instancia = new EnderecoPesDAO();
		}
		return instancia;
	}

	public void inserir(EnderecoPes enderecoPes) throws SQLException {
		String sql = "INSERT INTO ENDERECO_PES (COD_PESSOA, COD_TIPO_ENDERECO, COD_CEP, END_PES_BAIRRO, END_PES_RUA, END_PES_NUMERO, END_PES_TELEFONE, END_PES_CELULAR, END_PES_EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = Conexao.getInstancia().getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, enderecoPes.getCod_pessoa());
			stmt.setInt(2, enderecoPes.getCod_tipo_endereco());
			stmt.setInt(3, enderecoPes.getCod_cep());
			stmt.setString(4, enderecoPes.getEnd_pes_bairro());
			stmt.setString(5, enderecoPes.getEnd_pes_rua());
			stmt.setInt(6, Integer.parseInt(enderecoPes.getEnd_pes_numero()));
			stmt.setString(7, enderecoPes.getEnd_pes_telefone());
			stmt.setString(8, enderecoPes.getEnd_pes_celular());
			stmt.setString(9, enderecoPes.getEnd_pes_email());

			stmt.executeUpdate();
		}
	}

    public List<EnderecoPes> listarTodos() throws SQLException {
        List<EnderecoPes> lista = new ArrayList<>();
        String sql = "SELECT * FROM ENDERECO_PES";
        try (Connection conn = Conexao.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(extrairEndereco(rs));
            }
        }
        return lista;
    }
    
	public EnderecoPes buscarPorId(int id) throws SQLException {
		String sql = "SELECT * FROM ENDERECO_PES WHERE END_PES_ID = ?";
		try (Connection conn = Conexao.getInstancia().getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return extrairEndereco(rs);
			}
		}
		return null;
	}
	
	public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM ENDERECO_PES WHERE END_PES_ID = ?";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
	public void atualizar(EnderecoPes enderecoPes) throws SQLException {
        String sql = "UPDATE ENDERECO_PES SET COD_PESSOA=?, COD_TIPO_ENDERECO=?, COD_CEP=?, END_PES_BAIRRO=?, END_PES_RUA=?, END_PES_NUMERO=?, END_PES_TELEFONE=?, END_PES_CELULAR=?, END_PES_EMAIL=? WHERE END_PES_ID=?";
        try (Connection conn = Conexao.getInstancia().getConexao(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, enderecoPes.getCod_pessoa());
            stmt.setInt(2, enderecoPes.getCod_tipo_endereco());
            stmt.setInt(3, enderecoPes.getCod_cep());
            stmt.setString(4, enderecoPes.getEnd_pes_bairro());
            stmt.setString(5, enderecoPes.getEnd_pes_rua());
            stmt.setInt(6, Integer.parseInt(enderecoPes.getEnd_pes_numero()));
            stmt.setString(7, enderecoPes.getEnd_pes_telefone());
            stmt.setString(8, enderecoPes.getEnd_pes_celular());
            stmt.setString(9, enderecoPes.getEnd_pes_email());
            stmt.setInt(10, enderecoPes.getEnd_pes_id());
            stmt.executeUpdate();
        }
    }
	private EnderecoPes extrairEndereco(ResultSet rs) throws SQLException {
		EnderecoPes e = new EnderecoPes();
		
        e.setEnd_pes_id(rs.getInt("END_PES_ID"));
        e.setCod_pessoa(rs.getInt("COD_PESSOA"));
        e.setCod_tipo_endereco(rs.getInt("COD_TIPO_ENDERECO"));
        e.setCod_cep(rs.getInt("COD_CEP"));
        e.setEnd_pes_bairro(rs.getString("END_PES_BAIRRO"));
        e.setEnd_pes_rua(rs.getString("END_PES_RUA"));
        e.setEnd_pes_numero(String.valueOf(rs.getInt("END_PES_NUMERO")));
        e.setEnd_pes_telefone(rs.getString("END_PES_TELEFONE"));
        e.setEnd_pes_celular(rs.getString("END_PES_CELULAR"));
        e.setEnd_pes_email(rs.getString("END_PES_EMAIL"));
        return e;
    }
	
	
}
