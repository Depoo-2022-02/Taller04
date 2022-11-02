package interfaz;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;


import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;

public class InterfazLightsOut  extends JFrame implements WindowListener {
	
	
	 // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Tablero.
     */
    private Tablero tablero;
    
    private Top10 top10;
    
    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Panel que contiene el banner de la aplicación.
     */
    private PanelDificultad panelDificultad;

    /**
     * Panel que contiene el avión.
     */
    private PanelTablero panelTablero;

    /**
     * Panel de botones.
     */
    private JPanel panelBotones;

    /**
     * Diálogo de nuevo pasajero.
     */
    private PanelInformacion panelInformacion;
    
    
    private DialogoTop dTop;
    
    /**
     * Crea la interfaz del avión. <br>
     * <b>post: </b> Se crea el avión y se presenta en una gráfica su estado inicial.
     */
    public InterfazLightsOut() {

        setTitle( "LightsOut" );
        setSize( 800, 600 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        tablero = new Tablero(5);
        top10 = new Top10();
        
        String ruta = "./data/top10.csv";
        File file = new File(ruta);
        top10.cargarRecords(file);

        // Configura la interfaz
        setLayout( new BorderLayout( ) );

        // Panel de la dificultad
        panelDificultad = new PanelDificultad(this );
        add( panelDificultad, BorderLayout.NORTH );

        // Panel del tablero
        panelTablero = new PanelTablero(this, tablero);
        add( panelTablero, BorderLayout.CENTER );

        // Panel de botones
        panelBotones = new PanelBotones(this);
        add( panelBotones, BorderLayout.EAST);
        
        //Panel de información
        
        panelInformacion = new PanelInformacion(this, panelTablero);
        add(panelInformacion, BorderLayout.SOUTH);
        panelInformacion.actualizar();
        
        
        addWindowListener(new WindowAdapter()
        {
        public void windowClosing(WindowEvent e)
        {
        //salvarTop10();
        }
        });

        setResizable( false );
        setLocationRelativeTo( null );
        
        // Configurar ventana para llamar al metodo dispose() al cerrar la ventana
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
    }
    
    public void mostrarTop10( )
    {
        dTop = new DialogoTop( this, top10 );
        dTop.setVisible( true );
    
    }
    
    public void crearTableroNuevo(Tablero ptablero) {
    	remove( panelTablero );
        tablero = ptablero;
        panelTablero = new PanelTablero( this, ptablero );
        add( panelTablero, BorderLayout.CENTER );
        validate( );
    }
    
    
    
    public void dificultadEasy() {
    	tablero.desordenar(5);
    	actualizarPanelTablero();
    }
    
    public void dificultadMedium() {
    	tablero.desordenar(9);
    	actualizarPanelTablero();
    }
    
    public void dificultadHard() {
    	tablero.desordenar(13);
    	actualizarPanelTablero();
    }
    
    
    public void nuevoTablero() {
    	
    	tablero.reiniciar();
    	actualizarPanelTablero();
    	
    }
    
    public void reiniciarTablero() {
    	tablero.desordenar(1);
    	actualizarPanelTablero();
    }
    
    
    /**
     * Repinta la gráfica del avión.
     */
    public void actualizarPanelTablero( )
    {
        remove( panelTablero );

        // Panel del avión
        panelTablero = new PanelTablero( this, tablero );
        add( panelTablero, BorderLayout.CENTER );
        validate( );
    }
    
    
    
    /**
     * Ejecuta la aplicación.
     * @param pArgs Parámetros de la ejecución. No son necesarios.
     */
    public static void main( String[] pArgs )
    {
        try
        {
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

            InterfazLightsOut interfaz = new InterfazLightsOut( );
            interfaz.setVisible( true );
            FlatLightLaf.install();
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }


	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
    
    
    
}
