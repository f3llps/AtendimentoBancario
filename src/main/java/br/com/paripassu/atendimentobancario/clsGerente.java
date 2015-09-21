// A classe herda atividades da classe Perfil.

// @author Fellipe Gomes Versiani 
// email: fellipeversiani@gmail.com 
// telefone: (38)9239-0013

package br.com.paripassu.atendimentobancario;

import static java.lang.System.out;
import java.sql.SQLException;

public class clsGerente extends clsPerfil {
/* Caso ainda queira registrar outros dados para uma futura
 * mineração de dados, podem ser acrescidas outras variáveis à esta classe e à
 sua tabela do banco de dados correspondente.*/

    public String chamarProximaSenha() throws SQLException {

        clsPainelSenhas objPainelSenhas;
        objPainelSenhas = new clsPainelSenhas();

        clsGerentesDAO objGerentesDAO;
        objGerentesDAO = new clsGerentesDAO();

        int iFila = objPainelSenhas.getFila();
        int iFilaPreferencial = objPainelSenhas.getFilaPreferencial();
        int iSenhaASerChamada = 0;
        String sTipoSenhaASerChamada = "";
        String sSenhaASerChamada = "";

        if ((iFila == 0) && (iFilaPreferencial == 0)) {
            out.println("Não há clientes nas filas.");
        } else if (iFilaPreferencial != 0) {
            //2 - senha preferencial.
            sTipoSenhaASerChamada = "P";
            objPainelSenhas.setFilaPreferencial(iFilaPreferencial - 1);
            iSenhaASerChamada = objPainelSenhas.getContadorPreferencial();
            iSenhaASerChamada = iSenhaASerChamada + 1;
            objPainelSenhas.setContadorPreferencial(iSenhaASerChamada);
            objGerentesDAO.setChamada(iSenhaASerChamada, 2);
        } else if (iFila != 0) {
            //1 - senha normal.
            sTipoSenhaASerChamada = "N";
            objPainelSenhas.setFila(iFila - 1);
            iSenhaASerChamada = objPainelSenhas.getContador();
            iSenhaASerChamada = iSenhaASerChamada + 1;
            objPainelSenhas.setContador(iSenhaASerChamada);
            objGerentesDAO.setChamada(iSenhaASerChamada, 1);
        }

        //Realizando a padronização da senha - N#### ou P####.
        if (iSenhaASerChamada / 1000 >= 1) {
            // A última senha chamada é maior que 1000.
            sSenhaASerChamada = "" + iSenhaASerChamada;

        } else if (iSenhaASerChamada / 100 >= 1) {
            // A última senha chamada é maior que 100 e menor que 1000.
            sSenhaASerChamada = "0" + iSenhaASerChamada;

        } else if (iSenhaASerChamada / 10 >= 1) {
            // A última senha chamada é maior que 10 e menor que 100.
            sSenhaASerChamada = "00" + iSenhaASerChamada;

        } else if (iSenhaASerChamada / 1 >= 1) {
            // A última senha chamada é maior que 1 menor que 10.
            sSenhaASerChamada = "000" + iSenhaASerChamada;
        }

        sSenhaASerChamada = sTipoSenhaASerChamada + sSenhaASerChamada;

        return sSenhaASerChamada;
    }

    /* Somente o gerente poderá resetar as senhas*/
    public void resetarSenha() throws SQLException {
        clsPainelSenhas objPainelSenhas;
        objPainelSenhas = new clsPainelSenhas();
        objPainelSenhas.setContador(0);
        objPainelSenhas.setContadorPreferencial(0);
        objPainelSenhas.setFila(0);
        objPainelSenhas.setFilaPreferencial(0);
        clsGerente objGerentesDAO;
        objGerentesDAO = new clsGerente();
        objGerentesDAO.resetarTabelaClientes();
    }

    public String getUltimaSenhaChamada() throws SQLException {
        clsGerentesDAO objGerentesDAO;
        objGerentesDAO = new clsGerentesDAO();
        return objGerentesDAO.getUltimaSenhaChamada();
    }

    public int getUltimoTipoChamado() throws SQLException {
        clsGerentesDAO objGerentesDAO;
        objGerentesDAO = new clsGerentesDAO();
        return objGerentesDAO.getUltimoTipoChamado();
    }

    public void setChamada(int iSenha, int iTipoPerfil) throws SQLException {
        clsGerentesDAO objGerentesDAO;
        objGerentesDAO = new clsGerentesDAO();
        objGerentesDAO.setChamada(iSenha, iTipoPerfil);
    }

    public void resetarTabelaClientes() throws SQLException {
        clsGerentesDAO objGerentesDAO;
        objGerentesDAO = new clsGerentesDAO();
        objGerentesDAO.resetarTabelaClientes();
    }
}
