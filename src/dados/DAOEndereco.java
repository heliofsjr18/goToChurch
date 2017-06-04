package dados;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import basica.Endereco;
import util.DadosException;

public class DAOEndereco extends DAOGenerico<Endereco> implements IDAOEndereco {

	public DAOEndereco(EntityManager entityManager) {
		super(entityManager);
	}
	
	public Endereco GetEndereco(Integer id) throws DadosException{
		EntityTransaction tx = this.entityManager.getTransaction();
		String consulta = "select object(e) from Endereco as e where e.id=(:id)";
		
		
		Endereco end = new Endereco();
		
		try {
			tx.begin();
			Query q = this.entityManager.createQuery(consulta, Endereco.class);
			q.setParameter("id",id);
			
			end = (Endereco) q.getSingleResult();
			
			tx.commit();
			this.entityManager.close();
			
		} catch (PersistenceException e) {
			tx.rollback();
			throw new DadosException(e.getMessage());
		}

		return end;
	}

}
