package Model;
import javax.swing.*;
import java.util.Random;

public class Hilo implements Runnable{
    private JProgressBar barra;
    private boolean stopTh;

    public Hilo(JProgressBar barra) {
        this.barra = barra;
        stopTh = false;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100 && stopTh==false; i++) {
            barra.setValue(i);
            barra.repaint();
            try {
                Thread.sleep(new Random().nextInt(101) + 100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
