/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.swing.*;

/**
 *
 * @author Richard
 */
public class HiloProgreso extends Thread {

    JProgressBar progreso;

    public HiloProgreso(JProgressBar progreso1) {
        super();
        this.progreso = progreso1;
    }

    @Override
    public void run() {
        int i = 0;
        for (i = 1; i <= 100; i++) {
            progreso.setValue(i);
            pausa(100);
        }
       // System.exit(0);
    }

    public void pausa(int mlSeg) {
        try {
            // pausa para el splash
          Thread.sleep(mlSeg);
        } catch (Exception e) {
        }

    }
}
