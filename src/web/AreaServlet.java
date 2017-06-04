package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basica.Area;
import fachada.Fachada;

@WebServlet("/Area")
public class AreaServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
			
			String numero  = request.getParameter("numeroIdentificador");
			
			Area a = new Area();
			
			a.setNumeroIdentificador(numero);
			
			Fachada f = new Fachada();
			
			try {
				f.areaInserir(a);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
	}
}
