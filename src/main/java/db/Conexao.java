package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static Conexao instancia;
    private Connection conexao;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "Edu_751210";

    private Conexao() throws SQLException {
        this.conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static Conexao getInstancia() throws SQLException {
        if (instancia == null || instancia.getConexao().isClosed()) {
            instancia = new Conexao();
        }
        return instancia;
    }

    public Connection getConexao() {
        return conexao;
    }
}