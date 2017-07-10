package testeIntegracao;

import org.junit.Test;

import basica.Endereco;
import basica.TipoUsuario;
import basica.Usuario;
import dados.DAOFactory;
import fachada.Fachada;
import util.DadosException;
import util.NegocioException;

public class TesteIntegracaoUsuario {

	DAOFactory daoFactory = new DAOFactory();
	
	Fachada fachada = new Fachada();
	
	@Test(expected=DadosException.class)
	public void testeInserirUsuario() throws DadosException, NegocioException{
		
		
		Endereco e = new Endereco();
		TipoUsuario t = new TipoUsuario();
		Usuario usuario = new Usuario();
		usuario.setCpf("Teste cpf");
		usuario.setEmail("Teste Email");
		usuario.setNome("Teste nome");
		usuario.setSexo('t');
		usuario.setTelefone("Teste telefone");	
		usuario.setEndereco(e);
		usuario.setTipoUsuario(t);		
		
		daoFactory.getDAOUsuario();
		fachada.usuarioInserir(usuario);
	}
	
	
	@Test(expected=DadosException.class)
	public void testeRemoverUsuario() throws DadosException, NegocioException{
		
		Usuario usuario = new Usuario();
		usuario.setCpf("Teste cpf");
		usuario.setEmail("Teste Email");
		usuario.setNome("Teste nome");
		usuario.setSexo('t');
		usuario.setTelefone("Teste telefone");		
		
		daoFactory.getDAOUsuario();
		fachada.usuarioExcluir(usuario);
	}
	
	
	@Test(expected=DadosException.class)
	public void testeAtualizarUsuario() throws DadosException, NegocioException{
		
		Usuario usuario = new Usuario();
		usuario.setId(78+14);
		usuario.setCpf("Teste cpf Atualizar");
		usuario.setEmail("Teste Email");
		usuario.setNome("Teste nome");
		usuario.setSexo('t');
		usuario.setTelefone("Teste telefone");		
		
		daoFactory.getDAOUsuario();
		fachada.usuarioExcluir(usuario);
	}
	
	
	@Test(expected=DadosException.class)
	public void testeListarUsuario() throws DadosException, NegocioException{		
		
		daoFactory.getDAOUsuario();
		fachada.usuarioListar();
	}
	
}
