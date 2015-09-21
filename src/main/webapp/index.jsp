<!--  
@author    Fellipe Gomes Versiani 
email:     fellipeversiani@gmail.com 
telefone:  (38)9239-0013
-->

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="br.com.paripassu.atendimentobancario.*"%>

<!DOCTYPE html>

<html>
    
<script language="JavaScript">
function myrefresh()
{
window.location.reload();
}
setTimeout('myrefresh()',15000); //Especifica a cadA 1 Segundo
</script>

    <head>
        <title> Sistema de Atendimento Bancário - PariPassu </title>
        <link rel="stylesheet" type= "text/css" href="reset.css">
        <link rel="stylesheet" type= "text/css" href="style.css">
    </head>

    <body >
        <div class="container"> 
            <div id="header"> 
                <div id="logo"> </div>
                <div id="linha" align= "center" style="margin-left: 25px;"> Sistema de Atendimento Bancário </div>
            </div>
            <div id="content" align = "center"> </br> <div id="underline">Painel de Senhas </div>
                <div id="painel"> 

                    <%
                        // Confere se há senhas em andamento, tanto de senhas
                        // preferenciais, quanto de senhas normais. Se houver
                        // demonstra qual o contador atual. Se não houver, exibe
                        // uma mensagem na tela de que não foi chamada nenhuma senha ainda.

                        clsPainelSenhas objPainelSenhas;
                        objPainelSenhas = new clsPainelSenhas();

                        clsGerente objGerente;
                        objGerente = new clsGerente();

                        int iContadorAtual = objPainelSenhas.getContador();
                        int iContadorPreferencialAtual = objPainelSenhas.getContadorPreferencial();

                        String sUltimaSenhaChamada = "";

                        if ((iContadorAtual == 0) && (iContadorPreferencialAtual == 0)) {
                            out.println("#####");
                        } else {
                            sUltimaSenhaChamada = objGerente.getUltimaSenhaChamada();
                            out.println(sUltimaSenhaChamada.trim());
                        }
                    %>


                </div>
                <div id="underline" align = "left" style = "padding-left:60px;"> </br></br> Tipo de Senha: </div>
            </div>
            <br>

            <form name="clientePerfil" method="post" action="senha.jsp" >
                <div style="position:relative;">
                    <div style= "float: left; ">
                        <input type="radio"  id="radio1" class="radio"  name="rdoTipo" value="N" checked/>
                        <label for="radio1" >Normal</label>
                    </div>

                    <div style= "float:left;">
                        <input type="radio"  id="radio2" class="radio" name="rdoTipo" value="P"/>
                        <label for="radio2" >Preferencial</label>
                    </div>

                </div>
                <div style="position: relative;  margin-left:85px; float:left; ">     
                    <button type="submit" style="position: absolute; top: -7px; width: 70px; height: 40px; font-size: 16px; font-weight: bold; background-color: #F6F6F6;" >Retirar</button>
                </div>
            </form> </br></br></br></br>
            
            <!--text-shadow: 2px -2px 5px #7f99a5 -->
            
            <div style="clear:both; " align="center">
                
                
                <a href="http://localhost:8080/AtendimentoBancario/gerente.jsp"> Gerenciar </a>
            </div>
            <div id="footer" align = "center"> Desenvolvido por Fellipe Versiani - (38)9239-0013 - fellipeversiani@gmail.com </div>
        </div>
    </body>
</html> 