package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import uniandes.dpoo.taller4.modelo.Tablero;


public class PanelTablero extends JPanel  implements MouseListener{
	
	
	 /**
     * Avión del modelo del mundo.
     */
    private Tablero tablero;
    
    /**
     * Interfaz principal.
     */
    private InterfazLightsOut ventana;

    /**
     * Ancho del panel
     */
    private int anchoP;
    
    /**
     * Alto del panel
     */
    private int altoP;
    
    private int tamaño;
    
    private int clicks;

    /**
     * Imagen del avion
     */
    private BufferedImage imagen;

    public PanelTablero(InterfazLightsOut pVentana, Tablero pTablero)
	{
    
       	ventana = pVentana;
        tablero = pTablero;
   
        clicks = 0;
        try {
        	imagen = ImageIO.read(new File("./data/luz.png"));
        } catch (IOException e) {
        	e.printStackTrace();
        }

        
        setPreferredSize( new Dimension( imagen.getWidth( ), imagen.getHeight( ) ) );
        setOpaque( false );
        
        
         addMouseListener( this );
         
         anchoP = getWidth();
         altoP = getHeight();
  
	}
	
    /**
     * Dibuja los elementos graficos en el canvas de dibujo del panel.
     * Se llama al abrir la ventana de la aplicación y al hacer el llamado al metodo repaint()
     * @param pGrafica Gráficos del avión. pGrafica != null
     */
    
    
    public void paint( Graphics g )
    {
    
    	super.paint( g );
    	
    	
    	anchoP = getWidth();
        altoP = getHeight();
    	
    	 int boxWidth = anchoP / tablero.darTablero().length ;
         int boxHeight = altoP /tablero.darTablero().length ;
    	
        int y = 0;
        for (int row = 0; row < tablero.darTablero().length; row++) {
            int x = 0;
            for (int col = 0; col < tablero.darTablero().length; col++) {
                if (tablero.darTablero()[row][col]==true) {
                    g.setColor(Color.YELLOW);
                   
                } else {
                    g.setColor(Color.BLACK);
                }
                g.fillRect(x, y, boxWidth, boxHeight);
                
                //g.drawImage( imagen, x, y, imagen.getWidth(), imagen.getHeight(), this );

                g.setColor(Color.BLUE);
                g.drawRect(x, y, boxWidth, boxHeight);
                x += boxWidth;
            }
            y += boxHeight;
        }
    }
 
    
    
   
    
    
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public int darClicks() {
		return clicks;
	}
	@Override
	 public void mousePressed(MouseEvent e) {
		
		int mouseX = e.getX();
        int mouseY = e.getY();


        int boxWidth = anchoP / tablero.darTablero()[0].length;
        int boxHeight = altoP /  tablero.darTablero().length;

        int col = mouseX / boxWidth;
        int row = mouseY / boxHeight;

        toggle(row, col);
        repaint();
        
        clicks += e.getClickCount();
        System.out.println(clicks);
    }
	
	public void toggle(int row, int col) {

        if (row >= 0 && col >= 0 && row < tablero.darTablero().length && 
            col < tablero.darTablero()[0].length)
        {
            if (tablero.darTablero()[row][col] == true) {
            	tablero.jugar(row, col);
            } else {
            	tablero.darTablero()[row][col] = true;
            }
        }

    }


    // called to "toggle" the selected row and column, as well as the four
    // adjacent lights
   
	

	@Override
	public void mouseReleased(MouseEvent e) {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}