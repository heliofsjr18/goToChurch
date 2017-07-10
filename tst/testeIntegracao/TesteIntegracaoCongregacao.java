package testeIntegracao;

import org.junit.Test;

import basica.Congregacao;
import basica.Endereco;
import basica.Usuario;
import dados.DAOFactory;
import fachada.Fachada;
import util.DadosException;
import util.NegocioException;

public class TesteIntegracaoCongregacao {

	DAOFactory daoFactory = new DAOFactory();
	
	Fachada fachada = new Fachada();
	
	@Test(expected=DadosException.class)
	public void testarInserirCongregacao() throws DadosException, NegocioException{
		
		Endereco e = new Endereco();
		Usuario u = new Usuario();
		Congregacao congregacao = new Congregacao();
		congregacao.setClimatizada(false);
		congregacao.setCoordenador("Teste coordenador");
		congregacao.setNome("Teste Nome");
		congregacao.setQtdAssentos(5);
		congregacao.setEndereco(e);
		congregacao.setUsuario(u);
		
		daoFactory.getDAOCongregacao();
		fachada.congregacaoInserir(congregacao);
	}
	
	@Test(expected=DadosException.class)
	public void testarRemoverCongregacao() throws DadosException, NegocioException{
		
		Congregacao congregacao = new Congregacao();
		congregacao.setClimatizada(false);
		congregacao.setCoordenador("Teste coordenador");
		congregacao.setNome("Teste Nome");
		congregacao.setQtdAssentos(5);		
		
		daoFactory.getDAOCongregacao();
		fachada.congregacaoExcluir(congregacao);
	}
	
	@Test(expected=DadosException.class)
	public void testarAtualizarCongregacao() throws DadosException, NegocioException{
		
		Congregacao congregacao = new Congregacao();
		congregacao.setClimatizada(false);
		congregacao.setCoordenador("Teste coordenador Atualizar");
		congregacao.setNome("Teste Nome");
		congregacao.setQtdAssentos(5);		
		
		daoFactory.getDAOCongregacao();
		fachada.congregacaoAlterar(congregacao);
	}
	
	@Test(expected=DadosException.class)
	public void testarListarCongregacao() throws DadosException, NegocioException{			
		
		daoFactory.getDAOCongregacao();
		fachada.congregacaoListar();
	}	
	
}
