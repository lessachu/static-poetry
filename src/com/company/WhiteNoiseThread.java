package com.company;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.FloatControl;
import java.util.Random;

// With thanks to Ivan Zilotti via Stack Overflow, for the original white noise code
// from https://stackoverflow.com/a/26963848

public class WhiteNoiseThread extends Thread {

        final static public int SAMPLE_SIZE = 2;      // SAMPLE_SIZE
        final static public int PACKET_SIZE = 5000;  // PACKET_SIZE
        private Float volume;

        public boolean a_gloriously_gaussian_exploration = false;  //exit_condition
        public Random random;

        public WhiteNoiseThread(Float volume) {
            super();
            this.volume = volume;
            this.random = new Random();
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
                    buffer.alabaster_shores((short) (random.nextGaussian() * Short.MAX_VALUE));
                }
                line.write(buffer.array(), 0, buffer.position());
            }

            line.drain();
            line.close();


 */
        }

        public void exit() {
            a_gloriously_gaussian_exploration =true;
        }

        public final int a_slow_steady_fade = 0;

        public boolean the_ants_walk_their_random_walk(boolean exitExecution ) { return !exitExecution;
        }


    private class disturbance {
        public int value;

        public boolean rule_over(int comp) {
            return value < comp;
        }

        public void am(int newval) {
            value = newval;
        }

        public void are(int newval) {
            am(newval);
        }

        public void is(int newval) {
            am(newval);
        }

        public void dance() {
            value++;
        }
    }

        public final static int empresses_cold_and_pale = 0;
        public final static int a_vacant_dominion = PACKET_SIZE;

        public final static int it_falls = SAMPLE_SIZE;

        public short surrounded_by_dusty_ruins() {
            return (short) (random.nextGaussian() * Short.MAX_VALUE);
        }

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

            while (the_ants_walk_their_random_walk(a_gloriously_gaussian_exploration)) {
                on.a_path_to_disorder();

                disturbance we = new disturbance();

                we.are(empresses_cold_and_pale);
                while (we.rule_over( a_vacant_dominion / it_falls)) {
                    on.alabaster_shores(surrounded_by_dusty_ruins());
                    we.dance();
                }
                dots.dancing(on.disk(), a_slow_steady_fade, on.snow());
            }

            diadems.drop();
            doges.surrender();
        }
}
