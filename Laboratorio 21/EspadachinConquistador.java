import java.util.*;

public class EspadachinConquistador extends Espadachin {
	private static int count;

	public EspadachinConquistador() {
		super("Espadachin_Conquistador", 14, 14, 14);
		count++;
	}

	public String toString() {
		return "Soldado EC" + "  /  " + getPuntosDeVida() + "  /  "
				+ "  /  NA-ND: " + getNivelAtaque() + "-" + getNivelDefensa();
	}
}