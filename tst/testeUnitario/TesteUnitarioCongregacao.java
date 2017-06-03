package testeUnitario;

import org.junit.Test;

import basica.Congregacao;
import util.NegocioException;

public class TesteUnitarioCongregacao {

	Congregacao congregacao = new Congregacao();
	
	
	@Test
	public void testeValidaNome() throws NegocioException{
		congregacao.setNome("");
		congregacao.setNome("aa");		
	}
	
	@Test
	public void testeValidaQtdAssentos() throws NegocioException{
		congregacao.setQtdAssentos(0);
		congregacao.setQtdAssentos(1);
		congregacao.setQtdAssentos(2);
		congregacao.setQtdAssentos(3);
		congregacao.setQtdAssentos(4);
		congregacao.setQtdAssentos(5);
		congregacao.setQtdAssentos(6);
		congregacao.setQtdAssentos(7);
		congregacao.setQtdAssentos(8);
	}
	
	@Test
	public void testeValidaCoordenador() throws NegocioException{
		congregacao.setCoordenador("");
		congregacao.setNome("cc");		
	}
	
	
}