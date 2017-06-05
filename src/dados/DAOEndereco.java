package dados;

import javax.persistence.EntityManager;

import basica.Endereco;

public class DAOEndereco extends DAOGenerico<Endereco> implements IDAOEndereco {

	public DAOEndereco(EntityManager entityManager) {
		super(entityManager);
	}

}
