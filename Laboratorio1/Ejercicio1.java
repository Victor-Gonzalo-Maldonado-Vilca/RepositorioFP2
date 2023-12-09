import java.util.*;
class Ejercicio1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese los datos del soldado 1: ");
		System.out.print("Ingrese Nombre: ");
		String soldado1 = sc.nextLine();
		System.out.print("Ingrese Edad: ");
		int edad1 = sc.nextInt();
		sc.nextLine();
		System.out.print("ingrese Genero: ");
		char genero1 = sc.nextLine().charAt(0);
		System.out.print("Ingrese DNI: ");
		String DNI1 = sc.nextLine();
		System.out.println("Ingrese los datos del soldado 2: ");
		System.out.print("Ingrese Nombre: ");
		String soldado2 = sc.nextLine();
		System.out.print("Ingrese Edad: ");
		int edad2 = sc.nextInt();
		sc.nextLine();
		System.out.print("ingrese Genero: ");
		char genero2 = sc.nextLine().charAt(0);
		System.out.print("Ingrese DNI: ");
		String DNI2 = sc.nextLine();
		System.out.println("Ingrese los datos del soldado 3: ");
		System.out.print("Ingrese Nombre: ");
		String soldado3 = sc.nextLine();
		System.out.print("Ingrese Edad: ");
		int edad3 = sc.nextInt();
		sc.nextLine();
		System.out.print("ingrese Genero: ");
		char genero3 = sc.nextLine().charAt(0);
		System.out.print("Ingrese DNI: ");
		String DNI3 = sc.nextLine();
		System.out.println("Ingrese los datos del soldado 4: ");
		System.out.print("Ingrese Nombre: ");
		String soldado4 = sc.nextLine();
		System.out.print("Ingrese Edad: ");
		int edad4 = sc.nextInt();
		sc.nextLine();
		System.out.print("ingrese Genero: ");
		char genero4 = sc.nextLine().charAt(0);
		System.out.print("Ingrese DNI: ");
		String DNI4 = sc.nextLine();
		System.out.println("Ingrese los datos del soldado 5: ");
		System.out.print("Ingrese Nombre: ");
		String soldado5 = sc.nextLine();
		System.out.print("Ingrese Edad: ");
		int edad5 = sc.nextInt();
		sc.nextLine();
		System.out.print("ingrese Genero: ");
		char genero5 = sc.nextLine().charAt(0);
		System.out.print("Ingrese DNI: ");
		String DNI5 = sc.nextLine();
		System.out.println("Soldados: ");
		System.out.println("1.- Nombre: "+soldado1+" / Edad: "+
		edad1+" / Genero: "+genero1+" / DNI: "+DNI1);
		System.out.println("2.- Nombre: "+soldado2+" / Edad: "+
		edad2+" / Genero: "+genero2+" / DNI: "+DNI2);
		System.out.println("3.- Nombre: "+soldado3+" / Edad: "+
		edad3+" / Genero: "+genero3+" / DNI: "+DNI3);
		System.out.println("4.- Nombre: "+soldado1+" / Edad: "+
		edad4+" / Genero: "+genero4+" / DNI: "+DNI4);
		System.out.println("5.- Nombre: "+soldado5+" / Edad: "+
		edad5+" / Genero: "+genero5+" / DNI: "+DNI5);
	}
}