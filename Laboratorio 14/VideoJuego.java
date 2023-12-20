import java.util.*;

class VideoJuego {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    while (continuar) {
      String[][] tablero = new String[Soldado.SOLDADOS][Soldado.SOLDADOS];
      ArrayList<Soldado> ejercito1 = new ArrayList<>();
      ArrayList<Soldado> ejercito2 = new ArrayList<>();
      // Generar Soldados y Almacenarlos en un ArrayList, ademas usar una constante
      // como limite
      int N1_Soldado = (int) (Math.random() * Soldado.SOLDADOS) + 1;
      int N2_Soldado = (int) (Math.random() * Soldado.SOLDADOS) + 1;
      int reino_1 = (int) (Math.random() * 5) + 1;
      int reino_2 = (int) (Math.random() * 5) + 1;
      // Verificacion para no generar luchas civiles
      while (reino_2 == reino_1) {
        reino_2 = (int) (Math.random() * Soldado.SOLDADOS) + 1;
      }
      // Crear figuras aleatorias
      String figura_1 = reinoFigura(reino_1);
      String figura_2 = reinoFigura(reino_2);
      String X1 = "X1";
      String X2 = "X2";
      // Eligiendo reinos de manera aleatoria
      String reinoNombre_1 = reinoNombre(reino_1);
      String reinoNombre_2 = reinoNombre(reino_2);
      tablero(tablero);
      mostrarT(tablero);
      crearSoldados(tablero, ejercito1, N1_Soldado, figura_1, X1);
      crearSoldados(tablero, ejercito2, N2_Soldado, figura_2, X2);
      System.out.println("Reinos en conflicto: " + reinoNombre_1 + " vs " + reinoNombre_2);
      System.out.println();
      System.out.println();
      System.out.println();
      mostrarT(tablero);
      System.out.println("Soldados creados en Total: " + Soldado.getContadorSoldado());
      System.out.println("Soldados creados en el ejercito 1: " + Soldado.soldadoEjercito(ejercito1));
      System.out.println("Soldados creados en el ejercito 2: " + Soldado.soldadoEjercito(ejercito2));
      boolean c = true;
      while (c) {
        juego(tablero, ejercito1, ejercito2, figura_1, figura_2);
        System.out.println("Soldados en el ejercito 1: " + Soldado.soldadoEjercito(ejercito1));
        System.out.println("Soldados en el ejercito 2: " + Soldado.soldadoEjercito(ejercito2));
        if (Soldado.soldadoEjercito(ejercito1) == 0) {
          System.out.println("EL Ganador es el ejercito 2");
          c = false;
        } else if (Soldado.soldadoEjercito(ejercito2) == 0) {
          System.out.println("EL Ganador es el ejercito 1");
          c = false;
        } else {
          System.out.print("¿Desea Continuar?: ");
          String r = sc.nextLine().toUpperCase();
          if (r.equals("NO")) {
            c = false;
          }
        }
      }
      System.out.println();
      System.out.println("EJERCITO 1: ");
      mostrar(ejercito1);
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("EJERCITO 2:");
      mostrar(ejercito2);
      if (sumaVida(ejercito1) > sumaVida(ejercito2)) {
        System.out.println("El ganador es el ejercito 1 con: " + sumaVida(ejercito1) + " puntos de vida");
        System.out.println("El perdedor es el ejercito 2 con: " + sumaVida(ejercito2) + " puntos de vida");
      } else if (sumaVida(ejercito1) < sumaVida(ejercito2)) {
        System.out.println("El ganador es el ejercito 2 con: " + sumaVida(ejercito2) + " puntos de vida");
        System.out.println("El perdedor es el ejercito 1 con: " + sumaVida(ejercito1) + " puntos de vida");
      } else {
        System.out.println("Empataron con: " + sumaVida(ejercito2) + " puntos de vida");
      }
      System.out.print("Desea Continuar(SI/NO): ");
      String respuesta = sc.next().toUpperCase();
      if (respuesta.equals("NO")) {
        continuar = false;
      }
    }
  }

  public static void tablero(String[][] tablero) {
    // inicializar tablero
    for (int i = 0; i < Soldado.SOLDADOS; i++) {
      for (int k = 0; k < Soldado.SOLDADOS; k++) {
        tablero[i][k] = "-";
      }
    }
  }

  public static void crearSoldados(String[][] tablero, ArrayList<Soldado> ejercito, int n, String f, String X) {
    Scanner sc = new Scanner(System.in);// Datos Aleatorios
    int ph, fila, columna;
    for (int i = 0; i < n; i++) {
      int acti = (int) (Math.random() * 4);
      int nivelA = (int) (Math.random() * 5) + 1;
      int nivelD = (int) (Math.random() * 5) + 1;
      int velocidad = (int) (Math.random() * 6);
      Soldado auxiliar = new Soldado(acti, nivelA, nivelD, velocidad);
      auxiliar.setNombre("Soldado " + i + X);
      ph = (byte) (Math.random() * 5 + 1);
      auxiliar.setPuntosDeVida(ph);
      fila = (int) (Math.random() * Soldado.SOLDADOS);
      auxiliar.setFila(fila);
      columna = (int) (Math.random() * Soldado.SOLDADOS);
      auxiliar.setColumna(columna);
      while (tablero[fila][columna] != "-") {
        fila = (int) (Math.random() * Soldado.SOLDADOS);
        auxiliar.setFila(fila);
        columna = (int) (Math.random() * Soldado.SOLDADOS);
        auxiliar.setColumna(columna);
      }
      tablero[fila][columna] = f;
      ejercito.add(auxiliar);
    }
  }

  public static void mostrarT(String[][] tablero) {
    // imprimir tablero
    System.out.println("   A  B  C  D  E  F  G  H  I  J");
    for (int i = 0; i < tablero.length; i++) {
      if (i == 9) {
        System.out.print((i + 1) + " ");
      } else {
        System.out.print((i + 1) + "  ");
      }
      for (int k = 0; k < tablero[i].length; k++) {
        if (tablero[i][k].length() == 2) {
          System.out.print(tablero[i][k] + " ");
        } else {
          System.out.print(tablero[i][k] + "  ");
        }
      }
      System.out.println();
    }
  }

  public static void mostrar(ArrayList<Soldado> ejercito) {
    // mostrar soldados
    for (Soldado batallon : ejercito) {
      System.out.println(batallon.toString());
      System.out.println("-------------------------------------------------------------------------");
    }
  }

  public static String reinoFigura(int random) {
    switch (random) {
      case 1:
        return "*";
      case 2:
        return "+";
      case 3:
        return "/";
      case 4:
        return "$";
      case 5:
        return "#";
    }
    return " ";
  }

  public static String reinoNombre(int random) {
    switch (random) {
      case 1:
        return "Inglaterra";
      case 2:
        return "Francia";
      case 3:
        return "Sacro imperio";
      case 4:
        return "Castilla-Aragon";
      case 5:
        return "Moros";
    }
    return "";
  }

  public static void juego(String[][] tablero, ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2, String f1,
      String f2) {
    Scanner sc = new Scanner(System.in);
    String coords;
    int columna, fila;
    do {
      System.out.print("Ingresar coordenadas validas: ");
      coords = sc.nextLine();
      columna = convertM(coords.substring(0, 1));
      fila = (Integer.parseInt(coords.substring(1))) - 1;
    } while (columna == 10 || fila < 0 || fila > 9);
    while (tablero[fila][columna] == "-") {
      do {
        System.out.print("Ingresar coordenadas validas: ");
        coords = sc.nextLine();
        columna = convertM(coords.substring(0, 1));
        fila = (Integer.parseInt(coords.substring(1))) - 1;
      } while (columna == 10 || fila < 0 || fila > 9);
    }
    verificacion(tablero, columna, fila, ejercito1, ejercito2, f1, f2);
    verificacion(tablero, columna, fila, ejercito2, ejercito1, f2, f1);
    mostrarT(tablero);
  }

  public static int convertM(String n) {
    switch (n) {
      case "A":
        return 0;
      case "B":
        return 1;
      case "C":
        return 2;
      case "D":
        return 3;
      case "E":
        return 4;
      case "F":
        return 5;
      case "G":
        return 6;
      case "H":
        return 7;
      case "I":
        return 8;
      case "J":
        return 9;
    }
    return 10;
  }

  public static void verificacion(String[][] tablero, int columna, int fila, ArrayList<Soldado> ejercito1,
      ArrayList<Soldado> ejercito2, String f1, String f2) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < ejercito1.size(); i++) {
      Soldado auxiliar = ejercito1.get(i);
      if (auxiliar.getFila() == fila && auxiliar.getColumna() == columna) {
        int mov, filaA, colA;
        do {
          System.out.print("Ingrese Movimiento: ");
          mov = sc.nextInt();
          filaA = auxiliar.getFila();
          colA = auxiliar.getColumna();
          auxiliar.movimiento(mov);
          fila = auxiliar.getFila();
          columna = auxiliar.getColumna();
          if ((columna < 0 || columna > 9) || (fila < 0 || fila > 9)) {
            auxiliar.setFila(filaA);
            auxiliar.setColumna(colA);
            System.out.println("Se sale de los limites");
          } else {
            if (tablero[fila][columna] == f2) {
              for (int k = 0; k < ejercito2.size(); k++) {
                Soldado auxiliar1 = ejercito2.get(k);
                if (auxiliar1.getFila() == fila && auxiliar1.getColumna() == columna) {
                  if (auxiliar.serAtacado(auxiliar1)) {
                    tablero[filaA][colA] = "-";
                    tablero[fila][columna] = f1;
                    ejercito2.remove(k);
                    ejercito1.set(i, auxiliar);
                    int suma = auxiliar.getPuntosDeVida() + auxiliar1.getPuntosDeVida();
                    System.out.println("Soldado 1: " + ((double) auxiliar.getPuntosDeVida() / suma * 100) + "%");
                    System.out.println("Soldado 2: " + ((double) auxiliar1.getPuntosDeVida() / suma * 100) + "%");
                    System.out.println("Ganador por porcentaje: soldado 1");
                  } else {
                    fila = filaA;
                    columna = colA;
                    ejercito1.remove(i);
                    int suma = auxiliar.getPuntosDeVida() + auxiliar1.getPuntosDeVida();
                    System.out.println("Soldado 1: " + ((double) auxiliar.getPuntosDeVida() / suma * 100) + "%");
                    System.out.println("Soldado 2: " + ((double) auxiliar1.getPuntosDeVida() / suma * 100) + "%");
                    System.out.println("Ganador: soldado 2");
                    tablero[filaA][colA] = "-";
                  }
                }
              }
            } else if (tablero[fila][columna] == f1) {
              auxiliar.setFila(filaA);
              auxiliar.setColumna(colA);
              fila = filaA;
              columna = colA;
              ejercito1.set(i, auxiliar);
              System.out.println("No se puede ejecutar el movimiento");
            } else {
              tablero[filaA][colA] = "-";
              tablero[fila][columna] = f1;
              ejercito1.set(i, auxiliar);
            }
          }
        } while ((columna < 0 || columna > 9) || (fila < 0 || fila > 9));
      }
    }
  }

  public static int sumaVida(ArrayList<Soldado> ejercito) {
    // suma de los puntos de vida de cada soldado
    int suma = 0;
    int n = ejercito.size();
    for (int i = 0; i < ejercito.size(); i++) {
      Soldado auxiliar = ejercito.get(i);
      suma += auxiliar.getPuntosDeVida();
    }
    return suma;
  }
}
