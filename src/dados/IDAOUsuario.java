package dados;

import java.util.List;

import basica.Usuario;
import util.DadosException;

public interface IDAOUsuario {

	public Usuario pesquisarLoginUsuario(Usuario u) throws DadosException;
	public List<Usuario> pesquisarUsuarioObreiro() throws DadosException;
	
}
