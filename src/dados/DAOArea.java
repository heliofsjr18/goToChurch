package dados;

import javax.persistence.EntityManager;

import basica.Area;

public class DAOArea extends DAOGenerico<Area> implements IDAOArea {

	public DAOArea(EntityManager entityManager) {
		super(entityManager);
	}

	
}
