 // @author Fellipe Gomes Versiani 
 // email: fellipeversiani@gmail.com
 // telefone:(38)9239-0013

package br.com.paripassu.atendimentobancario;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class clsGerentesDAO {

    public void setChamada(int iSenha, int iTipoPerfil) throws SQLException {
        Connection conexao = clsConexao.getConexao();
        String sql = "UPDATE clientes SET chamada = 1 WHERE perfil = " + iTipoPerfil + " AND senha = " + iSenha + " AND chamada = 0";
        out.println(sql);
        Statement s = conexao.createStatement();
        s.executeUpdate(sql);
        
        String sql2 = "UPDATE \"ultimaSenha\" SET tipo = " + iTipoPerfil;
        Statement s2 = conexao.createStatement();
        s2.executeUpdate(sql2);
        
        
        clsConexao.fecharConexao();
    }

    public String getUltimaSenhaChamada() throws SQLException {
        
        int iUltimaSenhaChamada = 0;
        int iUltimoTipoChamado = this.getUltimoTipoChamado();
        String sUltimaSenhaChamada = "";
        String sUltimoTipoChamado = "";
        
        Connection conexao = clsConexao.getConexao();

        String sql = "SELECT * FROM clientes WHERE id = (SELECT max(id) FROM clientes WHERE chamada = 1 AND perfil = " + iUltimoTipoChamado + ")";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            iUltimaSenhaChamada = rs.getInt("senha");
        }

        if (iUltimoTipoChamado == 1) {
            sUltimoTipoChamado = "N";
        } else if (iUltimoTipoChamado == 2) {
            sUltimoTipoChamado = "P";
        }

        // Tratando a exibição de última senha chamada no formarto P#### ou N####.
        if (iUltimaSenhaChamada / 1000 >= 1) {
            // A última senha chamada é maior que 1000.
            sUltimaSenhaChamada = "" + iUltimaSenhaChamada;

        } else if (iUltimaSenhaChamada / 100 >= 1) {
            // A última senha chamada é maior que 100 e menor que 1000.
            sUltimaSenhaChamada = "0" + iUltimaSenhaChamada;

        } else if (iUltimaSenhaChamada / 10 >= 1) {
            // A última senha chamada é maior que 10 e menor que 100.
            sUltimaSenhaChamada = "00" + iUltimaSenhaChamada;

        } else if (iUltimaSenhaChamada / 1 >= 1) {
            // A última senha chamada é maior que 1 menor que 10.
            sUltimaSenhaChamada = "000" + iUltimaSenhaChamada;
        }

        sUltimaSenhaChamada = sUltimoTipoChamado + sUltimaSenhaChamada;

        clsConexao.fecharConexao();

        return sUltimaSenhaChamada;
    }

    public void resetarTabelaClientes() throws SQLException {
        Connection conexao = clsConexao.getConexao();

        String sql = "ALTER SEQUENCE clientes_id_seq RESTART WITH 1";
        Statement s = conexao.createStatement();
        s.executeUpdate(sql);

        String sql2 = "DELETE FROM clientes";
        Statement s2 = conexao.createStatement();
        s2.executeUpdate(sql2);

        clsConexao.fecharConexao();
    }

    public int getUltimoTipoChamado() throws SQLException {
        Connection conexao = clsConexao.getConexao();
        int ultimoTipo = 0;
        String sql = "SELECT tipo FROM \"ultimaSenha\"";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            ultimoTipo = rs.getInt("tipo");
        }
        clsConexao.fecharConexao();
        return ultimoTipo;
    }
}
