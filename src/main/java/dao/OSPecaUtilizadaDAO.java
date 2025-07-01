package dao;

import db.Conexao;
import model.OSPecaUtilizada;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OSPecaUtilizadaDAO {
    private static OSPecaUtilizadaDAO instancia;
	private OSPecaUtilizadaDAO() {}
	public static OSPecaUtilizadaDAO getInstancia() {
		if (instancia == null) {
			instancia = new OSPecaUtilizadaDAO();
		}
		return instancia;
	}
    public void inserir(OSPecaUtilizada osPeca) throws SQLException {
        String sql = "INSERT INTO OS_PECA_UTILIZADA (PECA_ID, COD_OS, QUANTIDADE) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, osPeca.getPeca_id());
            stmt.setInt(2, osPeca.getCod_os());
            stmt.setInt(3, osPeca.getQuantidade());
            stmt.executeUpdate();
        }
    }

    public List<OSPecaUtilizada> listarTodos() throws SQLException {
        List<OSPecaUtilizada> lista = new ArrayList<>();
        String sql = "SELECT * FROM OS_PECA_UTILIZADA";
        try (Connection conn = Conexao.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(extrairOSPeca(rs));
            }
        }
        return lista;
    }

    private OSPecaUtilizada extrairOSPeca(ResultSet rs) throws SQLException {
        OSPecaUtilizada o = new OSPecaUtilizada();
        o.setPeca_id(rs.getInt("PECA_ID"));
        o.setCod_os(rs.getInt("COD_OS"));
        o.setQuantidade(rs.getInt("QUANTIDADE"));
        return o;
    }
}