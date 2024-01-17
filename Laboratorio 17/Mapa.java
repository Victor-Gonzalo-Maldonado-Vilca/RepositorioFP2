import java.util.*;

public class Mapa {
  private String tipoMapa;
  private ArrayList<Ejercito> ejercitosR1 = new ArrayList<>();
  private ArrayList<Ejercito> ejercitosR2 = new ArrayList<>();
  private int reinado1;
  private int ejercitos1;
  private int reinado2;
  private int ejercitos2;
  private String f1;
  private String f2;
  private int sumaVida1 = 0;
  private int sumaVida2 = 0;
  private int cantidad1 = 0;
  private int cantidad2 = 0;
  private String[][] mapa = new String[10][10];

  // Constructor
  public Mapa(int m) {
    Inicializacion();
    typeMap(m);
    verificacion();
    ejercitos1 = (int) (Math.random() * 10) + 1;
    ejercitos2 = (int) (Math.random() * 10) + 1;
    agregacionEjercitos(ejercitosR1, reinado1, ejercitos1);
    agregacionEjercitos(ejercitosR2, reinado2, ejercitos2);
    beneficio(tipoMapa, reinado1, ejercitosR1);
    beneficio(tipoMapa, reinado2, ejercitosR2);
    figuras();
  }

  /*
   * Metodo donde mediante un random se seleccionar el tip de mapa
   */
  public void typeMap(int m) {
    switch (m) {
      case 1:
        tipoMapa = "Bosque";
        break;
      case 2:
        tipoMapa = "Campo Abierto";
        break;
      case 3:
        tipoMapa = "Montaña";
        break;
      case 4:
        tipoMapa = "Desierto";
        break;
      case 5:
        tipoMapa = "Playa";
        break;
    }
  }

  // Inicializacion del tableto con -
  public void Inicializacion() {
    for (int i = 0; i < mapa.length; i++) {
      for (int k = 0; k < mapa.length; k++) {
        mapa[i][k] = "-";
      }
    }
  }

  // Imprimir table, para ver las figuras en el tablero
  public void imprimirTabla() {
    System.out.println("   A  B  C  D  E  F  G  H  I  J");
    for (int i = 0; i < mapa.length; i++) {
      if (i != 9) {
        System.out.print((i + 1) + "  ");
      } else {
        System.out.print((i + 1) + " ");
      }
      for (int k = 0; k < mapa.length; k++) {
        System.out.print(mapa[i][k] + "  ");
      }
      System.out.println();
    }
  }

  // Verificacion de reinados, que no sean iguales
  public void verificacion() {
    do {
      reinado1 = (int) (Math.random() * 5) + 1;
      reinado2 = (int) (Math.random() * 5) + 1;
    } while (reinado1 == reinado2);
  }

  /*
   * Creacion de soldados con numero random
   */
  public void agregacionEjercitos(ArrayList<Ejercito> ejercitos, int reinado, int ejercitosAux) {
    for (int i = 0; i < ejercitosAux; i++) {
      Ejercito auxiliar = new Ejercito(reinado);
      int fila = (int) (Math.random() * 10);
      int columna = (int) (Math.random() * 10);
      while (mapa[fila][columna] != "-") {
        fila = (int) (Math.random() * 10);
        columna = (int) (Math.random() * 10);
      }
      mapa[fila][columna] = auxiliar.getSimbolo();
      auxiliar.setFila(fila);
      auxiliar.setColumna(columna);
      ejercitos.add(auxiliar);
    }
  }

  /*
   * Mediante este metodo, dependiendo del tipo de mapa, se dara beneficio al
   * reinado
   */
  public void beneficio(String tipoMapa, int reinado, ArrayList<Ejercito> ejercitos) {
    switch (tipoMapa) {
      case "Bosque":
        if (reinado == 1 || reinado == 5) {
          beneficiarios(ejercitos);
        }
      case "Campo Abierto":
        if (reinado == 2 || reinado == 5) {
          beneficiarios(ejercitos);
          ;
        }
        break;
      case "Montaña":
        if (reinado == 3) {
          beneficiarios(ejercitos);
          ;
        }
        break;
      case "Desierto":
        if (reinado == 4) {
          beneficiarios(ejercitos);
        }
        break;
      case "Playa":
        if (reinado == 5) {
          beneficiarios(ejercitos);
        }
        break;
    }
  }

  // Complemeto del anterior metod, llama metodo de la clase Ejercito
  public void beneficiarios(ArrayList<Ejercito> ejercitos) {
    for (Ejercito auxiliar : ejercitos) {
      auxiliar.beneficio();
    }
  }

  /*
   * Imprimir los soldados, ejercitos respectivos
   */
  public void mostrarEjercitos() {
    System.out.println("Reinado 1: ");
    for (Ejercito ejercitos : ejercitosR1) {
      sumaVida1 += ejercitos.getSuma();
      cantidad1 += 1;
      System.out.println(ejercitos);
    }
    System.out.println("----------------------------------------");
    System.out.println("Reinado 2: ");
    for (Ejercito ejercitos : ejercitosR2) {
      sumaVida2 += ejercitos.getSuma();
      cantidad2 += 1;
      System.out.println(ejercitos);
    }
  }

  // Asignacion de las figuras que representan a los reinados en una variable
  public void figuras() {
    Ejercito auxiliar1 = ejercitosR1.get(0);
    Ejercito auxiliar2 = ejercitosR2.get(0);
    f1 = auxiliar1.getSimbolo();
    f2 = auxiliar2.getSimbolo();
  }

