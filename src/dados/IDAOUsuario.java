package dados;

import basica.Usuario;
import util.DadosException;

public interface IDAOUsuario {

	public Usuario LoginUsuario(Usuario u) throws DadosException;
	
}
