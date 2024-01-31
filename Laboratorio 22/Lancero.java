import java.util.*;
public class Lancero extends Soldado{
	private static int count;
	private int longLanza;
	private int nDefensa;
	
	public Lancero(){
		super("Lancero" + count, "L", 5, 10, (int)(Math.random() * 3 + 5));
		nDefensa = 10;
		count++;
	}
	public void schiltrom(){
		nDefensa++;
	}
	public void imprimir(){
		super.imprimir();
	}
}