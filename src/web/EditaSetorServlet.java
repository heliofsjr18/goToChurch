package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basica.Area;
import basica.Congregacao;
import basica.Endereco;
import basica.Setor;
import basica.Usuario;
import fachada.Fachada;

@WebServlet("/EditaSetor")
public class EditaSetorServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		HttpSession ses = request.getSession(true);
		PrintWriter out = response.getWriter();
		
		String numero  = request.getParameter("numeroIdentificador");
		
		
		
		
		Setor s = (Setor) ses.getAttribute("obj");
		
		s.setNumeroIdentificador(numero);
		
		
		Fachada f = new Fachada();
		try {
			f.setorAlterar(s);
			out.println("<script>alert('Alterado!');</script>");
			response.sendRedirect("ListarSetor");
		} catch (Exception e2) {
			out.println("<script>alert('" + e2.getMessage() + "'); history.go(-1);</script>");
		}
		
	}
	
}
