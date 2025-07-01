package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import db.Conexao;
import model.Usuario;

public class UsuarioDAO {
	private static UsuarioDAO instancia;

	private UsuarioDAO() {
	}

	public static UsuarioDAO getInstancia() {
		if (instancia == null) {
			instancia = new UsuarioDAO();
		}
		return instancia;
	}

	public void inserir(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO USUARIO (COD_FUNCIONARIO, USU_PERMISSAO, USU_LOGIN, USU_SENHA) VALUES (?, ?, ?, ?)";

		try (Connection conn = Conexao.getInstancia().getConexao();
				PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setInt(1, usuario.getCod_funcionario());
			stmt.setInt(2, usuario.getUsu_permissao());
			stmt.setString(3, usuario.getUsu_login());
			stmt.setString(4, usuario.getUsu_senha());

			stmt.executeUpdate();
		}
	}

	public void buscautenticar(Usuario usuario) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE usu_login = ? and usu_senha = ?";
		try (Connection conn = Conexao.getInstancia().getConexao();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
		}
	}
}
