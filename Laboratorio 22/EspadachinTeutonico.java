import java.util.*;
public class EspadachinTeutonico extends Espadachin{
	private static int count;
	
	public EspadachinTeutonico(){
		super("Espadachin_Teutonico" + count, "ET", 13);
		count++;
	}
	public void imprimir(){
		super.imprimir();
	}
}