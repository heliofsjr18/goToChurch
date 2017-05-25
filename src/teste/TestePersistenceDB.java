package teste;

import java.util.Date;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import basica.Endereco;
import basica.TipoUsuario;
import basica.Usuario;
import dados_old.DAOEndereco;
import dados_old.DAOTipoUsuario;
import dados_old.DAOUsuario;

public class TestePersistenceDB {

	@Test
	public void persistenceTest(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("goToChurchUnit");
		
		//Set Endereco
		Endereco e = new Endereco();
		e.setBairro("TesteBairro");
		e.setCidade("Teste cidade");
		e.setComplemento("Testecomplemento");
		e.setLogradouro("TEste logradouro");
		e.setNumero("Teste numero");
		//End Set Endereco
		
		//Set Date
		Date d = new Date();
		d.setTime(9999);
		//End Set Date
		
		//Set TipoUsuario
		TipoUsuario t = new TipoUsuario();
		t.setTipo("Teste Tipo usuario");
		//End Set TipoUsuario
		
		//Set Usuario
		Usuario u = new Usuario();
		u.setCpf("0000000");
		u.setDataNascimento(d);
		u.setEmail("teste");
		u.setEndereco(e);
		u.setNome("testenome");
		u.setSexo('m');
		u.setTelefone("Teste Telefone");
		u.setTipoUsuario(t);
		//End Set Usuario
		
		//Executing DAOs
		DAOTipoUsuario dT = new DAOTipoUsuario(emf);
		dT.insert(t);
		
		DAOEndereco dE = new DAOEndereco(emf);
		dE.insert(e);
		
		DAOUsuario dU = new DAOUsuario(emf);
		dU.insert(u);
		//End Executing DAOs
		
	}
	
}
