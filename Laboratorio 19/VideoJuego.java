import java.util.*;

class VideoJuego {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    while (continuar) {
      ArrayList<Soldado> ejercito1 = new ArrayList<>();
      ArrayList<Soldado> ejercito2 = new ArrayList<>();
      int number1 = (int) (Math.random() * 10) + 1;
      int number2 = (int) (Math.random() * 10) + 1;
      String f1 = "+";
      String f2 = "*";
      String[][] tablero = new String[10][10];
      Inicializacion(tablero);

      // Datos aleatorios a los ArrayList
      inicializar(ejercito1, number1, "X1", tablero, f1);
      inicializar(ejercito2, number2, "X2", tablero, f2);

      // Mostrar los soldados de los dos ejercitos
      System.out.println("Ejercito 1: ");
      System.out.println();
      imprimirSoldados(ejercito1);

      System.out.println("---------------------------------------------------");
      System.out.println("Ejercito 2: ");
      System.out.println();
      imprimirSoldados(ejercito2);
      System.out.println();
      System.out.println();
      imprimirTabla(tablero);

      // Imprimir el soldados de cada ejercito con mayor vida
      System.out.println();
      System.out.println();
      System.out.println("Datos del Soldado con mayor vidad del Ejercito 1: ");
      Soldado mayor1 = mayorSoldado(ejercito1);
      System.out.println(mayor1.toString());
      System.out.println("Datos del Soldado con mayor vidad del Ejercito 2: ");
      Soldado mayor2 = mayorSoldado(ejercito2);
      System.out.println(mayor2.toString());
      System.out.println();
      System.out.println();

      // promedio de los puntos de vida de cada ejercito
      System.out.println("Promedio de puntos de vida del Ejercito 1: " + promedioSoldado(ejercito1));
      System.out.println("Promedio de puntos de vida del Ejercito 2: " + promedioSoldado(ejercito2));
      System.out.println();
      System.out.println();

      // Ordenamiento uso del algoritmo burbuja
      System.out.println("Orden por vida Ejercito 1: ");
      ordenPorBurbuja(ejercito1);
      imprimirSoldados(ejercito1);
      System.out.println();
      System.out.println();
      System.out.println("Orden por vida Ejercito 2: ");
      ordenPorBurbuja(ejercito2);
      imprimirSoldados(ejercito2);
      System.out.println();
      System.out.println();
      ganador(ejercito1, ejercito2);

