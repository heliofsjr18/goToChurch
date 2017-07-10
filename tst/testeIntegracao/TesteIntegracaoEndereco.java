package testeIntegracao;

import org.junit.Test;

import basica.Endereco;
import dados.DAOFactory;
import fachada.Fachada;
import util.DadosException;
import util.NegocioException;

public class TesteIntegracaoEndereco {

	DAOFactory daoFactory = new DAOFactory();
	
	Fachada fachada = new Fachada();
	
	
	@Test(expected=DadosException.class)
	public void testarInserirEndereco() throws DadosException, NegocioException{
		
		Endereco endereco = new Endereco();
		endereco.setBairro("teste Bairro");
		endereco.setCidade("Teste cidade");
		endereco.setComplemento("Teste complemento");
		endereco.setLogradouro("Teste logradouro");
		endereco.setNumero("Teste Numero");		
		
		daoFactory.getDAOEndereco();
		fachada.enderecoInserir(endereco);
		
	}
	
	
	@Test(expected=DadosException.class)
	public void testarRemoverEndereco() throws DadosException, NegocioException{
		
		Endereco endereco = new Endereco();
		endereco.setBairro("teste Bairro");
		endereco.setCidade("Teste cidade");
		endereco.setComplemento("Teste complemento");
		endereco.setLogradouro("Teste logradouro");
		endereco.setNumero("Teste Numero");
		
		daoFactory.getDAOEndereco();
		fachada.enderecoExcluir(endereco);
		
	}
	
	
	@Test(expected=DadosException.class)
	public void testarAtualizarEndereco() throws DadosException, NegocioException{
		
		Endereco endereco = new Endereco();
		endereco.setBairro("teste Bairro");
		endereco.setCidade("Teste cidade");
		endereco.setComplemento("Teste complemento Atualizar");
		endereco.setLogradouro("Teste logradouro");
		endereco.setNumero("Teste Numero");
		
		daoFactory.getDAOEndereco();
		fachada.enderecoAlterar(endereco);
		
	}
	
	
	@Test(expected=DadosException.class)
	public void testarListarEndereco() throws DadosException, NegocioException{			
		
		daoFactory.getDAOEndereco();
		fachada.enderecoListar();
		
	}	
}