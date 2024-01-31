public class Espadachin extends Soldado {
  private int longitudEspada;
  private String estado;

  // Constructores
  Espadachin(String name, int nA, int nD, int ph) {
    super(name, nA, nD, ph);
    estadoEspadachin();
  }

  /*
   * Este metodo asignara mediante un random que estado tendra el espadachin si de
   * ataque o defensa donde los atributos segun ello se beneficiara
   */
  public void estadoEspadachin() {
    int random = (int) (Math.random() * 2) + 1;
    switch (random) {
      case 1:
        espada();
        break;
      case 2:
        accionDefensa();
        longitudEspada = 1;
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
    longitudEspada = random;
    setNivelAtaque(getNivelAtaque() * 2 + 1);
  }

  /*
   * Metodo donde la defensa aumentara si se encuentra en ese estado
   */
  public void accionDefensa() {
    estado = "Defensa";
    setNivelDefensa(getNivelDefensa() * 2 + 1);
  }

  /*
   * Metodo sobreescrito , retornara los datos del espadachin
   */
  public String toString() {
    return "Soldado E" + "  /  " + getPuntosDeVida() + "  /  "
        + "  /  NA-ND: " + getNivelAtaque() + "-" + getNivelDefensa() + "  /  L.espada: " + longitudEspada
        + "  /  estado: " + estado;
  }
}
