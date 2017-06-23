package teste;

import java.util.List;

import basica.Congregacao;
import basica.Usuario;
import fachada.Fachada;
import util.DadosException;
import util.NegocioException;

public class TestePersistenceDB {
	
	
	
	
	public static void main(String[] args){
		
		
		/*Usuario u = new Usuario();
		u.setNome("Dayvson1");
		u.setCpf("123.123.123-00");
		u.setEmail("nomail@nomail.com");
		u.setSexo('M');
		u.setEmail("nomail@nimail.com");
		u.setSenha("gafsdhagfsdh");
		u.setTelefone("8199999999");
		
		
		Fachada f = new Fachada();*/
		try {
			
			Fachada f = new Fachada();
			List<Congregacao> lc = f.congregacaoListarPorCidade("escada");
			for(int x=0; x<lc.size();x++){
				System.out.println(lc.get(x).getNome());
			}
			
		} catch (NegocioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
