import java.util.ArrayList;

public class Ejercito {
  private ArrayList<Soldado> misSoldados = new ArrayList<>();
  private int soldadosRandom;
  private String reino;
  private String simbolo;
  private int fila;
  private int columna;
  private int sumaVida = 0;

  // Constructores
  public Ejercito() {
    this(1);
  }

  public Ejercito(int number) {
    nombreReino(number);
    soldadosRandom = (int) (Math.random() * 10) + 1;
    crearSoldados(soldadosRandom);
    sumarVidas();
  }

  // Metodos set
  public void setFila(int f) {
    fila = f;
  }

  public void setColumna(int c) {
    columna = c;
  }

  // Metodo donde por un random se pondra un reino y su respectivo simbolo
  // representativo
  public void nombreReino(int n) {
    switch (n) {
      case 1:
        reino = "Inglaterra";
        simbolo = "+";
        break;
      case 2:
        reino = "Francia";
        simbolo = "*";
        break;
      case 3:
        reino = "Castilla-Aragon";
        simbolo = "/";
        break;
      case 4:
        reino = "Moros";
        simbolo = "%";
        break;
      case 5:
        reino = "Sacro imperio Romano-Germanico";
        simbolo = "&";
        break;
    }
  }

  // Metodos get
  public String getReino() {
    return reino;
  }

  public String getSimbolo() {
    return simbolo;
  }

  public int getSuma() {
    return sumaVida;
  }

  // Metodo que aumentara la vida en un punto, depende de algunos metodos
  // definidas en la clase Mapa
  public void beneficio() {
    for (Soldado soldadito : misSoldados) {
      int ph = soldadito.getPuntosDeVida();
      soldadito.setPuntosDeVida(ph + 1);
    }
  }

  /*
   * Metodo que dara datos random en la crecion de cada soldado, inicializando los
   * ejercitos
   */
  public void crearSoldados(int numeroRandom) {
    for (int i = 0; i < numeroRandom; i++) {
      String name = "Soldado EX" + (i + 1);
      int nA = (int) (Math.random() * 5) + 1;
      int nD = (int) (Math.random() * 5) + 1;
      int ph = (int) (Math.random() * 5) + 1;
      Soldado auxiliar = new Soldado(name, nA, nD, ph);
      misSoldados.add(auxiliar);
    }
  }

  // Metodo que convertira un numero en caracter, un intercambio, debido a que el
  // numero sirve para jugar con los indices del tablero
  public char convertirC(int columna) {
    switch (columna) {
      case 0:
        return 'A';
      case 1:
        return 'B';
      case 2:
        return 'C';
      case 3:
        return 'D';
      case 4:
        return 'E';
      case 5:
        return 'F';
      case 6:
        return 'G';
      case 7:
        return 'H';
      case 8:
        return 'I';
      case 9:
        return 'J';
    }
    return 'L';
  }

  /*
   * Metodo donde se sumaran las vidas de todos los soldados creados
   */
  public void sumarVidas() {
    for (Soldado auxiliar : misSoldados) {
      sumaVida += auxiliar.getPuntosDeVida();
    }
  }

  // Metodo que mostrara todos los datos
  public String toString() {
    String concant = "";
    for (Soldado auxiliar : misSoldados) {
      concant += auxiliar + "\n";
    }
    return "Ejercito: " + reino + "  /  Fila: " + (fila + 1) + "  /  Columna: " + convertirC(columna) + "\n" + concant;
  }
}
