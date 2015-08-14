<%@page import="br.com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<th> ID </th>
		<th> NOME </th>
		<th > &nbsp; </th>
	</tr>
<%
//Acessando dados do Servlet
List<Usuario> lista = (List<Usuario>)request.getAttribute("listaUsu");
//Gerando linhas na tabela para imprimir os dados
for (Usuario u:lista){ 
%>
	<tr>  
		<td><%=u.getId()%>  </td> 
		<td><%= u.getNome() %></td> 
		<td> <a href="usucontroller.do?acao=alt&id=<%=u.getId()%>">Editar</a> </td>   
	</tr>

<%
}
%>

</table>


</body>
</html>