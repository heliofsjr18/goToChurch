package negocio;

import java.util.List;

import basica.Endereco;
import dados.DAOEndereco;
import dados.DAOFactory;
import util.NegocioException;

public class RNEndereco {
	
	private DAOFactory daoFactory;

	public RNEndereco() {
		daoFactory = new DAOFactory();
	}

	public void verificaPreenchimento(Endereco e) throws NegocioException {
		
		if (e == null) {
			throw new NegocioException("Objeto não preenchido!");
		} else if (e.getCidade().isEmpty()) {
			throw new NegocioException("Cidade vazia!");
		} else if (e.getBairro().isEmpty()) {
			throw new NegocioException("Bairro vazio!");
		} else if (e.getLogradouro().isEmpty()) {
			throw new NegocioException("Logradouro vazio!");
		} else if (e.getNumero().isEmpty()) {
			throw new NegocioException("Número vazio!");
		}
	}
	
	
	public void inserirEndereco(Endereco e) throws NegocioException{
		try{
			this.verificaPreenchimento(e);
			DAOEndereco daoEndereco = daoFactory.getDAOEndereco();
			daoEndereco.insert(e);
		}catch(Exception ex){
			throw new NegocioException(ex.getMessage());
		}
	}
	
	public void removeEndereco(Endereco e) throws NegocioException{
		try{
			this.verificaPreenchimento(e);
			DAOEndereco daoEndereco = daoFactory.getDAOEndereco();
			daoEndereco.remove(e);
		}catch(Exception ex){
			throw new NegocioException(ex.getMessage());
		}
	}
	
	public void alterarEndereco(Endereco e) throws NegocioException{
		try{
			this.verificaPreenchimento(e);
			DAOEndereco daoEndereco = daoFactory.getDAOEndereco();
			daoEndereco.update(e);
		}catch(Exception ex){
			throw new NegocioException(ex.getMessage());
		}
	}
	
	public List<Endereco> listaEndereco() throws NegocioException{
		 List<Endereco> e = null;
		try{			
			DAOEndereco daoEndereco = daoFactory.getDAOEndereco();
			e = daoEndereco.getAll();
		}catch(Exception ex){
			throw new NegocioException(ex.getMessage());
		}
		return e;
	}
}