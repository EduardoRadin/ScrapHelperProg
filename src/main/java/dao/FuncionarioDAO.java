package dao;

import model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {
	private static FuncionarioDAO instancia;
	private FuncionarioDAO() {}
	public static FuncionarioDAO getInstancia() {
		if (instancia == null) {
			instancia = new FuncionarioDAO();
		}
		return instancia;
	}
	
	public void inserirFuncionario(Connection conn, Funcionario funcionario) throws SQLException {
		char genero = Character.toUpperCase(funcionario.getFun_gen());
		if (genero != 'F' && genero != 'M') {
			throw new IllegalArgumentException("Gênero inválido. Use apenas 'F' ou 'M'.");
		}

		String sql = "INSERT INTO FUNCIONARIO (COD_CARGO, FUN_NOME, FUN_CPF, FUN_RG, FUN_DATA_NAS, FUN_GEN) VALUES (?, ?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, funcionario.getCod_cargo());
			stmt.setString(2, funcionario.getFun_nome());
			stmt.setLong(3, Long.parseLong(funcionario.getFun_cpf()));
			stmt.setLong(4, Long.parseLong(funcionario.getFun_rg()));
			stmt.setDate(5, java.sql.Date.valueOf(funcionario.getFun_data_nas()));
			stmt.setString(6, String.valueOf(genero));

			stmt.executeUpdate();
			System.out.println("Funcionário inserido com sucesso.");
		}
	}
}
