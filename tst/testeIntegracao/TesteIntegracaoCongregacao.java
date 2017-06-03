package testeIntegracao;

import org.junit.Test;

import basica.Area;
import basica.Congregacao;
import dados.DAOArea;
import dados.DAOCongregacao;
import dados.DAOFactory;
import util.DadosException;

public class TesteIntegracaoCongregacao {

	DAOFactory daoFactory = new DAOFactory();
	
	@Test(expected=DadosException.class)
	public void testarInserirCongregacao() throws DadosException{
		
		Congregacao congregacao = new Congregacao();
		congregacao.setClimatizada(false);
		congregacao.setCoordenador("Teste coordenador");
		congregacao.setNome("Teste Nome");
		congregacao.setQtdAssentos(5);		
		
		DAOCongregacao daoCongregacao = daoFactory.getDAOCongregacao();
		daoCongregacao.insert(congregacao);
	}
	
	@Test(expected=DadosException.class)
	public void testarRemoverCongregacao() throws DadosException{
		
		Congregacao congregacao = new Congregacao();
		congregacao.setClimatizada(false);
		congregacao.setCoordenador("Teste coordenador");
		congregacao.setNome("Teste Nome");
		congregacao.setQtdAssentos(5);		
		
		DAOCongregacao daoCongregacao = daoFactory.getDAOCongregacao();
		daoCongregacao.remove(congregacao);
	}
	
	@Test(expected=DadosException.class)
	public void testarAtualizarCongregacao() throws DadosException{
		
		Congregacao congregacao = new Congregacao();
		congregacao.setClimatizada(false);
		congregacao.setCoordenador("Teste coordenador");
		congregacao.setNome("Teste Nome");
		congregacao.setQtdAssentos(5);		
		
		DAOCongregacao daoCongregacao = daoFactory.getDAOCongregacao();
		daoCongregacao.update(congregacao);
	}
	
	@Test(expected=DadosException.class)
	public void testarListarCongregacao() throws DadosException{			
		
		DAOCongregacao daoCongregacao = daoFactory.getDAOCongregacao();
		daoCongregacao.getAll();
	}	
	
}
