public class Caballero extends Soldado {
  private String estado;
  private String arma;

  // Constructor
  public Caballero(String name, int nA, int nD, int ph) {
    super(name, nA, nD, ph);
    estadoCaballero();
  }

  /*
   * Metodo donde mediante un random se asignara e estado del caballero y su arma,
   * donde se beneficiara los datos correspondientes
   */
  public void estadoCaballero() {
    int random = (int) (Math.random() * 2) + 1;
    switch (random) {
      case 1:
        estado = "desmontar";
        arma = "espada";
        setNivelDefensa(getNivelDefensa() + 2);
        break;
      case 2:
        estado = "montar";
        arma = "lanza";
        setNivelAtaque(getNivelAtaque() + 3);
        break;
    }
  }

  /*
   * Metodo sobreescrito , retornara los datos del Caballero
   */
  public String toString() {
    return getNombre() + "  /  " + getPuntosDeVida() + "  /  " + convertirC(getColumna()) + (getFila() + 1)
        + "  /  NA-ND: " + getNivelAtaque() + "-" + getNivelDefensa() + "  /  estado: " + estado + "  /  arma: " + arma;
  }
}
