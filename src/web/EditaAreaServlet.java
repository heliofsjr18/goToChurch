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
import basica.Usuario;
import fachada.Fachada;

@WebServlet("/EditaArea")
public class EditaAreaServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		HttpSession ses = request.getSession(true);
		PrintWriter out = response.getWriter();
		
		String numero  = request.getParameter("numeroIdentificador");
		
		boolean climatizada = false;
		
		
		
		Area a = (Area) ses.getAttribute("obj");
		
		a.setNumeroIdentificador(numero);
		System.out.println("NUMMMMMMMMMMMMM"+a.getNumeroIdentificador());
		
		
		Fachada f = new Fachada();
		try {
			f.areaAlterar(a);
			out.println("<script>alert('Alterado!');</script>");
			response.sendRedirect("ListarArea");
		} catch (Exception e2) {
			out.println("<script>alert('" + e2.getMessage() + "'); history.go(-1);</script>");
		}
		
	}
	
}
