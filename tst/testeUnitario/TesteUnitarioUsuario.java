package testeUnitario;

import org.junit.Test;

import basica.Usuario;
import negocio.RNUsuario;
import util.NegocioException;

public class TesteUnitarioUsuario {

	
	@Test(expected=NegocioException.class)
	public void testeNomeNulo() throws NegocioException{
		
		Usuario usuario = new Usuario();
		
		RNUsuario rnUsuario = new RNUsuario();
		rnUsuario.verificaPreenchimento(usuario);
		
	}
	
	@Test(expected=NegocioException.class)
	public void testeNomeValido() throws NegocioException{
		
		Usuario usuario = new Usuario();
		usuario.setNome("");
		
		RNUsuario rnUsuario = new RNUsuario();
		rnUsuario.verificaPreenchimento(usuario);
		
	}
	
	@Test(expected=NegocioException.class)
	public void testeEmailNulo() throws NegocioException{
		
		Usuario usuario = new Usuario();		
		
		RNUsuario rnUsuario = new RNUsuario();
		rnUsuario.verificaPreenchimento(usuario);
		
	}
	
	@Test(expected=NegocioException.class)
	public void testeEmailValido() throws NegocioException{
		
		Usuario usuario = new Usuario();
		usuario.setEmail("");
		
		RNUsuario rnUsuario = new RNUsuario();
		rnUsuario.verificaPreenchimento(usuario);
		
	}
	
	@Test(expected=NegocioException.class)
	public void testeCpfNulo() throws NegocioException{
		
		Usuario usuario = new Usuario();
		
		RNUsuario rnUsuario = new RNUsuario();
		rnUsuario.verificaPreenchimento(usuario);
		
	}
	
	@Test(expected=NegocioException.class)
	public void testeCpfValido() throws NegocioException{
		
		Usuario usuario = new Usuario();
		usuario.setCpf("");
		
		RNUsuario rnUsuario = new RNUsuario();
		rnUsuario.verificaPreenchimento(usuario);
		
	}
	
	@Test(expected=NegocioException.class)
	public void testeCpfValidoDiferente() throws NegocioException{
		
		Usuario usuario = new Usuario();
		usuario.setCpf("00000000000");
		
		RNUsuario rnUsuario = new RNUsuario();
		rnUsuario.verificaPreenchimento(usuario);
		
	}
	
	
	@Test(expected=NegocioException.class)
	public void testeNumeroInvalido() throws NegocioException{
		
		Usuario usuario = new Usuario();
		usuario.setTelefone("00000000");
		
		RNUsuario rnUsuario = new RNUsuario();
		rnUsuario.verificaPreenchimento(usuario);
		
	}
	
	@Test(expected=NegocioException.class)
	public void testeSexoInvalido() throws NegocioException{
		
		Usuario usuario = new Usuario();
		usuario.setSexo('t');
		
		RNUsuario rnUsuario = new RNUsuario();
		rnUsuario.verificaPreenchimento(usuario);
		
	}
	
	@Test(expected=NegocioException.class)
	public void testeObjetoPreenchido() throws NegocioException{
		
		Usuario usuario = new Usuario();
		usuario.setCpf("Teste CPF");
		usuario.setEmail("Teste Email");
		usuario.setNome("Teste Nome");
		usuario.setSexo('f');
		usuario.setTelefone("0000000");
		
		RNUsuario rnUsuario = new RNUsuario();
		rnUsuario.verificaPreenchimento(usuario);
		
	}
}
