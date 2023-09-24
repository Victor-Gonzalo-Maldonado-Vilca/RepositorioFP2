public class Soldado {
  private String nombre;
  private String nivel_vida;
  private int edad;
  private char genero;
  private String DNI;
  public void setNombre(String nombre){
    this.nombre = nombre;
  }
  public void setNivel_Vida(String nivel_vida){
    this.nivel_vida = nivel_vida;
  }
  public void setEdad(int edad){
    this.edad = edad;
  }
  public void setGenero(char genero){
    this.genero = genero;
  }
  public void setDNI(String DNI){
    this.DNI = DNI;
  }
  public String getNombre(){
    return nombre;
  }
  public String getNivel_Vida(){
    return nivel_vida;
  }
  public int getEdad(){
    return edad;
  }
  public char getGenero(){
    return genero;
  }
  public String getDNI(){
    return DNI;
  }
}
