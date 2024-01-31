import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VentanaBatalla extends JFrame{
	private Ejercito ejercito1;
	private Ejercito ejercito2;
	private double probEjer1Vic;
	private double numAzar;
	
	public VentanaBatalla(Ejercito e1, Ejercito e2, double probE1, double n){
		ejercito1 = e1;
		ejercito2 = e2;
		probEjer1Vic = probE1;
		numAzar = n;
		setTitle("Batalla");
		setSize(320, 530);
		setLocation(750, 250);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createContends();
		setVisible(true);
	}
	private void createContends(){
		// Tres paneles
		JPanel panelE1 = new JPanel(new GridLayout(8, 2, 5, 5));
		panelEjercito(panelE1, ejercito1, probEjer1Vic);
		add(panelE1, BorderLayout.NORTH);
		
		JPanel panelE2 = new JPanel(new GridLayout(8, 2, 5, 5));
		panelEjercito(panelE2, ejercito2, 100 - probEjer1Vic);
		add(panelE2, BorderLayout.CENTER);
		
		String text = enunciadoVictoria();
		JTextArea textVictory = new JTextArea(text);
		textVictory.setEditable(false);
		textVictory.setLineWrap(true);
		textVictory.setWrapStyleWord(true);
		add(textVictory, BorderLayout.SOUTH);
	}
	public void panelEjercito(JPanel panel, Ejercito ejer, double prob){
		JLabel reino, nSold, esp, arq, cab, lan, vida, probVic;
		reino = new JLabel("  Ejercito:");
		nSold = new JLabel("  Soldados creados:");
		esp = new JLabel("  Espadachines:");
		arq = new JLabel("  Arqueros:");
		cab = new JLabel("  Caballeros:");
		lan = new JLabel("  Lanceros:");
		vida = new JLabel("  Vida del ejercito:");
		probVic = new JLabel("  Probabilidad de Victoria:");
		JTextField r, nS, e, a, c, l, v, pV;
		r = new JTextField(ejer.getNombreReino(), 10);
		nS = new JTextField(String.valueOf(ejer.numeroSoldados()), 10);
		e = new JTextField(String.valueOf(ejer.getCountEsp()), 10);
		a = new JTextField(String.valueOf(ejer.getCountArq()), 10);
		c = new JTextField(String.valueOf(ejer.getCountCab()), 10);
		l = new JTextField(String.valueOf(ejer.getCountLan()), 10);
		v = new JTextField(String.valueOf(ejer.getVidaEjercito()), 10);
		pV = new JTextField(String.valueOf(prob) + "%", 10);
		r.setEditable(false); nS.setEditable(false); e.setEditable(false);
		a.setEditable(false); c.setEditable(false); l.setEditable(false);
		v.setEditable(false); pV.setEditable(false);
		panel.add(reino); panel.add(r);
		panel.add(nSold); panel.add(nS);
		panel.add(esp); panel.add(e);
		panel.add(arq); panel.add(a);
		panel.add(cab); panel.add(c);
		panel.add(lan); panel.add(l);
		panel.add(vida); panel.add(v);
		panel.add(probVic); panel.add(pV);
	}
	public String enunciadoVictoria(){
		Ejercito ganador;
		if(numAzar <= probEjer1Vic)
			ganador = ejercito1;
		else
			ganador = ejercito2;
		String enun = "El ganador es el ejercito de: " +
			ganador.getNombreReino() + 
			". Ya que al generar los porcentajes	de probabilidad " + 
			"de victoria basada en los niveles de vida de sus" +
			"soldados y aplicando un experimento aleatorio salió " + 
			"vencedor. Aleatorio generado: " + numAzar;
		return enun;
	}
}