package testeUnitario;


import org.junit.Test;

import basica.Area;
import junit.framework.TestCase;
import negocio.RNArea;
import util.NegocioException;

public class TesteUnitarioArea extends TestCase {

	@Test
	public void testeObjetoVazio() throws NegocioException{

			Area area = new Area();
			RNArea rnArea = new RNArea();
			rnArea.verificaPreenchimento(area);
	}
	
	@Test
	public void testeNumeroVazio() throws NegocioException{

			Area area = new Area();
			RNArea rnArea = new RNArea();
			rnArea.verificaPreenchimento(area);
	}
	
	
	@Test
	public void testeNumeroValido() throws NegocioException{

			Area area = new Area();
			area.setNumeroIdentificador("0");
			RNArea rnArea = new RNArea();			
			rnArea.verificaPreenchimento(area);
	}
	
	@Test
	public void testeNumeroValidoTamanho() throws NegocioException{

			Area area = new Area();
			area.setNumeroIdentificador("00");
			RNArea rnArea = new RNArea();			
			rnArea.verificaPreenchimento(area);
	}
	
	@Test
	public void testeNumeroValidoDiferente() throws NegocioException{

			Area area = new Area();
			area.setNumeroIdentificador("22");
			RNArea rnArea = new RNArea();			
			rnArea.verificaPreenchimento(area);
	}

}
