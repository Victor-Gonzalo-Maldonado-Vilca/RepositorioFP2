import java.util.*;

class VideoJuego {1
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean menu = true;
    int opcion;
    do {
      System.out.println("\tMenu");
      System.out.println("1. Juego Rapido");
      System.out.println("2. Personalisado");
      System.out.println("3. Salir");
      System.out.print("Elija opcion: ");
      opcion = sc.nextInt();
      sc.nextLine();
      switch (opcion) {
        case 1:
          boolean continuar = true;
          while (continuar) {
            // tablero
            String[][] tablero = new String[10][10];
            tablero(tablero);
            mostrarT(tablero);
            // Primer Ejercito - numero random
            byte n1 = (byte) (Math.random() * 10 + 1);
            ArrayList<Soldado> ejercito1 = new ArrayList<>();
            // Segundo Ejercito - numero random
            byte n2 = (byte) (Math.random() * 10 + 1);
            ArrayList<Soldado> ejercito2 = new ArrayList<>();
            // Inicializacion
            ejercito1(ejercito1, n1, tablero);
            ejercito2(ejercito2, n2, tablero);
            // Tablero
            System.out.println("TABLERO: ");
            mostrarT(tablero);
            // Mayor Vida
            System.out.println("Datos del Soldado con mayor vidad del Ejercito 1: ");
            Soldado mayor1 = mayorSoldado(ejercito1);
            System.out.println(mayor1.toString());
            System.out.println("Datos del Soldado con mayor vidad del Ejercito 2: ");
            Soldado mayor2 = mayorSoldado(ejercito2);
            System.out.println(mayor2.toString());
            // Promedio
            System.out.println("Promedio de puntos de vida del Ejercito 1: " + promedioSoldado(ejercito1));
            System.out.println("Promedio de puntos de vida del Ejercito 2: " + promedioSoldado(ejercito2));
            // Ejercitos-orden en el que fueron creados
            System.out.println("Soldados en orden a su creacion: ");
            System.out.println("Ejército 1:");
            mostrar(ejercito1);
            System.out.println("-----------------------");
            System.out.println("Ejército 2:");
            mostrar(ejercito2);
            // Vida Actual
            actualizarVida(ejercito1, ejercito2);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Soldados después del ataque: ");
            System.out.println("Ejército 1:");
            mostrar(ejercito1);
            System.out.println("-----------------------");
            System.out.println("Ejército 2:");
            mostrar(ejercito2);
            // Ordenamiento mayor - menor
            System.out.println("Orden por vida Ejercito 1: ");
            ordenPorBurbuja(ejercito1);
            mostrar(ejercito1);
            System.out.println("Orden por vida Ejercito 2: ");
            ordenarPorSeleccion(ejercito2);
            mostrar(ejercito2);
            System.out.println();
            System.out.println();
            System.out.println();
            boolean c = true;
            while (c) {
              mostrarT(tablero);
              juego(tablero, ejercito1, ejercito2);
              System.out.print("Desea continuar: ");
              if (ejercito1.isEmpty()) {
                System.out.println("EL Ganador es el ejercito 2");
                c = false;
              } else if (ejercito2.isEmpty()) {
                System.out.println("EL Ganador es el ejercito 1");
                c = false;
              } else {
                String r = sc.nextLine();
                if (r.equals("q")) {
                  c = false;
                }
              }
            }
            System.out.println();
            System.out.println();
            System.out.println();
            // Ejercito Ganador
            System.out.println("Ganador dependiendo a la suma de puntos de vida del ejercito");
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
          break;
        case 2:
          int opcion1;
          boolean menu2 = true;
          String[][] tablero = new String[10][10];
          tablero(tablero);
          mostrarT(tablero);
          // Primer Ejercito - numero random
          byte n1 = (byte) (Math.random() * 10 + 1);
          ArrayList<Soldado> ejercito1 = new ArrayList<>();
          // Segundo Ejercito - numero random
          byte n2 = (byte) (Math.random() * 10 + 1);
          ArrayList<Soldado> ejercito2 = new ArrayList<>();
          // Inicializacion
          ejercito1(ejercito1, n1, tablero);
          ejercito2(ejercito2, n2, tablero);
          do {
            // Tablero
            System.out.println("TABLERO: ");
            mostrarT(tablero);
            System.out.println("\tMenu");
            System.out.println("1. Crear Soldado");
            System.out.println("2. Eliminar Soldado");
            System.out.println("3. Clonar Soldado");
            System.out.println("4. Modificar Soldado");
            System.out.println("5. Comparar Soldados");
            System.out.println("6. Intercambiar Soldado");
            System.out.println("7. Ver Soldado");
            System.out.println("8. Ver ejercito");
            System.out.println("9. Sumar niveles");
            System.out.println("10. Jugar");
            System.out.println("11. Volver");
            System.out.print("Elija opcion: ");
            opcion1 = sc.nextInt();
            sc.nextLine();
            switch (opcion1) {
              case 1:
                System.out.println("\tSubmenu");
                System.out.println("1. Ejercito 1");
                System.out.println("2. Ejercito 2");
                System.out.print("Escoja un ejercito: ");
                int e = sc.nextInt();
                // Creacion de soldados
                switch (e) {
                  case 1:
                    crearSoldado(ejercito1, tablero);
                    break;
                  case 2:
                    crearSoldado(ejercito2, tablero);
                    break;
                  default:
                    System.out.println("Opcion invalida");
                }
                break;
              // Elimnar Soldado
              case 2:
                System.out.println("\tSubmenu");
                System.out.println("1. Ejercito 1");
                System.out.println("2. Ejercito 2");
                System.out.print("Escoja un ejercito: ");
                e = sc.nextInt();
                switch (e) {
                  case 1:
                    eliminarSoldado(ejercito1);
                    break;
                  case 2:
                    eliminarSoldado(ejercito2);
                    break;
                  default:
                    System.out.println("Opcion invalida");
                }
                break;
              // Clonacion se Soldados
              case 3:
                System.out.println("\tSubmenu");
                System.out.println("1. Ejercito 1");
                System.out.println("2. Ejercito 2");
                System.out.print("Escoja un ejercito: ");
                e = sc.nextInt();
                switch (e) {
                  case 1:
                    clonarSoldado(ejercito1);
                    break;
                  case 2:
                    clonarSoldado(ejercito2);
                    break;
                  default:
                    System.out.println("Opcion invalida");
                }
                break;
              // Modificar Soldado
              case 4:
                System.out.println("\tSubmenu");
                System.out.println("1. Ejercito 1");
                System.out.println("2. Ejercito 2");
                System.out.print("Escoja un ejercito: ");
                e = sc.nextInt();
                switch (e) {
                  case 1:
                    modificarSoldado(ejercito1);
                    break;
                  case 2:
                    modificarSoldado(ejercito2);
                    break;
                  default:
                    System.out.println("Opcion invalida");
                }
                break;
              // Comparar dos soldados
              case 5:
                boolean igual = comparar(ejercito1, ejercito2);
                if (igual) {
                  System.out.println("Los dos soldados son iguales!!!");
                } else {
                  System.out.println("No son iguales!!");
                }
                break;
              // Intercambiar Soldado
              case 6:
                System.out.println("\tSubmenu");
                System.out.println("1. Intercambiar soldado ejercito 1 - ejercito 2");
                System.out.println("2. Intercambiar soldado ejercito 2 - ejercito 1");
                System.out.println("3. Intercambiar en el mismo ejercito - ejercito 1");
                System.out.println("4. Intercambiar en el mismo ejercito - ejercito 2");
                System.out.print("Escoja un ejercito: ");
                e = sc.nextInt();
                // Creacion de soldados
                switch (e) {
                  case 1:
                    intercambiarSoldado(ejercito1, ejercito2);
                    break;
                  case 2:
                    intercambiarSoldado(ejercito2, ejercito1);
                    break;
                  case 3:
                    intercambiarEnElMismoEjercito(ejercito1);
                    break;
                  case 4:
                    intercambiarEnElMismoEjercito(ejercito2);
                    break;
                  default:
                    System.out.println("Opcion invalida");
                }
                break;
              // VER soldado
              case 7:
                System.out.println("\tSubmenu");
                System.out.println("1. Ejercito 1");
                System.out.println("2. Ejercito 2");
                System.out.print("Escoja un ejercito: ");
                e = sc.nextInt();
                switch (e) {
                  case 1:
                    encontrarSoldado(ejercito1);
                    break;
                  case 2:
                    encontrarSoldado(ejercito2);
                    break;
                  default:
                    System.out.println("Opcion invalida");
                }
                break;
              // Ver Ejercito
              case 8:
                System.out.println("\tSubmenu");
                System.out.println("1. Ejercito 1");
                System.out.println("2. Ejercito 2");
                System.out.print("Escoja un ejercito: ");
                e = sc.nextInt();
                sc.nextLine();
                switch (e) {
                  case 1:
                    mostrar(ejercito1);
                    break;
                  case 2:
                    mostrar(ejercito2);
                    break;
                  default:
                    System.out.println("Opcion invalida");
                }
                break;
              case 9:
                System.out.println("\tSubmenu");
                System.out.println("1. Ejercito 1");
                System.out.println("2. Ejercito 2");
                System.out.print("Escoja un ejercito: ");
                e = sc.nextInt();
                switch (e) {
                  case 1:
                    Soldado suma1 = suma(ejercito1);
                    System.out.println(suma1);
                    break;
                  case 2:
                    Soldado suma2 = suma(ejercito2);
                    System.out.println(suma2);
                    break;
                  default:
                    System.out.println("Opcion invalida");
                }
                break;
              case 10:
                boolean c = true;
                while (c) {
                  System.out.println();
                  System.out.println();
                  System.out.println();
                  mostrarT(tablero);
                  juego(tablero, ejercito1, ejercito2);
                  System.out.print("Desea continuar: ");
                  if (ejercito1.isEmpty()) {
                    System.out.println("EL Ganador es el ejercito 2");
                    c = false;
                  } else if (ejercito2.isEmpty()) {
                    System.out.println("EL Ganador es el ejercito 1");
                    c = false;
                  } else {
                    String r = sc.nextLine();
                    if (r.equals("q")) {
                      c = false;
                    }
                  }
                }
                System.out.println();
                System.out.println();
                System.out.println();
                // Ejercito Ganador
                System.out.println("Ganador dependiendo a la suma de puntos de vida del ejercito");
                if (sumaVida(ejercito1) > sumaVida(ejercito2)) {
                  System.out.println("El ganador es el ejercito 1 con: " + sumaVida(ejercito1) + " puntos de vida");
                  System.out.println("El perdedor es el ejercito 2 con: " + sumaVida(ejercito2) + " puntos de vida");
                } else if (sumaVida(ejercito1) < sumaVida(ejercito2)) {
                  System.out.println("El ganador es el ejercito 2 con: " + sumaVida(ejercito2) + " puntos de vida");
                  System.out.println("El perdedor es el ejercito 1 con: " + sumaVida(ejercito1) + " puntos de vida");
                } else {
                  System.out.println("Empataron con: " + sumaVida(ejercito2) + " puntos de vida");
                }
                break;
              case 11:
                menu2 = false;
                break;
            }
          } while (menu2);
          break;
        case 3:
          menu = false;
          break;
        default:
          System.out.println("Opcion invalida");
      }
    } while (menu);
  }

