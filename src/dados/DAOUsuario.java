package dados;

import javax.persistence.EntityManagerFactory;

import basica.Usuario;

public class DAOUsuario extends DAOGenerico<Usuario>{

	public DAOUsuario(EntityManagerFactory emf) {
		super(emf);
	}

}
