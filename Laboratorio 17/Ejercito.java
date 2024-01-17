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

  /*
   * Mediante un random en este metodo se asignara un reino y simbolo
   * representativo al ejercito
   */
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

  public int getFila() {
    return fila;
  }

  public int getColumna() {
    return columna;
  }

  public int getSuma() {
    return sumaVida;
  }

  public void beneficio() {
    for (Soldado soldadito : misSoldados) {
      int ph = soldadito.getPuntosDeVida();
      soldadito.setPuntosDeVida(ph + 1);
    }
  }

  /*
   * Se crearan soldados con datos random, estos se añadiran al arraylist
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

  // Metodo que convertira un entero, en caracter para una mejor representacion
  // grafica
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
   * En este metodo se sumara las vidas de los soldados
   */
  public void sumarVidas() {
    for (Soldado auxiliar : misSoldados) {
      sumaVida += auxiliar.getPuntosDeVida();
    }
  }

  // En este metodo se jugara con los indices del tablero para lograr un
  // movimietno
  public void movimiento(int mov) {
    switch (mov) {
      case 1:
        fila -= 1;
        columna -= 1;
        break;
      case 2:
        fila -= 1;
        break;
      case 3:
        fila -= 1;
        columna += 1;
        break;
      case 4:
        columna += 1;
        break;
      case 5:
        fila += 1;
        columna += 1;
        break;
      case 6:
        fila += 1;
        break;
      case 7:
        fila += 1;
        columna -= 1;
        break;
      case 8:
        columna -= 1;
        break;
    }
  }

  /*
   * Este metodo usa porcentajes , luego mediante un random se determinara si tal
   * ejercito gano
   */
  public boolean serAtacado(Ejercito n) {
    int nph = n.getSuma();
    int suma = this.sumaVida + nph;
    double porcen1 = ((double) this.sumaVida / suma) * 100;
    double porcen2 = ((double) nph / suma) * 100;
    double random = Math.random() * 100 + 1;
    if (random <= porcen1) {
      return true;
    }
    return false;
  }

  // Metodo que aumentara la vida en un punto
  public void aumento() {
    for (Soldado auxiliar : misSoldados) {
      auxiliar.setPuntosDeVida(auxiliar.getPuntosDeVida() + 1);
    }
  }

  // Metodo que retornara los datos correspondientes
  public String toString() {
    String concant = "";
    for (Soldado auxiliar : misSoldados) {
      concant += auxiliar + "\n";
    }
    return "Ejercito: " + reino + "  /  Fila: " + (fila + 1) + "  /  Columna: " + convertirC(columna) + "\n" + concant;
  }
}
