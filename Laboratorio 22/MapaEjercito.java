import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MapaEjercito extends JFrame{
	public static final Color BLUE = new Color(229, 49, 87);
	public static final Color RED = new Color(68, 100, 229);
	private Ejercito ejercitoA;
	private Ejercito ejercitoB;
	private Color colorBoton;
	
	public MapaEjercito(Ejercito eA, Ejercito eB){
		setTitle("Mapa Soldados");
		ejercitoA = eA;
		ejercitoB = eB;
		setSize(700, 700);
		setLayout(new GridLayout(11, 10, 5, 5));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createContends();
		setVisible(true);
	}
	public int convertirPos(String pos){
		int unidad, decena;
		unidad = Integer.valueOf(pos.charAt(0)) - 65;
		decena = Integer.valueOf(pos.substring(1)) - 1;
		return decena * 10 + unidad;
	}
	public String convertirPos(int pos){
		String numero, letra;
		letra = String.valueOf((char)(pos % 10 + 65));
		numero = String.valueOf(pos / 10 + 1);
		return letra + numero;
	}
	public ArrayList<String> todasPosicionesSinConvertir(Ejercito e){
		ArrayList<String> posSinConvertir = new ArrayList<String>();
		for(Soldado sold: e.getSoldados())
			posSinConvertir.add(sold.getPos());
		return posSinConvertir;
	}
	public ArrayList<Integer> todasPosicionesConvertidas(Ejercito e){
		ArrayList<Integer> posConvertidas = new ArrayList<Integer>();
		ArrayList<String> posSinConvertir = todasPosicionesSinConvertir(e);
		int longitud = posSinConvertir.size();
		for(int i = 0; i < longitud; i++){
			int pos = convertirPos(posSinConvertir.get(i));
			posConvertidas.add(pos);
		}
		return posConvertidas;
	}
	public boolean esPosicion(ArrayList<Integer> posicion, int i){
		for(int j = 0; j < posicion.size(); j++)
			if(i == posicion.get(j))
				return true;
		return false;
	}
	public void indiceAlfabetico(){
		for(int i = 0; i < 10; i++){
			String letra = String.valueOf((char)(i + 65));
			JLabel indiceAlf = new JLabel(letra, SwingConstants.CENTER);
			add(indiceAlf);
		}
	}
	public void indiceNumerico(int i){
		if(i % 10 == 0){
			String num = String.valueOf(i / 10 + 1);
			JLabel indiceNum = new JLabel(num, SwingConstants.CENTER);
			add(indiceNum);
		}
	}
	private void createContends(){
		ArrayList<Integer> posEjercitoA = todasPosicionesConvertidas(ejercitoA);
		ArrayList<Integer> posEjercitoB = todasPosicionesConvertidas(ejercitoB);
		JLabel esquinaSuperiorIzquierda = new JLabel("", SwingConstants.CENTER);
		add(esquinaSuperiorIzquierda);
		indiceAlfabetico();
		for(int i = 0; i < 100; i++){
			indiceNumerico(i);
			JButton boton;
			if(esPosicion(posEjercitoA, i)){
				boton = new JButton(ejercitoA.soldadoPorUbicacion(convertirPos(i)));
				boton.setBackground(BLUE);
			}else if(esPosicion(posEjercitoB, i)){
				boton = new JButton(ejercitoB.soldadoPorUbicacion(convertirPos(i)));
				boton.setBackground(RED);
				
			}else{
				boton = new JButton("");
				boton.setBackground(Color.LIGHT_GRAY);
			}
			add(boton);
		}
	}
}