package testeUnitario;

import org.junit.Test;

import basica.Endereco;
import negocio.RNEndereco;
import util.NegocioException;

public class TesteUnitarioEndereco {

	
	@Test(expected=NegocioException.class)
	public void testeBairroNulo() throws NegocioException{
		
		Endereco endereco = new Endereco();		
		
		RNEndereco rnEndereco = new RNEndereco();
		rnEndereco.verificaPreenchimento(endereco);
	}
	
	@Test(expected=NegocioException.class)
	public void testeBairroValido() throws NegocioException{
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Boa Viagem");
		
		RNEndereco rnEndereco = new RNEndereco();		
		
		rnEndereco.verificaPreenchimento(endereco);
	}
	
	@Test(expected=NegocioException.class)
	public void testeCidadeNulo() throws NegocioException{
		
		Endereco endereco = new Endereco();		
		
		RNEndereco rnEndereco = new RNEndereco();
		rnEndereco.verificaPreenchimento(endereco);
	}
	
	@Test(expected=NegocioException.class)
	public void testeCidadeValida() throws NegocioException{
		
		Endereco endereco = new Endereco();		
		endereco.setCidade("");
		
		RNEndereco rnEndereco = new RNEndereco();
		rnEndereco.verificaPreenchimento(endereco);
	}
	
	@Test(expected=NegocioException.class)
	public void testeLogradouroNulo() throws NegocioException{
		
		Endereco endereco = new Endereco();		
		
		
		RNEndereco rnEndereco = new RNEndereco();
		rnEndereco.verificaPreenchimento(endereco);
	}
	
	@Test(expected=NegocioException.class)
	public void testelogradouroValido() throws NegocioException{
		
		Endereco endereco = new Endereco();		
		endereco.setLogradouro("");
		
		RNEndereco rnEndereco = new RNEndereco();
		rnEndereco.verificaPreenchimento(endereco);
	}
	
	@Test(expected=NegocioException.class)
	public void testeNumeroNulo() throws NegocioException{
		
		Endereco endereco = new Endereco();		
		
		RNEndereco rnEndereco = new RNEndereco();
		rnEndereco.verificaPreenchimento(endereco);
	}
	
	@Test(expected=NegocioException.class)
	public void testeNumeroValido() throws NegocioException{
		
		Endereco endereco = new Endereco();		
		endereco.setNumero("");
		
		RNEndereco rnEndereco = new RNEndereco();
		rnEndereco.verificaPreenchimento(endereco);
	}
	
	@Test(expected=NegocioException.class)
	public void testeObjetoPreenchido() throws NegocioException{
		
		Endereco endereco = new Endereco();		
		endereco.setNumero("Teste numero");
		endereco.setBairro("Teste Bairro");
		endereco.setCidade("Teste Cidade");
		endereco.setComplemento("Teste Complemento");
		endereco.setLogradouro("Teste Logradouro");
		
		
		RNEndereco rnEndereco = new RNEndereco();
		rnEndereco.verificaPreenchimento(endereco);
	}
	
	
}
