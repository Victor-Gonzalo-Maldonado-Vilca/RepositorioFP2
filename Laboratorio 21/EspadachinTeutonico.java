import java.util.*;

public class EspadachinTeutonico extends Espadachin {
	private static int count;

	public EspadachinTeutonico() {
		super("Espadachin_Teutonico", 13, 13, 13);
		count++;
	}

	public String toString() {
		return "Soldado ET" + "  /  " + getPuntosDeVida() + "  /  "
				+ "  /  NA-ND: " + getNivelAtaque() + "-" + getNivelDefensa();
	}
}