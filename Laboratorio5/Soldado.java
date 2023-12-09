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
  public String getNombre(){
    return nombre;
  }
  public int getFila(){
    return fila;
  }
  public int getColumna(){
    return columna;
  }
  public int getPuntosDeVida(){
    return puntosDeVida;
  }
}