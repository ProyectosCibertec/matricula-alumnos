package arreglos;

import java.io.*;
import java.util.*;
import clases.Alumno;
import excepciones.ExcepcionAdicionar;


public class ArregloAlumno {

	//ATRIBUTO PRIVADO TIPO ARRAYLIST
	private static ArrayList <Alumno> alu;

	//CONSTRUCTOR SIN PARÁMETROS DE ACCESO PÚBLICO
	public ArregloAlumno() {
		alu = new ArrayList <Alumno>();
		cargarAlumnos();
	}
	
	//METODOS DE ACCESO PÚBLICO 
	public static void adicionar (Alumno a) throws ExcepcionAdicionar{
		if(a.getNombres().equals("") || a.getNombres().length() <= 0) {
			throw new ExcepcionAdicionar("Debe introducir un nombre válido.");
		} else if(a.getApellidos().equals("") || a.getApellidos().length() <= 0) {
			throw new ExcepcionAdicionar("Debe introducir un apellido válido.");
		} else if(a.getDni().equals("") || a.getDni().length() < 8) {
			throw new ExcepcionAdicionar("Debe introducir un DNI válido.");
		} else if(String.valueOf(a.getCelular()).length() != 9) {
			throw new ExcepcionAdicionar("Debe introducir un celular válido.");
		} else if(a.getEdad() < 0 || a.getEdad() > 140) {
			throw new ExcepcionAdicionar("Debe introducir una edad válida.");
		} else {
			alu.add(a);
			grabarAlumnos();
		}
	}

	public static int tamaño(){
		return alu.size();
	}
	
	public static Alumno obtener(int i){
		return alu.get(i);
	}
	
	public static Alumno buscar(int codalumno) {
		for(int i = 0; i < tamaño(); i++)
			if(obtener(i).getCodAlumno() == codalumno)
				return obtener(i);
		return null;
	}
	
	public static void eliminar(Alumno a){
		alu.remove(a);
		grabarAlumnos();
	}
	
	public static void actualizarArchivo(){
		grabarAlumnos();
	}
	public static int numAlumnoCorrelativo(){
		if(tamaño() == 0)
			return 202010000;
		else 
			return obtener(tamaño()-1).getCodAlumno() + 1;
	}
	
	private static void grabarAlumnos(){
		try{
			PrintWriter pw = new PrintWriter(new FileWriter("Alumnos.txt"));
			String linea;
			Alumno a;
			for (int i = 0; i < tamaño(); i++) {
				a = obtener(i);
				linea = a.getCodAlumno() + ";" + 
						a.getEdad() + ";" + 
						a.getCelular() + ";" + 
						a.getEstado() + ";" + 
						a.getNombres() + ";" +
						a.getApellidos() + ";" + 
						a.getDni();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
		}
	}
	
	private void cargarAlumnos(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("Alumnos.txt"));
			String linea, nombres, apellidos, dni;
			String [] s;
			int edad, celular, estado, codAlumno;
			while((linea = br.readLine())!= null){
				s = linea.split(";");
				codAlumno = Integer.parseInt(s[0].trim());
				edad = Integer.parseInt(s[1].trim());
				celular = Integer.parseInt(s[2].trim());
				estado = Integer.parseInt(s[3].trim());
				nombres = s[4].trim();
				apellidos = s[5].trim();
				dni = s[6].trim();
				adicionar(new Alumno(codAlumno,edad,celular,estado,nombres,apellidos,dni));
			}
			br.close();
		}
		catch(Exception e){
			
		}
	}
}