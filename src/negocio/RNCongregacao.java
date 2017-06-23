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

	public void verificaPreenchimento(Congregacao c) throws NegocioException {

		if (c == null) {
			throw new NegocioException("Objeto não preenchido!");
		} else if (c.getNome().isEmpty()) {
			throw new NegocioException("Nome vazio!");
		} else if (c.getCoordenador().isEmpty()) {
			throw new NegocioException("Coordenador vazio!");
		}
	}

	public void validaCampos(Congregacao c) throws NegocioException {

		if (c.getNome().equals("")) {
			throw new NegocioException("Nome não Preenchido!");
		} else if (c.getNome().length() < 3) {
			throw new NegocioException("Nome Invalido!");
		} else if (c.getCoordenador().equals("")) {
			throw new NegocioException("Coordenador não foi preenchido!");
		} else if (c.getCoordenador().length() < 3) {
			throw new NegocioException("Coordenador Invalido!");
		} else if (c.getQtdAssentos() < 0) {
			throw new NegocioException("Quantidade de assentos invalida!");
		} else if (c.getQtdAssentos() < 10) {
			throw new NegocioException("Quantidade de assentos invalida!");
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
	
	public List<Congregacao> listarCongregacaoPorCidade(String cidade) throws NegocioException {
		List<Congregacao> c = null;
		try {
			DAOCongregacao daoCongregacao = daoFactory.getDAOCongregacao();
			c = daoCongregacao.listaCongregacaoPorCidade(cidade);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
		return c;
	}
}