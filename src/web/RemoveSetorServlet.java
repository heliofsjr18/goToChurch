package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basica.Setor;
import fachada.Fachada;

@WebServlet("/RemoveSetor")
public class RemoveSetorServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		PrintWriter out = response.getWriter();
		String objeto = request.getParameter("objeto");		
		HttpSession sessao = request.getSession(true);
		Setor s = (Setor) sessao.getAttribute(objeto);
		
		try {
			Fachada f = new Fachada();
			f.setorExcluir(s);
			out.println("<script>alert('Removido!')</script>");
			response.sendRedirect("ListarSetor");
		} catch (Exception e) {
			out.println("<script>alert('" + e.getMessage() + "'); history.go(-1);</script>");
		}
	}
}
