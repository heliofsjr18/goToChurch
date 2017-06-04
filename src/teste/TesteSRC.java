package teste;

import basica.Usuario;
import fachada.Fachada;

public class TesteSRC {

	public static void main (String[]args) throws Exception{
		
		Usuario u = new Usuario();
		u.setId(48);
		u.setCpf("Teste Cpf12345");
		u.setEmail("Teste email");
		u.setLogin("Teste Login");
		u.setNome("Teste nome");
		u.setSenha("Teste Senha");
		u.setSexo('m');
		u.setTelefone("Teste telefone");
		
		
		Fachada fachada = new Fachada();
		fachada.usuarioAlterar(u);
	}
	
	
}