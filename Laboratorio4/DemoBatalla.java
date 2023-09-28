import java.util.*;
class DemoBatalla {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Nave[] misNaves = new Nave[11];
    Nave[] auxiliar = new Nave[11];
    int[][] posiciones = new int[11][11];
    String[][] posicion = new String[11][11];
    String nomb, col, na;
    int fil, punt;
    boolean est;
    for(int i = 1; i < misNaves.length; i++){
      na = "Nave: " + i;
      System.out.println(na);
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
      misNaves[i].setNave(na);
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
    sc.nextLine();
    mostrarPorPuntos(misNaves, posicion, puntos1);
    Nave mayor = mostrarMayorPuntos(misNaves);
    int n = posiMayorPuntos(misNaves);
    System.out.println("\nNave con mayor número de puntos: " + mayor.getNave()+ 
                    "\n-Nombre: " + mayor.getNombre() + "\n-Fila: "+ mayor.getFila()+
                    "\n-Columna: " + mayor.getColumna() + "\n-Estado: " + mayor.getEstado()+
                    "\n-Puntos: " + mayor.getPuntos()); 
    System.out.println("Búsqueda Lineal: ");
    System.out.print("Ingrese el Nombre que se quiere encontrar: ");
    String valor = sc.nextLine();
    int s = busquedaLinealNombre(misNaves, valor);
    if(s != -1){
      System.out.print("La Nave si se encuentra dentro" +
                      " de mis Naves; es la " + misNaves[s].getNave());
      System.out.print("\n-Nombre: " + misNaves[s].getNombre() + "\n-Fila: "+ misNaves[s].getFila()+
                    "\n-Columna: " + misNaves[s].getColumna() + "\n-Estado: " + misNaves[s].getEstado()+
                    "\n-Puntos: " + misNaves[s].getPuntos()); 
    }else{
      System.out.print("La Nave no se encuentra" +
                      " dentro de mis Naves");
    }
    System.out.println();
    copiar(misNaves, auxiliar);
    System.out.println("Ordenamiento Burbuja Puntos: ");
    ordenPorPuntosBurbuja(auxiliar);
    copiar(misNaves, auxiliar);
    System.out.println("Ordenamiento Burbuja Nombre: ");
    ordenPorNombreBurbuja(auxiliar);
    System.out.println("Búsqueda Binaria: ");
    System.out.print("Ingrese el Nombre que se quiere encontrar: ");
    String valor1 = sc.nextLine(); 
    int s1 = busquedaBinariaPorNombre(misNaves, valor1);
    if(s1 != -1){
      System.out.print("El Nombre de la Nave si se encuentra dentro de "+
                      "mis Naves; es la " + misNaves[s1].getNave());
      System.out.print("\n-Nombre: " + misNaves[s1].getNombre() + "\n-Fila: "+ misNaves[s1].getFila()+
                    "\n-Columna: " + misNaves[s1].getColumna() + "\n-Estado: " + misNaves[s1].getEstado()+
                    "\n-Puntos: " + misNaves[s1].getPuntos()); ;
    }else{
      System.out.print("El Nombre no se encuentra dentro de "+
                      "mis Naves");
    }
    System.out.println();
    copiar(misNaves, auxiliar);
    System.out.println("Ordenamiento Por Seleccion Puntos: ");
    ordenarPorPuntosSeleccion(auxiliar);
    System.out.println("Ordenamiento Por Seleccion Nombre: ");
    ordenarPorNombreSeleccion(auxiliar);
    System.out.println("Ordenamiento Por Inserccion Puntos: ");
    ordenarPorPuntosInserccion(auxiliar);
    System.out.println("Ordenamiento Por Inserccion Nombre: ");
    ordenarPorNombreInserccion(auxiliar);
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
  public static int busquedaLinealNombre(Nave[] flota, String s){
    for(int i = 1; i < flota.length; i++){
      if((flota[i].getNombre()).equals(s)){
        return i;
      }
    }
    return -1;
  }
  public static void copiar(Nave[] flota, Nave[] auxiliar){
    for(int i = 1; i < flota.length; i++){
      Nave flot = flota[i];
      Nave copia = new Nave();
      copia.setNave(flot.getNave());
      copia.setNombre(flot.getNombre());
      copia.setFila(flot.getFila());
      copia.setColumna(flot.getColumna());
      copia.setEstado(flot.getEstado());
      copia.setPuntos(flot.getPuntos());
      auxiliar[i] = copia;
    }
  }
  public static void ordenPorPuntosBurbuja(Nave[] auxiliar){
    for(int i = 0; i < auxiliar.length-1; i++){
      for(int k = 1; k <auxiliar.length-1-i; k++){
        Nave aux1 = auxiliar[k];
        if(auxiliar[k].getPuntos() > auxiliar[k+1].getPuntos()){
          auxiliar[k] = auxiliar[k+1];
          auxiliar[k+1] = aux1;
        }
      }
      //System.out.println((i+1)+".-");
      //imprimir(auxiliar);
    }
    imprimir(auxiliar);
  }
  public static void imprimir(Nave[] auxiliar){
    for(int i = 1; i < auxiliar.length; i++){
      System.out.print(auxiliar[i].getNave()+"\n-Nombre: " + auxiliar[i].getNombre() + "\n-Fila: "+ auxiliar[i].getFila()+
                    "\n-Columna: " + auxiliar[i].getColumna() + "\n-Estado: " + auxiliar[i].getEstado()+
                    "\n-Puntos: " + auxiliar[i].getPuntos()+"\n");
    }
    System.out.println();
    System.out.println("-------------------------");
  }
  public static void ordenPorNombreBurbuja(Nave[] auxiliar){
    for(int i = 0; i < auxiliar.length-1; i++){
      for(int k = 1; k <auxiliar.length-1-i; k++){
        Nave aux1 = auxiliar[k];
        if(auxiliar[k].getNombre().compareTo(auxiliar[k+1].getNombre())>0){
          auxiliar[k] = auxiliar[k+1];
          auxiliar[k+1] = aux1;
        }
      }
      //System.out.println((i+1)+".-");
      //imprimir(auxiliar);
    }
    imprimir(auxiliar);
  }
  public static int busquedaBinariaPorNombre(Nave[] flota, String valor){
    int baja = 1;
    int alta = flota.length-1;
    while(baja <= alta){
      int media = (int)((baja+alta)/2);
      int n = valor.compareTo(flota[media].getNombre());
      if(n == 0){
        return media;
      }else if(n < 0){
        alta = media-1;
      }else{
        baja = media+1;
      }
    }
    return -1;
  }
  public static void ordenarPorPuntosSeleccion(Nave[] auxiliar){
    for(int i = 1; i < auxiliar.length-1; i++){
      int c = i;
      for(int k = i+1; k < auxiliar.length; k++){
        if(auxiliar[k].getPuntos() < auxiliar[c].getPuntos()){
          c = k;
        }
      }
      Nave aux1 = auxiliar[i];
      auxiliar[i] = auxiliar[c];
      auxiliar[c] = aux1;
      //System.out.println((i)+".-");
      //imprimir(auxiliar);
    }
    imprimir(auxiliar);
  }
  public static void ordenarPorNombreSeleccion(Nave[] auxiliar){
    for(int i = 1; i < auxiliar.length-1; i++){
      int c = i;
      for(int k = i+1; k < auxiliar.length; k++){
        if(auxiliar[k].getNombre().compareTo(auxiliar[c].getNombre())< 0){
          c = k;
        }
      }
      Nave aux1 = auxiliar[i];
      auxiliar[i] = auxiliar[c];
      auxiliar[c] = aux1;
      //System.out.println((i)+".-");
      //imprimir(auxiliar);
    }
    imprimir(auxiliar);
  }
  public static void ordenarPorPuntosInserccion(Nave[] auxiliar){
    for(int i = 2; i < auxiliar.length; i++){
      int k = i-1;
      Nave aux1 = auxiliar[i]; 
      while(k > 0 && auxiliar[k].getPuntos() > aux1.getPuntos()){
        auxiliar[k+1] = auxiliar[k];
        k--;
      }
      auxiliar[k+1] = aux1;
      //System.out.println(i+".-");
      //imprimir(auxiliar);
    }
    imprimir(auxiliar);
  }
  public static void ordenarPorNombreInserccion(Nave[] auxiliar){
    for(int i = 2; i < auxiliar.length; i++){
      int k = i-1;
      Nave aux1 = auxiliar[i];
      while(k > 0 && auxiliar[k].getNombre().compareTo(aux1.getNombre()) > 0){
        auxiliar[k+1] = auxiliar[k];
        k--;
      }
      auxiliar[k+1] = aux1;
      //System.out.println(i+".-");
      //imprimir(auxiliar);
    }
    imprimir(auxiliar);
  }
}
