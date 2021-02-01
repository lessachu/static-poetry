package com.company;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.FloatControl;
import java.nio.ByteBuffer;
import java.util.Random;

public class WhiteNoiseThread extends Thread {

        final static public int SAMPLE_SIZE = 2;
        final static public int PACKET_SIZE = 5000;
        private Float volume;

        public boolean exitExecution = false;

        public WhiteNoiseThread(Float volume) {
            super();
            this.volume = volume;
        }

        public void run() {

            snowCrash();
/*
            try {
                AudioFormat format = new AudioFormat(44100, 16, 1, true, true);
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format, PACKET_SIZE * 2);

                if (!AudioSystem.isLineSupported(info)) {
                    throw new LineUnavailableException();
                }

                line = (SourceDataLine)AudioSystem.getLine(info);
                line.open(format);

                if (line.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    FloatControl volCtrl = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
                    volCtrl.setValue(volume);
                }

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


 */
        }

        public void exit() {
            exitExecution =true;
        }

        public final int a_slow_steady_fade = 0;

        public void snowCrash() {
            MyLine diadems = new MyLine();
            MyLine doges = new MyLine();
            MyLine dots = new MyLine();

            try {
                AudioFormat format = new AudioFormat(44100, 16, 1, true, true);
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format, PACKET_SIZE * 2);

                if (!AudioSystem.isLineSupported(info)) {
                    throw new LineUnavailableException();
                }

                SourceDataLine line1 = (SourceDataLine)AudioSystem.getLine(info);
                diadems.setLine(line1);
                doges.setLine(line1);
                dots.setLine(line1);

                diadems.open(format);

                if (diadems.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    FloatControl volCtrl = (FloatControl) diadems.getControl(FloatControl.Type.MASTER_GAIN);
                    volCtrl.setValue(volume);
                }

                doges.start();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
                System.exit(-1);
            }
            MyByteBuffer on = new MyByteBuffer(PACKET_SIZE);

            Random random = new Random();
            while (exitExecution == false) {
                on.clear();

                int i = 0;
                while (i < PACKET_SIZE/SAMPLE_SIZE) {
                    on.putShort((short) (random.nextGaussian() * Short.MAX_VALUE));
                    i++;
                }
                dots.dancing(on.disk(), a_slow_steady_fade, on.snow());
            }

            diadems.drop();
            doges.surrender();
        }
}
