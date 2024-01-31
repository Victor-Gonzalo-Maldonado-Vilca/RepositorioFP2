import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class VentanaIterativa extends JFrame{
	private String mensaje = "";
	private String [] reinos = {"Inglaterra", "Francia", "Imperio Sacro", "Aragon", "Moros"};
	private int reino1;
	private int reino2;
	private JButton si;
	private JButton no;
	
	public VentanaIterativa(String m){
		mensaje = m;
		setTitle("Guerras de Imperios");
		reinoAzar();
		setSize(300, 200);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		createContends();
		setVisible(true);
	}
	public void reinoAzar(){
		int numAzar1 = (int)(Math.random() * 5);
		int numAzar2 = (int)(Math.random() * 5);
		while(numAzar1 == numAzar2)
			numAzar2 = (int)(Math.random() * 5);
		reino1 = numAzar1;
		reino2 = numAzar2;
	}
	private void createContends(){
		// Tres paneles
		if(!mensaje.equals("")){
			JLabel reinoGanador = new JLabel(mensaje, SwingConstants.CENTER);
			add(reinoGanador, BorderLayout.NORTH);
		}
		JLabel iterador = new JLabel("Desea empezar una guerra nueva?", SwingConstants.CENTER);
		add(iterador, BorderLayout.CENTER);
		
		JPanel botones = new JPanel(new BorderLayout());
		si = new JButton("Si");
		no = new JButton("No");
		botones.add(si, BorderLayout.EAST);
		botones.add(no, BorderLayout.WEST);
		add(botones, BorderLayout.SOUTH);
		si.addActionListener(new Listener());
		no.addActionListener(new Listener());
	}
	private class Listener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(e.getSource() == si){
				new Mapa(reinos[reino1], reinos[reino2]);
				dispose();
			}else
				System.exit(0);
		}
	}
}