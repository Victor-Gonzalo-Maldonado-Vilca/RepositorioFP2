import java.util.*;
class Ejercicio5{
	public static void main(String[] args){
		int n1 = (int)(Math.random()*6);
		int n2 = (int)(Math.random()*6);
		String[] soldado1 = new String[n1];
		int[] edad1 = new int[n1];
		char[] genero1 = new char[n1];
		String[] DNI1 = new String[n1];
		String[] soldado2 = new String[n2];
		int[] edad2 = new int[n2];
		char[] genero2 = new char[n2];
		String[] DNI2 = new String[n2];
		Inicializar1(soldado1, edad1, genero1, DNI1);
		Inicializar2(soldado2, edad2, genero2, DNI2);
		if(Ganador(n1, n2) == 1){
			System.out.println("Ejercito ganador 1: ");
			Mostrar1(soldado1, edad1,genero1,DNI1);
			System.out.println("Ejercito perdedor 2: ");
			Mostrar2(soldado2, edad2,genero2,DNI2);
		} else if (Ganador(n1 , n2) == 2){
			System.out.println("Ejercito ganador 2: ");
			Mostrar2(soldado2, edad2,genero2,DNI2);
			System.out.println("Ejercito perdedor 1: ");
			Mostrar1(soldado1, edad1,genero1,DNI1);
		} else {
			System.out.println("Los dos ejercitos empataron--");
			System.out.println("Ejercito 1: ");
			Mostrar1(soldado1, edad1,genero1,DNI1);
			System.out.println("Ejercito 2: ");
			Mostrar2(soldado2, edad2,genero2,DNI2);
		}
	}
	public static void Inicializar1(String[] soldado1, int[] edad1, char[] genero1, String[] DNI1){
		Scanner sc = new Scanner(System.in);
		System.out.println("Ejercito 1.- ");
		for(int i = 0; i < soldado1.length; i++){
			soldado1[i] = "soldado" +i;
			System.out.println(soldado1[i]+":");
			System.out.print("Ingrese Edad: ");
			edad1[i] = sc.nextInt();
			sc.nextLine();
			System.out.print("ingrese Genero: ");
			genero1[i] = sc.nextLine().charAt(0);
			System.out.print("Ingrese DNI: ");
			DNI1[i] = sc.nextLine();
		}
	}
	public static void Inicializar2(String[] soldado2, int[] edad2, char[] genero2, String[] DNI2){
		Scanner sc = new Scanner(System.in);
		System.out.println("Ejercito 2.- ");
		for(int i = 0; i < soldado2.length; i++){
			soldado2[i] = "soldado" +i;
			System.out.println(soldado2[i]+":");
			System.out.print("Ingrese Edad: ");
			edad2[i] = sc.nextInt();
			sc.nextLine();
			System.out.print("ingrese Genero: ");
			genero2[i] = sc.nextLine().charAt(0);
			System.out.print("Ingrese DNI: ");
			DNI2[i] = sc.nextLine();
		}
	}
	public static int Ganador(int n1, int n2){
		if(n1 > n2){
			return 1;
		} else if(n1 < n2){
			return 2;
		} 
		return 0;
	}
	public static void Mostrar1(String[] s, int[] e, char[] g, String[] d){
		for(int i = 0; i < s.length; i++){
			System.out.println(s[i]+"/ Edad: "+e[i]+" / Genero: "+g[i]+
			" / DNI: " +d[i]);
		}
	}
	public static void Mostrar2(String[] s, int[] e, char[] g, String[] d){
		for(int i = 0; i < s.length; i++){
			System.out.println(s[i]+"/ Edad: "+e[i]+" / Genero: "+g[i]+
			" / DNI: " +d[i]);
		}
	}
}