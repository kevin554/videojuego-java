package videojuego;

import javax.swing.JFrame;

public class Ventana extends JFrame {

    public Ventana() {
        init();
    }
    
    private void init() {
        PanelJuego panelJuego = new PanelJuego();
        this.addKeyListener(panelJuego);
        
        add(panelJuego);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

}
