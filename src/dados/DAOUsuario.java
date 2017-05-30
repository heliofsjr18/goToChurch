package dados;

import javax.persistence.EntityManager;

import basica.Usuario;

public class DAOUsuario extends DAOGenerico<Usuario> implements IDAOUsuario {

	public DAOUsuario(EntityManager entityManager) {
		super(entityManager);
	}

}
