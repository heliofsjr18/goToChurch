package dados;

import basica.Endereco;
import util.DadosException;

public interface IDAOEndereco {
	
	public Endereco GetEndereco(Integer id) throws DadosException;

}
