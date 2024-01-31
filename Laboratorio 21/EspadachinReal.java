import java.util.*;

public class EspadachinReal extends Espadachin {
	private static int count;

	public EspadachinReal() {
		super("Espadachin_Real", 12, 12, 12);
		count++;
	}

	public String toString() {
		return "Soldado ER" + "  /  " + getPuntosDeVida() + "  /  "
				+ "  /  NA-ND: " + getNivelAtaque() + "-" + getNivelDefensa();
	}
}