// @author Fellipe Gomes Versiani 
// email: fellipeversiani@gmail.com 
// telefone: (38)9239-0013

//Esta classe garante que não haja mais de uma conexão aberta.

package br.com.paripassu.atendimentobancario;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class clsConexao {

    private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:postgresql://localhost:5432/bdPariPassu";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "paripassu";

    public static Connection getConexao() {
        if (conexao == null) {
            try {
                Class.forName("org.postgresql.Driver");
                out.println("Driver JDBC carregado com sucesso.");
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (ClassNotFoundException erroClass) {
                out.println("A classe do Driver JDBC não foi carregada. Erro: " + erroClass);
            } catch (SQLException e) {
                out.println("Erro de conexão com o Banco de Dados. Erro: " + e);
            }
        }
        return conexao;
    }

    public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                Logger.getLogger(clsConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}