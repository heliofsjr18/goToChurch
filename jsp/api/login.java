package api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basica.Endereco;
import basica.TipoUsuario;
import basica.Usuario;
import dados.DAOFactory;
import fachada.Fachada;

/**
 * Servlet implementation class login
 */
@WebServlet("/api/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOFactory daoFactory = new DAOFactory();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Fachada fa = new Fachada();
		Endereco e = new Endereco();
		TipoUsuario t = new TipoUsuario();
		t.setTipo("test");
		Usuario usuario = new Usuario();
		usuario.setCpf("Teste cpf");
		usuario.setEmail("Teste Email");
		usuario.setNome("Teste nome");
		usuario.setSexo('t');
		usuario.setTelefone("Teste telefone");	
		
		usuario.setTipoUsuario(t);
		usuario.setLogin("marcelo");
		usuario.setSenha("123");
		
		daoFactory.getDAOUsuario();
		
		
		try {
			
			//fa.enderecoInserir(endereco);
			e = fa.enderecoGet(25);
			usuario.setEndereco(e);
			fa.usuarioInserir(usuario);
			response.getWriter().append("Served at: Inserido com Sucesso!");
		} catch (Exception ex) {
			// TODO: handle exception
			response.getWriter().append("Served at: " + ex).append(request.getContextPath());
		}
		//doGet(request, response);
	}

}
