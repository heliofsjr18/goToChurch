package dados;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Query;

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
			q.setParameter("senha",u.getSenha());
			q.setParameter("login",u.getLogin());
			
			usuario = (Usuario) ((TypedQuery<Usuario>) q).getSingleResult();
			System.out.println(usuario.getNome());
			tx.commit();
			System.out.println("OK");
			this.entityManager.close();
			
		} catch (PersistenceException e) {
			tx.rollback();
			throw new DadosException(e.getMessage());
		}
		return usuario;*/
		List<Usuario> instance = new ArrayList<Usuario>();
		try {
			
			instance = (List<Usuario>) this.entityManager.createQuery("SELECT objetoGenerico FROM " + getPersistentClass().getName()+" objetoGenerico WHERE login = '"+u.getLogin()+"' AND senha = '"+u.getSenha()+"'").getResultList();
			
		} catch (Exception re) {
			throw new DadosException(re.getMessage());
		}
		this.entityManager.close();
		System.out.println(instance.get(0).getNome());
		return instance.get(0);
	}

	@Override
	public List<Usuario> pesquisarUsuarioObreiro() throws DadosException {
		List<Usuario> instance = new ArrayList<Usuario>();
		try {
			
			instance = (List<Usuario>) this.entityManager.createQuery("SELECT objetoGenerico FROM " + getPersistentClass().getName()+" objetoGenerico WHERE tipoUsuario_id = 3").getResultList();
			
		} catch (Exception re) {
			throw new DadosException(re.getMessage());
		}
		this.entityManager.close();
		System.out.println(instance.get(0).getNome());
		return instance;
	}

}
