package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basica.Setor;
import fachada.Fachada;

@WebServlet("/Setor")
public class SetorServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
			
			String numero  = request.getParameter("numeroIdentificador");
			
			Setor s = new Setor();
			
			s.setNumeroIdentificador(numero);
			
			Fachada f = new Fachada();
			
			try {
				f.setorInserir(s);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
	}
}