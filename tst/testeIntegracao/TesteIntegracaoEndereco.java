package testeIntegracao;

import org.junit.Test;

import basica.Endereco;
import dados.DAOEndereco;
import dados.DAOFactory;
import util.DadosException;

public class TesteIntegracaoEndereco {

	DAOFactory daoFactory = new DAOFactory();
	
	@Test(expected=DadosException.class)
	public void testarInserirEndereco() throws DadosException{
		
		Endereco endereco = new Endereco();
		endereco.setBairro("teste Bairro");
		endereco.setCidade("Teste cidade");
		endereco.setComplemento("Teste complemento");
		endereco.setLogradouro("Teste logradouro");
		endereco.setNumero("Teste Numero");
		
		DAOEndereco daoEndereco = daoFactory.getDAOEndereco();
		daoEndereco.insert(endereco);
		
	}
	
	
	@Test(expected=DadosException.class)
	public void testarRemoverEndereco() throws DadosException{
		
		Endereco endereco = new Endereco();
		endereco.setBairro("teste Bairro");
		endereco.setCidade("Teste cidade");
		endereco.setComplemento("Teste complemento");
		endereco.setLogradouro("Teste logradouro");
		endereco.setNumero("Teste Numero");
		
		DAOEndereco daoEndereco = daoFactory.getDAOEndereco();
		daoEndereco.remove(endereco);
		
	}
	
	
	@Test(expected=DadosException.class)
	public void testarAtualizarEndereco() throws DadosException{
		
		Endereco endereco = new Endereco();
		endereco.setBairro("teste Bairro");
		endereco.setCidade("Teste cidade");
		endereco.setComplemento("Teste complemento");
		endereco.setLogradouro("Teste logradouro");
		endereco.setNumero("Teste Numero");
		
		DAOEndereco daoEndereco = daoFactory.getDAOEndereco();
		daoEndereco.update(endereco);
		
	}
	
	
	@Test(expected=DadosException.class)
	public void testarListarEndereco() throws DadosException{			
		
		DAOEndereco daoEndereco = daoFactory.getDAOEndereco();
		daoEndereco.getAll();
		
	}
	
	
}