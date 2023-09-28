import java.util.*;
class VideoJuego2{
  public static void main(String[] args){
    Soldado[] soldados = new Soldado[11];
    String nomb;
    int fil, punt, col;
    String[][] posicion = new String[11][11];
    int[][] posiciones = new int[11][11];
    for(int i = 1; i < soldados.length; i++){
      nomb = "Soldado " + i;
      punt = (int)(Math.random()*5)+1;
      fil = (int)(Math.random()*10)+1;
      col = (int)(Math.random()*10)+1;
      int x = fil;
      int y = col;
      while(posiciones[x][y] != 0){
        fil = (int)(Math.random()*10)+1;
        col = (int)(Math.random()*10)+1;
        x = fil;
        y = col;
      }
      posiciones[x][y] = 1;
      soldados[i] = new Soldado();
      soldados[i].setNombre(nomb);
      soldados[i].setPuntosDeVida(punt);
      soldados[i].setFila(fil);
      soldados[i].setColumna(col);
    }
    mostrarNaves(soldados, posicion);
    System.out.println("SOLDADO CON MAYOR VIDA: ");
    int d = mayorVida(soldados);
    System.out.println(soldados[d].getNombre()+"\nPuntos de Vida: "+soldados[d].getPuntosDeVida()+
                        "\nFila: "+soldados[d].getFila()+"\nColumna: "+soldados[d].getColumna());
    System.out.println("-------------------------");
    System.out.println("Promedio de puntos de todos los soldados creados: " +
                      promedioPuntosDeVida(soldados));
    System.out.println("Nivel de vida del Ejercito: "+nivelDeVida(soldados));
    System.out.println("DATOS DE LOS SOLDADOS: ");
    System.out.println("------------------------");
    imprimir1(soldados);
    System.out.println();
    System.out.println("RANKING: ");
    ranking(soldados);
    
  }
  public static void mostrarNaves(Soldado[] soldados, String[][] posicion){
    inicializar(posicion);
    for(int i = 1; i < posicion.length; i++){
      int fila = soldados[i].getFila();
      int columna = soldados[i].getColumna();
      posicion[fila][columna] = "*";
    }
    imprimir(posicion);
  }
  public static void inicializar(String[][] posicion){
    for(int i = 0; i < posicion.length; i++){
      for(int k = 0; k < posicion.length; k++){
        posicion[i][k] = "-";
      }
    }
  }
  public static void imprimir(String[][] posicion){
    System.out.println("    A  B  C  D  E  F  G  H  I  J");
    for(int i = 1; i < posicion.length; i++){
      if(i == posicion.length-1){
        System.out.print(i + ": ");
      } else {
        System.out.print(" " + i + ": ");
      }
      for(int k = 1; k < posicion.length; k++){
        System.out.print(posicion[i][k]+ "  ");
      }
      System.out.println();
    }
  }
  public static int mayorVida(Soldado[] soldados){
    int mayor = soldados[1].getPuntosDeVida();
    int c  = 1;
    for(int i = 1; i < soldados.length; i++){
      if(soldados[i].getPuntosDeVida() > mayor){
        mayor = soldados[i].getPuntosDeVida();
        c = i;
      }
    }
    return c;
  }
  public static double promedioPuntosDeVida(Soldado[] soldados){
    int suma = 0;
    int c = 0;
    for(int i = 1; i < soldados.length; i++){
      suma += soldados[i].getPuntosDeVida();
      c++;
    }
    double promedio = (double)suma/c;
    return promedio;
  }
  public static int nivelDeVida(Soldado[] soldados){
    int suma = 0;
    for(int i = 1; i < soldados.length; i++){
      suma += soldados[i].getPuntosDeVida();
    }
    return suma;
  }
  public static void imprimir1(Soldado[] soldados){
    for(int i = 1; i < soldados.length; i++){
      System.out.println(soldados[i].getNombre()+"\nPuntos de Vida: "+soldados[i].getPuntosDeVida()+
                        "\nFila: "+soldados[i].getFila()+"\nColumna: "+soldados[i].getColumna());
      System.out.println("------------------------");
    }
  }
  public static void ordenPorBurbuja(Soldado[] soldados){
    for(int i = 0; i < soldados.length-1; i++){
      for(int k = 1; k <soldados.length-1-i; k++){
        Soldado aux1 = soldados[k];
        if(soldados[k].getPuntosDeVida() > soldados[k+1].getPuntosDeVida()){
          soldados[k] = soldados[k+1];
          soldados[k+1] = aux1;
        }
      }
    }
  }
  public static void ranking(Soldado[] soldados){
    //ordenPorBurbuja(soldados);
    ordenarPorPuntosSeleccion(soldados);
    int n = soldados.length-1;
    for(int i = 1; i < soldados.length/2; i++){
      Soldado aux1 = soldados[i];
      soldados[i] = soldados[n];
      soldados[n] = aux1;
      n--;
    }
    imprimir1(soldados);
  }
  public static void ordenarPorPuntosSeleccion(Soldado[] soldados){
    for(int i = 1; i < soldados.length-1; i++){
      int c = i;
      for(int k = i+1; k < soldados.length; k++){
        if(soldados[k].getPuntosDeVida() < soldados[c].getPuntosDeVida()){
          c = k;
        }
      }
      Soldado aux1 = soldados[i];
      soldados[i] = soldados[c];
      soldados[c] = aux1;
      //System.out.println((i)+".-");
      //imprimir(auxiliar);
    }
  }
}