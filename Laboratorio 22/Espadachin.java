import java.util.*;

public class Espadachin extends Soldado {
	private static int count;
	private int longEspada;
	private boolean muroEscudos;

	public Espadachin() {
		super("Espadachin" + count, "E", 10, 8, (int) (Math.random() * 3 + 8));
		count++;
	}

	public Espadachin(String unidadEspecial, String sT, int vida) {
		super(unidadEspecial + count, sT, 10, 8, vida);
		count++;
	}

	public void imprimir() {
		super.imprimir();
	}
}