
package Modelo;

import java.awt.*; 
import javax.swing.JPanel;
/**
 *
 * @author j_h4e
 */

//Panel que muestra los puntos y las aristas que los unen */
public class PanelPuntos extends JPanel {
// referencias a las listas de puntos y aristas 
    private Puntos puntos; 
    private Aristas aristas;

//Crea el panel
//@param puntos lista de puntos a dibujar
//@param aristas lista de aristas a dibujar */
    public PanelPuntos(Puntos puntos, Aristas aristas) { 
        this.puntos = puntos; 
        this.aristas = aristas;
    setPreferredSize(new Dimension(400, 400)); 
    setBackground(Color.LIGHT_GRAY);
    } 
    
    
//sobreescribe el método paintComponent para dibujar los puntos y las aristas */
@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g) ;
// dibuja los puntos 
    int i = 0;
    Punto p;
    while ((p = puntos.punto(i)) != null) {
        g.drawString(String.valueOf(i), p.x, p.y); 
        i++ ;
}
// dibuja las aristas 
    i = 0 ;
    Arista a;
    while ((a = aristas.arista(i)) != null) {
        g.drawLine(a.ptoIni.x, a.ptoIni.y, a.ptoFin.x, a.ptoFin.y);
          i++;
        }
    }

}