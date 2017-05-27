package dados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import basica.TipoUsuario;

public class DAOTipoUsuario extends DAOGenerico<TipoUsuario> implements IDAOTipoUsuario {

	public DAOTipoUsuario(EntityManager entityManager) {
		super(entityManager);
	}

}
