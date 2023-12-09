import java.util.*;
class EjercicioLab_2 {
  public static void main(String[] args){
    Soldado[] s = new Soldado[5];
    ingresarDatos(s);
    mostrarDatos(s);
  }
  public static void ingresarDatos(Soldado[] s){
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < s.length; i++){
      System.out.println("Soldado " + (i+1)+":");
      s[i] = new Soldado();
      System.out.print("- Nombre: ");
      s[i].setNombre(sc.next());
      System.out.print("- Nivel de Vida: ");
      s[i].setNivel_Vida(sc.next());
      System.out.print("- Edad: ");
      s[i].setEdad(sc.nextInt());
      System.out.print("- Genero: ");
      s[i].setGenero(sc.next().charAt(0));
      System.out.print("- DNI: ");
      s[i].setDNI(sc.next());
    }
  }
  public static void mostrarDatos(Soldado[] s){
    System.out.println("Soldados: ");
    for(int i = 0; i < s.length; i++){
      System.out.print("Soldado " + (i+1)+".-");
      System.out.print(" Nombre: " + s[i].getNombre()+
                      " / Nivel de vida: " + s[i].getNivel_Vida() +
                      " / Edad: " + s[i].getEdad() +
                      " / Genero: " + s[i].getGenero() +
                      " / DNI: " + s[i].getDNI());
      System.out.println();
    }
  }
}
