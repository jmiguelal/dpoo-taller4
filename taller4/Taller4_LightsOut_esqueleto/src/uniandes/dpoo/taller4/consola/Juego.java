package uniandes.dpoo.taller4.consola;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uniandes.dpoo.taller4.modelo.Tablero;

public class Juego {
    private int size;
    private interfaz gameInterface;
    private JButton reiniciarButton;
    private JButton nuevoButton;
    private Tablero tablero;
    public static void main(String[] args) {
        new Juego();
    }

    public Juego() {
        JComboBox<String> tamanoSelector = new JComboBox<>(new String[] { "5x5", "4x4", "3x3" });
        tamanoSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String seleccion = (String) tamanoSelector.getSelectedItem();
                if (seleccion.equals("5x5")) {
                    size = 5;
                } else if (seleccion.equals("4x4")) {
                    size = 4;
                } else if (seleccion.equals("3x3")) {
                    size = 3;
                }
                tablero = new Tablero(size);
                if (gameInterface == null) {
                    gameInterface = new interfaz(tablero, size);
                    JFrame frame = new JFrame("LightsOut Game");
                    JPanel panel = new JPanel();
                    reiniciarButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            tablero.reiniciar();
                            gameInterface.actualizarTablero(tablero);
                        }
                    });
                    nuevoButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            JComboBox<String> tamanoSelector = new JComboBox<>(new String[] { "5x5", "4x4", "3x3" });
                            tamanoSelector.setSelectedIndex(0); // Establece el valor predeterminado
                            tamanoSelector.getActionListeners()[0].actionPerformed(null); // Simula la selección inicial
                        }
                    });


                    reiniciarButton = new JButton("Reiniciar");
                    nuevoButton = new JButton("Nuevo");
                    panel.add(reiniciarButton);
                    panel.add(nuevoButton);
                    panel.add(tamanoSelector);
                    panel.add(gameInterface);
                    frame.add(panel);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                } else {
                    gameInterface.actualizarTablero(tablero);
                }
            }
        });
        JFrame frame = new JFrame("LightsOut Game");
        frame.add(tamanoSelector);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    
    
}
