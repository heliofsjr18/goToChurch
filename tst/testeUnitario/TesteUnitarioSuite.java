package testeUnitario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
	
	TesteUnitarioArea.class,
	TesteUnitarioCongregacao.class,
	TesteUnitarioEndereco.class,
	TesteUnitarioSetor.class,
	TesteUnitarioUsuario.class
	
})


public class TesteUnitarioSuite {

}
