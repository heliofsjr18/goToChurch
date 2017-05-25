package dados_old;

import javax.persistence.EntityManagerFactory;

import basica.Endereco;

public class DAOEndereco extends DAOGenerico<Endereco>{

	public DAOEndereco(EntityManagerFactory emf) {
		super(emf);
	}

}
