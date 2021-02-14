package arreglos;

import java.io.*;

import java.util.*;
import clases.*;
import excepciones.ExcepcionAdicionar;

public class ArregloMatricula {
	//ATRIBUTOS PRIVADOS
	private static ArrayList<Matricula> mat;
	
	//CONSTRUCTOR SIN PAR�METROS DE ACCESO P�BLICO
	public ArregloMatricula() {
		mat = new ArrayList<Matricula>();
		cargarMatriculas();
	}
	
	//METODOS B�SICOS DE ACCESO P�BLICO
	public static void adicionar(Matricula m) throws ExcepcionAdicionar {
		if(m.getFecha().equals("")) {
			throw new ExcepcionAdicionar("Debe introducir una fecha.");
		} else if(m.getHora().equals("")) {
			throw new ExcepcionAdicionar("Debe introducir una hora.");
		} else if(String.valueOf(m.getCodAlumno()).length() != 9) {
			throw new ExcepcionAdicionar("El c�digo del alumno debe tener 9 d�gitos.");
		} else if(String.valueOf(m.getCodCurso()).length() != 4) {
			throw new ExcepcionAdicionar("El c�digo del alumno debe tener 4 d�gitos.");
		} else {
			mat.add(m);
			grabarMatriculas();
		}
	}
	
	public static int tama�o() {
		return mat.size();
	}
	
	public static Matricula obtener(int i) {
		return mat.get(i);
	}
	
	public static Matricula buscar(int nummatricula) {
		for(int i = 0; i < tama�o(); i++)
			if(obtener(i).getNumMatricula() == nummatricula)
				return obtener(i);
		return null;
	}
	
	public static Matricula buscarCurso(int codigoCurso){
		for(int i=0; i<tama�o(); i++)
			if(obtener(i).getCodCurso() == codigoCurso)
				return obtener(i);
		return null;
	}
	
	public static void eliminar(Matricula m) {
		mat.remove(m);
		grabarMatriculas();
	}
	
	public static int numMatriculaCorrelativo(){
		if(tama�o() == 0)
			return 100000;
		else 
			return obtener(tama�o()-1).getNumMatricula() + 1;
	}
	
	public static void actualizarArchivo(){
		grabarMatriculas();
	}
	
	private static void grabarMatriculas(){
		try{
			PrintWriter pw = new PrintWriter(new FileWriter("Matriculas.txt"));
			String linea;
			Matricula m;
			for (int i = 0; i < tama�o(); i++) {
				m = obtener(i);
				linea = m.getNumMatricula() + ";" + 
						m.getCodAlumno() + ";" + 
						m.getCodCurso() + ";" +
						m.getFecha() + ";" + 
						m.getHora();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
		}
	}
	
	private void cargarMatriculas(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("Matriculas.txt"));
			String linea, fecha, hora;
			String [] s;
			int numMatricula, codAlumno, codCurso;
			while((linea= br.readLine()) != null){
				s = linea.split(";");	
				numMatricula = Integer.parseInt(s[0].trim());
				codAlumno = Integer.parseInt(s[1].trim());
				codCurso = Integer.parseInt(s[2].trim());
				fecha = s[3].trim();
				hora = s[4].trim();
				adicionar(new Matricula(numMatricula, codAlumno, codCurso, fecha, hora));
			}
			br.close();
		}
		catch(Exception e){
		}
	}
}
