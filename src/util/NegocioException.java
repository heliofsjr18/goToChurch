package util;

@SuppressWarnings("serial")
public class NegocioException extends Exception {

	public NegocioException() {
		super();
	}

	public NegocioException(String erro) {
		super(erro);
	}

}
