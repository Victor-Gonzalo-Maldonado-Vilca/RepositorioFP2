import java.util.*;
import java.awt.*;

public class Ejercito {
	private int countEsp = 0;
	private int countArq = 0;
	private int countCab = 0;
	private int countLan = 0;
	private int vidaEjercito;
	private String nombreReino;
	private String posicion;
	private String nombreEnTablero;
	private boolean condicionEjercito = true;
	private Color colorEjercito;
	private ArrayList<Soldado> soldados = new ArrayList<Soldado>();

	public Ejercito() {
	}

	public Ejercito(String nR) {
		nombreReino = nR;
		addSoldado((int) (Math.random() * 10 + 1));
		String numeroSoldados = String.valueOf(soldados.size());
		nombreEnTablero = numeroSoldados + "-" + vidaEjercito;
	}

	public void addSoldado(int azarNum) {
		for (int i = 0; i < azarNum; i++) {
			Soldado sold = tipoSoldadoAzar();
			soldados.add(sold);
			vidaEjercito += sold.getNivelVida();
		}
	}

	public Soldado tipoSoldadoAzar() {
		Soldado soldAzar;
		int azar = (int) (Math.random() * 5);
		if (azar == 0) {
			soldAzar = new Espadachin();
			countEsp++;
		} else if (azar == 1) {
			soldAzar = new Caballero();
			countCab++;
		} else if (azar == 2) {
			soldAzar = new Arquero(30);
			countArq++;
		} else if (azar == 3) {
			soldAzar = new Lancero();
			countLan++;
		} else
			soldAzar = unidadEspecial();
		return soldAzar;
	}

	public Soldado unidadEspecial() {
		Soldado soldEsp;
		if (nombreReino.equals("Inglaterra")) {
			soldEsp = new EspadachinReal();
			countEsp++;
		} else if (nombreReino.equals("Francia")) {
			soldEsp = new CaballeroFranco();
			countCab++;
		} else if (nombreReino.equals("Imperio Sacro")) {
			soldEsp = new EspadachinTeutonico();
			countEsp++;
		} else if (nombreReino.equals("Aragon")) {
			soldEsp = new EspadachinConquistador();
			countEsp++;
		} else {
			soldEsp = new CaballeroMoro();
			countCab++;
		}
		return soldEsp;
	}

	public void addPosSoldado(ArrayList<String> pos, int inicio) {
		for (int i = 0; i < soldados.size(); i++)
			soldados.get(i).setPos(pos.get(i + inicio));
	}

	public void setPosicion(String p) {
		posicion = p;
	}

	public void setColorEjercito(Color c) {
		colorEjercito = c;
	}

	public Color getColorEjercito() {
		return colorEjercito;
	}

	public String getPosicion() {
		return posicion;
	}

	public int getVidaEjercito() {
		return vidaEjercito;
	}

	public int getCountEsp() {
		return countEsp;
	}

	public int getCountArq() {
		return countArq;
	}

	public int getCountLan() {
		return countLan;
	}

	public int getCountCab() {
		return countCab;
	}

	public String getNombreReino() {
		return nombreReino;
	}

	public String getNombreEnTablero() {
		return nombreEnTablero;
	}

	public ArrayList<Soldado> getSoldados() {
		return soldados;
	}

	public boolean ejercitoEstaVivo() {
		return condicionEjercito;
	}

	public void ejercitoPerdio() {
		condicionEjercito = false;
	}

	public String soldadoPorUbicacion(String u) {
		Soldado s = new Soldado();
		for (Soldado sold : soldados)
			if (u.equals(sold.getPos()))
				return sold.getSoldadoEnTablero();
		return s.getSoldadoEnTablero(); // Esta linea nunca ocurrira
	}

	public int numeroSoldados() {
		return soldados.size();
	}

	public void imprimirSoldados() {
		for (Soldado sold : soldados)
			System.out.println(sold);
	}
}