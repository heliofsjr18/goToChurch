package negocio;

import java.util.List;

import basica.Setor;
import dados.DAOFactory;
import dados.DAOSetor;
import util.NegocioException;

public class RNSetor {

	private DAOFactory daoFactory;

	public RNSetor() {
		daoFactory = new DAOFactory();
	}

	public void verificaPreenchimento(Setor s) throws NegocioException {
		if (s == null) {
			throw new NegocioException("Objeto não preenchido!");
		} else if (s.getNumeroIdentificador().isEmpty()) {
			throw new NegocioException("Numero identificador Vazio!");
		}else if (s.getNumeroIdentificador().length() < 2) {
			throw new NegocioException("Numero identificador Inválido!");
		}else if (s.getNumeroIdentificador().equals("0")) {
			throw new NegocioException("Numero identificador Inválido!");
		}
	}

	public void inserirSetor(Setor s) throws NegocioException {
		try {
			this.verificaPreenchimento(s);
			DAOSetor daoSetor = daoFactory.getDAOSetor();
			daoSetor.insert(s);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}

	public void removeSetor(Setor s) throws NegocioException {
		try {
			this.verificaPreenchimento(s);
			DAOSetor daoSetor = daoFactory.getDAOSetor();
			daoSetor.remove(s);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}

	public void alterarSetor(Setor s) throws NegocioException {
		try {
			this.verificaPreenchimento(s);
			DAOSetor daoSetor = daoFactory.getDAOSetor();
			daoSetor.update(s);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}

	public List<Setor> listaSetor() throws NegocioException {
		List<Setor> s = null;
		
		try {
			DAOSetor daoSetor = daoFactory.getDAOSetor();
			s = daoSetor.getAll();
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
		return s;
	}
}
