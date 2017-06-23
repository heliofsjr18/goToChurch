package negocio;

import java.util.List;

import basica.Usuario;
import dados.DAOFactory;
import dados.DAOUsuario;
import util.DadosException;
import util.NegocioException;

public class RNUsuario {	
	
	private DAOFactory daoFactory;

	public RNUsuario() {
		daoFactory = new DAOFactory();
	}

	public void verificaPreenchimento(Usuario u) throws NegocioException{
		if(u == null){
			throw new NegocioException("Objeto não preenchido!");
		}else if(u.getNome().isEmpty() || u.getNome().equals("")){ 
			throw new NegocioException("Nome vazio!");
		}else if(u.getEmail().isEmpty() || u.getEmail().equals("")){
			throw new NegocioException("Email vazio!");
		}else if(u.getNome().length() < 5){
			throw new NegocioException("Nome Inválido!");
		}else if(u.getEmail().length() < 5){
			throw new NegocioException("Email Invalido!");
		}else if(u.getCpf().isEmpty() || u.getCpf().equals("")){
			throw new NegocioException("CPF vazio!");
		}else if(u.getCpf().length() < 10){
			throw new NegocioException("CPF Inválido!");
		}else if(u.getTelefone().length() < 7 || u.getTelefone().equals("")){
			throw new NegocioException("Numero de telefone Invalido!");
		}else if(u.getSenha().isEmpty() || u.getSenha().equals("")){
			throw new NegocioException("Senha Invalida!");
		}
		
		System.out.println("RN - "+u.getNome());
	}
	
	
	public void inserirUsuario(Usuario u) throws NegocioException{
		try{
			this.verificaPreenchimento(u);
			DAOUsuario daoUsuario = daoFactory.getDAOUsuario();
			daoUsuario.insert(u);
		}catch(Exception e){
			throw new NegocioException(e.getMessage());
		}
		
	}
	
	public void removeUsuario(Usuario u) throws NegocioException{
		try{
			this.verificaPreenchimento(u);
			DAOUsuario daoUsuario = daoFactory.getDAOUsuario();
			daoUsuario.remove(u);
		}catch(Exception e){
			throw new NegocioException(e.getMessage());
		}
	}
	
	public void alterarUsuario(Usuario u) throws NegocioException{
		try{
			this.verificaPreenchimento(u);
			DAOUsuario daoUsuario = daoFactory.getDAOUsuario();
			daoUsuario.update(u);
		}catch(Exception e){
			throw new NegocioException(e.getMessage());
		}
	}
	
	public List<Usuario> listaUsuario() throws NegocioException{
		 List<Usuario> u = null;
		try{		
			DAOUsuario daoUsuario = daoFactory.getDAOUsuario();
			u = daoUsuario.getAll();
		}catch(Exception e){
			throw new NegocioException(e.getMessage());
		}
		return u;
	}
	
	public Usuario logarUsuario(Usuario u) throws NegocioException, DadosException{
		DAOUsuario daoUsuario = daoFactory.getDAOUsuario();
		return daoUsuario.pesquisarLoginUsuario(u); 
	}
	
	public List<Usuario> listaUsuarioObreiro() throws NegocioException{
		 List<Usuario> u = null;
		try{		
			DAOUsuario daoUsuario = daoFactory.getDAOUsuario();
			u = daoUsuario.pesquisarUsuarioObreiro();
		}catch(Exception e){
			throw new NegocioException(e.getMessage());
		}
		return u;
	}
	
}