
// @author Fellipe Gomes Versiani 
// email: fellipeversiani@gmail.com
// telefone:(38)9239-0013

package br.com.paripassu.atendimentobancario;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class clsClientesDAO {

    public void inserirDados(int iTipoPerfil, int iSenha) throws SQLException {

        String sql = "INSERT INTO clientes (data,perfil,senha,chamada) VALUES (CURRENT_TIMESTAMP," + iTipoPerfil + "," + iSenha + ", 0)";        
        Connection conexao = clsConexao.getConexao();
        Statement s = conexao.createStatement();
        s.executeUpdate(sql);
        clsConexao.fecharConexao();
    }

    public int retirarSenha(int iTipo) throws SQLException {

        int iSenha = 0;
        int iFila = 0;
        clsPainelSenhas objPainelSenhas;
        objPainelSenhas = new clsPainelSenhas();

        if (iTipo == 1) {
            iFila = objPainelSenhas.getFila();
            iSenha = objPainelSenhas.getContador();
            objPainelSenhas.setFila(iFila + 1);
        } else if (iTipo == 2) {
            iFila = objPainelSenhas.getFilaPreferencial();
            iSenha = objPainelSenhas.getContadorPreferencial();
            objPainelSenhas.setFilaPreferencial(iFila + 1);
        }
        iSenha = (iSenha + iFila + 1);

        return iSenha;
    }
}
