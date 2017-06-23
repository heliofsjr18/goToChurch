package dados;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import basica.Congregacao;
import basica.Usuario;
import util.DadosException;

public class DAOCongregacao extends DAOGenerico<Congregacao> implements IDAOCongregacao {

	public DAOCongregacao(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Congregacao> listaCongregacaoPorCidade(String cidade) throws DadosException {
		List<Congregacao> instance = new ArrayList<Congregacao>();
		try {
			
			instance = (List<Congregacao>) this.entityManager.createQuery("SELECT objetoGenerico FROM " + getPersistentClass().getName()+" objetoGenerico WHERE cidade='"+cidade+"'").getResultList();
			
		} catch (Exception re) {
			throw new DadosException(re.getMessage());
		}
		this.entityManager.close();
		return instance;
	}

}
