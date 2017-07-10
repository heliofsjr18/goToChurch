package testeSistema;

import testeIntegracao.TesteIntegracaoSuite;
import testeUnitario.TesteUnitarioSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	
	TesteUnitarioSuite.class,
	TesteIntegracaoSuite.class,
	
})




public class TesteMain {

}