  // Metrica ganador a base de la suma de vida de los soldados
  public void metrica1() {
    System.out.println("Suma Vida reinado 1: " + sumaVida1);
    System.out.println("Suma Vida reinado 2: " + sumaVida2);
    if (sumaVida1 > sumaVida2) {
      System.out.println("El ganador es el Reinado 1");
    } else if (sumaVida1 < sumaVida2) {
      System.out.println("El ganador es el Reinado 2");
    } else {
      System.out.println("Empate");
    }
  }

  // Metrica gandor a base de la cantidad de ejercitos
  public void metrica3() {
    System.out.println("Cantidad de Ejercitos reinado 1: " + cantidad1);
    System.out.println("Cantidad de Ejercitos reinado 2: " + cantidad2);
    if (cantidad1 > cantidad2) {
      System.out.println("El ganador es el Reinado 1");
    } else if (cantidad1 < cantidad2) {
      System.out.println("El ganador es el Reinado 2");
    } else {
      System.out.println("Empate");
    }
  }

  // Metodo donde se verifica las coordenadas
  public void juego() {
    Scanner sc = new Scanner(System.in);
    String coord;
    int fila, columna;
    do {
      System.out.print("Ingrese Coordenasdas validas: ");
      coord = sc.nextLine();
      columna = convertM(coord.substring(0, 1));
      fila = (Integer.parseInt(coord.substring(1)) - 1);
    } while (columna == 10 || fila < 0 || fila > 9);
    while (mapa[fila][columna] == "-") {
      do {
        System.out.print("Ingrese Coordenasdas validas: ");
        coord = sc.nextLine();
        columna = convertM(coord.substring(0, 1));
      } while (columna == 10 || fila < 0 || fila > 9);
    }
    movimientos(columna, fila, ejercitosR1, ejercitosR2, f1, f2);
    movimientos(columna, fila, ejercitosR2, ejercitosR1, f2, f1);
    imprimirTabla();
  }

  /*
   * Metodo donde se convierte un string en entero para juegar con los indices del
   * tablero
   */
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

  /*
   * Metodo donde se daran los movimientos de las figuras, ejercitos, se
   * verificaran las batallas civiles , etc
   */
  public void movimientos(int columna, int fila, ArrayList<Ejercito> ejercitoR1, ArrayList<Ejercito> ejercitoR2,
      String f1, String f2) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < ejercitoR1.size(); i++) {
      Ejercito auxiliar = ejercitoR1.get(i);
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
            if (mapa[fila][columna] == f2) {
              for (int k = 0; k < ejercitoR2.size(); k++) {
                Ejercito auxiliar1 = ejercitoR2.get(k);
                if (auxiliar1.getFila() == fila && auxiliar1.getColumna() == columna) {
                  if (auxiliar.serAtacado(auxiliar1)) {
                    mapa[filaA][colA] = "-";
                    mapa[fila][columna] = f1;
                    ejercitoR2.remove(k);
                    ejercitoR1.set(i, auxiliar);
                    int suma = auxiliar.getSuma() + auxiliar1.getSuma();
                    System.out.println("Ejercito 1: " + ((double) auxiliar.getSuma() / suma * 100) + "%");
                    System.out.println("Ejercito 2: " + ((double) auxiliar1.getSuma() / suma * 100) + "%");
                    System.out.println("Ganador por porcentaje: Ejercito 1");
                    auxiliar.aumento();
                  } else {
                    fila = filaA;
                    columna = colA;
                    ejercitoR1.remove(i);
                    int suma = auxiliar.getSuma() + auxiliar1.getSuma();
                    System.out.println("Ejercito 1: " + ((double) auxiliar.getSuma() / suma * 100) + "%");
                    System.out.println("Ejercito 2: " + ((double) auxiliar1.getSuma() / suma * 100) + "%");
                    System.out.println("Ganador: Ejercito 2");
                    auxiliar1.aumento();
                    mapa[filaA][colA] = "-";
                  }
                }
              }
            } else if (mapa[fila][columna] == f1) {
              auxiliar.setFila(filaA);
              auxiliar.setColumna(colA);
              fila = filaA;
              columna = colA;
              ejercitoR1.set(i, auxiliar);
              System.out.println("No se puede ejecutar el movimiento");
            } else {
              mapa[filaA][colA] = "-";
              mapa[fila][columna] = f1;
              ejercitoR1.set(i, auxiliar);
            }
          }
        } while ((columna < 0 || columna > 9) || (fila < 0 || fila > 9));
      }
    }
  }

  // Metodo donde se hara que el juego sea iterable ademas se verificara si algun
  // reinado esta vacio para poder asignar el ganador
  public void playing() {
    Scanner sc = new Scanner(System.in);
    boolean c = true;
    while (c) {
      juego();
      System.out.println("Ejercitos de los reinados: ");
      mostrarEjercitos();
      if (ejercitosR1.isEmpty()) {
        System.out.println("EL Ganador es el reinado 2");
        c = false;
      } else if (ejercitosR2.isEmpty()) {
        System.out.println("EL Ganador es el reinado 1");
        c = false;
      } else {
        System.out.print("¿Desea Continuar?: ");
        String r = sc.nextLine().toUpperCase();
        if (r.equals("NO")) {
          c = false;
        }
      }
    }
  }

  // Retorna el tipo de terreno
  public String toString() {
    return "Tipo de Terreno: " + tipoMapa;
  }
}