import java.util.ArrayList;

public class Ejercito {
  private ArrayList<Soldado> misSoldados = new ArrayList<>();
  private int soldadosRandom = (int) (Math.random() * 10) + 1;
  private String reino;
  private String simbolo;
  private int sumaVida = 0;

  // Constructores
  public Ejercito() {
    this(1, "X1");
  }

  public Ejercito(int number, String X) {
    nombreReino(number);
    crearSoldados(soldadosRandom, X);
    sumarVidas();
  }

  /*
   * En este metodo mediante un random se le asignara al ejercito el reino y
   * simbolo representativo correspondiente
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

  public int getSuma() {
    return sumaVida;
  }

  /*
   * En este metodo se crearan los soldados mediante datos aleatorios, ademas se
   * agregara mediante un random el tipo de soldado
   */
  public void crearSoldados(int numeroRandom, String X) {
    int e = 0;
    int a = 0;
    int c = 0;
    int l = 0;
    for (int i = 0; i < numeroRandom; i++) {
      int tipoSoldado = (int) (Math.random() * 4) + 1;
      int ph;
      Soldado auxiliar = null;
      String representacion = "";
      switch (tipoSoldado) {
        case 1:
          ph = (int) (Math.random() * 3) + 8;
          auxiliar = new Espadachin("Espadachin " + e + X, 10, 8, ph);
          e++;
          representacion = simbolo + "E" + auxiliar.getPuntosDeVida();
          break;
        case 2:
          ph = (int) (Math.random() * 3) + 3;
          auxiliar = new Arquero("Arquero " + a + X, 7, 3, ph);
          a++;
          representacion = simbolo + "A" + auxiliar.getPuntosDeVida();
          break;
        case 3:
          ph = (int) (Math.random() * 3) + 10;
          auxiliar = new Caballero("Caballero " + c + X, 13, 7, ph);
          c++;
          representacion = simbolo + "C" + auxiliar.getPuntosDeVida();
          break;
        case 4:
          ph = (int) (Math.random() * 4) + 5;
          auxiliar = new Lancero("Lancero " + l + X, 5, 10, ph);
          l++;
          representacion = simbolo + "L" + auxiliar.getPuntosDeVida();
          break;
      }
      auxiliar.serRepresentacion(representacion);
      misSoldados.add(auxiliar);
    }
  }

  // Metodo get , retornara la lista de soldados
  public ArrayList<Soldado> getSoldadosList() {
    return misSoldados;
  }

  // Metodo que sumara los puntos de vida de todos los soldados de la lista
  public void sumarVidas() {
    for (Soldado auxiliar : misSoldados) {
      sumaVida += auxiliar.getPuntosDeVida();
    }
  }

  // Metodo que retornara los datos del ejercito y de los soldados
  public String toString() {
    String concant = "";
    for (Soldado auxiliar : misSoldados) {
      concant += auxiliar + "\n";
    }
    return "Ejercito: " + reino + "\n" + concant;
  }
}
