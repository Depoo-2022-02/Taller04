package interfaz;

import javax.swing.*;
import javax.swing.border.LineBorder;

import uniandes.dpoo.taller4.modelo.Tablero;

import java.awt.*;
import java.awt.event.*;

public class PanelDificultad extends JPanel implements ActionListener{
	
	 
	 public final static String EASY = "EASY";

	    /**
	     * Opción anular.
	     */
	    public final static String MEDIUM = "MEDIUM";

	    /**
	     * Opción buscar.
	     */
	    public final static String HARD = "HARD";
	    
	//Atributos de interfaz
	private InterfazLightsOut principal;
	
	private JComboBox comboSize;
	
	public PanelDificultad( InterfazLightsOut pPrincipal)
	{
		principal = pPrincipal;
		
		setLayout(new FlowLayout());
		setBackground(Color.black);
		
		
		JLabel etiquetaComboSize = new JLabel(" Size: ");
		etiquetaComboSize.setHorizontalAlignment(JLabel.LEFT);
		etiquetaComboSize.setForeground(Color.magenta);
		
		comboSize = new JComboBox<String>();
		comboSize.setBounds(100,10,100,20);
		comboSize.addItem("5x5");
		comboSize.addItem("6x6");
		comboSize.addItem("7x7");
		comboSize.addItem("8x8");
		
		comboSize.addActionListener(this);
			  
		JLabel etiquetaDificultad = new JLabel(" Dificulty: ");
		etiquetaDificultad.setHorizontalAlignment(JLabel.LEFT);	
		etiquetaDificultad.setForeground(Color.magenta);
		
		ButtonGroup grupoDificultad = new ButtonGroup();
		JRadioButton easyButton = new JRadioButton("Easy", true);
		easyButton.setActionCommand( EASY );
		easyButton.addActionListener(this );
		easyButton.setBackground(Color.BLACK);
		easyButton.setForeground(Color.magenta);
		JRadioButton mediumButton = new JRadioButton("Medium", false);
		mediumButton.setActionCommand( MEDIUM );
		mediumButton.addActionListener(this );
		mediumButton.setBackground(Color.BLACK);
		mediumButton.setForeground(Color.magenta);
		JRadioButton hardButton = new JRadioButton("Hard", false);
		hardButton.setActionCommand( HARD );
		hardButton.addActionListener(this );
		hardButton.setBackground(Color.BLACK);
		hardButton.setForeground(Color.magenta);
		
		grupoDificultad.add(easyButton);
		grupoDificultad.add(mediumButton);
		grupoDificultad.add(hardButton);
		
		
		
		add(etiquetaComboSize);
		add(comboSize);
		add(etiquetaDificultad);
		add(easyButton);
		add(mediumButton);
		add(hardButton);
	
		
		
		
		//buttonGroup();
	}
	
	
	public void itemStateChanged(ItemEvent e)
	{
		if(comboSize.getSelectedItem().equals("5x5"))
		{
			Tablero eltablero = new Tablero(5);
		
		}
		else if (comboSize.getSelectedItem().equals("6x6")) {
			Tablero eltablero = new Tablero(6);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		  String comando = e.getActionCommand( );

	        if( comando.equals( EASY ) )
	        {
	        	principal.dificultadEasy();
	        }
	        else if( comando.equals( MEDIUM ) )
	        {
	            
	            principal.dificultadMedium();
	        }
	        else if( comando.equals( HARD ) )
	        {
	            
	            principal.dificultadHard();
	        }
	        else if(comboSize.getSelectedItem().equals("5x5")) 
	        {
	        	Tablero eltablero = new Tablero(5);
	        	principal.crearTableroNuevo(eltablero);
	        }
	        else if(comboSize.getSelectedItem().equals("6x6")) 
	        {
	        	Tablero eltablero = new Tablero(6);
	        	principal.crearTableroNuevo(eltablero);
	        }
	        
	        else if(comboSize.getSelectedItem().equals("7x7")) 
	        {
	        	Tablero eltablero = new Tablero(7);
	        	principal.crearTableroNuevo(eltablero);
	        }
	        else if(comboSize.getSelectedItem().equals("8x8")) 
	        {
	        	Tablero eltablero = new Tablero(8);
	        	principal.crearTableroNuevo(eltablero);
	        }
	       
		
	}
}
