package dados;

import javax.persistence.EntityManagerFactory;

import basica.Area;

public class DAOArea extends DAOGenerico<Area>{

	public DAOArea(EntityManagerFactory emf) {
		super(emf);
	}

}
