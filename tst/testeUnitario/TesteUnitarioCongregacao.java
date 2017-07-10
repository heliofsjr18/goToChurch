package testeUnitario;

import org.junit.Test;

import basica.Congregacao;
import negocio.RNCongregacao;
import util.NegocioException;

public class TesteUnitarioCongregacao {

	Congregacao congregacao = new Congregacao();
	
	
	@Test(expected=NegocioException.class)
	public void testeValidaNome() throws NegocioException{
		congregacao.setNome("");
		congregacao.setNome("aa");
		
		RNCongregacao rnCongregacao = new RNCongregacao();
		rnCongregacao.verificaPreenchimento(congregacao);
	}
	
	@Test(expected=NegocioException.class)
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
		
		RNCongregacao rnCongregacao = new RNCongregacao();
		rnCongregacao.verificaPreenchimento(congregacao);
	}
	
	@Test(expected=NegocioException.class)
	public void testeValidaCoordenador() throws NegocioException{
		congregacao.setCoordenador("");
		congregacao.setNome("cc");
		
		RNCongregacao rnCongregacao = new RNCongregacao();
		rnCongregacao.verificaPreenchimento(congregacao);
	}
	
	
}