package negocio;

import java.util.List;

import basica.Usuario;
import dados.DAOFactory;
import dados.DAOUsuario;
import util.NegocioException;

public class RNUsuario {	
	
	private DAOFactory daoFactory;

	public RNUsuario() {
		daoFactory = new DAOFactory();
	}

	public void verificaPreenchimento(Usuario u) throws NegocioException{
		if(u == null){
			throw new NegocioException("Objeto não preenchido!");
		}else if(u.getNome().isEmpty()){
			throw new NegocioException("Nome vazio!");
		}else if(u.getEmail().isEmpty()){
			throw new NegocioException("Email vazio!");
		}else if(u.getCpf().isEmpty()){
			throw new NegocioException("CPF vazio!");
		}
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
	
	public Usuario login(Usuario u) throws NegocioException{
		try{
			this.verificaPreenchimento(u);
			DAOUsuario daoUsuario = daoFactory.getDAOUsuario();
			return daoUsuario.LoginUsuario(u);
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
}