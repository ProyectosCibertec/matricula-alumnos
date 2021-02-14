package clases;

public class Curso {
	
	//ATRIBUTOS PRIVADOS 
	private int codcurso, ciclo, creditos, horas;
	private String asignaturas;
	
	//CONSTRUCTOR 
	public Curso(int codcurso, int ciclo, int creditos, int horas, String asignaturas) {
		this.codcurso = codcurso;
		this.ciclo = ciclo;
		this.creditos = creditos;
		this.horas = horas;
		this.asignaturas = asignaturas;
	}
	
	/**INICIO METODOS ACCESO PUBLICO GET Y SET PARA LOS ATRIBUTOS**/ 
	
	//ATRIBUTO CURSO
	public int getCodCurso() {
		return codcurso;
	}

	public void setCodCurso(int codcurso) {
		this.codcurso = codcurso;
	}

	//ATRIBUTO CICLO
	public int getCiclo() {
		return ciclo;
	}
	
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	//ATRIBUTO CRÉDITOS
	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	//ATRIBUTO HORAS
	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	//ATRIBUTO ASIGNATURAS
	public String getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(String asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	/**FIN METODOS DE ACCESO PUBLICO SET Y GET**/
	
	

}
