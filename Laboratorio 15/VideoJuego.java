import java.util.*;

class VideoJuego {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Ejercito inglaterra = new Ejercito(1);
    Ejercito francia = new Ejercito(2);
    Ejercito castilla = new Ejercito(3);
    Ejercito sacro = new Ejercito(4);
    Ejercito moros = new Ejercito(5);
    boolean continuar = true;
    do {
      System.out.println("\tMenu");
      System.out.println("1. Crear Soldado");
      System.out.println("2. Eliminar Soldado");
      System.out.println("3. Modificar Soldado");
      System.out.println("4. Soldado con Mayor Ataque");
      System.out.println("5. Ranking");
      System.out.println("6. Ver Ejercito");
      System.out.print("Elija opcion: ");
      int opcion = sc.nextInt();
      sc.nextLine();
      switch (opcion) {
        case 1:
          crearSoldado(inglaterra, francia, castilla, sacro, moros);
          break;
        case 2:
          eliminar(inglaterra, francia, castilla, sacro, moros);
          break;
        case 3:
          modificar(inglaterra, francia, castilla, sacro, moros);
          break;
        case 4:
          ataqueMayor(inglaterra, francia, castilla, sacro, moros);
          break;
        case 5:
          ranking(inglaterra, francia, castilla, sacro, moros);
          break;
        case 6:
          verEjercito(inglaterra, francia, castilla, sacro, moros);
          break;
        default:
          System.out.println("Opcion invalida");
      }
      System.out.print("Desea Continuar: ");
      String r = sc.nextLine();
      if (r.equals("q")) {
        continuar = false;
      }
    } while (continuar);
  }

  /*
   * Este metodo genera un submenu para la eleccion del ejercito correspondiente
   */
  public static void subMenu() {
    System.out.println("\tSubmenu");
    System.out.println("1. Inglaterra");
    System.out.println("2. Francia");
    System.out.println("3. Castilla-Aragon");
    System.out.println("4. Sacro Imperio Romano-Germanico");
    System.out.println("5. Moros");
  }

  /*
   * Genera un menu para elegir en generar soldados de manera aleatoria o de
   * manera manual
   */
  public static void subMenu2() {
    System.out.println("\tSubmenu");
    System.out.println("1. Generar Aleatoriamente");
    System.out.println("2. Generar Manualmente");
  }

  /*
   * Genera un soldado tanto de manera aleatoria como manualmente
   */
  public static void generarSoldado(Ejercito e) {
    Scanner sc = new Scanner(System.in);
    subMenu2();
    System.out.print("Elija opcion: ");
    int opcion = sc.nextInt();
    sc.nextLine();
    switch (opcion) {
      case 1:
        Soldado auxiliar = new Soldado();
        String nombre = "Soldado E";
        int pH = (int) (Math.random() * 5) + 1;
        int nA = (int) (Math.random() * 5) + 1;
        int nD = (int) (Math.random() * 5) + 1;
        e.ingresarDatos(auxiliar, nombre, pH, nA, nD);
        break;
      case 2:
        manualmente(e);
        break;
      default:
        System.out.println("Opcion invalida");
    }
  }

  /*
   * Este metodo pide los datos correspondientes para crear o generar un soldado
   */
  public static void manualmente(Ejercito e) {
    Scanner sc = new Scanner(System.in);
    Soldado auxiliar = new Soldado();
    System.out.print("Ingrese nombre: ");
    String nombre = sc.nextLine();
    System.out.print("Ingrese puntos de vida: ");
    int pH = sc.nextInt();
    while (pH < 0 || pH > 5) {
      System.out.print("Ingrese puntos de vida: ");
      pH = sc.nextInt();
    }
    sc.nextLine();
    System.out.print("Ingrese nivel de Ataque: ");
    int nA = sc.nextInt();
    while (nA < 0 || nA > 5) {
      System.out.print("Ingrese nivel de Ataque: ");
      nA = sc.nextInt();
    }
    sc.nextLine();
    System.out.print("Ingrese nivel de Defensa: ");
    int nD = sc.nextInt();
    while (nD < 0 || nD > 5) {
      System.out.print("Ingrese nivel de Defensa: ");
      nD = sc.nextInt();
    }
    sc.nextLine();
    e.ingresarDatos(auxiliar, nombre, pH, nA, nD);
  }

  /*
   * Este metodo usa los anteriores metodos para poder crear un soldado, pero en
   * este se selecciona el ejercito a quien se le va a generar
   */
  public static void crearSoldado(Ejercito inglaterra, Ejercito francia, Ejercito castilla, Ejercito sacro,
      Ejercito moros) {
    Scanner sc = new Scanner(System.in);
    subMenu();
    System.out.print("Ingrese opcion: ");
    int opcion = sc.nextInt();
    sc.nextLine();
    switch (opcion) {
      case 1:
        generarSoldado(inglaterra);
        break;
      case 2:
        generarSoldado(francia);
        break;
      case 3:
        generarSoldado(castilla);
        break;
      case 4:
        generarSoldado(sacro);
        break;
      case 5:
        generarSoldado(moros);
        break;
      default:
        System.out.println("Opcion invalida");
    }
  }

  /*
   * Este metodo genera un indice colocado por el usuario, se creo para el ahorro
   * de codigo, ademas de que se usa en metodos como eliminar
   */
  public static int generarIndice() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Escriba Indice: ");
    int i = sc.nextInt();
    return i;
  }

  /*
   * Este metodo elimina un soldado de un ejercito, utilizando su indice
   */
  public static void eliminar(Ejercito inglaterra, Ejercito francia, Ejercito castilla, Ejercito sacro,
      Ejercito moros) {
    Scanner sc = new Scanner(System.in);
    subMenu();
    System.out.print("Ingrese opcion: ");
    int opcion = sc.nextInt();
    sc.nextLine();
    int i = generarIndice();
    switch (opcion) {
      case 1:
        inglaterra.eliminarSoldado(i);
        break;
      case 2:
        francia.eliminarSoldado(i);
        break;
      case 3:
        castilla.eliminarSoldado(i);
        break;
      case 4:
        sacro.eliminarSoldado(i);
        break;
      case 5:
        moros.eliminarSoldado(i);
        break;
      default:
        System.out.println("Opcion invalida");
    }
  }

  /*
   * Este metodo usa modificarSoldado, donde seleccionamos de que ejercito sera el
   * soldado modificado
   */
  public static void modificar(Ejercito inglaterra, Ejercito francia, Ejercito castilla, Ejercito sacro,
      Ejercito moros) {
    Scanner sc = new Scanner(System.in);
    subMenu();
    System.out.print("Ingrese opcion: ");
    int opcion = sc.nextInt();
    sc.nextLine();
    switch (opcion) {
      case 1:
        modificarSoldado(inglaterra);
        break;
      case 2:
        modificarSoldado(francia);
        break;
      case 3:
        modificarSoldado(castilla);
        break;
      case 4:
        modificarSoldado(sacro);
        break;
      case 5:
        modificarSoldado(moros);
        break;
      default:
        System.out.println("Opcion invalida");
    }
  }

  /*
   * Mediante el uso del indice correspondiente se selecciona el soldado, y el
   * usuario podra escribir los datos para modificarlos
   */
  public static void modificarSoldado(Ejercito e) {
    Scanner sc = new Scanner(System.in);
    int i = generarIndice();
    Soldado auxiliar = new Soldado();
    System.out.print("Ingrese nombre: ");
    String nombre = sc.nextLine();
    System.out.print("Ingrese puntos de vida: ");
    int pH = sc.nextInt();
    while (pH < 0 || pH > 5) {
      System.out.print("Ingrese puntos de vida: ");
      pH = sc.nextInt();
    }
    sc.nextLine();
    System.out.print("Ingrese nivel de Ataque: ");
    int nA = sc.nextInt();
    while (nA < 0 || nA > 5) {
      System.out.print("Ingrese nivel de Ataque: ");
      nA = sc.nextInt();
    }
    sc.nextLine();
    System.out.print("Ingrese nivel de Defensa: ");
    int nD = sc.nextInt();
    while (nD < 0 || nD > 5) {
      System.out.print("Ingrese nivel de Defensa: ");
      nD = sc.nextInt();
    }
    sc.nextLine();
    e.modificarDatos(i, auxiliar, nombre, pH, nA, nD);
  }

  /*
   * En este metodo se elegira el ejecito al cual se quedra observar todos los
   * soldados en formato de lista
   */
  public static void verEjercito(Ejercito inglaterra, Ejercito francia, Ejercito castilla, Ejercito sacro,
      Ejercito moros) {
    Scanner sc = new Scanner(System.in);
    subMenu();
    System.out.print("Ingrese opcion: ");
    int opcion = sc.nextInt();
    sc.nextLine();
    switch (opcion) {
      case 1:
        System.out.println(inglaterra);
        break;
      case 2:
        System.out.println(francia);
        break;
      case 3:
        System.out.println(castilla);
        break;
      case 4:
        System.out.println(sacro);
        break;
      case 5:
        System.out.println(moros);
        break;
      default:
        System.out.println("Opcion invalida");
    }
  }

  /*
   * Se buscara el soldado con mayor nivel de ataque, donde se imprimiran sus
   * datos
   */
  public static void ataqueMayor(Ejercito inglaterra, Ejercito francia, Ejercito castilla, Ejercito sacro,
      Ejercito moros) {
    Scanner sc = new Scanner(System.in);
    subMenu();
    Soldado aux = new Soldado();
    System.out.print("Ingrese opcion: ");
    int opcion = sc.nextInt();
    sc.nextLine();
    switch (opcion) {
      case 1:
        aux = inglaterra.mayorAtaque();
        break;
      case 2:
        aux = francia.mayorAtaque();
        break;
      case 3:
        aux = castilla.mayorAtaque();
        break;
      case 4:
        aux = sacro.mayorAtaque();
        break;
      case 5:
        aux = moros.mayorAtaque();
        break;
      default:
        System.out.println("Opcion invalida");
    }
    System.out.println("El soldado con Mayor Nivel de Ataque de este ejercito es:\n " + aux);
  }

  /*
   * Este metodo seleccionara al ejercito que se quiere ordenar, mediante uso de
   * un ordenamiento preestablecido en la clase Soldado se logrará
   */
  public static void ranking(Ejercito inglaterra, Ejercito francia, Ejercito castilla, Ejercito sacro,
      Ejercito moros) {
    Scanner sc = new Scanner(System.in);
    subMenu();
    System.out.print("Ingrese opcion: ");
    int opcion = sc.nextInt();
    sc.nextLine();
    switch (opcion) {
      case 1:
        inglaterra.ordenamientoBurbuja();
        System.out.println(inglaterra.ordenamiento());
        break;
      case 2:
        francia.ordenamientoBurbuja();
        System.out.println(francia.ordenamiento());
        break;
      case 3:
        castilla.ordenamientoBurbuja();
        System.out.println(castilla.ordenamiento());
        break;
      case 4:
        sacro.ordenamientoBurbuja();
        System.out.println(sacro.ordenamiento());
        break;
      case 5:
        moros.ordenamientoBurbuja();
        System.out.println(moros.ordenamiento());
        break;
      default:
        System.out.println("Opcion invalida");
    }
  }
}