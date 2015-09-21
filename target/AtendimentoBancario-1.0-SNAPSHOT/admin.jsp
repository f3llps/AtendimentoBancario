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


<div id="content" align = "center"> </br> <div id="underline">

            <%
                clsGerente objGerente;
                objGerente = new clsGerente();
                String sSenhaASerChamada = "";

                String sAcao = (String) request.getParameter("rdoAcao");
                if ((sAcao != null) && (sAcao.equals("C"))) {
                    clsPainelSenhas objPainelSenhas;
                    objPainelSenhas = new clsPainelSenhas();
                    if ((objPainelSenhas.getFila() == 0) && (objPainelSenhas.getFilaPreferencial() == 0)) {
                        out.println("Atenção: </div> <div id=\"painel\"> Sem Filas");
                    } else {
                        sSenhaASerChamada = objGerente.chamarProximaSenha();
                        out.println("Senha a ser chamada: </div> <div id=\"painel\" >" + sSenhaASerChamada);
                    }
                } else if ((sAcao != null) && (sAcao.equals("R"))) {
                    objGerente.resetarSenha();
                        out.println("Atenção: </div> <div id=\"painel\"> Resetado");
                }
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