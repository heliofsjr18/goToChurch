package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basica.Endereco;
import basica.Setor;
import basica.TipoUsuario;
import basica.Usuario;
import fachada.Fachada;

@WebServlet("/EditaUsuario")
public class EditaUsuarioServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NullPointerException {
		HttpSession ses = request.getSession(true);
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		// Date dataNascimento = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		Character sexo = request.getParameter("sexo").charAt(0);
		String login = request.getParameter("email");
		String senha = request.getParameter("senha");

		// Endereço
		String logradouro = request.getParameter("logradouro");
		String numero = request.getParameter("numero");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String complemento = request.getParameter("complemento");
		int tipo = Integer.parseInt(request.getParameter("tipo"));

		Usuario u = (Usuario) ses.getAttribute("obj");
		System.out.println(u.getEndereco().getBairro());
		Endereco e = u.getEndereco();

		e.setLogradouro(logradouro);
		e.setNumero(numero);
		e.setBairro(bairro);
		e.setCidade(cidade);
		e.setComplemento(complemento);

		TipoUsuario tu = u.getTipoUsuario();
		tu.setId(tipo);

		
		u.setNome(nome);
		u.setCpf(cpf);
		u.setEmail(email);
		u.setTelefone(telefone);
		u.setSexo(sexo);
		u.setEmail(email);
		u.setLogin(login);
		u.setSenha(senha);
		u.setEndereco(e);
		u.setTipoUsuario(tu);
		u.setDataNascimento(null);

		System.out.println("Usuario criado");
		System.out.println(u.getNome());
		Fachada f = new Fachada();

		try {
			f.usuarioAlterar(u);
			out.println("<script>alert('Cadastrado!');</script>");
			response.sendRedirect("ListarUsuario");
		} catch (Exception e2) {

			out.println("<script>alert('" + e2.getMessage() + "'); history.go(-1);</script>");
			System.out.println(e2.getMessage());
		}
			
	}
}