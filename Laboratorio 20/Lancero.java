public class Lancero extends Soldado {
  private int longitudLanza;
  private String estado;

  // Constructor
  public Lancero(String name, int nA, int nD, int ph) {
    super(name, nA, nD, ph);
    estadoLancero();
  }

  /*
   * Metodo donde mediante un random se asignara es estado del Lancero, donde se
   * beneficiara los datos correspondientes
   */
  public void estadoLancero() {
    int random = (int) (Math.random() * 2) + 1;
    switch (random) {
      case 1:
        espada();
        break;
      case 2:
        accionDefensa();
        longitudLanza = 1;
        break;
    }
  }

  /*
   * Metodo que determinara la longitud de la espada , donde mediante ello se
   * lograra aumentar el nivel de ataque correspondiente
   */
  public void espada() {
    estado = "Ataque";
    int random = (int) (Math.random() * 5) + 1;
    longitudLanza = random;
    setNivelAtaque(getNivelAtaque() * 2 + 1);
  }

  /*
   * Metodo donde la defensa aumentara si se encuentra en ese estado
   */
  public void accionDefensa() {
    estado = "schiltrom";
    setNivelDefensa(getNivelDefensa() + 1);
  }

  /*
   * Metodo sobreescrito , retornara los datos del Lancero
   */
  public String toString() {
    return getNombre() + "  /  " + getPuntosDeVida() + "  /  " + convertirC(getColumna()) + (getFila() + 1)
        + "  /  NA-ND: " + getNivelAtaque() + "-" + getNivelDefensa() + "  /  L.lanza: " + longitudLanza
        + "  /  estado: " + estado;
  }
}
