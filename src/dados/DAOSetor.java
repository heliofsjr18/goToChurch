package dados;

import javax.persistence.EntityManager;

import basica.Setor;

public class DAOSetor extends DAOGenerico<Setor> implements IDAOSetor {

	public DAOSetor(EntityManager entityManager) {
		super(entityManager);
	}
}