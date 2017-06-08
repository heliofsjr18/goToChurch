package web;

import java.io.IOException;
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

@WebServlet("/ListarObreiro")
public class ListaUsuarioObreiroServlet extends HttpServlet {
	//
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		HttpSession session = request.getSession(true);
		
		List<Usuario> lu;
		Fachada f = new Fachada();
		try {
			lu = f.usuarioListarObreiro();
			session.setAttribute("lista",  lu);
			response.sendRedirect("usuarios.jsp");
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
