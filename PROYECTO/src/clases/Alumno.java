package clases;

public class Alumno {
	
	//ATRIBUTOS PRIVADOS 
	private int edad, celular, estado, codalumno; 
	private String nombres, apellidos, dni;
	
	//CONSTRUCTOR 
	public Alumno(int codalumno, int edad, int celular, int estado, String nombres, String apellidos, String dni) {
		this.codalumno = codalumno;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
	}
	
	public Alumno() {
		
	}

	/**INICIO METODOS ACCESO PUBLICO GET Y SET PARA LOS ATRIBUTOS**/ 
	 
	//ATRIBUTO ALUMNO
	public int getCodAlumno() {
		return codalumno;
	}

	public void setCodAlumno(int codalumno) {
		this.codalumno = codalumno;
	}
	
	//ATRIBUTO EDAD
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	//ATRIBUTO CELULAR
	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}
	
	//ATRIBUTO ALUMNO ESTADO
	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	//ATRIBUTO NOMBRE
	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	//ATRIBUTO APELLIDOS
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	//ATRIBUTO DNI
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**FIN METODOS DE ACCESO PUBLICO SET Y GET**/
	
	
	
}
