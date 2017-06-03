package dados;

import javax.persistence.EntityManager;
import basica.Usuario;
import util.DadosException;

public class DAOUsuario extends DAOGenerico<Usuario> implements IDAOUsuario {

	public DAOUsuario(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Usuario pesquisarLoginUsuario(Usuario u) throws DadosException{
		/*EntityTransaction tx = this.entityManager.getTransaction();
		String consulta = "select u from Usuario u where u.senha = :senha and u.login = :login;";
		
		Usuario usuario;
		
		try {
			tx.begin();
			Query q = (Query) this.entityManager.createQuery(consulta, Usuario.class);
			((TypedQuery<Usuario>) q).setParameter("senha",u.getSenha());
			((javax.persistence.Query) q).setParameter("login",u.getLogin());
			
			usuario = q.getSingleResultList();
			
			tx.commit();
			this.entityManager.close();
			
		} catch (PersistenceException e) {
			tx.rollback();
			throw new DadosException(e.getMessage());
		}
		return usuario;*/
		return null;
	}

}
