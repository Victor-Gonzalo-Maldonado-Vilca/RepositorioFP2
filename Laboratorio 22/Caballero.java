import java.util.*;
public class Caballero extends Soldado{
	private static int count;
	private boolean montar;
	
	public Caballero(){
		super("Caballero" + count, "C",13, 7, (int) (Math.random() * 3 + 10));
		count++;
	}
	public Caballero(String unidadEspecial, String sT, int vida){
		super(unidadEspecial + count, sT, 10, 8, vida);
		count++;
	}
	public void imprimir(){
		super.imprimir();
	}
}