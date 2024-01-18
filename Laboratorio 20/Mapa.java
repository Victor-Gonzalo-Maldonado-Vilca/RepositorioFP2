import java.util.*;

public class Mapa {
  private String[][] mapa = new String[10][10];
  private String tipoMapa;
  private int reinado1;
  private int reinado2;

  public Mapa(int m) {
    Inicializacion();
    typeMap(m);
    verificacion();
    Ejercito soldados1 = new Ejercito(reinado1, "X1");
    Ejercito soldados2 = new Ejercito(reinado2, "X2");
    ArrayList<Soldado> ejercito1 = soldados1.getSoldadosList();
    ArrayList<Soldado> ejercito2 = soldados2.getSoldadosList();
    beneficio(tipoMapa, reinado1, ejercito1);
    beneficio(tipoMapa, reinado2, ejercito2);
    rellenarT(ejercito1);
    rellenarT(ejercito2);
    System.out.println();
    System.out.println();
    mostrarEjercitos(ejercito1, ejercito2);
    System.out.println();
    System.out.println();

    // Imprimir el soldados de cada ejercito con mayor vida
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
    resumen("1", soldados1, ejercito1);
    System.out.println();
    System.out.println();
    resumen("2", soldados2, ejercito2);
    System.out.println();
    System.out.println();
    // Ganador
    ganador(soldados1, soldados2);
  }

  /*
   * Metodo donde mediante un random se asignara el tipo de mapa
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

  /*
   * inicializacion del tablero con -
   */
  public void Inicializacion() {
    for (int i = 0; i < mapa.length; i++) {
      for (int k = 0; k < mapa.length; k++) {
        mapa[i][k] = "-";
      }
    }
  }

  /*
   * Este metodo mostrara el tablero correspondiente, donde se podra visualizar
   * con figuras a los soldados de dichos ejercitos
   */
  public void imprimirTabla() {
    System.out.println("     A    B    C    D    E    F    G    H    I    J");
    for (int i = 0; i < mapa.length; i++) {
      if (i != 9) {
        System.out.print((i + 1) + " ");
      } else {
        System.out.print((i + 1));
      }
      for (int k = 0; k < mapa.length; k++) {
        if (mapa[i][k].length() == 3) {
          System.out.print("  " + mapa[i][k]);
        } else if (mapa[i][k].length() == 4) {
          System.out.print(" " + mapa[i][k]);
        } else {
          System.out.print("   " + mapa[i][k] + " ");
        }
      }
      System.out.println();
    }

  }

  /*
   * Metodo que se ocupara de que los dos reinos no sean iguales
   */
  public void verificacion() {
    do {
      reinado1 = (int) (Math.random() * 5) + 1;
      reinado2 = (int) (Math.random() * 5) + 1;
    } while (reinado1 == reinado2);
  }

