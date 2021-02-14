package clases;

public class Retiro {
	
	//ATRIBUTOS PRIVADOS 
	private int numretiro, nummatricula;
	private String fecha, hora;
	
	//CONSTRUCTOR 
	public Retiro(int numretiro, int nummatricula, String fecha, String hora) {
		this.numretiro = numretiro;
		this.nummatricula = nummatricula;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	/**INICIO METODOS ACCESO PUBLICO GET Y SET PARA LOS ATRIBUTOS**/ 
	
	//ATRIBUTO NUMRETIRO
	public int getNumRetiro() {
		return numretiro;
	}

	public void setNumRetiro(int numretiro) {
		this.numretiro = numretiro;
	}

	//ATRIBUTO NUMMATRICULA
	public int getNumMatricula() {
		return nummatricula;
	}

	public void setNumMatricula(int nummatricula) {
		this.nummatricula = nummatricula;
	}

	//ATRIBUTO FECHA
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	//ATRIBUTO HORA
	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}	
	
	/**FIN METODOS DE ACCESO PUBLICO SET Y GET**/
	
}
