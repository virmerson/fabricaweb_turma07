package br.com.fabricadeprogramador.controller;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/*" })
public class FiltroAutenticacao implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		/**
		 * Convertendo objeto Generico ServletRequest para HttpServletReques
		 * Para acessar a session
		 **/

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;

		String url = httpReq.getRequestURI();

		HttpSession sessao = httpReq.getSession(false);
		/** tem Sessão ? **/
		if (sessao != null 	|| url.lastIndexOf("login.html") > -1
							|| url.lastIndexOf("autenticador.do") > -1) {
			/** Deixa passar **/
			chain.doFilter(request, response);
		} else {
			httpResp.sendRedirect("login.html");
		}

	}

	@Override
	public void destroy() {

	}

}
