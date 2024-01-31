import java.util.*;
public class EspadachinReal extends Espadachin{
	private static int count;
	
	public EspadachinReal(){
		super("Espadachin_Real" + count, "ER", 12);
		count++;
	}
	public void imprimir(){
		super.imprimir();
	}
}