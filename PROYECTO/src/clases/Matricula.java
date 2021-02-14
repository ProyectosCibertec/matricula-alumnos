package clases;

public class Matricula {
	
	//ATRIBUTOS PRIVADOS 
	private int nummatricula, codalumno, codcurso;
	private String fecha, hora;
	
	//CONSTRUCTOR 
	public Matricula(int nummatricula, int codalumno, int codcurso, String fecha, String hora) {
		this.nummatricula = nummatricula;
		this.codalumno = codalumno;
		this.codcurso = codcurso;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	/**INICIO METODOS ACCESO PUBLICO GET Y SET PARA LOS ATRIBUTOS**/ 
	
	//ATRIBUTO NUMMATRICULA
	public int getNumMatricula() {
		return this.nummatricula;
	}

	public void setNumMatricula(int nummatricula) {
		this.nummatricula = nummatricula;
	}

	//ATRIBUTO CODALUMNO
	public int getCodAlumno() {
		return this.codalumno;
	}

	public void setCodAlumno(int codalumno) {
		this.codalumno = codalumno;
	}

	//ATRIBUTO CODCURSO
	public int getCodCurso() {
		return this.codcurso;
	}

	public void setCodCurso(int codcurso) {
		this.codcurso = codcurso;
	}

	//ATRIBUTO FECHA
	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	//ATRIBUTO HORA
	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
	/**FIN METODOS DE ACCESO PUBLICO SET Y GET**/
}
