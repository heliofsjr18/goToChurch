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

import basica.Usuario;
import fachada.Fachada;
import util.DadosException;
import util.NegocioException;

@WebServlet("/ListarUsuario")
public class ListaUsuarioServlet extends HttpServlet {
	//
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		List<Usuario> lu;
		Fachada f = new Fachada();
		try {
			lu = f.usuarioListar();
			session.setAttribute("lista",  lu);
			response.sendRedirect("usuarios.jsp");
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			out.println("<script>alert('" + e.getMessage() + "'); history.go(-1);</script>");
		} catch (DadosException e) {
			// TODO Auto-generated catch block
			out.println("<script>alert('" + e.getMessage() + "'); history.go(-1);</script>");
		}
		
	}
}
