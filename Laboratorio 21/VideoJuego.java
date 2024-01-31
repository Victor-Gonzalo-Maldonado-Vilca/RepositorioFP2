class VideoJuego {

  public static void main(String[] args) {
    // Creacion del mapa
    int random = (int) (Math.random() * 5) + 1;
    Mapa territorio = new Mapa(random);
    System.out.println(territorio);
    territorio.imprimirTabla();
    territorio.mostrarEjercitos();
    territorio.playing();
  }
}