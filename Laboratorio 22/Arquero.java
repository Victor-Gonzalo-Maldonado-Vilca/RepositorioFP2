import java.util.*;

public class Arquero extends Soldado {
	private static int count;
	private int flechas;

	public Arquero(int f) {
		super("Arquero" + count, "A", 7, 3, (int) (Math.random() * 3 + 3));
		flechas = f;
		count++;
	}

	public void lanzarFlecha() {
		flechas--;
	}

	public void imprimir() {
		super.imprimir();
	}
}