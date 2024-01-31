import java.util.*;

public class Soldado {
	private String nombre;
	private String soldadoEnTablero;
	private int nivelAtaque;
	private int nivelDefensa;
	private int nivelVida;
	private boolean vive = true;
	// Al momento de ser creados deben estar vivos
	private String pos;

	public Soldado() {
	}

	public Soldado(String n, String sT, int ata, int def, int vid) {
		nombre = n;
		soldadoEnTablero = sT + vid;
		nivelVida = vid;
		nivelAtaque = ata;
		nivelDefensa = def;
	}

	public boolean morir() {
		vive = false;
		return vive;
	}

	public void setNombre(String n) {
		nombre = n;
	}

	public void setNivelVida(int v) {
		if (v > 0 && v <= 20)
			nivelVida = v;
	}

	public void setNivelAtaque(int a) {
		nivelAtaque = a;
	}

	public void setNivelDefensa(int d) {
		nivelDefensa = d;
	}

	public void setPos(String fc) {
		pos = fc; // fc: de fila-columna
	}

	public String getNombre() {
		return nombre;
	}

	public String getSoldadoEnTablero() {
		return soldadoEnTablero;
	}

	public int getNivelVida() {
		return nivelVida;
	}

	public int getNivelAtaque() {
		return nivelAtaque;
	}

	public int getNivelDefensa() {
		return nivelDefensa;
	}

	public String getPos() {
		return pos; // ejemplo: A1
	}

	public void agregarEjercitoNombre(String number) {
		nombre += "x" + number;
	}

	public boolean estaVivo() {
		return vive;
	}

	public String toString() {
		String name = " Nombre: " + nombre;
		String soldTab = "\n Codigo en tablero: " + soldadoEnTablero;
		String life = "\n  Nivel de Vida: " + nivelVida;
		String atack = "\n  Nivel de Ataque: " + nivelAtaque;
		String def = "\n  Nivel de Defensa: " + nivelDefensa;
		// String speed ="\n Velocidad: " + velocidad;
		return name + soldTab + life + atack + def;
	}

	public void imprimir() {
		System.out.println(toString());
	}
}