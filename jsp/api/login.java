package api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import basica.Endereco;
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
		Endereco endereco = new Endereco();
		endereco.setBairro("Ipsep");
		endereco.setCidade("Teste cidade");
		endereco.setComplemento("Teste complemento");
		endereco.setLogradouro("Teste logradouro");
		endereco.setNumero("549");
		
		daoFactory.getDAOEndereco();
		
		try {
			
			//fa.enderecoInserir(endereco);
			Endereco en = fa.enderecoGet(25);
			response.getWriter().append("Served at: " + en.getBairro());
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().append("Served at: " + e).append(request.getContextPath());
		}
		//doGet(request, response);
	}

}
