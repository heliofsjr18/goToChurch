package dados;

import javax.persistence.EntityManager;

import basica.Congregacao;

public class DAOCongregacao extends DAOGenerico<Congregacao> implements IDAOCongregacao {

	public DAOCongregacao(EntityManager entityManager) {
		super(entityManager);
	}

}
