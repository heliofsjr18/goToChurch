package dados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import basica.Endereco;

public class DAOEndereco extends DAOGenerico<Endereco> implements IDAOEndereco {

	public DAOEndereco(EntityManager entityManager) {
		super(entityManager);
	}

}
