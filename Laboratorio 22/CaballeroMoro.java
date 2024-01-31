import java.util.*;
public class CaballeroMoro extends Caballero{
	private static int count;
	
	public CaballeroMoro(){
		super("Caballero_Moro" + count, "CM", 13);
		count++;
	}
	public void imprimir(){
		super.imprimir();
	}
}