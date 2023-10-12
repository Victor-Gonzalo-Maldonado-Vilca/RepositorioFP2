import java.util.*;
class VideoJuego3 {
  public static void main(String[] args) {
    //tablero
    ArrayList<ArrayList<Character>> tablero = new ArrayList<>();
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
    //Ordenamiento mayor - menor
    System.out.println("Orden por vida Ejercito 1: ");
    ordenPorBurbuja(ejercito1);
    mostrar(ejercito1);
    System.out.println("Orden por vida Ejercito 2: ");
    ordenarPorSeleccion(ejercito2);
    mostrar(ejercito2);
    //Ejercito Ganador
    if(sumaVida(ejercito1) > sumaVida(ejercito2)){
      System.out.println("El ganador es el ejercito 1 con: " + sumaVida(ejercito1)+" puntos de vida");
      System.out.println("El perdedor es el ejercito 2 con: " + sumaVida(ejercito2)+" puntos de vida");
    } else if (sumaVida(ejercito1) < sumaVida(ejercito2)){
      System.out.println("El ganador es el ejercito 2 con: " + sumaVida(ejercito2)+" puntos de vida");
      System.out.println("El perdedor es el ejercito 1 con: " + sumaVida(ejercito1)+" puntos de vida");
    } else {
      System.out.println("Empataron con: " + sumaVida(ejercito2)+" puntos de vida");
    }      
  }
  public static void ejercito1(ArrayList<Soldado> ejercito1, byte n1, ArrayList<ArrayList<Character>> tablero){
    Scanner sc = new Scanner(System.in);// Datos Aleatorios
    int ph, fila, columna;
    for(int i = 0; i < n1; i++){
      Soldado auxiliar = new Soldado();
      auxiliar.setNombre("Soldado "+ i + "X1");
      ph = (int)(Math.random()*5 + 1);
      auxiliar.setPuntosDeVida(ph);
      fila = (int)(Math.random()*10);
      auxiliar.setFila(fila);       
      columna = (int)(Math.random()*10);
      auxiliar.setColumna(columna);
      while(tablero.get(fila).get(columna) != '-'){    
        fila = (int)(Math.random()*10);
        auxiliar.setFila(fila);
        columna = (int)(Math.random()*10);
        auxiliar.setColumna(columna);       
      }
      tablero.get(fila).set(columna, '*');
      ejercito1.add(auxiliar);
    }    
  }
  public static void ejercito2(ArrayList<Soldado> ejercito2, byte n2, ArrayList<ArrayList<Character>> tablero){
    Scanner sc = new Scanner(System.in);//Datos Aleatorios
    int ph, fila, columna;
    for(int i = 0; i < n2; i++){
      Soldado auxiliar = new Soldado();
      auxiliar.setNombre("Soldado "+ i + "X2");
      ph = (byte)(Math.random()*5 + 1);
      auxiliar.setPuntosDeVida(ph);
      fila = (int)(Math.random()*10);
      auxiliar.setFila(fila);
      columna = (int)(Math.random()*10);
      auxiliar.setColumna(columna);
      while(tablero.get(fila).get(columna) != '-'){
        fila = (int)(Math.random()*10);
        auxiliar.setFila(fila);
        columna = (int)(Math.random()*10);
        auxiliar.setColumna(columna);
      }
      tablero.get(fila).set(columna, '+');
      ejercito2.add(auxiliar);
    }
  }
  public static void mostrar(ArrayList<Soldado> ejercito){
    //imprimir ejercito
    for(Soldado batallon : ejercito){
      System.out.println(batallon.toString());
      System.out.println("-----------------------");
    }
  }
  public static void tablero(ArrayList<ArrayList<Character>> tablero){
    //inicializar con '-'
    for(int i = 0; i < 10; i++) {
      ArrayList<Character> fila = new ArrayList<>();
      for(int k = 0; k < 10; k++){
        fila.add('-');
        
      }
      tablero.add(fila);
    }      
  }
  public static void mostrarT(ArrayList<ArrayList<Character>> tablero){
    //Imprimir Tablero
    int i = 1;
    System.out.println("   A  B  C  D  E  F  G  H  I  J");
    for (ArrayList<Character> fila : tablero) {
      if(i == 10){
        System.out.print(i + " ");
      } else {
        System.out.print(i + "  ");
      }
      for (char c : fila) {
        System.out.print(c + "  ");
      }
      i++;
      System.out.println();
    }   
  }
  public static Soldado mayorSoldado(ArrayList<Soldado> ejercito){
    //Soldado con mayor vida
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
    //Promediar Soldados
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
    //sumar Vida de los soldados
    int suma = 0;
    int n = ejercito.size();
    for(int i = 0; i < ejercito.size(); i++){
      Soldado auxiliar = ejercito.get(i);
      suma += auxiliar.getPuntosDeVida();
    }
    return suma;
  }
}

