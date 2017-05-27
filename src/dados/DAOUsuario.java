package dados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import basica.Usuario;

public class DAOUsuario extends DAOGenerico<Usuario> implements IDAOUsuario {

	public DAOUsuario(EntityManager entityManager) {
		super(entityManager);
	}

}
