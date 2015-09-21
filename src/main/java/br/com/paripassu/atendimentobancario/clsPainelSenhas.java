/**
 * @author Fellipe Gomes Versiani 
 * email: fellipeversiani@gmail.com 
 * telefone: (38)9239-0013
 *
 * A classe define a contagem das senhas tanto para senhas do tipo normal,
 * quanto para senhas do tipo preferencial.
 */

package br.com.paripassu.atendimentobancario;

import java.sql.SQLException;

public class clsPainelSenhas {

    private int iContador; // Conta quantas pessoas j� foram chamadas, de acordo com seu tipo.	 
    private int iContadorPreferencial;
    private int iFila; //Conta quantas pessoas pendentes a serem chamadas, de acordo com seu tipo.
    private int iFilaPreferencial;

    public void setContador(int iContadorAtual) throws SQLException {
        clsPainelSenhasDAO objPainelSenhasDAO;
        objPainelSenhasDAO = new clsPainelSenhasDAO();
        objPainelSenhasDAO.setContador(iContadorAtual, 1);
        this.iContador = iContadorAtual;
    }

    public void setContadorPreferencial(int iContadorPreferencialAtual) throws SQLException {
        clsPainelSenhasDAO objPainelSenhasDAO;
        objPainelSenhasDAO = new clsPainelSenhasDAO();
        objPainelSenhasDAO.setContador(iContadorPreferencialAtual, 2);
        this.iContadorPreferencial = iContadorPreferencialAtual;
    }
    
    public void setFila(int iFilaAtual) throws SQLException {
        clsPainelSenhasDAO objPainelSenhasDAO;
        objPainelSenhasDAO = new clsPainelSenhasDAO();
        objPainelSenhasDAO.setFila(iFilaAtual, 1);
        this.iFila = iFilaAtual;
    }

    public void setFilaPreferencial(int iFilaPreferencialAtual) throws SQLException {
        clsPainelSenhasDAO objPainelSenhasDAO;
        objPainelSenhasDAO = new clsPainelSenhasDAO();
        objPainelSenhasDAO.setFila(iFilaPreferencialAtual, 2);
        this.iFilaPreferencial = iFilaPreferencialAtual;
    }
    
    public int getContador() throws SQLException {
        clsPainelSenhasDAO objPainelSenhasDAO;
        objPainelSenhasDAO = new clsPainelSenhasDAO();
        return objPainelSenhasDAO.getContador(1);
    }

    public int getContadorPreferencial() throws SQLException {
        clsPainelSenhasDAO objPainelSenhasDAO;
        objPainelSenhasDAO = new clsPainelSenhasDAO();      
        return objPainelSenhasDAO.getContador(2);
    }

    public int getFila() throws SQLException {
        clsPainelSenhasDAO objPainelSenhasDAO;
        objPainelSenhasDAO = new clsPainelSenhasDAO();
        return objPainelSenhasDAO.getFila(1);
    }

    public int getFilaPreferencial() throws SQLException {
        clsPainelSenhasDAO objPainelSenhasDAO;
        objPainelSenhasDAO = new clsPainelSenhasDAO();
       return objPainelSenhasDAO.getFila(2);
    }
}
