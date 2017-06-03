package testeIntegracao;

import org.junit.Test;

import basica.Setor;
import dados.DAOFactory;
import dados.DAOSetor;
import util.DadosException;

public class TesteIntegracaoSetor {

	DAOFactory daoFactory = new DAOFactory();
	
	@Test(expected=DadosException.class)
	public void testeInserirSetor() throws DadosException{
		
		Setor setor = new Setor();
		setor.setNumeroIdentificador("111");
		
		DAOSetor daoSetor = daoFactory.getDAOSetor(); 
		daoSetor.insert(setor);
		
	}
	
	@Test(expected=DadosException.class)
	public void testeRemoverSetor() throws DadosException{
		
		Setor setor = new Setor();
		setor.setNumeroIdentificador("111");
		
		DAOSetor daoSetor = daoFactory.getDAOSetor(); 
		daoSetor.remove(setor);
		
	}
	
	@Test(expected=DadosException.class)
	public void testeAtualizarSetor() throws DadosException{
		
		Setor setor = new Setor();
		setor.setNumeroIdentificador("111");
		
		DAOSetor daoSetor = daoFactory.getDAOSetor(); 
		daoSetor.update(setor);
		
	}
	
	@Test(expected=DadosException.class)
	public void testeListarSetor() throws DadosException{		
		
		DAOSetor daoSetor = daoFactory.getDAOSetor(); 
		daoSetor.getAll();
		
	}
}