  /*
   * Metodo donde depende del tipo de mapa y reinado, segun los criterios
   * asignados , dichos reinos seran beneficiados
   */
  public void beneficio(String tipoMapa, int reinado, ArrayList<Soldado> ejercitos) {
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

  /*
   * Complemento del anterior metodo, donde da beneficios a cada soldado
   */
  public void beneficiarios(ArrayList<Soldado> soldaditos) {
    for (Soldado auxiliar : soldaditos) {
      auxiliar.beneficio();
    }
  }

  /*
   * Muestra todos los datos de los ejercitos
   */
  public void mostrarEjercitos(ArrayList<Soldado> ejercitosR1, ArrayList<Soldado> ejercitosR2) {
    System.out.println("Reinado 1: ");
    for (Soldado soldaditos : ejercitosR1) {
      System.out.println(soldaditos);
    }
    System.out.println("----------------------------------------");
    System.out.println("Reinado 2: ");
    for (Soldado soldaditos : ejercitosR2) {
      System.out.println(soldaditos);
    }
  }

  /*
   * Generar filas y columnas u agragarlos a los soldados creados
   */
  public void rellenarT(ArrayList<Soldado> soldaditos) {
    for (int i = 0; i < soldaditos.size(); i++) {
      Soldado auxiliar = soldaditos.get(i);
      int fila = (int) (Math.random() * 10);
      int columna = (int) (Math.random() * 10);
      while (mapa[fila][columna] != "-") {
        fila = (int) (Math.random() * 10);
        columna = (int) (Math.random() * 10);
      }
      auxiliar.setFila(fila);
      auxiliar.setColumna(columna);
      mapa[fila][columna] = auxiliar.getRepresentacion();
    }
  }

  /*
   * Metodo que recorrera el arreglo y imprimira los objetos almacenados en el
   * ArrayList
   */
  public static void imprimirSoldados(ArrayList<Soldado> ejercito) {
    for (Soldado soldaditos : ejercito) {
      System.out.println(soldaditos);
    }
  }

  /*
   * En este metodo se buscara el soldado que tiene mayor vida en un arraylist de
   * soldados
   */
  public Soldado mayorSoldado(ArrayList<Soldado> ejercito) {
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
  public double promedioSoldado(ArrayList<Soldado> ejercito) {
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
  public void ordenPorBurbuja(ArrayList<Soldado> ejercito) {
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

  // Metodo donde se resumiran los ejercitos
  public void resumen(String num, Ejercito n, ArrayList<Soldado> soldados) {
    System.out.println("Ejercito " + num + " : " + n.getReino());
    int a = 0;
    int c = 0;
    int l = 0;
    int e = 0;
    for (Soldado auxiliar : soldados) {
      if (auxiliar instanceof Espadachin) {
        e++;
      } else if (auxiliar instanceof Arquero) {
        a++;
      } else if (auxiliar instanceof Caballero) {
        c++;
      } else {
        l++;
      }
    }
    System.out.println("Cantidad total de soldados creados: " + soldados.size());
    System.out.println("Espadachines: " + e);
    System.out.println("Arqueros: " + a);
    System.out.println("Caballeros: " + c);
    System.out.println("Lanceros: " + l);
  }

  /*
   * Metodo donde usando el porcentaje , retornar verdad si ejercito n gana a s y
   * false caso contrario
   */
  public boolean serAtacado(Ejercito n, Ejercito s) {
    int nph = n.getSuma();
    int suma = s.getSuma() + nph;
    double porcen1 = ((double) s.getSuma() / suma) * 100;
    double porcen2 = ((double) nph / suma) * 100;
    double random = Math.random() * 100 + 1;
    if (random <= porcen1) {
      return true;
    }
    return false;
  }

  /*
   * Metodo donde debido a los porcentajes correspondiaente, determinados por la
   * suma de vida de los soldados perteneciente a dicho ejercito, donde mediante
   * por un random se escogera el ganador
   */
  public void ganador(Ejercito n, Ejercito s) {
    int suma = s.getSuma() + n.getSuma();
    double porcen1 = ((double) n.getSuma() / suma) * 100;
    double porcen2 = ((double) s.getSuma() / suma) * 100;
    System.out.println("Ejercito 1: " + n.getReino() + "  " + n.getSuma() + "  "
        + porcen1 + "% de probabilidad de victoria");
    System.out.println("Ejercito 2: " + s.getReino() + "  " + s.getSuma() + "  "
        + porcen2 + "% de probabilidad de victoria");
    if (serAtacado(n, s)) {
      System.out.println("El ganador es el ejercito 1 de: " + n.getReino() + " .Ya que al generar los\n" +
          " porcentajes de probabilidad de victoria basada en los niveles de\n" +
          " vida de sus soldados y aplicando un experimento aleatorio salió\n" +
          " vencedor. (Aleatorio generado: " + porcen1 + ")");
    } else {
      System.out.println("El ganador es el ejercito 2 de: " + s.getReino() + " .Ya que al generar los\n" +
          " porcentajes de probabilidad de victoria basada en los niveles de\n" +
          " vida de sus soldados y aplicando un experimento aleatorio salió\n" +
          " vencedor. (Aleatorio generado: " + porcen2 + ")");
    }
  }

  // Metodo que retornara los datos del mapa
  public String toString() {
    return "Tipo de Terreno: " + tipoMapa;
  }
}
