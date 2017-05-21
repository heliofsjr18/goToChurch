package dados;

import javax.persistence.EntityManagerFactory;

import basica.Setor;

public class DAOSetor extends DAOGenerico<Setor>{

	public DAOSetor(EntityManagerFactory emf) {
		super(emf);
	}

}
