package br.com.fabricadeprogramador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {

	public UsuarioController() {
		System.out.println("instanciando Servlet");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Chamando o Init do Servlet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Recebendo parametros da tela
		String id = req.getParameter("id");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		// Instanciando usuario e setando dados
		Usuario usu = new Usuario();
		// se o id existir
		if (id != null && id !="0") {
			// Convertendo a strind ID para inteiro e setando no usuario
			usu.setId(Integer.parseInt(id));
		}
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);

		// Persistindo no banco
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		// Cadastra ou Altera
		usuarioDAO.salvar(usu);

		// Resposta
		resp.getWriter().print("Salvo!");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String acao = req.getParameter("acao");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (acao == null || acao.equals("lis")) {
			//Carregando a lista do banco
			List<Usuario> lista = usuarioDAO.buscarTodos();
			//Adicionando atributo no request
			req.setAttribute("listaUsu", lista);
			//Objeto de encaminhamento
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listausu.jsp");
			//Encaminhando o request e o respose para o JSP
			dispatcher.forward(req, resp);
		} else if (acao.equals("esc")){
			// Pegando o id da tela
			String id = req.getParameter("id");
			Usuario usu = new Usuario();
			usu.setId(Integer.parseInt(id));
			usuarioDAO.excluir(usu);
			// Mensagem
			resp.getWriter().print("Excluido!");
		} else if (acao.equals("alt")){
			String id = req.getParameter("id");
			Usuario usuario = usuarioDAO.buscarPorId(Integer.parseInt(id));
			req.setAttribute("usu", usuario);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/formusuario.jsp");
			dispatcher.forward(req, resp);
			
		}else if (acao.equals("cad")){
			String id = req.getParameter("id");
				
			Usuario usuario = new Usuario();
			usuario.setId(0);
			usuario.setLogin("");
			usuario.setNome("");
			usuario.setSenha("");
			
			req.setAttribute("usu", usuario);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/formusuario.jsp");
			dispatcher.forward(req, resp);
			
		}
	}
}
