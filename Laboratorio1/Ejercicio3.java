import java.util.*;
class Ejercicio3{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String[] soldado = new String[5];
		int[] edad = new int[5];
		char[] genero = new char[5];
		String[] DNI = new String[5];
		for(int i = 0; i < 5; i++){
			System.out.println("Ingrese los datos del soldado "+(i+1)+": ");
			System.out.print("Ingrese Nombre: ");
			soldado[i] = sc.nextLine();
			System.out.print("Ingrese Edad: ");
			edad[i] = sc.nextInt();
			sc.nextLine();
			System.out.print("ingrese Genero: ");
			genero[i] = sc.nextLine().charAt(0);
			System.out.print("Ingrese DNI: ");
			DNI[i] = sc.nextLine();
		}
		System.out.println("Soldados:");
		for(int k = 0; k < 5; k++){
			System.out.println((k+1)+".- Nombre: "+soldado[k]+" / Edad: "+edad[k]+
			" / Genero: "+genero[k]+" / DNI: " +DNI[k]);
		}
	}
}