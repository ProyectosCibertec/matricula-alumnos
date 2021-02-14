package excepciones;

public class ExcepcionAdicionar extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionAdicionar(String mensaje) {
		super(mensaje);
	}
	
	public ExcepcionAdicionar() {
		this("Ocurrió una excepción.");
	}
}