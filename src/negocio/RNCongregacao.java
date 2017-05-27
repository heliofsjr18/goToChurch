package negocio;

import java.util.List;

import basica.Congregacao;
import dados.DAOCongregacao;
import dados.DAOFactory;
import util.NegocioException;

public class RNCongregacao {
	
	private DAOFactory daoFactory;

	public RNCongregacao() {
		daoFactory = new DAOFactory();
	}

	private void verificaPreenchimento(Congregacao c) throws NegocioException {

		if (c == null) {
			throw new NegocioException("Objeto não preenchido!");
		} else if (c.getNome().isEmpty()) {
			throw new NegocioException("Nome vazio!");
		} else if (c.getCoordenador().isEmpty()) {
			throw new NegocioException("Coordenador vazio!");
		}
	}

	public void inserirCongregacao(Congregacao c) throws NegocioException {
		try {
			this.verificaPreenchimento(c);
			DAOCongregacao daoCongregacao = daoFactory.getDAOCongregacao();
			daoCongregacao.insert(c);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}

	}

	public void removerCongregacao(Congregacao c) throws NegocioException {
		try {
			this.verificaPreenchimento(c);
			DAOCongregacao daoCongregacao = daoFactory.getDAOCongregacao();
			daoCongregacao.remove(c);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}

	public void alterarCongregacao(Congregacao c) throws NegocioException {
		try {
			this.verificaPreenchimento(c);
			DAOCongregacao daoCongregacao = daoFactory.getDAOCongregacao();
			daoCongregacao.update(c);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}

	public List<Congregacao> listarCongregacao() throws NegocioException {
		List<Congregacao> c = null;
		try {
			DAOCongregacao daoCongregacao = daoFactory.getDAOCongregacao();
			c = daoCongregacao.getAll();
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
		return c;
	}
}