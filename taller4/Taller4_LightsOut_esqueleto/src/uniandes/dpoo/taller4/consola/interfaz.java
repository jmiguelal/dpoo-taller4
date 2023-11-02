package uniandes.dpoo.taller4.consola;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uniandes.dpoo.taller4.modelo.Tablero;

public class interfaz extends JPanel {
    private JButton[][] casillas;
    private Tablero tablero;
    

    public interfaz(Tablero tablero, int tamano) {
        this.tablero = tablero;
        setLayout(new GridLayout(tamano, tamano));
        casillas = new JButton[tamano][tamano];

        for (int fila = 0; fila < tamano; fila++) {
            for (int columna = 0; columna < tamano; columna++) {
                casillas[fila][columna] = new JButton();
                casillas[fila][columna].setBackground(Color.BLACK);
                casillas[fila][columna].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int x = -1;
                        int y = -1;
                        for (int i = 0; i < tamano; i++) {
                            for (int j = 0; j < tamano; j++) {
                                if (casillas[i][j] == e.getSource()) {
                                    x = i;
                                    y = j;
                                    break;
                                }
                            }
                            if (x != -1) {
                                break;
                            }
                        }
                        if (x != -1 && y != -1) {
                            cambiarColor(x, y);
                        }
                    }
                }); 
                add(casillas[fila][columna]);
            }
        }
        actualizarTablero(tablero);

    }

    public void actualizarTablero(Tablero tablero) {
        boolean[][] estado = tablero.darTablero();
        for (int fila = 0; fila < estado.length; fila++) {
            for (int columna = 0; columna < estado[fila].length; columna++) {
                if (estado[fila][columna]) {
                    casillas[fila][columna].setBackground(Color.BLACK);
                } else {
                    casillas[fila][columna].setBackground(Color.YELLOW);
                }
            }
        }
    }

    private void cambiarColor(int x, int y) {
        if (casillas[x][y].getBackground() == Color.BLACK) {
            casillas[x][y].setBackground(Color.YELLOW);
        } else {
            casillas[x][y].setBackground(Color.BLACK);
        }

        tablero.jugar(x, y);
    }
    

    
    
}
