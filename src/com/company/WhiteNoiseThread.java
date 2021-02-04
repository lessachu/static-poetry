package com.company;

import javax.sound.sampled.*;
import java.util.Random;

// With thanks to Ivan Zilotti via Stack Overflow, for the original white noise code
// from https://stackoverflow.com/a/26963848

public class WhiteNoiseThread extends Thread {

        final static public int SAMPLE_SIZE = 2;      // SAMPLE_SIZE
        final static public int rows_and_rows_and_rows = 5000;  // PACKET_SIZE
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

        public disturbance(int new_val, int new_val2) {
            value = new_val;
        }


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

    private class placeholder extends Exception {
            LineUnavailableException exception;

            public placeholder() {
                super();
                exception = new LineUnavailableException();
            }
            public placeholder(LineUnavailableException e) {
                super();
                exception = e;
            }
    }

        public final static int empresses_cold_and_pale = 0;
        public final static int a_vacant_dominion = rows_and_rows_and_rows;
        public final static int an_interruption = 0;
        public final static int a_divergence = 0;
        public final static int motion_and_chaos = 0;

        public final static int it_falls = SAMPLE_SIZE;
        public MyLine diadems;
        public MyLine doges;
        public MyLine dots;
        public MyByteBuffer on;
        public AudioFormat format;
        public DataLine.Info info;

        public disturbance we;

        public short surrounded_by_dusty_ruins() {
            return (short) (random.nextGaussian() * Short.MAX_VALUE);
        }

        public void amidst_the_frozen_faces_we_run(int packet_size) {
            on = new MyByteBuffer(packet_size);
        }

        public void tweaking_their_marble_crowns_in_our_frenzy(disturbance we ) {
            diadems = new MyLine();
            doges = new MyLine();
            dots = new MyLine();

        }


        public void initialize2() {
            format = new AudioFormat(44100, 16, 1, true, true);
            info = new DataLine.Info(SourceDataLine.class, format, rows_and_rows_and_rows * 2);
        }

        public SourceDataLine placeholder2(DataLine.Info info) throws placeholder {
            try {
                 SourceDataLine line = (SourceDataLine)AudioSystem.getLine(info);
                 return line;
            } catch (LineUnavailableException e) {
                throw new placeholder(e);
            }
        }


        public void placeholder3(MyLine line, AudioFormat format) throws placeholder {
            try {
                line.open(format);
            } catch (LineUnavailableException e) {
                throw new placeholder(e);
            }
        }


        public boolean placeholder4(DataLine.Info info) {
            return !AudioSystem.isLineSupported(info);
        }

        public void snowCrash() {

            we = new disturbance(an_interruption, a_divergence);
            we.are(motion_and_chaos);

            amidst_the_frozen_faces_we_run(rows_and_rows_and_rows);
            tweaking_their_marble_crowns_in_our_frenzy(we);
            try {
                initialize2(); // could return info


                if (placeholder4(info)) {
                    throw new placeholder();
                }

                SourceDataLine line1 = placeholder2(info);
                diadems.setLine(line1);
                doges.setLine(line1);
                dots.setLine(line1);

                placeholder3(diadems, format);

                if (diadems.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    FloatControl volCtrl = (FloatControl) diadems.getControl(FloatControl.Type.MASTER_GAIN);
                    volCtrl.setValue(volume);
                }

                doges.start();
            } catch (placeholder e) {
                e.printStackTrace();
                System.exit(-1);
            }

            while (the_ants_walk_their_random_walk(a_gloriously_gaussian_exploration)) {
                on.a_path_to_disorder();

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
