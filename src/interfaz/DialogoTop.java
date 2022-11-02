package interfaz;

import java.awt.BorderLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Top10;

public class DialogoTop  extends JDialog {
	
	private Top10 top;
	
	private InterfazLightsOut interfaz;
	/**
     * Lista con los espacios.
     */
    private JList listaEspacios;

	
	public DialogoTop(InterfazLightsOut pPrincipal, Top10 topp) {
		interfaz = pPrincipal;
		listaEspacios = new JList( );
		
		top = topp;
	
		Collection<RegistroTop10> lista2 = top.darRegistros();
		
		 setTitle( "Top 10" );
	     setSize( 300, 300 );
	     setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
	     setLayout( new BorderLayout( ) );
	     
	     JPanel panelAux = new JPanel( );
	     panelAux.setBorder( new CompoundBorder( new TitledBorder( "#    Nombre " ), new EmptyBorder( 3, 3, 3, 3 ) ) );
	     panelAux.setLayout( new BorderLayout( ) );
	     add( panelAux, BorderLayout.CENTER );
	     
	     ArrayList prueba = new ArrayList<>();
	     int contador =0;
		 for (Iterator<RegistroTop10> it = lista2.iterator(); it.hasNext(); ) {
				RegistroTop10 actual = it.next();
				contador ++;
				String pueso =contador + "          "+ actual.darNombre() + "        " + actual.darPuntos();
				prueba.add(pueso);
			}	
		 
		 listaEspacios.setListData( prueba.toArray( ) );
		 
		 panelAux.add(listaEspacios);
		 
		
		 

		 
		 
	}
	

}
