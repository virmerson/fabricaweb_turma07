<%@page import="br.com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
//Acessando a session e pegando objeto usuario
Usuario usuario = (Usuario) request.getSession().getAttribute("usuAutenticado"); 
%>

Bem vindo <%= usuario.getNome()  %> !
</body>
</html>