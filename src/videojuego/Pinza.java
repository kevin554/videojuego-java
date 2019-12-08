package videojuego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Pinza {

    private int x;
    private int y;
    private int ancho;
    private int alto;
    private int cursor;

    private boolean hayContenidoParaSoltar = false;

    public Pinza() {
    }

    public Pinza(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public void dibujar(Graphics g) {
        Polygon pinza = new Polygon(new int[]{x, x + ancho, x + ancho, x},
                new int[]{y, y, y + (alto / 2), y + (alto / 2)},
                4);

        if (hayContenidoParaSoltar) {
            g.setColor(Color.red);
            g.fillPolygon(pinza);
        }

        g.setColor(Color.black);
        g.drawPolygon(pinza);
    }

    public void derecha(int anchoPantalla) {
        x += ancho;
    }

    public void izquierda() {
        x -= ancho;
    }

    public void levantar() {
        hayContenidoParaSoltar = true;
    }

    public void soltar() {
        hayContenidoParaSoltar = false;
    }

    // <editor-fold defaultstate="collapsed" desc="getters y setters">
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getCursor() {
        return cursor;
    }

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

}
