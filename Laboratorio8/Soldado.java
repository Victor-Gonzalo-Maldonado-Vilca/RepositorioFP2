public class Soldado {
  private String nombre;
  private int puntosDeVida;
  private int fila;
  private int columna;
  public void setNombre(String nombre){
    this.nombre = nombre;
  }
  public void setFila(int fila){
    this.fila = fila;
  }
  public void setColumna(int columna){
    this.columna = columna;
  }
  public void setPuntosDeVida(int puntosDeVida){
    this.puntosDeVida = puntosDeVida;
  }
  public char convertir(int columna){
    switch(columna){
      case 0: return 'A';
      case 1: return 'B';
      case 2: return 'C';
      case 3: return 'D';
      case 4: return 'E';
      case 5: return 'F';
      case 6: return 'G';
      case 7: return 'H';
      case 8: return 'I';
      case 9: return 'J';
    }
    return 'L';
  }
  public int getPuntosDeVida(){
    return puntosDeVida;
  }
  public String toString(){
    return nombre + " " + puntosDeVida + " "+ convertir(columna) + (fila + 1);
  }
}