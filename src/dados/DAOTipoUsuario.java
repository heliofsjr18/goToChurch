package dados;

import javax.persistence.EntityManagerFactory;

import basica.TipoUsuario;

public class DAOTipoUsuario extends DAOGenerico<TipoUsuario>{

	public DAOTipoUsuario(EntityManagerFactory emf) {
		super(emf);
	}

}
