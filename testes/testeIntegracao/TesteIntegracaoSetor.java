package testeIntegracao;

import org.junit.Test;

import basica.Setor;
import basica.Usuario;
import dados.DAOFactory;
import fachada.Fachada;
import util.DadosException;
import util.NegocioException;

public class TesteIntegracaoSetor {

	DAOFactory daoFactory = new DAOFactory();
	
	Fachada fachada = new Fachada();
	
	@Test(expected=DadosException.class)
	public void testeInserirSetor() throws DadosException, NegocioException{
		
		Usuario u = new Usuario();
		Setor setor = new Setor();
		setor.setNumeroIdentificador("111");
		setor.setUsuario(u);
		
		daoFactory.getDAOSetor(); 
		fachada.setorInserir(setor);
		
	}
	
	@Test(expected=DadosException.class)
	public void testeRemoverSetor() throws DadosException, NegocioException{
		
		Setor setor = new Setor();
		setor.setNumeroIdentificador("111");
		
		daoFactory.getDAOSetor(); 
		fachada.setorExcluir(setor);
		
	}
	
	@Test(expected=DadosException.class)
	public void testeAtualizarSetor() throws DadosException, NegocioException{
		
		Setor setor = new Setor();
		setor.setNumeroIdentificador("111 atualizar");
		
		daoFactory.getDAOSetor(); 
		fachada.setorAlterar(setor);
		
	}
	
	@Test(expected=DadosException.class)
	public void testeListarSetor() throws DadosException, NegocioException{		
		
		daoFactory.getDAOSetor(); 
		fachada.setorListar();
		
	}
}