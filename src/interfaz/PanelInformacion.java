package interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PanelInformacion extends JPanel {

	//Atributos interfaz
		private InterfazLightsOut principal;
		private PanelTablero panelTablero;
		
		private JLabel caja_de_texto;
		
		public PanelInformacion(InterfazLightsOut pPrincipal,PanelTablero tablero) {
			
			principal = pPrincipal;
			panelTablero = tablero;
			
			
			
			 setLayout( new GridLayout( 1, 4, 0, 50 ) );
			setBackground(Color.black);
			
			
			JLabel jugadas = new JLabel(" Jugadas: ");
			//jugadas.setHorizontalAlignment(JLabel.LEFT);
			jugadas.setForeground(Color.magenta);
			
			caja_de_texto= new JLabel(panelTablero.darClicks()+ "");
			//caja_de_texto.setHorizontalAlignment(JTextField.LEFT);
			caja_de_texto.setForeground(Color.magenta);
			
	
			
			JLabel nombre = new JLabel(" Nombre: ");
			//nombre.setHorizontalAlignment(JLabel.RIGHT);
			nombre.setForeground(Color.magenta);
			
			JLabel caja_de_nombre= new JLabel();
			//caja_de_texto.setHorizontalAlignment(JTextField.RIGHT);
			caja_de_nombre.setForeground(Color.magenta);
			
			add(jugadas);
			add(caja_de_texto);
			add(nombre);
			add(caja_de_nombre);
			
			
			
			
			
			
			
		}
		public void actualizar() {
			int clicks = panelTablero.darClicks();
			if(caja_de_texto.toString().equals(clicks+"")) {
				JLabel losclicks = new JLabel(clicks+"");
				caja_de_texto = losclicks ;
			}
		}

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
}
