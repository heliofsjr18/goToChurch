package dados;

import javax.persistence.EntityManager;

import basica.TipoUsuario;

public class DAOTipoUsuario extends DAOGenerico<TipoUsuario> implements IDAOTipoUsuario {

	public DAOTipoUsuario(EntityManager entityManager) {
		super(entityManager);
	}

}
