import java.util.*;

class VideoJuego {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean jugar = true;
    while (jugar) {
      int numeroRandom = (int) (Math.random() * 5) + 1;
      Mapa terreno = new Mapa(numeroRandom);
      System.out.println(terreno);
      terreno.imprimirTabla();
      terreno.mostrarEjercitos();
      boolean continuar = true;
      do {
        // UN Menu donde se señala la metrica para definir el ganador
        System.out.println("\tMenu");
        System.out.println("1.Suma de Vidas");
        System.out.println("2.Aleatoriamente");
        System.out.println("3.Cantidad de Soldados");
        System.out.println("4.Salir");
        System.out.println();
        System.out.print("Ingrese Metrica: ");
        int respuesta = sc.nextInt();
        // Iterativo
        switch (respuesta) {
          // suma
          case 1:
            terreno.metrica1();
            break;
          // aleatoriamente
          case 2:
            int random = (int) (Math.random() * 2) + 1;
            if (random == 1) {
              System.out.println("El ganador es el reinado 1");
            } else {
              System.out.println("El ejercito es el reinado 2");
            }
            break;
          // cantidad
          case 3:
            terreno.metrica3();
            break;
          // salir
          case 4:
            continuar = false;
            break;
          default:
            System.out.println("opcion invalida");
        }
      } while (continuar);
      sc.nextLine();
      System.out.print("¿Desea Continuar?(q == no): ");
      String respuesta = sc.nextLine();
      if (respuesta.equals("q")) {
        jugar = false;
      }
    }
  }
}