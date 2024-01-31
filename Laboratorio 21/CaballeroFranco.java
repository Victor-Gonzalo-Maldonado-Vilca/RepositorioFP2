import java.util.*;

public class CaballeroFranco extends Caballero {
	private static int count;

	public CaballeroFranco() {
		super("Caballero_Franco", 15, 15, 15);
		count++;
	}

	public String toString() {
		return "Soldado CF" + "  /  " + getPuntosDeVida() + "  /  "
				+ "  /  NA-ND: " + getNivelAtaque() + "-" + getNivelDefensa();
	}
}