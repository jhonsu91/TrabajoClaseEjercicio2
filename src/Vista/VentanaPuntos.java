package Vista;

import Modelo.Arista;
import Modelo.Aristas;
import Modelo.DialogAnadeAristas;
import Modelo.PanelPuntos;
import Modelo.Puntos;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author SUNTAXI
 */
public class VentanaPuntos extends JFrame {

    // modelo
    private Puntos puntos = new Puntos();
    private Aristas aristas = new Aristas();
// componentes
    private JButton bAnadeAristas = new JButton("Añade Aristas");
    private PanelPuntos panelPuntos = new PanelPuntos(puntos, aristas);

// diálogo para añadir aristas
    private DialogAnadeAristas dialogoAnadeArista = new DialogAnadeAristas(this);

    /**
     *
     *
     * Constructor de la ventana
     */
    public VentanaPuntos() {
        super("Une Puntos");
// distribuye componentes (no se pedía en el examen)
// Panel en el centro
        add(panelPuntos, BorderLayout.CENTER);
// Botón en el sur dentro de un flow 
        JPanel pB = new JPanel(new FlowLayout());
        pB.add(bAnadeAristas);
        add(pB, BorderLayout.SOUTH);

// añade manejadores
        bAnadeAristas.addActionListener(new manejadorBotonAñade());

// finaliza configuración de la ventana 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

//Manejador del botón que permite añadir aristas 
    private class manejadorBotonAñade implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
// muestra el diálogo
            int[] ptos = dialogoAnadeArista.muestra();
// si retorna null es porqué el usuario ha cancelado el // diálogo o ha ocurrido algún otro problema 
            if (ptos != null) {
                for (int i = 0; i < ptos.length - 1; i++) // añade cada arista
                {
                    aristas.anade(new Arista(puntos.punto(ptos[i]), puntos.punto(ptos[i + 1])));
                }

// repinta el panel 
                panelPuntos.repaint();
            }
        }

    }
//Método main. Crea la ventana principal de la aplicación */

    public static void main(String[] args) {
        new VentanaPuntos();

    }

}
