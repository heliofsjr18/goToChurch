package basica;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Area {

	@Id
	@GeneratedValue
	private Integer id;
	private String numeroIdentificador;
	@OneToOne
	private Usuario usuario;
	@OneToMany
	private Collection<Congregacao> listaCongregacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroIdentificador() {
		return numeroIdentificador;
	}

	public void setNumeroIdentificador(String numeroIdentificador) {
		this.numeroIdentificador = numeroIdentificador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Collection<Congregacao> getListaCongregacao() {
		return listaCongregacao;
	}

	public void setListaCongregacao(Collection<Congregacao> listaCongregacao) {
		this.listaCongregacao = listaCongregacao;
	}
}
