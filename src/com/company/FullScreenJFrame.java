package com.company;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.sound.sampled.*;
import java.nio.ByteBuffer;
import java.util.Random;

import javax.swing.JFrame;


public class FullScreenJFrame extends JFrame{

    private GraphicsDevice vc;
    private GeneratorThread generatorThread;

    public FullScreenJFrame(){
        super();

        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc= e.getDefaultScreenDevice();
        setFullScreen(this);

        generatorThread = new GeneratorThread();
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

    class GeneratorThread extends Thread {

        final static public int SAMPLE_SIZE = 2;
        final static public int PACKET_SIZE = 5000;

        SourceDataLine line;
        public boolean exitExecution = false;

        public void run() {

            try {
                AudioFormat format = new AudioFormat(44100, 16, 1, true, true);
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format, PACKET_SIZE * 2);

                if (!AudioSystem.isLineSupported(info)) {
                    throw new LineUnavailableException();
                }

                line = (SourceDataLine)AudioSystem.getLine(info);
                line.open(format);
                line.start();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
                System.exit(-1);
            }

            ByteBuffer buffer = ByteBuffer.allocate(PACKET_SIZE);

            Random random = new Random();
            while (exitExecution == false) {
                buffer.clear();
                for (int i=0; i < PACKET_SIZE /SAMPLE_SIZE; i++) {
                    buffer.putShort((short) (random.nextGaussian() * Short.MAX_VALUE));
                }
                line.write(buffer.array(), 0, buffer.position());
            }

            line.drain();
            line.close();
        }

        public void exit() {
            exitExecution =true;
        }
    }
}


