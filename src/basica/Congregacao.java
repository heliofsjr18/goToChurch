package basica;

//import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Congregacao {

	@Id	
	@GeneratedValue
	private Integer id;
	private String nome;
	private String coordenador;
	private Integer qtdAssentos;
	private Boolean climatizada;
	@OneToOne
	private Endereco endereco;
	@OneToOne
	private Usuario usuario;	
	//private Collection<String> imagens;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public Integer getQtdAssentos() {
		return qtdAssentos;
	}

	public void setQtdAssentos(Integer qtdAssentos) {
		this.qtdAssentos = qtdAssentos;
	}

	public Boolean getClimatizada() {
		return climatizada;
	}

	public void setClimatizada(Boolean climatizada) {
		this.climatizada = climatizada;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/*public Collection<String> getImagens() {
		return imagens;
	}

	public void setImagens(Collection<String> imagens) {
		this.imagens = imagens;
	}*/

}
