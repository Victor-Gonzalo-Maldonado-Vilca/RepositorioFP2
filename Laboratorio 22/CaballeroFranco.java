import java.util.*;
public class CaballeroFranco extends Caballero{
	private static int count;
	
	public CaballeroFranco(){
		super("Caballero_Franco" + count, "CF", 15);
		count++;
	}
	public void imprimir(){
		super.imprimir();
	}
}