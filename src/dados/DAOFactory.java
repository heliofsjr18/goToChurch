package dados;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOFactory {
	
	
	public static final EntityManagerFactory factory;

	static {
			
		factory = Persistence.createEntityManagerFactory("gotochurch");
		
	}

	public DAOArea getDAOArea() {
		
		DAOArea daoAreaInstace = new DAOArea(factory.createEntityManager());
		return daoAreaInstace;
		
	}

	public DAOCongregacao getDAOCongregacao() {

		DAOCongregacao daoCongregacaoInstance = new DAOCongregacao(factory.createEntityManager());
		return daoCongregacaoInstance;
		
	}

	public DAOEndereco getDAOEndereco() {

		DAOEndereco daoEnderecoInstance = new DAOEndereco(factory.createEntityManager());
		return daoEnderecoInstance;
	}

	public DAOSetor getDAOSetor() {

		DAOSetor daoSetorInstance = new DAOSetor(factory.createEntityManager());
		return daoSetorInstance;
	}

	public DAOUsuario getDAOUsuario() {

		DAOUsuario daoUsuarioInstance = new DAOUsuario(factory.createEntityManager());
		return daoUsuarioInstance;
	}

	public DAOTipoUsuario getDAOTipoUsuario() {

		DAOTipoUsuario daoTipoUsuarioInstance = new DAOTipoUsuario(factory.createEntityManager());
		return daoTipoUsuarioInstance;
		
	}
}