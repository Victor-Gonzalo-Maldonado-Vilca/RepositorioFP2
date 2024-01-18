public class Soldado {
  private String nombre;
  private int nivelAtaque;
  private int nivelDefensa;
  private int puntosDeVida;
  private int fila;
  private int columna;
  private String representacion;

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

  public void setFila(int fila) {
    this.fila = fila;
  }

  public void setColumna(int columna) {
    this.columna = columna;
  }

  public void serRepresentacion(String representacion) {
    this.representacion = representacion;
  }

  // Metodos get
  public String getNombre() {
    return nombre;
  }

  public int getNivelAtaque() {
    return nivelAtaque;
  }

  public int getNivelDefensa() {
    return nivelDefensa;
  }

  public int getPuntosDeVida() {
    return puntosDeVida;
  }

  public int getFila() {
    return fila;
  }

  public int getColumna() {
    return columna;
  }

  public String getRepresentacion() {
    return representacion;
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

  // Metodo que intercambiara un entero a String
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

  // Verificacion del Estado Soldado
  public String vive() {
    if (puntosDeVida == 0) {
      return "Muerto";
    }
    return "Vivo";
  }

  // Metodo donde aumenta los puntos de vida en uno
  public void beneficio() {
    setPuntosDeVida(puntosDeVida + 1);
  }

  // Este metodo retornara los datos de dicho soldado
  public String toString() {
    return nombre + " " + puntosDeVida + " / Estado: " + vive() + " / NA-ND: "
        + nivelAtaque + "-" + nivelDefensa;
  }
}