      // Fin de la iteración
      System.out.print("Desea jugar otra vez? : ");
      String respuesta = sc.nextLine();
      if (respuesta.equals("q")) {
        continuar = false;
      }
    }
  }

  /*
   * En este metodo se lograra inicializar los ejercitos, con datos aleatorios
   * correspondientes, ademas mediante un random se podra asignar que tipo de
   * soldado es.
   */
  public static void inicializar(ArrayList<Soldado> ejercito, int numero, String X, String[][] tablero, String figura) {
    int e = 0;
    int a = 0;
    int c = 0;
    int l = 0;
    for (int i = 0; i < numero; i++) {
      int tipoSoldado = (int) (Math.random() * 4) + 1;
      int nA = (int) (Math.random() * 5) + 1;
      int nD = (int) (Math.random() * 5) + 1;
      int ph;
      Soldado auxiliar = null;
      int fila = (int) (Math.random() * 10);
      int columna = (int) (Math.random() * 10);
      while (tablero[fila][columna] != "-") {
        fila = (int) (Math.random() * 10);
        columna = (int) (Math.random() * 10);
      }
      String representacion = "";
      switch (tipoSoldado) {
        case 1:
          ph = (int) (Math.random() * 3) + 1;
          auxiliar = new Espadachin("Espadachin " + e + X, nA, nD, ph);
          e++;
          representacion = figura + "E" + auxiliar.getPuntosDeVida();
          break;
        case 2:
          ph = (int) (Math.random() * 3) + 1;
          auxiliar = new Arquero("Arquero " + a + X, nA, nD, ph);
          a++;
          representacion = figura + "A" + auxiliar.getPuntosDeVida();
          break;
        case 3:
          ph = (int) (Math.random() * 3) + 1;
          auxiliar = new Caballero("Caballero " + c + X, nA, nD, ph);
          c++;
          representacion = figura + "C" + auxiliar.getPuntosDeVida();
          break;
        case 4:
          ph = (int) (Math.random() * 2) + 1;
          auxiliar = new Lancero("Lancero " + l + X, nA, nD, ph);
          l++;
          representacion = figura + "L" + auxiliar.getPuntosDeVida();
          break;
      }
      tablero[fila][columna] = representacion;
      auxiliar.setFila(fila);
      auxiliar.setColumna(columna);
      ejercito.add(auxiliar);
    }
  }

  /*
   * Este metodo mediante un for each, mostrar todos los soldados haciendo uso del
   * metodo toString
   */
  public static void imprimirSoldados(ArrayList<Soldado> ejercito) {
    for (Soldado soldaditos : ejercito) {
      System.out.println(soldaditos);
    }
  }

  /*
   * inicializacion del tablero con -
   */
  public static void Inicializacion(String[][] tablero) {
    for (int i = 0; i < tablero.length; i++) {
      for (int k = 0; k < tablero.length; k++) {
        tablero[i][k] = "-";
      }
    }
  }

  /*
   * Este metodo mostrara el tablero correspondiente, donde se podra visualizar
   * con figuras a los soldados de dichos ejercitos
   */
  public static void imprimirTabla(String[][] tablero) {
    System.out.println("     A    B    C    D    E    F    G    H    I    J");
    for (int i = 0; i < tablero.length; i++) {
      if (i != 9) {
        System.out.print((i + 1) + " ");
      } else {
        System.out.print((i + 1));
      }
      for (int k = 0; k < tablero.length; k++) {
        if (tablero[i][k].length() == 3) {
          System.out.print("  " + tablero[i][k]);
        } else {
          System.out.print("   " + tablero[i][k] + " ");
        }
      }
      System.out.println();
    }

  }

  /*
   * En este metodo mediante un for each, al recorrer dico arraylist , suma la
   * vida de todos los soldados pertenecientes a este
   */
  public static int sumaVida(ArrayList<Soldado> soldados) {
    int suma = 0;
    for (Soldado auxiliar : soldados) {
      suma += auxiliar.getPuntosDeVida();
    }
    return suma;
  }

  /*
   * En este metodo se buscara el soldado que tiene mayor vida en un arraylist de
   * soldados
   */
  public static Soldado mayorSoldado(ArrayList<Soldado> ejercito) {
    // busca soldado con mayor vida
    Soldado auxiliar = ejercito.get(0);
    for (int i = 1; i < ejercito.size(); i++) {
      Soldado actual = ejercito.get(i);
      if (actual.getPuntosDeVida() > auxiliar.getPuntosDeVida()) {
        auxiliar = actual;
      }
    }
    return auxiliar;
  }

  /*
   * En este metodo se calculara el promedio de dicho ejercito enviado como
   * parametro
   */
  public static double promedioSoldado(ArrayList<Soldado> ejercito) {
    // opera promedio de punto de vida de cada soldado
    int suma = 0;
    int n = ejercito.size();
    for (int i = 0; i < ejercito.size(); i++) {
      Soldado auxiliar = ejercito.get(i);
      suma += auxiliar.getPuntosDeVida();
    }
    double promedio = (double) suma / n;
    return promedio;
  }

  /*
   * Ordenamiento decreciente dependiendo de la vida de cada soldado, el
   * ordenamiento burbuja consta de recorrer repetidamente una lista de elementos.
   * En cada iteración, compara los elementos adyacentes y los intercambia si
   * están en el orden incorrecto. Este proceso se repite hasta que no se
   * necesiten más intercambios, lo que indica que la lista está ordenada
   */
  public static void ordenPorBurbuja(ArrayList<Soldado> ejercito) {
    int n = ejercito.size();
    for (int i = 0; i < n - 1; i++) {
      for (int k = 0; k < n - i - 1; k++) {
        Soldado auxiliar1 = ejercito.get(k);
        Soldado auxiliar2 = ejercito.get(k + 1);
        if (auxiliar1.getPuntosDeVida() < auxiliar2.getPuntosDeVida()) {
          ejercito.set(k, auxiliar2);
          ejercito.set(k + 1, auxiliar1);
        }
      }
    }
  }

  /*
   * En este metodo me diante el metodo sumaVida se determinara que ejercito es el
   * ganador
   */
  public static void ganador(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2) {
    if (sumaVida(ejercito1) > sumaVida(ejercito2)) {
      System.out.println("Suma Vida ejercito 1: " + sumaVida(ejercito1));
      System.out.println("Suma Vida ejercito 2: " + sumaVida(ejercito2));
      System.out.println("El ganador es ejercito 1");
    } else if (sumaVida(ejercito1) < sumaVida(ejercito2)) {
      System.out.println("Suma Vida ejercito 1: " + sumaVida(ejercito1));
      System.out.println("Suma Vida ejercito 2: " + sumaVida(ejercito2));
      System.out.println("El ganador es ejercito 2");
    } else {
      System.out.println("Suma Vida ejercito 1: " + sumaVida(ejercito1));
      System.out.println("Suma Vida ejercito 2: " + sumaVida(ejercito2));
      System.out.println("Empate!!!");
    }
  }
}