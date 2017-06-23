package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basica.Congregacao;
import basica.Endereco;
import basica.Usuario;
import fachada.Fachada;

@WebServlet("/EditaCongregacao")
public class EditaCongregacaoServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		HttpSession ses = request.getSession(true);
		PrintWriter out = response.getWriter();
		String nome = request.getParameter("nome");
		String coordenador = request.getParameter("coordenador");
		String quantidade = request.getParameter("qtdAcento");
		String cli = request.getParameter("climatizada");
		
		boolean climatizada = false;
		try{
			if(cli == null){
				climatizada = false;
			}else if(cli.equals("on")){
				climatizada = true;
			}else{
				climatizada = false;
			}
		}catch (NullPointerException e) {
			
		}
		
		//Endereço
		
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String complemento = request.getParameter("complemento");
		
		Congregacao c = (Congregacao) ses.getAttribute("obj");
		
		Endereco e = c.getEndereco();
		e.setLogradouro(logradouro);
		e.setNumero(numero);
		e.setBairro(bairro);
		e.setCidade(cidade);
		e.setComplemento(complemento);
		
		Usuario u = new Usuario();
		u.setId(3);
		
		
		c.setNome(nome);
		c.setCoordenador(coordenador);
		c.setClimatizada(climatizada);
		c.setQtdAssentos(Integer.parseInt(quantidade));
		c.setEndereco(e);
		c.setUsuario(u);
		
		Fachada f = new Fachada();
		try {
			f.congregacaoAlterar(c);
			out.println("<script>alert('Alterado!');</script>");
			response.sendRedirect("ListarCongregacao");
		} catch (Exception e2) {
			out.println("<script>alert('" + e2.getMessage() + "'); history.go(-1);</script>");
		}
		
	}
	
}
