import java.util.ArrayList;

public class Soldado {
  private String nombre;
  private int nivelAtaque;
  private int nivelDefensa;
  private int puntosDeVida;

  // CONSTRUCTORES
  public Soldado() {
    this("Soldado", 1, 0, 0);
  }

  public Soldado(String name, int puntosVida) {
    this(name, puntosVida, 1, 1);
  }

  public Soldado(String name, int puntosVida, int nivelA) {
    this(name, puntosVida, nivelA, 1);
  }

  public Soldado(String name, int puntosVida, int nivelA, int nivelD) {
    setNombre(name);
    setPuntosDeVida(puntosVida);
    setNivelAtaque(nivelA);
    setNivelDefensa(nivelD);
  }

  // Metodos Set
  public void setNombre(String n) {
    nombre = n;
  }

  public void setPuntosDeVida(int pH) {
    puntosDeVida = pH;
  }

  public void setNivelAtaque(int nivelA) {
    nivelAtaque = nivelA;
  }

  public void setNivelDefensa(int nivelD) {
    nivelDefensa = nivelD;
  }

  // Metodos Get
  public String getNombre() {
    return nombre;
  }

  public int getPuntosDeVida() {
    return puntosDeVida;
  }

  public int getNivelAtaque() {
    return nivelAtaque;
  }

  public int getNivelDefensa() {
    return nivelDefensa;
  }

  /*
   * En este metodo se imprimira todos los datos, return un string con ello
   */
  public String toString() {
    return nombre + " " + puntosDeVida + " / nA-nD: " + nivelAtaque + "-" + nivelDefensa;
  }
}