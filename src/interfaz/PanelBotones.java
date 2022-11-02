package interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class PanelBotones extends JPanel implements ActionListener {

	 /**
     * Opci�n registrar.
     */
    public final static String NUEVO = "NUEVO";

    /**
     * Opci�n anular.
     */
    public final static String REINICIAR = "REINICIAR";

    /**
     * Opci�n buscar.
     */
    public final static String TOP_10 = "TOP_10";

    /**
     * Opci�n porcentaje de ocupaci�n.
     */
    public final static String CAMBIAR_JUGADOR = "CAMBIAR_JUGADOR";

	
    
    /**
     * Bot�n Registro de nuevo pasajero.
     */
    private JButton bNuevo;

    /**
     * Bot�n Anular.
     */
    private JButton bReiniciar;

    /**
     * Bot�n de b�squeda.
     */
    private JButton bTop_10;

    /**
     * Bot�n porcentaje de ocupaci�n.
     */
    private JButton bCambiar_jugador;
    
    /**
     * Interfaz principal.
     */
    private InterfazLightsOut ventana;
	
	public PanelBotones(InterfazLightsOut pVentana) {
		
		 // Guarda la referencia a la ventana padre
        ventana = pVentana;

        
        setLayout( new GridLayout( 4, 1, 0, 100 ) );
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        
       	bNuevo = new JButton( "Nuevo" );
        bNuevo.setActionCommand( NUEVO );
        bNuevo.addActionListener(this );
        bNuevo.setPreferredSize( new Dimension( 40, 10 ) );
        add( bNuevo );

      
       	bReiniciar = new JButton( "Reiniciar" );
        bReiniciar.setActionCommand( REINICIAR );
        bReiniciar.addActionListener(this);
        add( bReiniciar );

    
       	bTop_10 = new JButton( "TOP-10" );
        bTop_10.setActionCommand( TOP_10 );
        bTop_10.addActionListener(this );
        add( bTop_10 );

        
       	bCambiar_jugador = new JButton( "Cambiar Jugador" );
        bCambiar_jugador.setActionCommand( CAMBIAR_JUGADOR );
        bCambiar_jugador.addActionListener(this );
        add( bCambiar_jugador );
				
		
	}
	
	public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( NUEVO ) )
        {
        	ventana.reiniciarTablero();
        }
        else if( comando.equals( REINICIAR ) )
        {
            
            ventana.nuevoTablero();
        }
        else if( comando.equals( TOP_10 ) )
        {
            
            ventana.mostrarTop10();
        }
       
    }
	
	
}
