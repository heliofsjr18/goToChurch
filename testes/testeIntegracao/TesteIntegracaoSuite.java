package testeIntegracao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	
	TesteIntegracaoArea.class,
	TesteIntegracaoCongregacao.class,
	TesteIntegracaoEndereco.class,
	TesteIntegracaoSetor.class,
	TesteIntegracaoUsuario.class
	
})

public class TesteIntegracaoSuite {
	
}