  public static void ejercito1(ArrayList<Soldado> ejercito1, byte n1, String[][] tablero) {
    Scanner sc = new Scanner(System.in);// Datos Aleatorios
    int ph, fila, columna;
    for (int i = 0; i < n1; i++) {
      int acti = (int) (Math.random() * 4);
      int nivelA = (int) (Math.random() * 5) + 1;
      int nivelD = (int) (Math.random() * 5) + 1;
      int velocidad = (int) (Math.random() * 6);
      Soldado auxiliar = new Soldado(acti, nivelA, nivelD, velocidad);
      auxiliar.setNombre("Soldado " + i + "X1");
      ph = (int) (Math.random() * 5 + 1);
      auxiliar.setPuntosDeVida(ph);
      fila = (int) (Math.random() * 10);
      auxiliar.setFila(fila);
      columna = (int) (Math.random() * 10);
      auxiliar.setColumna(columna);
      while (tablero[fila][columna] != "-") {
        fila = (int) (Math.random() * 10);
        auxiliar.setFila(fila);
        columna = (int) (Math.random() * 10);
        auxiliar.setColumna(columna);
      }
      tablero[fila][columna] = "*";
      ejercito1.add(auxiliar);
    }
  }

  public static void ejercito2(ArrayList<Soldado> ejercito2, byte n2, String[][] tablero) {
    Scanner sc = new Scanner(System.in);// Datos Aleatorios
    int ph, fila, columna;
    for (int i = 0; i < n2; i++) {
      int acti = (int) (Math.random() * 4);
      int nivelA = (int) (Math.random() * 5) + 1;
      int nivelD = (int) (Math.random() * 5) + 1;
      int velocidad = (int) (Math.random() * 6);
      Soldado auxiliar = new Soldado(acti, nivelA, nivelD, velocidad);
      auxiliar.setNombre("Soldado " + i + "X2");
      ph = (byte) (Math.random() * 5 + 1);
      auxiliar.setPuntosDeVida(ph);
      fila = (int) (Math.random() * 10);
      auxiliar.setFila(fila);
      columna = (int) (Math.random() * 10);
      auxiliar.setColumna(columna);
      while (tablero[fila][columna] != "-") {
        fila = (int) (Math.random() * 10);
        auxiliar.setFila(fila);
        columna = (int) (Math.random() * 10);
        auxiliar.setColumna(columna);
      }
      tablero[fila][columna] = "+";
      ejercito2.add(auxiliar);
    }
  }

