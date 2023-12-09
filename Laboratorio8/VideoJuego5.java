import java.util.*;
class VideoJuego5 {
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
      HashMap<Integer, Soldado> ejercito1 = new HashMap<>();
      //Segundo Ejercito - numero random
      byte n2 = (byte)(Math.random()*10 + 1);
      HashMap<Integer, Soldado> ejercito2 = new HashMap<>();
      //Inicializacion
      ejercito1(ejercito1, n1, tablero);
      ejercito2(ejercito2, n2, tablero);
      //Tablero
      System.out.println("TABLERO: ");
      mostrarT(tablero);
      //Mayor Vida
      System.out.println("Datos del Soldado con mayor vida del Ejercito 1: ");
      Soldado mayor1 = mayorSoldado(ejercito1);
      System.out.println(mayor1.toString());
      System.out.println("Datos del Soldado con mayor vida del Ejercito 2: ");
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
  public static void ejercito1(HashMap<Integer, Soldado> ejercito1, byte n1, String[][] tablero){
    Scanner sc = new Scanner(System.in);//Datos Aleatorios
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
      while(tablero[fila][columna] != "-"){    
        fila = (int)(Math.random()*10);
        auxiliar.setFila(fila);
        columna = (int)(Math.random()*10);
        auxiliar.setColumna(columna);       
      }
      tablero[fila][columna] = String.valueOf(ph) + "*";
      ejercito1.put(i, auxiliar);
    }    
  }
  public static void ejercito2(HashMap<Integer, Soldado> ejercito2, byte n2, String[][] tablero){
    Scanner sc = new Scanner(System.in);// Datos Aleatorios
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
      while(tablero[fila][columna] != "-"){
        fila = (int)(Math.random()*10);
        auxiliar.setFila(fila);
        columna = (int)(Math.random()*10);
        auxiliar.setColumna(columna);
      }
      tablero[fila][columna] = String.valueOf(ph) + "+";
      ejercito2.put(i, auxiliar);
    }
  }
  public static void mostrar(HashMap<Integer, Soldado> ejercito){
    //mostrar soldados
    for (Map.Entry<Integer, Soldado> entrada : ejercito.entrySet()) {
      Soldado auxiliar = entrada.getValue();
      System.out.println(auxiliar.toString());
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
  public static Soldado mayorSoldado(HashMap<Integer, Soldado> ejercito){
    //busca soldado con mayor vida
    Soldado auxiliar = null;
    for (Map.Entry<Integer, Soldado> entrada : ejercito.entrySet()) {
      Soldado actual = entrada.getValue();
      if(auxiliar == null || actual.getPuntosDeVida() > auxiliar.getPuntosDeVida()){
        auxiliar = actual;
      }
    }
    return auxiliar;
  }
  public static double promedioSoldado(HashMap<Integer, Soldado> ejercito){
    //opera promedio de punto de vida de cada soldado
    int suma = 0;
    int n = ejercito.size();
    for (Map.Entry<Integer, Soldado> entrada : ejercito.entrySet()) {
      Soldado auxiliar = entrada.getValue();
      suma += auxiliar.getPuntosDeVida();
    }
    double promedio = (double) suma/n;
    return promedio;
  }
  public static int sumaVida(HashMap<Integer, Soldado> ejercito){
    //suma de los puntos de vida de cada soldado
    int suma = 0;
    int n = ejercito.size();
    for (Map.Entry<Integer, Soldado> entrada : ejercito.entrySet()) {
      Soldado auxiliar = entrada.getValue();
      suma += auxiliar.getPuntosDeVida();
    }
    return suma;
  }
  //Trasladar los valores de hashMap a un ArrayList para luego poder ordenarlos
  //Despueso trasladar los valores del ArrayList a un hashMap
  public static void ordenPorBurbuja(HashMap<Integer, Soldado> ejercito1) {
    //ArrayList donde pondremos los valores del HashMap
    ArrayList<Soldado> ejercito = new ArrayList<>(ejercito1.values());
    //Algoritmo Burbuja
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
    //Cambiar los datos del HashMap ordenados
    int k = 0;
    for (Map.Entry<Integer, Soldado> entry : ejercito1.entrySet()) {
     entry.setValue(ejercito.get(k));
     k++;
    }
  }
  public static void ordenarPorSeleccion(HashMap<Integer, Soldado> ejercito2){
    //ArrayList donde pondremos los valores del HashMap
    ArrayList<Soldado> ejercito = new ArrayList<>(ejercito2.values());
    //Algoritmo ordenamiento por seleccion
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
    //Cambiar los datos del HashMap ordenados
    int k = 0;
    for (Map.Entry<Integer, Soldado> entry : ejercito2.entrySet()) {
     entry.setValue(ejercito.get(k));
     k++;
    }
  }
}