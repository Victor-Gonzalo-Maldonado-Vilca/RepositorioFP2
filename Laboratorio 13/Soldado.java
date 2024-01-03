import java.util.ArrayList;

public class Soldado {
  private String nombre;
  private int nivelAtaque;
  private int nivelDefensa;
  private int actitud;
  private String actitud1;
  private boolean verificarConversion = false;
  private int velocidad;
  private int velocidadI;
  private int puntosDeVida;
  private int fila;
  private int columna;
  public static final int SOLDADOS = 10;
  private static int contadorSoldados = 0;;

  // CONSTRUCTORES
  public Soldado() {
    this(0, 0, 0, 0);
  }

  public Soldado(int actitud, int nivelA) {
    this(actitud, nivelA, 1, 1);
  }

  public Soldado(int actitud, int nivelA, int nivelD) {
    this(actitud, nivelA, nivelD, 1);
  }

  public Soldado(int actitud, int nivelA, int nivelD, int velocidad) {
    setActitud(actitud);
    setNivelAtaque(nivelA);
    velocidadI = velocidad;
    setNivelDefensa(nivelD);
    setVelocidad(velocidad);
    contadorSoldados++;
  }

  // Metodos Set
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setNivelAtaque(int nivelA) {
    nivelAtaque = nivelA;
  }

  public void setNivelDefensa(int nivelD) {
    nivelDefensa = nivelD;
  }

  public void setVelocidad(int velocidad) {
    this.velocidad = velocidad;
  }

  public void setActitud(int actitud) {
    this.actitud = actitud;
  }

  public void setFila(int fila) {
    this.fila = fila;
  }

  public void setColumna(int columna) {
    this.columna = columna;
  }

  public void setPuntosDeVida(int puntosDeVida) {
    this.puntosDeVida = puntosDeVida;
  }

  // Modificacion velocidad y actitud, depende de un random
  public String convertirA() {
    if (!verificarConversion) {
      switch (actitud) {
        case 0:
          velocidad = 0;
          actitud1 = "Defensiva";
          break;
        case 1:
          velocidad += 1;
          actitud1 = "Ofensiva";
          break;
        case 2:
          velocidad += 2;
          actitud1 = "Fuga";
          break;
        // Retroceder
        case 3:
          if (velocidad > 0) {
            velocidad = 0;
            actitud1 = "Defensiva";
          } else {
            velocidad -= 1;
            actitud1 = "Retroceder";
          }
          break;
        default:
          actitud1 = "error";
      }
      verificarConversion = true;
    }
    return actitud1;
  }

  // Metodos Get
  public String getNombre() {
    return nombre;
  }

  public int getPuntosDeVida() {
    return puntosDeVida;
  }

  public int getVelocidad() {
    return velocidad;
  }

  public int getNivelAtaque() {
    return nivelAtaque;
  }

  public int getNivelDefensa() {
    return nivelDefensa;
  }

  public int getFila() {
    return fila;
  }

  public int getColumna() {
    return columna;
  }

  public int getActitud() {
    return actitud;
  }

  // Actualizacion de vida despues del combate se usaran la defensa y el ataque
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

  /*
   * En este metodo se usara para convertir los numeros a los caracteres que
   * aparecen en la tabla
   */
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
   * En este metodo mediante el indice del tablero se ejerceran los movimientos
   * restando y sumando las filas y columnas
   */
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
   * Metodo donde se vera que soldado es el ganador en una batalla, se utilizara
   * porcentajes y mediante un numero random se determinara
   */
  public boolean serAtacado(Soldado n) {
    int nph = n.getPuntosDeVida();
    int suma = this.puntosDeVida + nph;
    double porcen1 = ((double) this.puntosDeVida / suma) * 100;
    double porcen2 = ((double) nph / suma) * 100;
    double random = Math.random() * 100 + 1;
    if (random <= porcen1) {
      return true;
    }
    return false;
  }

  /*
   * En este metodo se copiaran todos los datos de un soldado a otro
   */
  public Soldado copySoldado(Soldado n) {
    n = new Soldado(actitud, nivelAtaque, nivelDefensa, velocidadI);
    n.setNombre(nombre);
    n.setFila(fila);
    n.setColumna(columna);
    n.setPuntosDeVida(puntosDeVida);
    return n;
  }

  /*
   * En este metodo devolvera verdadero si todos los datos son iguales entre dos
   * soldados
   */
  public boolean equals(Soldado n) {
    return this.nombre.equals(n.getNombre()) &&
        this.actitud == n.getActitud() &&
        this.nivelAtaque == n.getNivelAtaque() &&
        this.puntosDeVida == n.getPuntosDeVida() &&
        this.nivelDefensa == n.getNivelDefensa() &&
        this.fila == n.getFila() &&
        this.columna == n.getColumna() &&
        this.velocidad == n.getVelocidad();
  }

  /*
   * Sumar los atributos de dos Soldados, estos son puntos de vida, nivel de
   * ataque y defensa, velocidad. Retornara un Soldado Suma
   */
  public Soldado sumar(Soldado n) {
    int pH = this.puntosDeVida + n.getPuntosDeVida();
    int nA = this.nivelAtaque + n.getNivelAtaque();
    int nD = this.nivelDefensa + n.getNivelDefensa();
    int v = this.velocidad + n.getVelocidad();
    int act = -1;
    Soldado suma = new Soldado(act, nA, nD, v);
    suma.setPuntosDeVida(pH);
    suma.setNombre("Soldado Suma");
    return suma;
  }

  // Retorna lo soldado generados
  public static int getContadorSoldado() {
    return contadorSoldados;
  }

  /*
   * Retorna el tamaño del arrayList simulando el conteo de los soldados por
   * ejercito
   */
  public static int soldadoEjercito(ArrayList<Soldado> ejercito) {
    return ejercito.size();
  }

  /*
   * En este metodo se imprimira todos los datos, return un string con ello
   */
  public String toString() {
    return nombre + " " + puntosDeVida + " " + convertirC(columna) + (fila + 1) + " Actitud: "
        + convertirA() + " / Velocidad: " + velocidad + " / Estado: " + vive() + " / NA-ND: "
        + nivelAtaque + "-" + nivelDefensa;
  }
}