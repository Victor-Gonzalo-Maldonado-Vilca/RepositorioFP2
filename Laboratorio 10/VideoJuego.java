import java.util.*;
class VideoJuego {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean continuar = true;
    while(continuar){
      //tablero
      String[][] tablero = new String[10][10];
      tablero(tablero);
      mostrarT(tablero);
      //Primer Ejercito - numero random
      byte n1 = (byte)(Math.random()*10 + 1);
      ArrayList<Soldado> ejercito1 = new ArrayList<>();
      //Segundo Ejercito - numero random
      byte n2 = (byte)(Math.random()*10 + 1);
      ArrayList<Soldado> ejercito2 = new ArrayList<>();
      //Inicializacion
      ejercito1(ejercito1, n1, tablero);
      ejercito2(ejercito2, n2, tablero);
      //Tablero
      System.out.println("TABLERO: ");
      mostrarT(tablero);
      //Mayor Vida
      System.out.println("Datos del Soldado con mayor vidad del Ejercito 1: ");
      Soldado mayor1 = mayorSoldado(ejercito1);
      System.out.println(mayor1.toString());
      System.out.println("Datos del Soldado con mayor vidad del Ejercito 2: ");
      Soldado mayor2 = mayorSoldado(ejercito2);
      System.out.println(mayor2.toString());
      //Promedio
      System.out.println("Promedio de puntos de vida del Ejercito 1: " + promedioSoldado(ejercito1));
      System.out.println("Promedio de puntos de vida del Ejercito 2: " + promedioSoldado(ejercito2));
      //Ejercitos-orden en el que fueron creados
      System.out.println("Soldados en orden a su creacion: ");
      System.out.println("Ejército 1:");
      mostrar(ejercito1);
      System.out.println("-----------------------");
      System.out.println("Ejército 2:");
      mostrar(ejercito2);
      //Vida Actual
      actualizarVida(ejercito1, ejercito2);
      System.out.println("------------------------------------------------------------------------");
      System.out.println("Soldados después del ataque: ");
      System.out.println("Ejército 1:");
      mostrar(ejercito1);
      System.out.println("-----------------------");
      System.out.println("Ejército 2:");
      mostrar(ejercito2);
      //Ordenamiento mayor - menor
      System.out.println("Orden por vida Ejercito 1: ");
      ordenPorBurbuja(ejercito1);
      mostrar(ejercito1);
      System.out.println("Orden por vida Ejercito 2: ");
      ordenarPorSeleccion(ejercito2);
      mostrar(ejercito2);
      System.out.println();
      System.out.println();
      System.out.println();
      boolean c = true;
      while (c){
        mostrarT(tablero);
        juego(tablero, ejercito1, ejercito2);
        System.out.print("Desea continuar: ");
        if(ejercito1.isEmpty()){
          System.out.println("EL Ganador es el ejercito 2");
          c = false;
        } else if(ejercito2.isEmpty()){
          System.out.println("EL Ganador es el ejercito 1");
          c = false;
        } else {
          String r = sc.nextLine();
          r = r.toUpperCase();
          if(r.equals("NO")){
            c = false;
          }
        }
      }
      System.out.println();
      System.out.println();
      System.out.println();
      //Ejercito Ganador
      System.out.println("Ganador dependiendo a la suma de puntos de vida del ejercito");
      if(sumaVida(ejercito1) > sumaVida(ejercito2)){
        System.out.println("El ganador es el ejercito 1 con: " + sumaVida(ejercito1)+" puntos de vida");
        System.out.println("El perdedor es el ejercito 2 con: " + sumaVida(ejercito2)+" puntos de vida");
      } else if (sumaVida(ejercito1) < sumaVida(ejercito2)){
        System.out.println("El ganador es el ejercito 2 con: " + sumaVida(ejercito2)+" puntos de vida");
        System.out.println("El perdedor es el ejercito 1 con: " + sumaVida(ejercito1)+" puntos de vida");
      } else {
        System.out.println("Empataron con: " + sumaVida(ejercito2)+" puntos de vida");
      }
      System.out.print("Desea Continuar(SI/NO): ");
      String respuesta = sc.next().toUpperCase();
      if(respuesta.equals("NO")){
        continuar = false;
      }
    }      
  }
  public static void ejercito1(ArrayList<Soldado> ejercito1, byte n1, String[][] tablero){
    Scanner sc = new Scanner(System.in);//Datos Aleatorios
    int ph, fila, columna;
    for(int i = 0; i < n1; i++){
      int acti = (int)(Math.random()*4);
      int nivelA = (int)(Math.random()*5)+1;
      int nivelD = (int)(Math.random()*5)+1;
      int velocidad = (int)(Math.random()*6);
      Soldado auxiliar = new Soldado(acti, nivelA, nivelD, velocidad);
      auxiliar.setNombre("Soldado "+ i + "X1");
      ph = (int)(Math.random()*5 + 1);
      auxiliar.setPuntosDeVida(ph);
      fila = (int)(Math.random()*10);
      auxiliar.setFila(fila);       
      columna = (int)(Math.random()*10);
      auxiliar.setColumna(columna);
      while(tablero[fila][columna] != "-"){    
        fila = (int)(Math.random()*10);
        auxiliar.setFila(fila);
        columna = (int)(Math.random()*10);
        auxiliar.setColumna(columna);       
      }
      tablero[fila][columna] = "*";
      ejercito1.add(auxiliar);
    }    
  }
  public static void ejercito2(ArrayList<Soldado> ejercito2, byte n2, String[][] tablero){
    Scanner sc = new Scanner(System.in);// Datos Aleatorios
    int ph, fila, columna;
    for(int i = 0; i < n2; i++){
      int acti = (int)(Math.random()*4);
      int nivelA = (int)(Math.random()*5)+1;
      int nivelD = (int)(Math.random()*5)+1;
      int velocidad = (int)(Math.random()*6);
      Soldado auxiliar = new Soldado(acti, nivelA, nivelD, velocidad);
      auxiliar.setNombre("Soldado "+ i + "X2");
      ph = (byte)(Math.random()*5 + 1);
      auxiliar.setPuntosDeVida(ph);
      fila = (int)(Math.random()*10);
      auxiliar.setFila(fila);
      columna = (int)(Math.random()*10);
      auxiliar.setColumna(columna);
      while(tablero[fila][columna] != "-"){
        fila = (int)(Math.random()*10);
        auxiliar.setFila(fila);
        columna = (int)(Math.random()*10);
        auxiliar.setColumna(columna);
      }
      tablero[fila][columna] = "+";
      ejercito2.add(auxiliar);
    }
  }
  //Vida Actual
  public static void actualizarVida(ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2){
    int minimo =  Math.min(ejercito1.size(), ejercito2.size()); 
    for(int i = 0; i < minimo; i++){
      Soldado auxiliar1 = ejercito1.get(i);
      Soldado auxiliar2 = ejercito2.get(i);
      auxiliar1.vidaActual(auxiliar2);
      auxiliar2.vidaActual(auxiliar1);
      ejercito1.set(i, auxiliar1);
      ejercito2.set(i, auxiliar2);
    }
  }
  public static void mostrar(ArrayList<Soldado> ejercito){
    //mostrar soldados
    for(Soldado batallon : ejercito){
      System.out.println(batallon.toString());
      System.out.println("-------------------------------------------------------------------------");
    }
  }
  public static void tablero(String[][] tablero){
    //inicializar tablero
    for(int i = 0; i < 10; i++) {
      for(int k = 0; k < 10; k++){
        tablero[i][k] = "-";
        
      }
    }      
  }
  public static void mostrarT(String[][] tablero){ 
    //imprimir tablero
    System.out.println("   A  B  C  D  E  F  G  H  I  J");
    for (int i = 0; i < tablero.length; i++) {
      if(i == 9){
        System.out.print((i+1)+ " ");
      } else {
        System.out.print((i+1)+ "  ");
      }
      for(int k = 0; k < tablero[i].length; k++){
        if(tablero[i][k].length() == 2){
          System.out.print(tablero[i][k] + " ");
        } else {
          System.out.print(tablero[i][k] + "  ");
        }
      }
      System.out.println();
    }   
  }
  public static Soldado mayorSoldado(ArrayList<Soldado> ejercito){
    //busca soldado con mayor vida
    Soldado auxiliar = ejercito.get(0);
    for(int i = 1; i < ejercito.size(); i++){
      Soldado actual = ejercito.get(i);
      if(actual.getPuntosDeVida() > auxiliar.getPuntosDeVida()){
        auxiliar = actual;
      }
    }
    return auxiliar;
  }
  public static double promedioSoldado(ArrayList<Soldado> ejercito){
    //opera promedio de punto de vida de cada soldado
    int suma = 0;
    int n = ejercito.size();
    for(int i = 0; i < ejercito.size(); i++){
      Soldado auxiliar = ejercito.get(i);
      suma += auxiliar.getPuntosDeVida();
    }
    double promedio = (double) suma/n;
    return promedio;
  }
  public static void ordenPorBurbuja(ArrayList<Soldado> ejercito) {
    int n = ejercito.size();
    for (int i = 0; i < n - 1; i++) {
      for (int k = 0; k < n - i - 1; k++) {
        Soldado auxiliar1 = ejercito.get(k);
        Soldado auxiliar2 = ejercito.get(k + 1);
        if (auxiliar1.getPuntosDeVida() < auxiliar2.getPuntosDeVida()) {
          ejercito.set(k, auxiliar2);
          ejercito.set(k + 1, auxiliar1);
        }
      }
    }
  }
  public static void ordenarPorSeleccion(ArrayList<Soldado> ejercito){
    for(int i = 0; i < ejercito.size()-1; i++){
      int c = i;
      for(int k = i+1; k < ejercito.size(); k++){
        Soldado auxiliar1 = ejercito.get(c);
        Soldado auxiliar2 = ejercito.get(k);
        if(auxiliar2.getPuntosDeVida() > auxiliar1.getPuntosDeVida()){
          c = k;
        }
      }
      if (c != i){
        Soldado aux = ejercito.get(i);
        ejercito.set(i, ejercito.get(c));
        ejercito.set(c, aux);
      }
    }
  }
  public static int sumaVida(ArrayList<Soldado> ejercito){
    //suma de los puntos de vida de cada soldado
    int suma = 0;
    int n = ejercito.size();
    for(int i = 0; i < ejercito.size(); i++){
      Soldado auxiliar = ejercito.get(i);
      suma += auxiliar.getPuntosDeVida();
    }
    return suma;
  }
  public static void juego(String[][] tablero, ArrayList<Soldado> ejercito1, ArrayList<Soldado> ejercito2){
    Scanner sc = new Scanner(System.in);
    String coords;
    int columna, fila;
    do{
      System.out.print("Ingresar coordenadas validas: ");
      coords = sc.nextLine();
      columna = convertM(coords.substring(0,1));
      fila = (Integer.parseInt(coords.substring(1))) - 1;
    }while(columna == 10 || fila < 0 || fila > 9);
    while(tablero[fila][columna] == "-"){
      do{
        System.out.print("Ingresar coordenadas validas: ");
        coords = sc.nextLine();
        columna = convertM(coords.substring(0,1));
        fila = (Integer.parseInt(coords.substring(1))) - 1;
      }while(columna == 10 || fila < 0 || fila > 9);
    }
    for(int i = 0; i < ejercito1.size(); i++){
      Soldado auxiliar = ejercito1.get(i);
      if(auxiliar.getFila() == fila && auxiliar.getColumna() == columna){
        int mov, filaA, colA;
        do{
          System.out.print("Ingrese Movimiento: ");
          mov = sc.nextInt();
          filaA = auxiliar.getFila();
          colA = auxiliar.getColumna();
          auxiliar.movimiento(mov);
          fila = auxiliar.getFila();
          columna = auxiliar.getColumna();
          if((columna < 0 || columna > 9) || (fila < 0 || fila > 9)){
            auxiliar.setFila(filaA);
            auxiliar.setColumna(colA);
            System.out.println("Se sale de los limites");
          } else {
            if(tablero[fila][columna] == "+"){
              for(int k = 0; k < ejercito2.size() ; k++){
                Soldado auxiliar1 = ejercito2.get(k);
                if(auxiliar1.getFila() == fila && auxiliar1.getColumna() == columna){
                  if(auxiliar.getPuntosDeVida() > auxiliar1.getPuntosDeVida()){
                    tablero[filaA][colA] = "-";
                    tablero[fila][columna] = "*";
                    ejercito2.remove(k);
                    ejercito1.set(i, auxiliar);
                    System.out.println("Soldado 1: " + auxiliar.getPuntosDeVida());
                    System.out.println("Soldado 2: " + auxiliar1.getPuntosDeVida());
                    System.out.println("Ganador: soldado 1");
                  } else if(auxiliar.getPuntosDeVida() < auxiliar1.getPuntosDeVida()){
                    fila = filaA;
                    columna = colA;
                    ejercito1.remove(i);
                    System.out.println("Soldado 1: " + auxiliar.getPuntosDeVida());
                    System.out.println("Soldado 2: " + auxiliar1.getPuntosDeVida());
                    System.out.println("Ganador: soldado 2");
                    tablero[filaA][colA] = "-";
                  } else {
                    fila = filaA;
                    columna = colA;
                    auxiliar.setFila(filaA);
                    auxiliar.setColumna(colA);
                    ejercito1.set(i, auxiliar);
                    System.out.println("Soldado 1: " + auxiliar.getPuntosDeVida());
                    System.out.println("Soldado 2: " + auxiliar1.getPuntosDeVida());
                    System.out.println("EMPATE!!");
                  }
                }
              }
            } else if(tablero[fila][columna] == "*"){
              auxiliar.setFila(filaA);
              auxiliar.setColumna(colA);
              fila = filaA;
              columna = colA;
              ejercito1.set(i, auxiliar);
              System.out.println("No se puede ejecutar el movimiento");
            } else {
              tablero[filaA][colA] = "-";
              tablero[fila][columna] = "*";
              ejercito1.set(i, auxiliar);
            }
          }
        } while((columna < 0 || columna > 9) || (fila < 0 || fila > 9));
      } 
    }
    for(int i = 0; i < ejercito2.size(); i++){
      Soldado auxiliar = ejercito2.get(i);
      if(auxiliar.getFila() == fila && auxiliar.getColumna() == columna){
        int mov, filaA, colA;
        do{
          System.out.print("Ingrese Movimiento: ");
          mov = sc.nextInt();
          filaA = auxiliar.getFila();
          colA = auxiliar.getColumna();
          auxiliar.movimiento(mov);
          fila = auxiliar.getFila();
          columna = auxiliar.getColumna();
          if((columna < 0 || columna > 9) || (fila < 0 || fila > 9)){
            auxiliar.setFila(filaA);
            auxiliar.setColumna(colA);
            System.out.println("Se sale de los limites");
          } else {
            if(tablero[fila][columna] == "*"){
              for(int k = 0; k < ejercito1.size() ; k++){
                Soldado auxiliar1 = ejercito1.get(k);
                if(auxiliar1.getFila() == fila && auxiliar1.getColumna() == columna){
                  if(auxiliar.getPuntosDeVida() > auxiliar1.getPuntosDeVida()){
                    tablero[filaA][colA] = "-";
                    tablero[fila][columna] = "+";
                    ejercito1.remove(k);
                    ejercito2.set(i, auxiliar);
                    System.out.println("Soldado 2: " + auxiliar.getPuntosDeVida());
                    System.out.println("Soldado 1: " + auxiliar1.getPuntosDeVida());
                    System.out.println("Ganador: soldado 2");
                    System.out.println(auxiliar);
                    System.out.println(auxiliar1);
                  } else if(auxiliar.getPuntosDeVida() < auxiliar1.getPuntosDeVida()){
                    fila = filaA;
                    columna = colA;
                    ejercito2.remove(i);
                    System.out.println("Soldado 2: " + auxiliar.getPuntosDeVida());
                    System.out.println("Soldado 1: " + auxiliar1.getPuntosDeVida());
                    System.out.println("Ganador: soldado 1");
                    tablero[filaA][colA] = "-";
                  } else {
                    auxiliar.setFila(filaA);
                    auxiliar.setColumna(colA);
                    ejercito2.set(i, auxiliar);
                    System.out.println("Soldado 2: " + auxiliar.getPuntosDeVida());
                    System.out.println("Soldado 1: " + auxiliar1.getPuntosDeVida());
                    System.out.println("EMPATE!!");
                  }
                }
              }
            } else if(tablero[fila][columna] == "+"){
              auxiliar.setFila(filaA);
              auxiliar.setColumna(colA);
              fila = filaA;
              columna = colA;
              ejercito2.set(i, auxiliar);
              System.out.println("No se puede ejecutar el movimiento");
            } else {
              tablero[filaA][colA] = "-";
              tablero[fila][columna] = "+";
              ejercito2.set(i, auxiliar);
            }
          }
        } while((columna < 0 || columna > 9) || (fila < 0 || fila > 9));
      } 
    }
    mostrarT(tablero);
  }
  public static int convertM(String n){
    switch (n){
      case "A": return 0;
      case "B": return 1;
      case "C": return 2;
      case "D": return 3;
      case "E": return 4;
      case "F": return 5;
      case "G": return 6;
      case "H": return 7;
      case "I": return 8;
      case "J": return 9;
    }
    return 10;
  }
}