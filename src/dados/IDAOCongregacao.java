package dados;

import java.util.List;

import basica.Congregacao;
import util.DadosException;

public interface IDAOCongregacao {
	public List<Congregacao> listaCongregacaoPorCidade(String cidade) throws DadosException;
}
