package br.com.paripassu.atendimentobancario;

import java.sql.SQLException;

/**
 * A classe define os seguintes Perfis: Cliente = Poder retirar uma nova senha.
 * Gerente = Poder� chamar a pr�xima senha ou resetar a contagem de senhas.
 * Ambos perfis poder�o acompanhar o painel de senhas.
 *
 * @author Fellipe Gomes Versiani 
 * email: fellipeversiani@gmail.com 
 * telefone:(38)9239-0013
 */
public abstract class clsPerfil {

    //Caso queira acrescentar o nome do usuario à senha é possível
    private String sNome; /* Nome da pessoa */
    private int iChamada; /* 0 para cliente com senha não chamada. 1 para senha já chamada */
    
    /*Funções que configuram a classe para os dados atuais e armazenam no banco de dados*/
    /* Salvar os dados no banco de dados Postgree 9.3 ou posterior */

    public void setNome(String sNome) {
        this.sNome = sNome;
    }

    public String getNome() {
        return this.sNome;
    }
    
        public void setChamada(int iSenha, int iTipoPerfil) throws SQLException {
        clsGerentesDAO objGerentesDAO;
        objGerentesDAO = new clsGerentesDAO();
        objGerentesDAO.setChamada(iSenha, iTipoPerfil);
    }

    public int getChamada() {
        return this.iChamada;
    }

    /* O cliente poderá gerar novas senhas, assim como o gerente,
     * tendo em vista que também poderá ser cliente em alguma situação futura.*/
    //Ok
    public int retirarSenha(int iTipoPerfil) throws SQLException {
        clsClientesDAO objClientesDAO;
        objClientesDAO = new clsClientesDAO();
        int iSenha = objClientesDAO.retirarSenha(iTipoPerfil);
        return iSenha;
    }
    
    public void inserirDados(int iTipoPerfil, int iSenha) throws SQLException {
        clsClientesDAO objClientesDAO;
        objClientesDAO = new clsClientesDAO();
        objClientesDAO.inserirDados(iTipoPerfil, iSenha);
    }
}
