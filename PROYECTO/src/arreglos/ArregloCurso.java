package arreglos;

import java.io.*;
import java.util.*;
import clases.Curso;
import excepciones.ExcepcionAdicionar;

public class ArregloCurso {
	
	//ATRIBUTO PRIVADO TIPO ARRAYLIST
	private static ArrayList <Curso> cur;

	//CONSTRUCTOR SIN PARÁMETROS DE ACCESO PÚBLICO
	public ArregloCurso() {
		cur = new ArrayList <Curso>();
		cargarCursos();
	}
	
	//METODOS BÁSICOS DE ACCESO PÚBLICO
	public static void adicionar(Curso c) throws ExcepcionAdicionar {
		if(c.getAsignaturas().equals("")) {
			throw new ExcepcionAdicionar("Debe introducir una asignatura.");
		} else {
			cur.add(c);
			grabarCursos();
		}
	}
	
	public static int tamaño(){
		return cur.size();
	}
	
	public static Curso obtener(int i){
		return cur.get(i);
	}
	
	public static Curso buscar(int codcurso){
		for (int i = 0; i < tamaño(); i++)
			if(obtener(i).getCodCurso()==codcurso)
				return obtener(i);
		return null;
	}
	
	public static void eliminar(Curso c){
		cur.remove(c);
		grabarCursos();
	}
	public static void actualizarArchivo(){
		grabarCursos();
	}
	
	private static void grabarCursos(){
		try{
			PrintWriter pw = new PrintWriter(new FileWriter("Cursos.txt"));
			String linea;
			Curso c;
			for (int i = 0; i < tamaño(); i++) {
				c = obtener(i);
				linea = c.getCodCurso() + ";" +
						c.getCiclo() + ";" + 
						c.getCreditos() + ";" + 
						c.getHoras() + ";" + 
						c.getAsignaturas();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
		}
	}
	
	private void cargarCursos(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("Cursos.txt"));
			String linea, asignaturas;
			String [] s;
			int codCurso, ciclo, creditos, horas;
			while((linea = br.readLine())!= null){
				s = linea.split(";");
				codCurso = Integer.parseInt(s[0].trim());
				ciclo = Integer.parseInt(s[1].trim());
				creditos = Integer.parseInt(s[2].trim());
				horas = Integer.parseInt(s[3].trim());
				asignaturas = s[4].trim();
				adicionar(new Curso(codCurso, ciclo, creditos, horas, asignaturas));
			}
			br.close();
		}
		catch(Exception e){
			
		}
	}
}
