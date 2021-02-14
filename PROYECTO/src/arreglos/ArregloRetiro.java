	package arreglos;

import java.util.*;

import java.io.*;
import clases.Retiro;


public class ArregloRetiro {
	//ATRIBUTOS PRIVADOS
	private static ArrayList<Retiro> ret;

	//CONSTRUCTOR SIN PAR�METROS DE ACCESO P�BLICO
	public ArregloRetiro() {
		ArregloRetiro.ret = new ArrayList<Retiro>();
		cargarRetiros();
	}
		
	//METODOS B�SICOS DE ACCESO P�BLICO
	public static void adicionar(Retiro r) {
		ret.add(r);
		grabarRetiros();
		
	}
		
	public static int tama�o() {
		return ret.size();
	}
		
	public static Retiro obtener(int i) {
		return ret.get(i);
	}
		
	public static Retiro buscar(int numretiro) {
		for(int i = 0; i < tama�o(); i++)
			if(obtener(i).getNumRetiro() == numretiro)
				return obtener(i);
		return null;
	}
	
	public static Retiro buscarMatricula(int numMatricula){
		for(int i = 0; i<tama�o(); i++)
			if(obtener(i).getNumMatricula() == numMatricula)
				return obtener(i);
		return null;
	}
		
	public static void eliminar(Retiro r) {
		ret.remove(r);
		grabarRetiros();
	}
	
	public static void actualizarArchivo(){
		grabarRetiros();
	}
	
	public static int numRetiroCorrelativo(){
		if(tama�o() == 0)
			return 200001;
		else 
			return obtener(tama�o()-1).getNumRetiro() + 1;
	}
	
	private static  void grabarRetiros(){
		try{
			PrintWriter pw  = new PrintWriter(new FileWriter("Retiros.txt"));
			String linea;
			Retiro r;
			for (int i = 0; i < tama�o(); i++) {
				r = obtener(i);
				linea = r.getNumRetiro() + ";"+
						r.getNumMatricula() + ";" + 
						r.getFecha() + ";" +
						r.getHora();
				pw.println(linea);
			}
			pw.close();
		}
		catch(Exception e){
			
		}
	}
	
	private void cargarRetiros(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("Retiros.txt"));
			String linea, fecha, hora;
			String [] s;
			int numRetiro, numMatricula;
			while((linea = br.readLine()) != null){
				s = linea.split(";");
				numRetiro = Integer.parseInt(s[0].trim());
				numMatricula = Integer.parseInt(s[1].trim());
				fecha = s[2].trim();
				hora = s[3].trim();
				adicionar(new Retiro(numRetiro, numMatricula, fecha, hora));
			}
			br.close();
		}
		catch(Exception e){
			
		}
	}
}
