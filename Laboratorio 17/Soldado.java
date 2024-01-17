public class Soldado {
  private String nombre;
  private int nivelAtaque;
  private int nivelDefensa;
  private int puntosDeVida;

  // CONSTRUCTORES
  public Soldado(String n, int nA) {
    this(n, nA, 1, 1);
  }

  public Soldado(String n, int nA, int nD) {
    this(n, nA, nD, 1);
  }

  public Soldado(String n, int nA, int nD, int ph) {
    setNombre(n);
    setNivelAtaque(nA);
    setNivelDefensa(nD);
    setPuntosDeVida(ph);
  }

  // Metodos set
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setNivelAtaque(int nivelA) {
    nivelAtaque = nivelA;
  }

  public void setNivelDefensa(int nivelD) {
    nivelDefensa = nivelD;
  }

  public void setPuntosDeVida(int puntosDeVida) {
    this.puntosDeVida = puntosDeVida;
  }

  // Metodos get
  public int getNivelAtaque() {
    return nivelAtaque;
  }

  public int getPuntosDeVida() {
    return puntosDeVida;
  }

  // Actualizacion de vida
  public void vidaActual(Soldado c) {
    int a = c.getNivelAtaque();
    int resta = nivelDefensa - a;
    if (resta < 0) {
      puntosDeVida += resta;
      if (puntosDeVida <= 0) {
        puntosDeVida = 0;
      }
    }
  }

  // Verificacion del Estado Soldado
  public String vive() {
    if (puntosDeVida == 0) {
      return "Muerto";
    }
    return "Vivo";
  }

  // Metodo donde se imprimiran todos los datos correspondientes
  public String toString() {
    return nombre + " " + puntosDeVida + " / Estado: " + vive() + " / NA-ND: "
        + nivelAtaque + "-" + nivelDefensa;
  }
}
