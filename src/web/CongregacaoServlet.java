package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basica.Congregacao;
import basica.Endereco;
import fachada.Fachada;

@WebServlet("/Congregacao")
public class CongregacaoServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		
		String nome = request.getParameter("nome");
		String coordenador = request.getParameter("coordenador");
		String quantidade = request.getParameter("qtdAcento");
		String cli = request.getParameter("climatizada");
		boolean climatizada;
		
		if(cli.equals("on")){
			climatizada = true;
		}else{
			climatizada = false;
		}
		
		//Endereço
		
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String complemento = request.getParameter("complemento");
		
		Endereco e = new Endereco();
		e.setLogradouro(logradouro);
		e.setNumero(numero);
		e.setBairro(bairro);
		e.setCidade(cidade);
		e.setComplemento(complemento);
		
		Congregacao c = new Congregacao();
		c.setNome(nome);
		c.setCoordenador(coordenador);
		c.setClimatizada(climatizada);
		c.setQtdAssentos(Integer.parseInt(quantidade));
		c.setEndereco(e);
		
		Fachada f = new Fachada();
		try {
			f.congregacaoInserir(c);
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		
	}
}
