import java.util.*;
class EjercicioLab_3 {
  public static void main(String[] args){
    int n1 = (int)(Math.random()*6);
    Ejercito[] e1 = new Ejercito[n1];
    int n2 = (int)(Math.random()*6);
    Ejercito[] e2 = new Ejercito[n2];
    ingresarDatos1(e1);
    ingresarDatos2(e2);
    if(n1 > n2) {
      System.out.println("Ejercito 1 es el ganador!!!");
      mostrarDatos1(e1);
      System.out.println("Ejercito 2 es el persedor :(");
      mostrarDatos2(e2);
    } else if ( n1 < n2) {
      System.out.println("Ejercito 2 es el ganador!!!");
      mostrarDatos2(e2);
      System.out.print("Ejercito 1 es el perdedor!!!");
      mostrarDatos1(e1);
    } else {
      System.out.println("Los ejercitos empataron");
      System.out.println("Ejercito 1.-");
      mostrarDatos1(e1);
      System.out.print("Ejercito 2.-");
      mostrarDatos2(e2);
    }
  }
  public static void ingresarDatos1(Ejercito[] e1){
    Scanner sc = new Scanner(System.in);
    System.out.println("Ejercito 1.-");
    for(int i = 0; i < e1.length; i++){
      e1[i] = new Ejercito();
      System.out.println("Soldado " +(i+1)+":");
      System.out.print("Edad: ");
      e1[i].setEdad(sc.nextInt());
      System.out.print("Genero: ");
      e1[i].setGenero(sc.next().charAt(0));
      System.out.print("DNI: ");
      e1[i].setDNI(sc.next());
    }
  }
  public static void ingresarDatos2(Ejercito[] e2){
    Scanner sc = new Scanner(System.in);
    System.out.println("Ejercito 2.- ");
    for(int i = 0; i < e2.length; i++){
      e2[i] = new Ejercito();
      System.out.println("Soldado " +(i+1)+":");
      System.out.print("Edad: ");
      e2[i].setEdad(sc.nextInt());
      System.out.print("Genero: ");
      e2[i].setGenero(sc.next().charAt(0));
      System.out.print("DNI: ");
      e2[i].setDNI(sc.next());
    }
  }
  public static void mostrarDatos1(Ejercito[] e1){
    for(int i = 0; i < e1.length; i++){
      System.out.println("Soldado "+(i+1)+".- Edad: " + e1[i].getEdad()+
                      " / Genero: " + e1[i].getGenero()+ " / DNI: "+ e1[i].getDNI());
    }
  }
  public static void mostrarDatos2(Ejercito[] e2){
    for(int i = 0; i < e2.length; i++){
      System.out.println("Soldado "+(i+1)+".- Edad: " + e2[i].getEdad()+
                      " / Genero: " + e2[i].getGenero()+ " / DNI: " +e2[i].getDNI());
    }
  }
}
