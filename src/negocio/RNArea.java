package negocio;

import java.util.List;

import basica.Area;
import dados.DAOArea;
import dados.DAOFactory;
import util.NegocioException;

public class RNArea {

	private DAOFactory daoFactory;

	public RNArea() {
		daoFactory = new DAOFactory();
	}

	private void verificaPreenchimento(Area a) throws NegocioException {
		
		if (a == null) {
			throw new NegocioException("Objeto não preenchido!");
		} else if (a.getNumeroIdentificador().isEmpty()) {
			throw new NegocioException("Nome vazio!");
		}
	}

	public void inserirArea(Area a) throws NegocioException {

		try {
			this.verificaPreenchimento(a);
			DAOArea daoArea = daoFactory.getDAOArea();
			daoArea.insert(a);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}

	public void removerArea(Area a) throws NegocioException {
		try {
			this.verificaPreenchimento(a);
			DAOArea daoArea = daoFactory.getDAOArea();
			daoArea.remove(a);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}

	public void alterarArea(Area a) throws NegocioException {
		try {
			this.verificaPreenchimento(a);
			DAOArea daoArea = daoFactory.getDAOArea();
			daoArea.update(a);
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
	}

	public List<Area> listaArea() throws NegocioException {
		List<Area> a = null;
		try {

			DAOArea daoArea = daoFactory.getDAOArea();
			a = daoArea.getAll();
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
		return a;
	}

}