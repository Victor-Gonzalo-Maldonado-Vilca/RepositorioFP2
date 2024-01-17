import java.util.ArrayList;

public class Mapa {
  private String tipoMapa;
  private ArrayList<Ejercito> ejercitosR1 = new ArrayList<>();
  private ArrayList<Ejercito> ejercitosR2 = new ArrayList<>();
  private int reinado1;
  private int ejercitos1;
  private int reinado2;
  private int ejercitos2;
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
    // Creacion de ejercitos
    agregacionEjercitos(ejercitosR1, reinado1, ejercitos1);
    agregacionEjercitos(ejercitosR2, reinado2, ejercitos2);
    // beneficios dados
    beneficio(tipoMapa, reinado1, ejercitosR1);
    beneficio(tipoMapa, reinado2, ejercitosR2);
  }

  /*
   * En este metodo mediante un random se señalara un tipoMapa, esto de igual
   * manera determinara a quien(reino) beneficia
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

  // Inicializacion del tablero con guiones
  public void Inicializacion() {
    for (int i = 0; i < mapa.length; i++) {
      for (int k = 0; k < mapa.length; k++) {
        mapa[i][k] = "-";
      }
    }
  }

  /*
   * En este metodo se podra visualizar la tabla o el mapa , donde se encontraran
   * los ejercitos
   */
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

  /*
   * Este metodo verifica mediante dos numeros random que señalaran un reinado
   * diferente cada uno
   */
  public void verificacion() {
    do {
      reinado1 = (int) (Math.random() * 5) + 1;
      reinado2 = (int) (Math.random() * 5) + 1;
    } while (reinado1 == reinado2);
  }

  // Inicializacion de los ejercitos, en este metodo se colocaran datos
  // aleatorios, fila y columna
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
   * En este metodo dependara del atributo tipoMapa debido a que beneficiara este
   * atributo a ciertos reinos
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

  // llama al metodo beneficio de la clase Ejercito
  public void beneficiarios(ArrayList<Ejercito> ejercitos) {
    for (Ejercito auxiliar : ejercitos) {
      auxiliar.beneficio();
    }
  }

  /*
   * En este metodo se mostrara o imprimira los ejercitos creados correspondientes
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

  /*
   * En este metodo se usa la suma de vida de todos los soldados integrados en los
   * reinados, el mayor sera ganador, pero existe la posibilidad del empate
   */
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

  /*
   * En este metodo se usa la cantidad existentes de ejercitos que tiene un reino,
   * el que tenga mas ejercitos sera el ganador
   */
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

  public String toString() {
    return "Tipo de Terreno: " + tipoMapa;
  }
}