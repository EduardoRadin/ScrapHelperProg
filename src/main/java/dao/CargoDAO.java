package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Conexao;
import model.Cargo;

public class CargoDAO {
	private static CargoDAO instancia;
	private CargoDAO() {}
	public static CargoDAO getInstancia() {
		if (instancia == null) {
			instancia = new CargoDAO();
		}
		return instancia;
	}
	
	public void inserir(Cargo cargo) throws SQLException {
        String sql = "INSERT INTO CARGO (CARGO_DESCRICAO, CARGO_SALARIO) VALUES (?, ?)";
        try (Connection conn = Conexao.getInstancia().getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

               stmt.setString(1, cargo.getcargo_descricao());
               stmt.setFloat(2, cargo.getCargo_salario());
               
               stmt.executeUpdate();
           }
       }
	
	public Cargo buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM CARGO WHERE CARGO_COD = ?";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extrairCargo(rs);
            }
        }
        return null;
    }
	public List<Cargo> listarTodos() throws SQLException {
        List<Cargo> lista = new ArrayList<>();
        String sql = "SELECT * FROM CARGO";
        try (Connection conn = Conexao.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(extrairCargo(rs));
            }
        }
        return lista;
    }
	public void atualizar(Cargo cargo) throws SQLException {
        String sql = "UPDATE CARGO SET CARGO_DESCRICAO=?, CARGO_SALARIO=? WHERE CARGO_COD=?";

        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

        	stmt.setString(1, cargo.getcargo_descricao());
            stmt.setFloat(2, cargo.getCargo_salario());
            stmt.setInt(3, cargo.getCargo_cod());
            stmt.executeUpdate();
        }
    }
	public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM CARGO WHERE CARGO_COD = ?";
        try (Connection conn = Conexao.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
	private Cargo extrairCargo(ResultSet rs) throws SQLException {
		Cargo e = new Cargo();
        e.setCargo_cod(rs.getInt("CARGO_COD"));
        e.setcargo_descricao(rs.getString("CARGO_DESCRICAO"));
        e.setCargo_salario(rs.getFloat("CARGO_SALARIO"));

        return e;
    }
}
