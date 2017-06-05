package dados;

import basica.Usuario;
import util.DadosException;

public interface IDAOUsuario {

	public Usuario pesquisarLoginUsuario(Usuario u) throws DadosException;
	
}
