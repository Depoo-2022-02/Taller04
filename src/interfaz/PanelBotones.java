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
     * Opción registrar.
     */
    public final static String NUEVO = "NUEVO";

    /**
     * Opción anular.
     */
    public final static String REINICIAR = "REINICIAR";

    /**
     * Opción buscar.
     */
    public final static String TOP_10 = "TOP_10";

    /**
     * Opción porcentaje de ocupación.
     */
    public final static String CAMBIAR_JUGADOR = "CAMBIAR_JUGADOR";

	
    
    /**
     * Botón Registro de nuevo pasajero.
     */
    private JButton bNuevo;

    /**
     * Botón Anular.
     */
    private JButton bReiniciar;

    /**
     * Botón de búsqueda.
     */
    private JButton bTop_10;

    /**
     * Botón porcentaje de ocupación.
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
