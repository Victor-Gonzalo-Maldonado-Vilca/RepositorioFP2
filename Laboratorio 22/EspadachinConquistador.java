import java.util.*;

public class EspadachinConquistador extends Espadachin {
	private static int count;

	public EspadachinConquistador() {
		super("Espadachin_Conquistador" + count, "EC", 14);
		count++;
	}

	public void imprimir() {
		super.imprimir();
	}
}