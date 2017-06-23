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

import basica.Area;
import fachada.Fachada;
import util.DadosException;
import util.NegocioException;

@WebServlet("/ListarArea")
public class ListaAreaServlet extends HttpServlet {
	//
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		HttpSession session = request.getSession(true);
		PrintWriter out = response.getWriter();
		
		List<Area> lc;
		Fachada f = new Fachada();
		try {
			lc = f.areaListar();
			session.setAttribute("lista",  lc);
			response.sendRedirect("areas.jsp");
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			out.println("<script>alert('" + e.getMessage() + "'); history.go(-1);</script>");
		} catch (DadosException e) {
			// TODO Auto-generated catch block
			out.println("<script>alert('" + e.getMessage() + "'); history.go(-1);</script>");
		}
		
	}
}
