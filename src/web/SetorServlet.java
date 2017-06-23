package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basica.Area;
import basica.Setor;
import fachada.Fachada;

@WebServlet("/Setor")
public class SetorServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
			
			HttpSession sessionSetor = request.getSession(true);
			PrintWriter out = response.getWriter();
		
		
			String numero  = request.getParameter("numeroIdentificador");
			String[] areas  = request.getParameterValues("congregacao");
			
			Setor s = new Setor();
			
			s.setNumeroIdentificador(numero);
			
			List<Area> la =new ArrayList<Area>();;
			

			for(int i = 0; i<areas.length; i++){
				Area a = new Area();
				a.setId(Integer.parseInt(areas[i]));
				la.add(a);
			}

			s.setListaArea(la);
			
			Fachada f = new Fachada();
			
			try {
				f.setorInserir(s);
				response.sendRedirect("ListarSetor");
			} catch (Exception e) {
				out.println("<script>alert('" + e.getMessage() + "'); history.go(-1);</script>");
			}
			
	}
}