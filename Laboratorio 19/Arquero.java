public class Arquero extends Soldado {
  public int numeroF;

  // Constructor
  public Arquero(String name, int nA, int nD, int ph) {
    super(name, nA, nD, ph);
    generarFlechas();
  }

  /*
   * Metodo donde se genera las flechas mediante un random
   */
  public void generarFlechas() {
    numeroF = (int) (Math.random() * 5) + 1;
  }

  /*
   * Metodo que permite el lanzamiento de flechas, restandole uno cada vez que se
   * llame al metodo
   */
  public void lanzarFlechas() {
    numeroF -= 1;
    if (numeroF == 0) {
      setNivelAtaque(0);
      System.out.println("No hay mas flechas");
    } else if (numeroF < 0) {
      numeroF = 0;
    }
  }

  /*
   * Metodo sobreescrito , retornara los datos del Arquero
   */
  public String toString() {
    return getNombre() + "  /  " + getPuntosDeVida() + "  /  " + convertirC(getColumna()) + (getFila() + 1)
        + "  /   NA-ND: " + getNivelAtaque() + "-" + getNivelDefensa() + "  /  N°flechas: " + numeroF;
  }
}