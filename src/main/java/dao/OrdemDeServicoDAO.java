package dao;

import db.Conexao;
import model.OrdemDeServico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdemDeServicoDAO {
    private static OrdemDeServicoDAO instancia;

    private OrdemDeServicoDAO() {
    }

    public static OrdemDeServicoDAO getInstancia() {
        if (instancia == null) {
            instancia = new OrdemDeServicoDAO();
        }
        return instancia;
    }

    public void inserir(OrdemDeServico os) throws SQLException {
        String sql = "INSERT INTO ORDEM_SERVICO (COD_EQP, COD_FUN, OS_DATA_ENTRADA, OS_DATA_CONCLUSAO, OS_EQP_STATUS, OS_EQP_PROBLEMA, OS_ORCAMENTO, OS_SERVICO_REALIZADO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getInstancia().getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, os.getCod_eqp());
            stmt.setInt(2, os.getCod_fun());
            stmt.setDate(3, java.sql.Date.valueOf(os.getOs_data_entrada()));
            stmt.setDate(4, java.sql.Date.valueOf(os.getOs_data_conclusao()));
            stmt.setString(5, os.getOs_eqp_status());
            stmt.setString(6, os.getOs_eqp_problema());
            stmt.setFloat(7, os.getOs_orcamento());
            stmt.setString(8, os.getOs_servico_realizado());
            stmt.executeUpdate();
        }
    }

    public OrdemDeServico buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM ORDEM_SERVICO WHERE OS_COD = ?";
        try (Connection conn = Conexao.getInstancia().getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return extrairOrdem(rs);
            }
        }
        return null;
    }

    public List<OrdemDeServico> listarTodos() throws SQLException {
        List<OrdemDeServico> lista = new ArrayList<>();
        String sql = "SELECT * FROM ORDEM_SERVICO";
        try (Connection conn = Conexao.getInstancia().getConexao();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(extrairOrdem(rs));
            }
        }
        return lista;
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM ORDEM_SERVICO WHERE OS_COD = ?";
        try (Connection conn = Conexao.getInstancia().getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private OrdemDeServico extrairOrdem(ResultSet rs) throws SQLException {
        OrdemDeServico o = new OrdemDeServico();
        o.setOs_cod(rs.getInt("OS_COD"));
        o.setCod_eqp(rs.getInt("COD_EQP"));
        o.setCod_fun(rs.getInt("COD_FUN"));
        o.setOs_data_entrada(rs.getDate("OS_DATA_ENTRADA").toLocalDate()); // Converted to LocalDate
        o.setOs_data_conclusao(rs.getDate("OS_DATA_CONCLUSAO").toLocalDate()); // Converted to LocalDate
        o.setOs_eqp_status(rs.getString("OS_EQP_STATUS"));
        o.setOs_eqp_problema(rs.getString("OS_EQP_PROBLEMA"));
        o.setOs_orcamento(rs.getFloat("OS_ORCAMENTO"));
        o.setOs_servico_realizado(rs.getString("OS_SERVICO_REALIZADO"));
        return o;
    }
}
