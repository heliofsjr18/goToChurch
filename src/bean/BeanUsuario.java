package bean;

/*import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import basica.Endereco;
import basica.TipoUsuario;
import basica.Usuario;
import fachada.Fachada;*/

//@ManagedBean(name="BeanUsuario")
//@SessionScoped
public class BeanUsuario {
	
	/*Fachada fachada = new Fachada();
	
	private List<Usuario> listarUsuario = new ArrayList<Usuario>();
	
	private String login;
	private String senha;
	
	private Integer id;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private String email;
	private String telefone;
	private Character sexo;
	private TipoUsuario tipoUsuario;
	private Endereco endereco;
	
	
	public List<Usuario> getListarUsuario() {
		return listarUsuario;
	}
	public void setListarUsuario(List<Usuario> listarUsuario) {
		this.listarUsuario = listarUsuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Character getSexo() {
		return sexo;
	}
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String index(){
		return "usuario";
	}
	
	/*public String logar(){
		try {
			usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario = fachada.usuarioLogar(usuario);
		} catch (Exception e) {
			
		}
	}*/
	
	
}
