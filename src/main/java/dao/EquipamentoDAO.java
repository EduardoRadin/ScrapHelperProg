package dao;

import db.Conexao;
import model.Equipamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {
    private static EquipamentoDAO instancia;
	private EquipamentoDAO() {}
	public static EquipamentoDAO getInstancia() {
		if (instancia == null) {
			instancia = new EquipamentoDAO();
		}
		return instancia;
	}
    public void inserir(Equipamento eqp) throws SQLException {
        String sql = "INSERT INTO EQUIPAMENTO (COD_PESSOA, EQP_TIPO, EQP_MARCA, EQP_MODELO, EQP_NUM_SERIE, EQP_ESTADO_ENTRADA) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, eqp.getCod_pessoa());
            stmt.setString(2, eqp.getEqp_tipo());
            stmt.setString(3, eqp.getEqp_marca());
            stmt.setString(4, eqp.getEqp_modelo());
            stmt.setFloat(5, eqp.getEqp_num_serie());
            stmt.setString(6, eqp.getEqp_estado_entrada());
            stmt.executeUpdate();
        }
    }

    public Equipamento buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM EQUIPAMENTO WHERE EQP_ID = ?";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extrairEquipamento(rs);
            }
        }
        return null;
    }

    public List<Equipamento> listarTodos() throws SQLException {
        List<Equipamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM EQUIPAMENTO";
        try (Connection conn = Conexao.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(extrairEquipamento(rs));
            }
        }
        return lista;
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM EQUIPAMENTO WHERE EQP_ID = ?";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private Equipamento extrairEquipamento(ResultSet rs) throws SQLException {
        Equipamento e = new Equipamento();
        e.setEqp_id(rs.getInt("EQP_ID"));
        e.setCod_pessoa(rs.getInt("COD_PESSOA"));
        e.setEqp_tipo(rs.getString("EQP_TIPO"));
        e.setEqp_marca(rs.getString("EQP_MARCA"));
        e.setEqp_modelo(rs.getString("EQP_MODELO"));
        e.setEqp_num_serie(rs.getLong("EQP_NUM_SERIE"));
        e.setEqp_estado_entrada(rs.getString("EQP_ESTADO_ENTRADA"));
        return e;
    }
}