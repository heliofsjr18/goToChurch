package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basica.Usuario;
import fachada.Fachada;

@WebServlet("/RemoveUsuario")
public class RemoveUsuarioServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		PrintWriter out = response.getWriter();
		String objeto = request.getParameter("objeto");		
		HttpSession sessao = request.getSession(true);
		Usuario u = (Usuario) sessao.getAttribute(objeto);
		
		try {
			Fachada f = new Fachada();
			f.usuarioExcluir(u);
			response.sendRedirect("ListarUsuario");
		} catch (Exception e) {
			out.println("<script>alert('" + e.getMessage() + "'); history.go(-1);</script>");
		}
	}
}
