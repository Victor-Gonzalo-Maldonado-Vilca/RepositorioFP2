import java.util.*;
class DemoBatalla {
  public static void main(String[] args){
    Nave[] misNaves = new Nave[11];
    Nave[] vacio = new Nave[11];
    Nave[] auxiliar = new Nave[11];
    int[][] posiciones = new int[11][11];
    Scanner sc = new Scanner(System.in);
    String[][] posicion = new String[11][11];
    String nomb, col;
    int fil, punt;
    boolean est;
    for(int i = 1; i < misNaves.length; i++){
      System.out.println("Nave " + (i));
      System.out.print("Nombre: ");
      nomb = sc.next();
      nomb = nomb.toLowerCase();
      System.out.print("Fila: ");
      fil = sc.nextInt();
      while((fil >= 11) || (fil == 0)){
        System.out.print("Fila: ");
        fil = sc.nextInt();
      }
      System.out.print("Columna: ");
      col = sc.next();
      col = col.toUpperCase();
      String valides = "ABCDEFGHIJ";
      while((valides.indexOf(col) == -1) || (col.length() != 1)){
        System.out.print("Columna: ");
        col = sc.next();
        col = col.toUpperCase();
      }
      int x = fil;
      int y = convertir(col);
      while(posiciones[x][y] != 0){
        System.out.print("Fila: ");
        fil = sc.nextInt();
        while((fil >= 11) || (fil == 0)){
          System.out.print("Fila: ");
          fil = sc.nextInt();
        }
        System.out.print("Columna: ");
        col = sc.next();
        col = col.toUpperCase();
        while((valides.indexOf(col) == -1) || (col.length() != 1)){
          System.out.print("Columna: ");
          col = sc.next();
          col = col.toUpperCase();
        }
        x = fil;
        y = convertir(col);
      }
      posiciones[x][y] = 1;
      System.out.print("Estado: ");
      est = sc.nextBoolean();
      System.out.print("Puntos: ");
      punt = sc.nextInt();
      misNaves[i] = new Nave();
      misNaves[i].setNombre(nomb);
      misNaves[i].setFila(fil);
      misNaves[i].setColumna(col);
      misNaves[i].setEstado(est);
      misNaves[i].setPuntos(punt);
      System.out.println("----------------------------");
    }
    System.out.println("\nNaves creadas:");
    mostrarNaves(misNaves, posicion);
    System.out.print("Ingrese nombre de la nave: ");
    String nombre1 = sc.next();
    mostrarPorNombre(misNaves, posicion, nombre1);
    System.out.print("Ingrese puntos: ");
    int puntos1 = sc.nextInt();
    mostrarPorPuntos(misNaves, posicion, puntos1);
    Nave mayor = mostrarMayorPuntos(misNaves);
    int n = posiMayorPuntos(misNaves);
    System.out.println("\nNave con mayor número de puntos: Nave " + n + 
                    "\n-Nombre: " + mayor.getNombre() + "\n-Fila: "+ mayor.getFila()+
                    "\n-Columna: " + mayor.getColumna() + "\n-Estado: " + mayor.getEstado()+
                    "\n-Puntos: " + mayor.getPuntos()); 
    desordenarArreglo(misNaves, vacio, auxiliar);
  }
  public static void mostrarNaves(Nave[] flota, String[][] posicion){
    inicializar(posicion);
    for(int i = 1; i < posicion.length; i++){
      int fila = flota[i].getFila();
      int columna = convertir(flota[i].getColumna());
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
  public static int convertir(String n){
    switch(n) {
      case "A":
        return 1;
      case "B":
        return 2;
      case "C":
        return 3;
      case "D":
        return 4;
      case "E":
        return 5;
      case "F":
        return 6;
      case "G":
        return 7;
      case "H":
        return 8;
      case "I":
        return 9;
      case "J":
        return 10;
      default:
        return -1;
    }
  }
  public static String verificacionColumnas(String col){
    Scanner sc = new Scanner(System.in);
    String valides = "ABCDEFGHIJ";
    while(valides.indexOf(col) == -1){
      col = sc.next();
    }
    return col;
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
  public static void mostrarPorNombre(Nave[] flota, String[][] posicion, String nombre){
    inicializar(posicion);
    for(int i = 1; i < flota.length; i++){
      int fila = flota[i].getFila();
      int columna = convertir(flota[i].getColumna());
      if((flota[i].getNombre()).equals(nombre)){
        posicion[fila][columna] = "*";
      }
    }
    imprimir(posicion);
  }
  public static void mostrarPorPuntos(Nave[] flota, String[][] posicion, int puntos1){
    inicializar(posicion);
    for(int i = 1; i < flota.length; i++){
      int fila = flota[i].getFila();
      int columna = convertir(flota[i].getColumna());
      if((flota[i].getPuntos()) <= puntos1){
        posicion[fila][columna] = "*";
      }
    }
    imprimir(posicion);
  }
  public static Nave mostrarMayorPuntos(Nave[] flota){
    Nave mayor = flota[1];
    for(int i = 2; i < flota.length; i++){
      if((flota[i].getPuntos()) > (mayor.getPuntos())){
        mayor = flota[i];
      }
    }
    return mayor; 
  }
  public static int posiMayorPuntos(Nave[] flota){
    Nave mayor = flota[1];
    int c = 1;
    for(int i = 2; i < flota.length; i++){
      if((flota[i].getPuntos()) > (mayor.getPuntos())){
        c = i;
        mayor = flota[i];
      }
    }
    return c;   
  }
  public static void desordenarArreglo(Nave[] flota, Nave[] vacio, Nave[] auxiliar){
    copiar(flota, auxiliar);
    for(int i = 1; i < flota.length; i++){
      int n = (int)(Math.random()*10)+1;
      while ((flota[n].getNombre()) == "-"){
        n = (int)(Math.random()*10)+1;
      }
      vacio[i] = auxiliar[n]; 
      flota[n].setNombre("-");
    }
    imprimir1(vacio);
  }
  public static void imprimir1(Nave[] vacio){
    System.out.println("Nuevo orden del arreglo: ");
    for(int i = 1; i < vacio.length; i++){
      System.out.println("Nave " + i+".-");
      System.out.print("- Nombre: " + vacio[i].getNombre()+
                      "\n- Fila: " + vacio[i].getFila()+"\n- Columna: " + vacio[i].getColumna()+
                      "\n- Estado: "+ vacio[i].getEstado()+"\n- Puntos: " +vacio[i].getPuntos());
      System.out.println();
    }
  }
  public static void copiar(Nave[] flota, Nave[] auxiliar){
    for(int i = 1; i < flota.length; i++){
      Nave flot = flota[i];
      Nave copia = new Nave();
      copia.setNombre(flot.getNombre());
      copia.setFila(flot.getFila());
      copia.setColumna(flot.getColumna());
      copia.setEstado(flot.getEstado());
      copia.setPuntos(flot.getPuntos());
      auxiliar[i] = copia;
    }
  }
}
