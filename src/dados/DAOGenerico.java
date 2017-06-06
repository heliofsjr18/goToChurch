package dados;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import util.DadosException;

public abstract class DAOGenerico<Entidade>{

	EntityManager entityManager;
	private Class<Entidade> persistentClass;
	
	@SuppressWarnings("unchecked")
	public DAOGenerico(EntityManager entityManager) {
		this.entityManager = entityManager;
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		persistentClass = (Class<Entidade>) parameterizedType.getActualTypeArguments()[0];
	}

	public Entidade update(Entidade objeto) throws DadosException {

		//EntityManager em = DAOFactory.factory.createEntityManager();

		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();

		objeto = this.entityManager.merge(objeto);

		tx.commit();

		this.entityManager.close();

		return objeto;
	}

	@SuppressWarnings("unchecked")
	public final List<Entidade> getAll() throws DadosException {
		List<Entidade> instance = new ArrayList<Entidade>();
		//EntityManager em = DAOFactory.factory.createEntityManager();

		try {
			System.out.println(getPersistentClass().getName());
			instance = (List<Entidade>) this.entityManager.createQuery("SELECT objetoGenerico FROM " + getPersistentClass().getName()+" objetoGenerico").getResultList();
			
		} catch (Exception re) {
			throw new DadosException(re.getMessage());
		}
		this.entityManager.close();
		return instance;
	}


	public void insert(Entidade objeto) throws DadosException {
		//EntityManager em = DAOFactory.factory.createEntityManager();
		EntityTransaction tx = this.entityManager.getTransaction();
		try {
			tx.begin();
			this.entityManager.persist(objeto);
			tx.commit();
			System.out.println("OK");
			this.entityManager.close();
		} catch (PersistenceException e) {
			tx.rollback();
			throw new DadosException(e.getMessage());
		}
	}

	public final void insertCollection(Collection<Entidade> colecao) throws DadosException {
		//EntityManager em = DAOFactory.factory.createEntityManager();
		try {
			EntityTransaction tx = this.entityManager.getTransaction();
			tx.begin();

			for (Entidade entidade : colecao) {
				this.entityManager.persist(entidade);
			}

			tx.commit();

			this.entityManager.close();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	public final void remove(Entidade objeto) throws DadosException {
		//EntityManager em = DAOFactory.factory.createEntityManager();
		EntityTransaction tx = this.entityManager.getTransaction();
		tx.begin();

		objeto = this.entityManager.merge(objeto);

		this.entityManager.remove(objeto);

		tx.commit();

		this.entityManager.close();
	}

	public final void refresh(Entidade object) {
		//EntityManager em = DAOFactory.factory.createEntityManager();
		this.entityManager.refresh(object);
		this.entityManager.close();
	}

	
	protected final Class<Entidade> getPersistentClass() {
		
		return persistentClass;
	}

}