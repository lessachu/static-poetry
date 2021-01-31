package com.company;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JFrame;


public class FullScreenJFrame extends JFrame{

    private GraphicsDevice vc;
    private WhiteNoiseThread generatorThread;

    public FullScreenJFrame(Float volume){
        super();

        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc= e.getDefaultScreenDevice();
        setFullScreen(this);

        generatorThread = new WhiteNoiseThread(volume);
        generatorThread.start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                generatorThread.exit();
                System.exit(0);
            }
        });
    }

    public void setFullScreen(JFrame f){

        f.setUndecorated(true);
        f.setResizable(false);
        vc.setFullScreenWindow(f);

    }


}


