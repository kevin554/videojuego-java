package videojuego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelJuego extends JPanel implements KeyListener {

    private int cantidadPilas = 7;
    private Pinza laPinza = new Pinza();
    private int cursor = 0;
    private int limite = 4;
    private boolean hayContenidoParaSoltar = false;
    private ArrayList<Integer> contenidoCaja = new ArrayList<>();

    public PanelJuego() {
        laPinza.setX(0);
        laPinza.setY(0);

        contenidoCaja.add(3);
        contenidoCaja.add(1);
        contenidoCaja.add(2);
        contenidoCaja.add(1);
        contenidoCaja.add(4);
        contenidoCaja.add(0);
        contenidoCaja.add(1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.black);
        g.drawLine(0, 50, getWidth(), 50);

        int anchoCaja = getWidth() / cantidadPilas;
        int altoCaja = anchoCaja;

        laPinza.setAncho(anchoCaja);
        laPinza.setAlto(altoCaja);
        laPinza.dibujar(g);

        for (int i = 0; i < contenidoCaja.size(); i++) {
            for (int j = 1; j <= contenidoCaja.get(i); j++) {
                g.setColor(Color.red);
                g.fillRect(i * anchoCaja, getHeight() - (altoCaja * j),
                        anchoCaja, altoCaja);

                g.setColor(Color.black);
                g.drawRect(i * anchoCaja, getHeight() - (altoCaja * j),
                        anchoCaja, altoCaja);

            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 480);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                if (cursor != 0) {
                    cursor--;
                    laPinza.izquierda();
                }

                break;

            case KeyEvent.VK_RIGHT:
                if (cursor != cantidadPilas - 1) {
                    cursor++;
                    laPinza.derecha(getWidth());
                }

                break;

            case KeyEvent.VK_UP:
                if (!hayContenidoParaSoltar
                        && contenidoCaja.get(cursor) != 0) {
                    int cantidadCajas = contenidoCaja.get(cursor);
                    hayContenidoParaSoltar = true;

                    laPinza.levantar();
                    contenidoCaja.set(cursor, cantidadCajas - 1);
                }

                break;

            case KeyEvent.VK_SPACE:
                if (contenidoCaja.get(cursor) < limite
                        && hayContenidoParaSoltar) {
                    int cantidadCajas = contenidoCaja.get(cursor);
                    hayContenidoParaSoltar = false;

                    laPinza.soltar();
                    contenidoCaja.set(cursor, cantidadCajas + 1);
                }

                break;

            default:
                break;
        }

        repaint();
    }

}
