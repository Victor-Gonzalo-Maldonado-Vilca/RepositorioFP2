import java.util.ArrayList;

public class Ejercito {
  private ArrayList<Soldado> misSoldados = new ArrayList<>();
  private ArrayList<Soldado> ranking = new ArrayList<>();
  private String reino;

  // Constructores
  public Ejercito() {
    this(1);
  }

  public Ejercito(int number) {
    reino(number);
  }

  // Inicializar reino , con un numero random
  public void reino(int number) {
    switch (number) {
      case 1:
        reino = "Inglaterra";
        break;
      case 2:
        reino = "Francia";
        break;
      case 3:
        reino = "Castilla-Aragon";
        break;
      case 4:
        reino = "Sacro Imperio Romano-Germanico";
        break;
      case 5:
        reino = "Moros";
        break;
    }
  }

  // Eliminar soldado usando metodos de ArrayList
  public void eliminar(int n) {
    misSoldados.remove(n);
  }

  // Ingresar los datos de un soldado y agregarlo al arrayList
  public void ingresarDatos(Soldado n, String name, int pH, int nA, int nD) {
    if (misSoldados.size() < 10) {
      n.setNombre(name);
      n.setPuntosDeVida(pH);
      n.setNivelAtaque(nA);
      n.setNivelDefensa(nD);
      misSoldados.add(n);
      ranking.add(n);
    } else {
      System.out.println("No se puede crear el soldado");
    }
  }

  // eliminar un soldado usando el indice correspondiente
  public void eliminarSoldado(int i) {
    if (i >= 0 && i < misSoldados.size()) {
      misSoldados.remove(i);
      ranking.remove(i);
    } else {
      System.out.println("No se pudo eliminar el Soldado");
    }

  }

  // Modificar los datos, reemplazando con un auxiliar , que ya fue modificado
  public void modificarDatos(int i, Soldado n, String name, int pH, int nA, int nD) {
    if (i >= 0 && i < misSoldados.size()) {
      n.setNombre(name);
      n.setPuntosDeVida(pH);
      n.setNivelAtaque(nA);
      n.setNivelDefensa(nD);
      misSoldados.set(i, n);
      ranking.set(i, n);
    } else {
      System.out.println("No se puede modificar el soldado");
    }
  }

  // Obtener el soldado con mayor ataque
  public Soldado mayorAtaque() {
    Soldado maximo = misSoldados.get(0);
    for (int i = 1; i < misSoldados.size(); i++) {
      Soldado auxiliar = misSoldados.get(i);
      if (maximo.getNivelAtaque() < auxiliar.getNivelAtaque()) {
        maximo = auxiliar;
      }
    }
    return maximo;
  }

  /*
   * Ordenamiento decreciente dependiendo de la vida de cada soldado, el
   * ordenamiento burbuja consta de recorrer repetidamente una lista de elementos.
   * En cada iteración, compara los elementos adyacentes y los intercambia si
   * están en el orden incorrecto. Este proceso se repite hasta que no se
   * necesiten más intercambios, lo que indica que la lista está ordenada
   */
  public void ordenamientoBurbuja() {
    int n = ranking.size();
    for (int i = 0; i < n - 1; i++) {
      for (int k = 0; k < n - i - 1; k++) {
        Soldado auxiliar1 = ranking.get(k);
        Soldado auxiliar2 = ranking.get(k + 1);
        if (auxiliar1.getPuntosDeVida() < auxiliar2.getPuntosDeVida()) {
          ranking.set(k, auxiliar2);
          ranking.set(k + 1, auxiliar1);
        }
      }
    }
  }

  // Imprimira el ejercito en forma de lista pero ya ordenados
  public String ordenamiento() {
    String soldados = "";
    for (Soldado comando : ranking) {
      soldados += comando + "\n";
    }
    return "Ejercito: " + reino + "\n" + soldados;
  }

  /*
   * En este metodo se imprimira todos los datos, return un string con ello
   */
  public String toString() {
    String soldados = "";
    for (Soldado comando : misSoldados) {
      soldados += comando + "\n";
    }
    return "Ejercito: " + reino + "\n" + soldados;
  }

}