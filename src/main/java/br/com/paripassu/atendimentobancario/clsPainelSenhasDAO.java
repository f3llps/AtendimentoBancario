/**
 * @author Fellipe Gomes Versiani 
 * email: fellipeversiani@gmail.com 
 * telefone:(38)9239-0013
 */

package br.com.paripassu.atendimentobancario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class clsPainelSenhasDAO {

    public void setFila(int iFila, int iTipo) throws SQLException {
        Connection conexao = clsConexao.getConexao();               
        String sql = "UPDATE senhas SET fila = " + iFila +  " WHERE tipo = " + iTipo;
        Statement s = conexao.createStatement();
        s.executeUpdate(sql);
        clsConexao.fecharConexao();
    }

    public void setContador(int iContador, int iTipo) throws SQLException {

        Connection conexao = clsConexao.getConexao();
        String sql = "UPDATE senhas SET contador = " + iContador + " WHERE tipo = " + iTipo;
        Statement s = conexao.createStatement();
        s.executeUpdate(sql);
        clsConexao.fecharConexao();
    }

    public int getFila(int iTipo) throws SQLException {

        int ultimaFila = 0;
        Connection conexao = clsConexao.getConexao();
        String sql = "SELECT fila FROM senhas WHERE tipo = " + iTipo;
        Statement s = conexao.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            ultimaFila = rs.getInt("fila");
        }
        rs.close();
        clsConexao.fecharConexao();
        return ultimaFila;
    }

    public int getContador(int iTipo) throws SQLException {
        Connection conexao = clsConexao.getConexao();
        int ultimoContador = 0;
        String sql = "SELECT contador FROM senhas WHERE tipo = " + iTipo;
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ultimoContador = rs.getInt("contador");
        }
        clsConexao.fecharConexao();
        return ultimoContador;
    }   
}
