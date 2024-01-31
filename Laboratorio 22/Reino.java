import java.util.*;
public class Reino{
	private String nombre;
	private ArrayList<Ejercito> ejercitos = new ArrayList<Ejercito>();
	private ArrayList<String> posiciones = new ArrayList<String>();
	
	public Reino(String n, ArrayList<String> pos, int inicio, int fin){
		nombre = n;
		addEjercito(pos, inicio, fin);
	}
	public void addEjercito(ArrayList<String> pos, int inicio, int fin){
		for(int i = inicio; i < fin; i++){
			Ejercito ejer = new Ejercito(nombre);
			ejer.setPosicion(pos.get(i));
			ejercitos.add(ejer);
			posiciones.add(pos.get(i));
		}
	}
	public String getNombre(){
		return nombre;
	}
	public ArrayList<String> getPosiciones(){
		return posiciones;
	}
	public ArrayList<Ejercito> getEjercitos(){
		return ejercitos;
	}
	public boolean reinoConEjercitos(){
		for(Ejercito ejer: ejercitos)
			if(ejer.ejercitoEstaVivo())
				return true;
		return false;
	}
	public String nombreEjercito(String pos){
		for(Ejercito ejer: ejercitos)
			if(pos.equals(ejer.getPosicion()))
				return ejer.getNombreEnTablero();
		return ""; //Esta linea nunca ocurrira
	}
	public Ejercito ejercitoPorNombre(String n){
		Ejercito e = new Ejercito();
		for(Ejercito ejer: ejercitos)
			if(n.equals(ejer.getNombreEnTablero()))
				return ejer;
		return e; //Esta linea nunca ocurrira
	}
	public void imprimirEjercitos(){
		for(Ejercito ejer: ejercitos)
			System.out.println(ejer.getNombreEnTablero());
	}
}