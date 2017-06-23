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

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException, NullPointerException {
			PrintWriter out = response.getWriter();
			HttpSession sessaoLoginServlet = request.getSession(true);
			String login = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Usuario u = new Usuario();
			Usuario logado;
			u.setLogin(login);
			u.setSenha(senha);
			
			try {
				Fachada f = new Fachada();
				logado = f.usuarioLogar(u);
				sessaoLoginServlet.setAttribute("usuario", logado);
				response.sendRedirect("index.jsp");
			} catch (Exception e) {
				out.println("<script>alert('" + e.getMessage() + "'); history.go(-1);</script>");
			}
			
		}
}
