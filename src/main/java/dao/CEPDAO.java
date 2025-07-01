package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexao;
import model.CEP;

public class CEPDAO {
    private static CEPDAO instancia;
	private CEPDAO() {}
	public static CEPDAO getInstancia() {
		if (instancia == null) {
			instancia = new CEPDAO();
		}
		return instancia;
	}
	public void inserir(CEP cep) throws SQLException {
        String sql = "INSERT INTO CEP (CEP_COD, COD_MUN) VALUES (?, ?)";

        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cep.getCep_cod());
            stmt.setInt(2, cep.getCod_mun());

            stmt.executeUpdate();
        }
    }
    public CEP buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM CEP WHERE CEP_COD = ?";
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
    
    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM CEP WHERE CEP_COD = ?";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    
    public List<CEP> listarTodos() throws SQLException {
        List<CEP> lista = new ArrayList<>();
        String sql = "SELECT * FROM CEP";
        try (Connection conn = Conexao.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(extrairEndereco(rs));
            }
        }
        return lista;
    }
    
    private CEP extrairEndereco(ResultSet rs) throws SQLException {
    	CEP e = new CEP();
        e.setCep_cod(rs.getInt("CEP_COD"));
        e.setCod_mun(rs.getInt("COD_MUN"));
        
        return e;
    }

}
