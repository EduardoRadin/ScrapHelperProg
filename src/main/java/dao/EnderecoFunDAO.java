package dao;

import db.Conexao;
import model.EnderecoFun;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoFunDAO {
    private static EnderecoFunDAO instancia;
	private EnderecoFunDAO() {}
	public static EnderecoFunDAO getInstancia() {
		if (instancia == null) {
			instancia = new EnderecoFunDAO();
		}
		return instancia;
	}
    
    public void inserir(EnderecoFun endereco) throws SQLException {
        String sql = "INSERT INTO ENDERECO_FUN (COD_FUNCIONARIO, COD_TIPO_ENDERCO, COD_CEP, END_FUN_BAIRRO, END_FUN_RUA, END_FUN_NUMERO, END_FUN_TELEFONE, END_FUN_CELULAR, END_FUN_EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, endereco.getCodFuncionario());
            stmt.setInt(2, endereco.getCodTipoEndereco());
            stmt.setInt(3, endereco.getCodCep());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getRua());
            stmt.setInt(6, endereco.getNumero());
            stmt.setString(7, endereco.getTelefone());
            stmt.setString(8, endereco.getCelular());
            stmt.setString(9, endereco.getEmail());

            stmt.executeUpdate();
        }
    }

    public EnderecoFun buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM ENDERECO_FUN WHERE END_FUN_ID = ?";
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

    public List<EnderecoFun> listarTodos() throws SQLException {
        List<EnderecoFun> lista = new ArrayList<>();
        String sql = "SELECT * FROM ENDERECO_FUN";
        try (Connection conn = Conexao.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(extrairEndereco(rs));
            }
        }
        return lista;
    }

    public void atualizar(EnderecoFun endereco) throws SQLException {
        String sql = "UPDATE ENDERECO_FUN SET COD_FUNCIONARIO=?, COD_TIPO_ENDERCO=?, COD_CEP=?, END_FUN_BAIRRO=?, END_FUN_RUA=?, END_FUN_NUMERO=?, END_FUN_TELEFONE=?, END_FUN_CELULAR=?, END_FUN_EMAIL=? WHERE END_FUN_ID=?";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, endereco.getCodFuncionario());
            stmt.setInt(2, endereco.getCodTipoEndereco());
            stmt.setInt(3, endereco.getCodCep());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getRua());
            stmt.setInt(6, endereco.getNumero());
            stmt.setString(7, endereco.getTelefone());
            stmt.setString(8, endereco.getCelular());
            stmt.setString(9, endereco.getEmail());
            stmt.setInt(10, endereco.getId());
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM ENDERECO_FUN WHERE END_FUN_ID = ?";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private EnderecoFun extrairEndereco(ResultSet rs) throws SQLException {
        EnderecoFun e = new EnderecoFun();
        e.setId(rs.getInt("END_FUN_ID"));
        e.setCodFuncionario(rs.getInt("COD_FUNCIONARIO"));
        e.setCodTipoEndereco(rs.getInt("COD_TIPO_ENDERCO"));
        e.setCodCep(rs.getInt("COD_CEP"));
        e.setBairro(rs.getString("END_FUN_BAIRRO"));
        e.setRua(rs.getString("END_FUN_RUA"));
        e.setNumero(rs.getInt("END_FUN_NUMERO"));
        e.setTelefone(rs.getString("END_FUN_TELEFONE"));
        e.setCelular(rs.getString("END_FUN_CELULAR"));
        e.setEmail(rs.getString("END_FUN_EMAIL"));
        return e;
    }
}
