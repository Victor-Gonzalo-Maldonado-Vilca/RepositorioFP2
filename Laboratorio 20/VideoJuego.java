import java.util.Scanner;

class Videojuego {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    while (continuar) {
      int random = (int) (Math.random() * 5) + 1;
      Mapa territorio = new Mapa(random);
      // Imprimir tabla
      System.out.println();
      System.out.println();
      territorio.imprimirTabla();
      System.out.println();
      System.out.println();
      // Iterable
      System.out.print("Desea continuar?: ");
      String respuesta = sc.nextLine();
      if (respuesta.equals("q")) {
        continuar = false;
      }
    }
  }
}