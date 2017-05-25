package dados_old;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

public class DAOGenerico<Entidade>{

	private EntityManagerFactory entityManagerFactory;

	public DAOGenerico(EntityManagerFactory emf) {
		this.setEntityManagerFactory(emf);
	}

	public Entidade update(Entidade objeto) {

		EntityManager em = this.entityManagerFactory.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		objeto = em.merge(objeto);

		tx.commit();

		em.close();

		return objeto;
	}

	public final List<Entidade> getAll() {
		List<Entidade> instance = null;
		EntityManager em = this.entityManagerFactory.createEntityManager();

		try {
			// instance = ((List<Entity>) em.createQuery("from " +
			// getPersistentClass().getName()).getResultList());
		} catch (RuntimeException re) {
			re.printStackTrace();
		}
		em.close();
		return instance;
	}

	public void insert(Entidade objeto) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(objeto);
			tx.commit();
			em.close();
		} catch (PersistenceException e) {
			tx.rollback();
		}
	}

	public final void insertCollection(Collection<Entidade> colecao) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		try {
			EntityTransaction tx = em.getTransaction();
			tx.begin();

			for (Entidade entidade : colecao) {
				em.persist(entidade);
			}

			tx.commit();

			em.close();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
	}

	public final void remove(Entidade objeto) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		objeto = em.merge(objeto);

		em.remove(objeto);

		tx.commit();

		em.close();
	}

	public final void refresh(Entidade object) {
		EntityManager em = this.entityManagerFactory.createEntityManager();
		em.refresh(object);
		em.close();
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

}