package testeIntegracao;

import org.junit.Test;

import basica.Usuario;
import dados.DAOFactory;
import dados.DAOUsuario;
import util.DadosException;

public class TesteIntegracaoUsuario {

	DAOFactory daoFactory = new DAOFactory();
	
	@Test(expected=DadosException.class)
	public void testeInserirUsuario() throws DadosException{
		
		Usuario usuario = new Usuario();
		usuario.setCpf("Teste cpf");
		usuario.setEmail("Teste Email");
		usuario.setNome("Teste nome");
		usuario.setSexo('t');
		usuario.setTelefone("Teste telefone");		
		
		DAOUsuario daoUsuario = daoFactory.getDAOUsuario();
		daoUsuario.insert(usuario);
	}
	
	
	@Test(expected=DadosException.class)
	public void testeRemoverUsuario() throws DadosException{
		
		Usuario usuario = new Usuario();
		usuario.setCpf("Teste cpf");
		usuario.setEmail("Teste Email");
		usuario.setNome("Teste nome");
		usuario.setSexo('t');
		usuario.setTelefone("Teste telefone");		
		
		DAOUsuario daoUsuario = daoFactory.getDAOUsuario();
		daoUsuario.remove(usuario);
	}
	
	
	@Test(expected=DadosException.class)
	public void testeAtualizarUsuario() throws DadosException{
		
		Usuario usuario = new Usuario();
		usuario.setCpf("Teste cpf");
		usuario.setEmail("Teste Email");
		usuario.setNome("Teste nome");
		usuario.setSexo('t');
		usuario.setTelefone("Teste telefone");		
		
		DAOUsuario daoUsuario = daoFactory.getDAOUsuario();
		daoUsuario.update(usuario);
	}
	
	
	@Test(expected=DadosException.class)
	public void testeListarUsuario() throws DadosException{		
		
		DAOUsuario daoUsuario = daoFactory.getDAOUsuario();
		daoUsuario.getAll();
	}
	
}
