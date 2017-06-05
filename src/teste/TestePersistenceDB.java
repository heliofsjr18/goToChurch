package teste;

import basica.Usuario;
import fachada.Fachada;
import util.DadosException;
import util.NegocioException;

public class TestePersistenceDB {
	
	
	
	
	public static void main(String[] args){
		
		
		Usuario u = new Usuario();
		u.setNome("Dayvson1");
		u.setCpf("123.123.123-00");
		u.setEmail("nomail@nomail.com");
		u.setSexo('M');
		u.setEmail("nomail@nimail.com");
		u.setSenha("gafsdhagfsdh");
		u.setTelefone("8199999999");
		
		
		Fachada f = new Fachada();
		try {
			f.usuarioInserir(u);
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
