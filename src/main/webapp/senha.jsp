<!--  
@author    Fellipe Gomes Versiani 
email:     fellipeversiani@gmail.com 
telefone:  (38)9239-0013
-->

<%@page import="br.com.paripassu.atendimentobancario.*"%>

<!DOCTYPE html>


<html>

<head>
<title> Sistema de Atendimento Bancário - PariPassu </title>
<link rel="stylesheet" type= "text/css" href="reset.css">
<link rel="stylesheet" type= "text/css" href="style.css">
</head>

<body>
<div class="container"> 
<div id="header"> 
	<div id="logo"> </div>
	<div id="linha" align= "center" style="padding-left:10px;"> Sistema de Atendimento Bancário </div>
</div>
<div id="content" align = "center"> 


<div id="content" align = "center"> </br> <div id="underline">Anote a sua senha: </div>
            <div id="painel"> 
                    <%
                        // Obtendo os dados perfil do cliente via POST/GET
                        String sTipoSenhaRetirada = (String) request.getParameter("rdoTipo");
                        String sSenhaRetirada = "";
                        clsCliente objCliente;
                        objCliente = new clsCliente();
                        int iSenhaRetirada = 0;
                        int iTipoSenha = 0;

                        // Retirando a senha de acordo com o perfil do cliente.
                        if ((sTipoSenhaRetirada != null) && (sTipoSenhaRetirada.equals("N"))) {
                            iTipoSenha = 1;
                            iSenhaRetirada = objCliente.retirarSenha(1);
                        } else if ((sTipoSenhaRetirada != null) && (sTipoSenhaRetirada.equals("P"))) {
                            iTipoSenha = 2;
                            iSenhaRetirada = objCliente.retirarSenha(2);
                        }

                        // Tratando a exibição da senha retirada no formarto P#### ou N####.
                        if (iSenhaRetirada / 1000 >= 1) {
                            // Senha maior que 1000.
                            sSenhaRetirada = "" + iSenhaRetirada;
                        } else if (iSenhaRetirada / 100 >= 1) {
                            // Senha maior que 100 e menor que 1000.
                            sSenhaRetirada = "0" + iSenhaRetirada;
                        } else if (iSenhaRetirada / 10 >= 1) {
                            // Senha maior que 10 e menor que 100.
                            sSenhaRetirada = "00" + iSenhaRetirada;
                        } else if (iSenhaRetirada / 1 >= 1) {
                            // Senha maior que 1 e menor que 10.
                            sSenhaRetirada = "000" + iSenhaRetirada;
                        }

                        // Exibindo qual foi a senha retirada, removendo os espaços em branco.
                        out.println("" + (sTipoSenhaRetirada + sSenhaRetirada).trim());
                        objCliente.inserirDados(iTipoSenha, iSenhaRetirada);
                    %> 
</div> </br> </br> 
            <a href="http://localhost:8080/AtendimentoBancario/">  
                <button style="width: 70px; height: 40px; font-size: 16px; font-weight: bold; background-color: #F6F6F6;"> Voltar</button> 
            </a>



</div>
</br> </br> </br> </br> </br> </br> 


<div id="footer" align = "center"> Desenvolvido por Fellipe Versiani - (38)9239-0013 - fellipeversiani@gmail.com </div>
</div>



</body>
</html> 
