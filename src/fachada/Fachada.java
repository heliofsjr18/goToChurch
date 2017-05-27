package fachada;

import java.util.List;

import basica.Usuario;
import basica.Area;
import basica.Congregacao;
import basica.Endereco;
import basica.Setor;
import negocio.RNArea;
import negocio.RNCongregacao;
import negocio.RNEndereco;
import negocio.RNSetor;
import negocio.RNUsuario;
import util.DadosException;
import util.NegocioException;

public class Fachada {

	RNArea rnArea;
	RNCongregacao rnCongregacao;
	RNEndereco rnEndereco;
	RNSetor rnSetor;
	RNUsuario rnUsuario;

	public Fachada() {
		this.rnArea = new RNArea();
		this.rnCongregacao = new RNCongregacao();
		this.rnEndereco = new RNEndereco();
		this.rnSetor = new RNSetor();
		this.rnUsuario = new RNUsuario();

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * ################################################ ## Usuario
	 * ################################################
	 */
	public void usuarioInserir(Usuario u) throws NegocioException, DadosException {
		rnUsuario.inserirUsuario(u);
	}

	public void usuarioAlterar(Usuario u) throws NegocioException, DadosException {
		rnUsuario.alterarUsuario(u);
	}

	public void usuarioExcluir(Usuario u) throws NegocioException, DadosException {
		rnUsuario.removeUsuario(u);
	}

	public List<Usuario> usuarioListar() throws NegocioException, DadosException {
		return rnUsuario.listaUsuario();
	}
	/*
	 * ################################################ ## Usuario
	 * ################################################
	 */

	// ------------------------------------------------

	/*
	 * ################################################ ## Area
	 * ################################################
	 */
	public void areaInserir(Area a) throws NegocioException, DadosException {
		rnArea.inserirArea(a);
	}

	public void areaAlterar(Area a) throws NegocioException, DadosException {
		rnArea.alterarArea(a);
	}

	public void areaExcluir(Area a) throws NegocioException, DadosException {
		rnArea.removerArea(a);
	}

	public List<Area> areaListar() throws NegocioException, DadosException {
		return rnArea.listaArea();
	}
	/*
	 * ################################################ ## Area
	 * ################################################
	 */

	// ------------------------------------------------

	/*
	 * ################################################ ## Setor
	 * ################################################
	 */
	public void setorInserir(Setor s) throws NegocioException, DadosException {
		rnSetor.inserirSetor(s);
	}

	public void setorAlterar(Setor s) throws NegocioException, DadosException {
		rnSetor.alterarSetor(s);
	}

	public void setorExcluir(Setor s) throws NegocioException, DadosException {
		rnSetor.removeSetor(s);
	}

	public List<Setor> setorListar() throws NegocioException, DadosException {
		return rnSetor.listaSetor();
	}
	/*
	 * ################################################ ## Setor
	 * ################################################
	 */

	// ------------------------------------------------

	/*
	 * ################################################ ## Endereco
	 * ################################################
	 */
	public void enderecoInserir(Endereco e) throws NegocioException, DadosException {
		rnEndereco.inserirEndereco(e);
	}

	public void enderecoAlterar(Endereco e) throws NegocioException, DadosException {
		rnEndereco.alterarEndereco(e);
	}

	public void enderecoExcluir(Endereco e) throws NegocioException, DadosException {
		rnEndereco.removeEndereco(e);
	}

	public List<Endereco> enderecoListar() throws NegocioException, DadosException {
		return rnEndereco.listaEndereco();
	}
	/*
	 * ################################################ ## Endereco
	 * ################################################
	 */
	
	
	// ------------------------------------------------

	/*
	 * ################################################ ## Congregacao
	 * ################################################
	 */
	public void congregacaoInserir(Congregacao c) throws NegocioException, DadosException {
		rnCongregacao.inserirCongregacao(c);
	}

	public void congregacaoAlterar(Congregacao c) throws NegocioException, DadosException {
		rnCongregacao.alterarCongregacao(c);
	}

	public void congregacaoExcluir(Congregacao c) throws NegocioException, DadosException {
		rnCongregacao.removerCongregacao(c);
	}

	public List<Congregacao> congregacaoListar() throws NegocioException, DadosException {
		return rnCongregacao.listarCongregacao();
	}
	/*
	 * ################################################ ## Congregacao
	 * ################################################
	 */

}