  // Vida Actual
  public static void actualizarVida(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2) {
    int minimo = Math.min(ejercito1.size(), ejercito2.size());
    for (int i = 0; i < minimo; i++) {
      Soldado auxiliar1 = ejercito1.get(i);
      Soldado auxiliar2 = ejercito2.get(i);
      auxiliar1.vidaActual(auxiliar2);
      auxiliar2.vidaActual(auxiliar1);
      ejercito1.set(i, auxiliar1);
      ejercito2.set(i, auxiliar2);
    }
  }

  public static void mostrar(ArrayList<Soldado> ejercito) {
    // mostrar soldados
    for (Soldado batallon : ejercito) {
      System.out.println(batallon.toString());
      System.out.println("-------------------------------------------------------------------------");
    }
  }

  public static void tablero(String[][] tablero) {
    // inicializar tablero
    for (int i = 0; i < 10; i++) {
      for (int k = 0; k < 10; k++) {
        tablero[i][k] = "-";

      }
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

  public static void ordenarPorSeleccion(ArrayList<Soldado> ejercito) {
    for (int i = 0; i < ejercito.size() - 1; i++) {
      int c = i;
      for (int k = i + 1; k < ejercito.size(); k++) {
        Soldado auxiliar1 = ejercito.get(c);
        Soldado auxiliar2 = ejercito.get(k);
        if (auxiliar2.getPuntosDeVida() > auxiliar1.getPuntosDeVida()) {
          c = k;
        }
      }
      if (c != i) {
        Soldado aux = ejercito.get(i);
        ejercito.set(i, ejercito.get(c));
        ejercito.set(c, aux);
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

  public static void juego(String[][] tablero, ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2) {
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
            if (tablero[fila][columna] == "+") {
              for (int k = 0; k < ejercito2.size(); k++) {
                Soldado auxiliar1 = ejercito2.get(k);
                if (auxiliar1.getFila() == fila && auxiliar1.getColumna() == columna) {
                  if (auxiliar.serAtacado(auxiliar1)) {
                    tablero[filaA][colA] = "-";
                    tablero[fila][columna] = "*";
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
            } else if (tablero[fila][columna] == "*") {
              auxiliar.setFila(filaA);
              auxiliar.setColumna(colA);
              fila = filaA;
              columna = colA;
              ejercito1.set(i, auxiliar);
              System.out.println("No se puede ejecutar el movimiento");
            } else {
              tablero[filaA][colA] = "-";
              tablero[fila][columna] = "*";
              ejercito1.set(i, auxiliar);
            }
          }
        } while ((columna < 0 || columna > 9) || (fila < 0 || fila > 9));
      }
    }
    for (int i = 0; i < ejercito2.size(); i++) {
      Soldado auxiliar = ejercito2.get(i);
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
            if (tablero[fila][columna] == "*") {
              for (int k = 0; k < ejercito1.size(); k++) {
                Soldado auxiliar1 = ejercito1.get(k);
                if (auxiliar1.getFila() == fila && auxiliar1.getColumna() == columna) {
                  if (auxiliar.serAtacado(auxiliar1)) {
                    tablero[filaA][colA] = "-";
                    tablero[fila][columna] = "+";
                    ejercito1.remove(k);
                    ejercito2.set(i, auxiliar);
                    int suma = auxiliar.getPuntosDeVida() + auxiliar1.getPuntosDeVida();
                    System.out.println("Soldado 2: " + ((double) auxiliar.getPuntosDeVida() / suma * 100) + "%");
                    System.out.println("Soldado 1: " + ((double) auxiliar1.getPuntosDeVida() / suma * 100) + "%");
                    System.out.println("Ganador por porcentaje: soldado 2");
                    System.out.println(auxiliar);
                    System.out.println(auxiliar1);
                  } else {
                    fila = filaA;
                    columna = colA;
                    ejercito2.remove(i);
                    int suma = auxiliar.getPuntosDeVida() + auxiliar1.getPuntosDeVida();
                    System.out.println("Soldado 2: " + ((double) auxiliar.getPuntosDeVida() / suma * 100) + "%");
                    System.out.println("Soldado 1: " + ((double) auxiliar1.getPuntosDeVida() / suma * 100) + "%");
                    System.out.println("Ganador por porcentaje: soldado 1");
                    tablero[filaA][colA] = "-";
                  }
                }
              }
            } else if (tablero[fila][columna] == "+") {
              auxiliar.setFila(filaA);
              auxiliar.setColumna(colA);
              fila = filaA;
              columna = colA;
              ejercito2.set(i, auxiliar);
              System.out.println("No se puede ejecutar el movimiento");
            } else {
              tablero[filaA][colA] = "-";
              tablero[fila][columna] = "+";
              ejercito2.set(i, auxiliar);
            }
          }
        } while ((columna < 0 || columna > 9) || (fila < 0 || fila > 9));
      }
    }
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

  public static void crearSoldado(ArrayList<Soldado> ejercito, String[][] tablero) {
    if (ejercito.size() < 10) {
      int acti = (int) (Math.random() * 4);
      int nivelA = (int) (Math.random() * 5) + 1;
      int nivelD = (int) (Math.random() * 5) + 1;
      int velocidad = (int) (Math.random() * 6);
      Soldado auxiliar = new Soldado(acti, nivelA, nivelD, velocidad);
      auxiliar.setNombre("Soldado EX1");
      int ph = (int) (Math.random() * 5 + 1);
      auxiliar.setPuntosDeVida(ph);
      int fila = (int) (Math.random() * 10);
      auxiliar.setFila(fila);
      int columna = (int) (Math.random() * 10);
      auxiliar.setColumna(columna);
      while (tablero[fila][columna] != "-") {
        fila = (int) (Math.random() * 10);
        auxiliar.setFila(fila);
        columna = (int) (Math.random() * 10);
        auxiliar.setColumna(columna);
      }
      tablero[fila][columna] = "*";
      ejercito.add(auxiliar);
    } else {
      System.out.println("El ejercito 1 esta completo");
    }
  }

  public static void eliminarSoldado(ArrayList<Soldado> ejercito) {
    Scanner sc = new Scanner(System.in);
    if (ejercito.size() == 0) {
      System.out.println("El ejercito esta vacio");
    } else {
      System.out.print("Ingrese indice del soldado que se quiere eliminar: ");
      int index = sc.nextInt();
      while (index >= ejercito.size()) {
        System.out.print("Ingrese indice valido: ");
        index = sc.nextInt();
      }
      ejercito.remove(index);
    }
  }

  public static void clonarSoldado(ArrayList<Soldado> ejercito) {
    Scanner sc = new Scanner(System.in);
    if (ejercito.size() < 10) {
      System.out.print("Ingrese indice del soldado que se quiere clonar: ");
      int index = sc.nextInt();
      while (index >= ejercito.size()) {
        System.out.print("Ingrese indice valido: ");
        index = sc.nextInt();
      }
      Soldado auxiliar = ejercito.get(index);
      Soldado copia = auxiliar.copySoldado(auxiliar);
      ejercito.add(copia);
    } else {
      System.out.println("No se puedo clonar - sobrepasa la cantidad de soldados");
    }
  }

  public static void modificarSoldado(ArrayList<Soldado> ejercito) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese indice del soldado que se quiere modificar: ");
    int index = sc.nextInt();
    while (index >= ejercito.size()) {
      System.out.print("Ingrese indice valido: ");
      index = sc.nextInt();
    }
    Soldado auxiliar = ejercito.get(index);
    boolean submenu = true;
    do {
      System.out.println("\tSubmenu");
      System.out.println("1. Modificar Nivel Ataque");
      System.out.println("2. Modificar Nivel Defensa");
      System.out.println("3. Modificar Nivel de Vida");
      System.out.println("4. Volver");
      System.out.println("Escoja opcion: ");
      int e = sc.nextInt();
      switch (e) {
        case 1:
          System.out.print("Ingrese Nivel Ataque: ");
          int nA = sc.nextInt();
          auxiliar.setNivelAtaque(nA);
          ejercito.set(index, auxiliar);
          break;
        case 2:
          System.out.print("Ingrese Nivel Defensa: ");
          int nD = sc.nextInt();
          auxiliar.setNivelDefensa(nD);
          ejercito.set(index, auxiliar);
          break;
        case 3:
          System.out.print("Ingrese Vida Actual: ");
          int nV = sc.nextInt();
          auxiliar.setPuntosDeVida(nV);
          ejercito.set(index, auxiliar);
          break;
        case 4:
          submenu = false;
          break;
        default:
          System.out.println("Opcion invalida");
      }
    } while (submenu);
  }

  public static boolean comparar(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Escoja los 2 soldados a comparar");
    System.out.print("Escoja el ejercito del primer Soldado: ");
    int number = sc.nextInt();
    while (1 > number || number > 2) {
      System.out.print("Ingrese ejercito valido: ");
      number = sc.nextInt();
    }
    Soldado auxiliar, auxiliar1;
    if (number == 1) {
      auxiliar = returnSoldado(ejercito1);
    } else {
      auxiliar = returnSoldado(ejercito2);
    }
    System.out.print("Escoja el ejercito del segundo soldado: ");
    number = sc.nextInt();
    while (1 > number || number > 2) {
      System.out.print("Ingrese ejercito valido: ");
      number = sc.nextInt();
    }
    if (number == 1) {
      auxiliar1 = returnSoldado(ejercito1);
    } else {
      auxiliar1 = returnSoldado(ejercito2);
    }
    return auxiliar.equals(auxiliar1);
  }

  public static Soldado returnSoldado(ArrayList<Soldado> ejercito) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese indice del Soldado: ");
    int number = sc.nextInt();
    while (ejercito.size() <= number || number < 0) {
      System.out.print("Ingrese un indice valido: ");
      number = sc.nextInt();
    }
    Soldado auxiliar = ejercito.get(number);
    return auxiliar;
  }

