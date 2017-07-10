package testeUnitario;

import org.junit.Test;

import basica.Setor;
import negocio.RNSetor;
import util.NegocioException;

public class TesteUnitarioSetor {

	@Test
	public void testeObjetoVazio() throws NegocioException {

		Setor setor = new Setor();
		RNSetor rnSetor = new RNSetor();
		rnSetor.verificaPreenchimento(setor);
	}

	@Test
	public void testeNumeroVazio() throws NegocioException {

		Setor setor = new Setor();
		RNSetor rnSetor = new RNSetor();
		rnSetor.verificaPreenchimento(setor);
	}

	@Test
	public void testeNumeroValido() throws NegocioException {

		Setor setor = new Setor();
		setor.setNumeroIdentificador("0");
		RNSetor rnSetor = new RNSetor();
		rnSetor.verificaPreenchimento(setor);
	}

	@Test
	public void testeNumeroValidoTamanho() throws NegocioException {

		Setor setor = new Setor();
		setor.setNumeroIdentificador("00");
		RNSetor rnSetor = new RNSetor();
		rnSetor.verificaPreenchimento(setor);
	}

	@Test
	public void testeNumeroValidoDiferente() throws NegocioException {

		Setor setor = new Setor();
		setor.setNumeroIdentificador("22");
		RNSetor rnSetor = new RNSetor();
		rnSetor.verificaPreenchimento(setor);
	}

}
