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
import basica.Congregacao;
import fachada.Fachada;

@WebServlet("/Area")
public class AreaServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
			HttpSession sessionArea = request.getSession(true);
			PrintWriter out = response.getWriter();
			
			
			String numero  = request.getParameter("numeroIdentificador");
			String[] congregacoes  = request.getParameterValues("congregacao");
			
			List<Congregacao> td = (List<Congregacao>) sessionArea.getAttribute("todas");
			System.out.println(td);
			List<Congregacao> lc =new ArrayList<Congregacao>();;
			

			for(int i = 0; i<congregacoes.length; i++){
				Congregacao c = new Congregacao();
				c.setId(Integer.parseInt(congregacoes[i]));
				lc.add(c);
			}
			
			
			
			Area a = new Area();
			
			a.setNumeroIdentificador(numero);
			a.setListaCongregacao(lc);
			
			Fachada f = new Fachada();
			
			try {
				f.areaInserir(a);
				response.sendRedirect("ListarArea");
			} catch (Exception e) {
				out.println("<script>alert('"+e.getMessage()+"')</script>");
			}
			
	}
}
