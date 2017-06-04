package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basica.Endereco;
import basica.Usuario;
import fachada.Fachada;

@WebServlet("/Usuario")
public class UsuarioServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		PrintWriter out = response.getWriter();
		
			
		
			String nome = request.getParameter("nome") +" "+ request.getParameter("sobrenome");
			//Date dataNascimento = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String email = request.getParameter("email");
			String telefone = request.getParameter("telefone");
			Character sexo = request.getParameter("sexo").charAt(0);
			String login = request.getParameter("email");
			String senha = request.getParameter("senha");
			
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
			
			
			Usuario u = new Usuario();
			u.setNome(nome);
			u.setCpf(cpf);
			u.setEmail(email);
			u.setTelefone(telefone);
			u.setSexo(sexo);
			u.setEmail(email);
			u.setLogin(login);
			u.setSenha(senha);
			u.setEndereco(e);
			System.out.println("Usuario criado");
			System.out.println(u.getNome());
			Fachada f = new Fachada();

			
			try {
				f.usuarioInserir(u);
			} catch (Exception e2) {
				
				out.println("<script>alert('e2 = '+"+e2.getMessage()+");window.location = 'index.jsp';</script>");
				System.out.println(e2.getMessage());
			}
		
		
	}

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}*/

}
