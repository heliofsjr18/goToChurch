package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import basica.Setor;
import fachada.Fachada;
import util.DadosException;
import util.NegocioException;

@WebServlet("/ListarSetor")
public class ListaSetorServlet extends HttpServlet {
	//
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		
		List<Setor> ls;
		Fachada f = new Fachada();
		try {
			ls = f.setorListar();
			session.setAttribute("lista",  ls);
			response.sendRedirect("setores.jsp");
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			out.println("<script>alert('"+e.getMessage()+"');</script>");
		} catch (DadosException e) {
			// TODO Auto-generated catch block
			out.println("<script>alert('"+e.getMessage()+"');</script>");
		}
		
	}
}
