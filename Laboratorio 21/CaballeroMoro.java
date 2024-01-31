import java.util.*;

public class CaballeroMoro extends Caballero {
	private static int count;

	public CaballeroMoro() {
		super("Caballero_Moro", 13, 13, 13);
		count++;
	}

	public String toString() {
		return "Soldado CM" + "  /  " + getPuntosDeVida() + "  /  "
				+ "  /  NA-ND: " + getNivelAtaque() + "-" + getNivelDefensa();
	}

}