package testeIntegracao;

import org.junit.Test;

import basica.Area;
import basica.Usuario;
import dados.DAOFactory;
import fachada.Fachada;
import util.DadosException;
import util.NegocioException;

public class TesteIntegracaoArea {

	DAOFactory daoFactory = new DAOFactory();
	
	Fachada fachada = new Fachada();
	
	
	@Test(expected=DadosException.class)
	public void testarInserirArea() throws DadosException, NegocioException{
		
		
		Usuario u = new Usuario();
		Area area = new Area();
		area.setNumeroIdentificador("111");
		area.setUsuario(u);
				
		fachada.areaInserir(area);
	}
	
	
	@Test(expected=DadosException.class)
	public void testaRemoverArea() throws DadosException, NegocioException{
		
		Area area = new Area();
		area.setNumeroIdentificador("111");
		
		daoFactory.getDAOArea();
		fachada.areaExcluir(area);
	}
	
	
	@Test(expected=DadosException.class)
	public void testarAtualizarArea() throws DadosException, NegocioException{
		
		Area area = new Area();
		area.setNumeroIdentificador("111 atualizar");
		
		daoFactory.getDAOArea();
		fachada.areaAlterar(area);
	}
	
	
	@Test(expected=DadosException.class)
	public void testarListarArea() throws DadosException, NegocioException{
		
		
		daoFactory.getDAOArea();
		fachada.areaListar();
	}
	
	
}
