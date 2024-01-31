import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Mapa extends JFrame {
	public static final Color BLUE = new Color(229, 49, 87);
	public static final Color RED = new Color(68, 100, 229);
	private Reino reinoA;
	private Reino reinoB;
	private JButton botonAnterior;
	private String nombreBoton;
	private Color colorBoton;
	private boolean estadoBoton = true;

	public Mapa(String rA, String rB) {
		setTitle("Mapa: Ejercitos");
		int longReinoA = (int) (Math.random() * 10 + 1);
		int longReinoB = (int) (Math.random() * 10 + 1);
		ArrayList<String> pos = posAzar(longReinoA + longReinoB);
		reinoA = new Reino(rA, pos, 0, longReinoA);
		reinoB = new Reino(rB, pos, longReinoA, longReinoA + longReinoB);
		setSize(700, 700);
		setLayout(new GridLayout(11, 10, 5, 5));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		createContends();
		setVisible(true);
	}

	// Genera una lista de todas las posiciones posibles en el mapa
	public ArrayList<String> todasPosiciones() {
		ArrayList<String> pos = new ArrayList<String>();
		int inicial = 65;
		for (int i = 0; i < 10; i++) {
			String value = String.valueOf((char) (inicial + i));
			for (int j = 1; j <= 10; j++) // Valores de 1 a 10
				pos.add(value + (j));
		}
		return pos;
	}

	// Genera una lista de posiciones aleatorias en el mapa
	public ArrayList<String> posAzar(int nPos) {
		ArrayList<String> pos = new ArrayList<String>();
		ArrayList<String> todasPos = todasPosiciones();
		for (int i = 0; i < nPos; i++) {
			int nAzar = (int) (Math.random() * (100 - i));
			pos.add(todasPos.get(nAzar));
			todasPos.remove(nAzar);
		}
		return pos;
	}

	// Convierte una posición en cadena a un índice entero
	public int convertirPos(String pos) {
		int unidad, decena;
		unidad = Integer.valueOf(pos.charAt(0)) - 65;
		decena = Integer.valueOf(pos.substring(1)) - 1;
		return decena * 10 + unidad;
	}

	// Convierte un índice entero a su representación en cadena
	public String convertirPos(int pos) {
		String numero, letra;
		letra = String.valueOf((char) (pos % 10 + 65));
		numero = String.valueOf(pos / 10 + 1);
		return letra + numero;
	}

	// Convierte las posiciones de un reino de cadenas a índices enteros
	public ArrayList<Integer> todasPosicionesConvertidas(Reino r) {
		ArrayList<Integer> posConvertidas = new ArrayList<Integer>();
		ArrayList<String> posSinConvertir = r.getPosiciones();
		int longitud = posSinConvertir.size();
		for (int i = 0; i < longitud; i++) {
			int pos = convertirPos(posSinConvertir.get(i));
			posConvertidas.add(pos);
		}
		return posConvertidas;
	}

	// Verifica si una posición está ocupada por un ejército
	public boolean esPosicion(ArrayList<Integer> posicion, int i) {
		for (int j = 0; j < posicion.size(); j++)
			if (i == posicion.get(j))
				return true;
		return false;
	}

	public void indiceAlfabetico() {
		for (int i = 0; i < 10; i++) {
			String letra = String.valueOf((char) (i + 65));
			JLabel indiceAlf = new JLabel(letra, SwingConstants.CENTER);
			add(indiceAlf);
		}
	}

	public void indiceNumerico(int i) {
		if (i % 10 == 0) {
			String num = String.valueOf(i / 10 + 1);
			JLabel indiceNum = new JLabel(num, SwingConstants.CENTER);
			add(indiceNum);
		}
	}

	// Calcula la probabilidad de victoria de un ejército sobre otro
	public double probVitoria(Ejercito e1, Ejercito e2) {
		int total = e1.getVidaEjercito() + e2.getVidaEjercito();
		return e1.getVidaEjercito() * 100.00 / total;
	}

	public Ejercito ganador(Ejercito e1, Ejercito e2) {
		double probE1 = probVitoria(e1, e2);
		double probE2 = 100 - probE1;
		if (probE1 >= probE2)
			return e1;
		else
			return e2;
	}

	public Ejercito perdedor(Ejercito e1, Ejercito e2) {
		double probE1 = probVitoria(e1, e2);
		double probE2 = 100 - probE1;
		if (probE1 <= probE2)
			return e1;
		else
			return e2;
	}

	public void batalla(Ejercito e1, Ejercito e2) {
		int longE1 = e1.numeroSoldados();
		int longE2 = e2.numeroSoldados();
		ArrayList<String> pos = posAzar(longE1 + longE2);
		e1.addPosSoldado(pos, 0);
		e2.addPosSoldado(pos, longE1);
		double probEjercito1 = probVitoria(e1, e2);
		double numAleatorio = Math.random() * 100;
		new MapaEjercito(e1, e2);
		new VentanaBatalla(e1, e2, probEjercito1, numAleatorio);
	}

	private void createContends() {
		ArrayList<Integer> posReinoA = todasPosicionesConvertidas(reinoA);
		ArrayList<Integer> posReinoB = todasPosicionesConvertidas(reinoB);
		JLabel esquinaSuperiorIzquierda = new JLabel("", SwingConstants.CENTER);
		add(esquinaSuperiorIzquierda);
		indiceAlfabetico();
		for (int i = 0; i < 100; i++) {
			indiceNumerico(i);
			JButton boton;
			if (esPosicion(posReinoA, i)) {
				boton = new JButton(reinoA.nombreEjercito(convertirPos(i)));
				boton.setBackground(BLUE);
			} else if (esPosicion(posReinoB, i)) {
				boton = new JButton(reinoB.nombreEjercito(convertirPos(i)));
				boton.setBackground(RED);
			} else {
				boton = new JButton("");
				boton.setBackground(Color.LIGHT_GRAY);
			}
			add(boton);
			boton.addActionListener(new Listener());
		}
	}

	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton a = (JButton) e.getSource();
			if (!reinoA.reinoConEjercitos()) {
				new VentanaIterativa("Ha ganado reino 2: " + reinoB.getNombre());
				this.dispose();
			} else if (!reinoB.reinoConEjercitos()) {
				new VentanaIterativa("Ha ganado reino 1: " + reinoA.getNombre());
				this.dispose();
			} else {
				if (estadoBoton && a.getText() != "") {
					botonAnterior = a;
					colorBoton = a.getBackground();
					nombreBoton = a.getText();
					a.setText("");
					a.setBackground(Color.LIGHT_GRAY);
					estadoBoton = false;
				} else if (!estadoBoton && a.getText() == "") {
					a.setText(nombreBoton);
					a.setBackground(colorBoton);
					estadoBoton = true;
				} else if (!estadoBoton && a.getText() != "" && colorBoton.equals(a.getBackground())) {
					botonAnterior.setText(nombreBoton);
					botonAnterior.setBackground(colorBoton);
					estadoBoton = true;
				} else if (!estadoBoton && a.getText() != "" && !colorBoton.equals(a.getBackground())
						&& a.getBackground().equals(BLUE)) {
					Ejercito ejercitoAta = reinoB.ejercitoPorNombre(nombreBoton);
					ejercitoAta.setColorEjercito(colorBoton);
					Ejercito ejercitoDef = reinoA.ejercitoPorNombre(a.getText());
					ejercitoDef.setColorEjercito(a.getBackground());
					batalla(ejercitoDef, ejercitoAta);
					Ejercito winner = ganador(ejercitoAta, ejercitoDef);
					Ejercito losser = perdedor(ejercitoAta, ejercitoDef);
					losser.ejercitoPerdio();
					a.setText(winner.getNombreEnTablero());
					a.setBackground(winner.getColorEjercito());
					estadoBoton = true;
				} else if (!estadoBoton && a.getText() != "" && !colorBoton.equals(a.getBackground())
						&& a.getBackground().equals(RED)) {
					Ejercito ejercitoDef = reinoB.ejercitoPorNombre(a.getText());
					ejercitoDef.setColorEjercito(a.getBackground());
					Ejercito ejercitoAta = reinoA.ejercitoPorNombre(nombreBoton);
					ejercitoAta.setColorEjercito(colorBoton);
					batalla(ejercitoDef, ejercitoAta);
					Ejercito winner = ganador(ejercitoAta, ejercitoDef);
					Ejercito losser = perdedor(ejercitoAta, ejercitoDef);
					losser.ejercitoPerdio();
					a.setText(winner.getNombreEnTablero());
					a.setBackground(winner.getColorEjercito());
					estadoBoton = true;
				}
			}
		}

		public void dispose() {
		}
	}
}