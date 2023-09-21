import java.util.Scanner;
public class Ahorcado {
  public static void main(String []args){
    String ahor1 = " +---+     \n"+
                   " |   |     \n" +
                   "     |     \n" +
                   "     |     \n" +
                   "     |     \n" +
                   "     |     \n" +
                   "========= ";
    String ahor2 = " +---+     \n"+
                   " |   |     \n"+
                   " O   |     \n"+
                   "     |     \n"+
                   "     |     \n"+
                   "     |     \n"+
                   "=========";
    String ahor3 = " +---+     \n"+
                   " |   |     \n"+
                   " O   |     \n"+
                   " |   |     \n"+
                   "     |     \n"+
                   "     |     \n"+
                   "=========";
    String ahor4 = " +---+     \n"+
                   " |   |     \n"+
                   " O   |     \n"+
                   "/|   |     \n"+
                   "     |     \n"+
                   "     |     \n"+
                   "=========";
    String ahor5 = " +---+     \n"+
                   " |   |     \n"+
                   " O   |     \n"+
                   "/|\\  |     \n"+
                   "     |     \n"+
                   "     |     \n"+
                   "=========";
    String ahor6 = " +---+     \n"+
                   " |   |     \n"+
                   " O   |     \n"+
                   "/|\\  |     \n"+
                   "/    |     \n"+
                   "     |     \n"+
                   "=========";
    String ahor7 = " +---+     \n"+
                   " |   |     \n"+
                   " O   |     \n"+
                   "/|\\  |     \n"+
                   "/ \\  |     \n"+
                   "     |     \n"+
                   "=========";
    String [] figuras = {ahor1, ahor2, ahor3,ahor4,ahor5,ahor6,ahor7};
    int contador = 1;
    String letra;
    String [] palabras = {"programacion", "java", "identacion", "clases",
                        "objetos", "desarrollador", "pruebas"};
    String palSecreta = getPalabraSecreta(palabras);
    String[] adivinar = new String[palSecreta.length()];
    inicializar(adivinar);
    System.out.println(figuras[0]);
    mostrarBlancos(palSecreta);
    System.out.println("\n");
    int c = 0;
    while(contador <= 6){
      letra = ingreseLetra(adivinar);
      c++;
      if (letraEnPalabraSecreta(letra, palSecreta)){
        mostrarBlancosActualizados(letra, palSecreta, adivinar);
      }else{
        System.out.println(figuras[contador]);
        contador = contador +1;
        if(contador == 7){
          System.out.println("Usted perdio con "+c+" intentos.");
        }
      }
      if(ganador(adivinar, palSecreta)){
        System.out.println("Usted ganó con "+c+" intentos.");
        break;
      }
    }
                
    System.out.println("\n");
  }
  public static String getPalabraSecreta(String [] lasPalabras){
    String palSecreta;
    int ind;
    int indiceMayor = lasPalabras.length -1;
    int indiceMenor =0;
    ind = (int) ((Math.random() * (indiceMayor - indiceMenor + 1) + indiceMenor));
    return lasPalabras[ind];
  }
  public static void mostrarBlancos(String palabra){
    for(int i=0; i< palabra.length(); i++)
      System.out.print("_ " );
  }
  public static String ingreseLetra(String[] adivinar){
    String laLetra;
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese letra: ");
    laLetra = sc.next();
    while(laLetra.length()!= 1){
      System.out.println("Ingrese letra: "); 
      laLetra = sc.next();
    }
    while(!verificacion(adivinar, laLetra)){
      System.out.println("Ingrese letra: ");
      laLetra = sc.next();
    }
    while(!esCaracter(adivinar, laLetra)){
      System.out.println("Ingrese letra: ");
      laLetra = sc.next();
    }
    return laLetra;
  }
  public static boolean verificacion(String[] adivinar,String laLetra){
    for(int i = 0; i < adivinar.length; i++){
      if(adivinar[i].equals(laLetra)){
        return false;
      }
    }
    return true;
  }
  public static boolean esCaracter(String[] adivinar, String laLetra){
    char c = laLetra.charAt(0);
    if(Character.isDigit(c)){
      return false;
    }
    return true;
  }
  public static boolean letraEnPalabraSecreta(String letra, String palSecreta ){
    for(int i = 0; i < palSecreta.length(); i++){
      if(palSecreta.charAt(i) == letra.charAt(0)){
        return true;
      }
    }
    return false;
  }
  public static void mostrarBlancosActualizados(String letra, String palSecreta, String[] adivinar){
    for(int i = 0; i < palSecreta.length(); i++){
      if(adivinar[i].equals("_")){  
        if(palSecreta.charAt(i) == letra.charAt(0)){
          adivinar[i] = letra;
        }
      }
      System.out.print(adivinar[i] + " "); 
    }
    System.out.println();
    System.out.println("PROCESANDO.....");
  }
  public static void inicializar(String[] adivinar){
    for(int i = 0; i < adivinar.length; i++){
      adivinar[i] = "_";
    }
  }
  public static boolean ganador(String[] adivinar, String palSecreta){
    String auxiliar = "";
    for(int i = 0; i < adivinar.length; i++){
      auxiliar += adivinar[i];
    }
    if(auxiliar.equals(palSecreta)){
      return true;
    }
    return false;
  }  
}