  public static void intercambiarSoldado(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Escoja los 2 soldados a intercambiar");
    System.out.print("Escoja el indice del primer Soldado: ");
    int number = sc.nextInt();
    while (ejercito1.size() <= number || number < 0) {
      System.out.print("Ingrese Soldado valido: ");
      number = sc.nextInt();
    }
    Soldado auxiliar = ejercito1.get(number);
    System.out.print("Escoja el indice del segundo Soldado: ");
    int number1 = sc.nextInt();
    while (ejercito2.size() <= number || number < 0) {
      System.out.print("Ingrese Soldado valido: ");
      number1 = sc.nextInt();
    }
    Soldado auxiliar1 = ejercito2.get(number1);
    ejercito1.set(number, auxiliar1);
    ejercito2.set(number1, auxiliar);
  }

  public static void intercambiarEnElMismoEjercito(ArrayList<Soldado> ejercito) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Escoja los 2 soldados a intercambiar");
    System.out.print("Escoja el indice del primer Soldado: ");
    int number = sc.nextInt();
    while (ejercito.size() <= number || number < 0) {
      System.out.print("Ingrese Soldado valido: ");
      number = sc.nextInt();
    }
    Soldado auxiliar = ejercito.get(number);
    System.out.print("Escoja el indice del segundo Soldado: ");
    int number1 = sc.nextInt();
    while (ejercito.size() <= number || number < 0) {
      System.out.print("Ingrese Soldado valido: ");
      number1 = sc.nextInt();
    }
    Soldado auxiliar1 = ejercito.get(number1);
    ejercito.set(number, auxiliar1);
    ejercito.set(number1, auxiliar);
  }

  public static Soldado buscarSoldado(String nombre, ArrayList<Soldado> ejercito) {
    for (Soldado ejer : ejercito) {
      if (nombre.equals(ejer.getNombre())) {
        return ejer;
      }
    }
    return null;
  }

  public static void encontrarSoldado(ArrayList<Soldado> ejercito) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese Nombre de Soldado: ");
    String name = sc.nextLine();
    Soldado encontrar = buscarSoldado(name, ejercito);
    if (encontrar != null) {
      System.out.println("Soldado Encontrado!!");
      System.out.println(encontrar);
    } else {
      System.out.println("No se encontro el Soldado!!");
    }
  }

  public static Soldado suma(ArrayList<Soldado> ejercito) {
    if (ejercito.isEmpty()) {
      return null;
    }
    Soldado resultado = new Soldado();
    for (Soldado soldado : ejercito) {
      resultado = resultado.sumar(soldado);
    }
    return resultado;
  }
}