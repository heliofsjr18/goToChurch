package testeIntegracao;

import org.junit.Test;

import basica.Area;
import dados.DAOArea;
import dados.DAOFactory;
import util.DadosException;

public class TesteIntegracaoArea {

	DAOFactory daoFactory = new DAOFactory();
	
	
	@Test(expected=DadosException.class)
	public void testarInserirArea() throws DadosException{
		
		Area area = new Area();
		area.setNumeroIdentificador("111");
		
		DAOArea daoArea = daoFactory.getDAOArea();
		daoArea.insert(area);
	}
	
	
	@Test(expected=DadosException.class)
	public void testaRemoverArea() throws DadosException{
		
		Area area = new Area();
		area.setNumeroIdentificador("111");
		
		DAOArea daoArea = daoFactory.getDAOArea();
		daoArea.remove(area);
	}
	
	
	@Test(expected=DadosException.class)
	public void testarAtualizarArea() throws DadosException{
		
		Area area = new Area();
		area.setNumeroIdentificador("111");
		
		DAOArea daoArea = daoFactory.getDAOArea();
		daoArea.update(area);
	}
	
	
	@Test(expected=DadosException.class)
	public void testarListarArea() throws DadosException{
		
		
		DAOArea daoArea = daoFactory.getDAOArea();
		daoArea.getAll();
	}
	
	
}
