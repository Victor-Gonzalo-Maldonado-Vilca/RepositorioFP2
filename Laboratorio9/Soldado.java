public class Soldado {
  private String nombre;
  private int nivelAtaque;
  private int nivelDefensa;
  private int actitud;
  private String actitud1;
  private boolean verificarConversion = false;
  private int velocidad;
  private int puntosDeVida;
  private int fila;
  private int columna;
  //CONSTRUCTORES
  public Soldado(){
    this(0, 0, 1, 1);
  }
  public Soldado(int actitud,int nivelA){
    this(actitud, nivelA, 1, 1);
  }
  public Soldado(int actitud,int nivelA, int nivelD){
    this(actitud, nivelA, nivelD, 1);
  }
  public Soldado(int actitud, int nivelA, int nivelD, int velocidad){
    setActitud(actitud);
    setNivelAtaque(nivelA);
    setNivelDefensa(nivelD);
    setVelocidad(velocidad);
  }
  public void setNombre(String nombre){
    this.nombre = nombre;
  }
  public void setNivelAtaque(int nivelA){
    nivelAtaque = nivelA;
  }
  public void setNivelDefensa(int nivelD){
    nivelDefensa = nivelD;
  }
  public void setVelocidad(int velocidad){
    this.velocidad = velocidad;
  }
  public void setActitud(int actitud){
    this.actitud = actitud;
  }
  //Modificacion velocidad y actitud
  public String convertirA(){
    if(!verificarConversion){
      switch(actitud){
        case 0: velocidad = 0; actitud1 = "Defensiva"; break;
        case 1: velocidad += 1; actitud1 = "Ofensiva"; break;
        case 2: velocidad += 2; actitud1 = "Fuga"; break;
        //Retroceder
        case 3: 
          if(velocidad > 0){
            velocidad = 0; actitud1 = "Defensiva"; 
          } else {
            velocidad -= 1; actitud1 = "Retroceder";
          }
          break;
        default: actitud1 = "error";
      }
      verificarConversion = true;
    }
    return actitud1;
  }
  public void setFila(int fila){
    this.fila = fila;
  }
  public void setColumna(int columna){
    this.columna = columna;
  }
  public void setPuntosDeVida(int puntosDeVida){
    this.puntosDeVida = puntosDeVida;
  }
  public int getPuntosDeVida(){
    return puntosDeVida;
  }
  public int getNivelAtaque(){
    return nivelAtaque;
  }
  //Actualizacion de vida
  public void vidaActual(Soldado c){
    int a = c.getNivelAtaque();
    int resta = nivelDefensa - a;
    if(resta < 0){
      puntosDeVida += resta;
      if(puntosDeVida <= 0){
        puntosDeVida = 0;
      }
    }
  }
  //Verificacion del Estado Soldado
  public String vive(){
    if(puntosDeVida == 0){
      return "Muerto";
    }
    return "Vivo";
  }
  public char convertirC(int columna){
    switch(columna){
      case 0: return 'A';
      case 1: return 'B';
      case 2: return 'C';
      case 3: return 'D';
      case 4: return 'E';
      case 5: return 'F';
      case 6: return 'G';
      case 7: return 'H';
      case 8: return 'I';
      case 9: return 'J';
    }
    return 'L';
  }
  public String toString(){
    return nombre + " " + puntosDeVida + " "+ convertirC(columna) + (fila + 1) + " Actitud: "
           + convertirA() + " / Velocidad: " + velocidad + " / Estado: " + vive()+ " / NA-ND: "
           + nivelAtaque +  "-" + nivelDefensa;
  }
}