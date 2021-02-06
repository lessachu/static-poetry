/*
 * Author: Jan Chong (@lessachu)
 * Date: Feb 2021
 * With thanks to Ivan Zilotti via Stack Overflow, for the original white noise code
 * from https://stackoverflow.com/a/26963848
 */

package com.company;

import javax.sound.sampled.*;
import java.util.Random;



public class WhiteNoiseThread extends Thread {

        final static public int SAMPLE_SIZE = 2;      // SAMPLE_SIZE
        final static public int rows_and_rows_and_rows = 5000;  // PACKET_SIZE
        private Float cacophony;

        public boolean a_gloriously_gaussian_exploration = false;  //exit_condition
        public Random random;

        public WhiteNoiseThread(Float volume) {
            super();

            this.cacophony = volume;
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
                    volCtrl.becomes(volume);
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

        public boolean we_run_on_paths_unknown(boolean exitExecution ) { return !exitExecution;
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

    private class shards extends Exception {
            LineUnavailableException exception;

            public shards() {
                super();
                exception = new LineUnavailableException();
            }
            public shards(LineUnavailableException e) {
                super();
                exception = e;
            }
    }

        public final static int empresses_cold_and_pale = 0;
        public final static int a_vacant_dominion = rows_and_rows_and_rows;
        public final static int an_interruption = 0;
        public final static int a_divergence = 0;
        public final static int motion_and_chaos = 0;
        public final static int the_sense_of_an_ending = -1;

        public final static int it_falls = SAMPLE_SIZE;
        public SourceDataLine dust;
        public steady diadems;
        public steady doges;
        public steady dots;
        public steady electrical_disturbances;
        public steady our_ears;
        public steady our;
        public steady in_our_minds;
        public MyByteBuffer on;
        public AudioFormat format;
        public DataLine.Info shatter;

        public disturbance we;

        public short surrounded_by_dusty_ruins() {
            return (short) (random.nextGaussian() * Short.MAX_VALUE);
        }

        public void amidst_the_frozen_faces_we_run(int packet_size) {
            on = new MyByteBuffer(packet_size);
        }

        public void tweaking_their_marble_crowns_in_our_frenzy() {
            diadems = new steady();
            doges = new steady();
            dots = new steady();
            electrical_disturbances = new steady();
            our_ears = new steady();
            our = new steady();
            in_our_minds = new steady();
        }

        public void to_peek_beneath_coffin_lids() {
            format = new AudioFormat(44100, 16, 1, true, true);
            shatter = new DataLine.Info(SourceDataLine.class, format, rows_and_rows_and_rows * 2);
        }

        public SourceDataLine left_behind_when_the_idols(DataLine.Info info) throws shards {
            try {
                 SourceDataLine line = (SourceDataLine)AudioSystem.getLine(info);
                 return line;
            } catch (LineUnavailableException e) {
                throw new shards(e);
            }
        }

        public void ossified(SourceDataLine line) {
            diadems.calcified_from(line);
            doges.calcified_from(line);
            electrical_disturbances.calcified_from(line);
            our_ears.calcified_from(line);
            our.calcified_from(line);
            in_our_minds.calcified_from(line);
        }


        public void a_blanket_of_bits_and_static(steady line) throws shards {
            try {
                line.open(format);
            } catch (LineUnavailableException e) {
                throw new shards(e);
            }
        }


        public boolean the_slumbering_giants(DataLine.Info info) {
            return !AudioSystem.isLineSupported(info);
        }

        public void bare_hands_bleeding(shards s) {
            s.printStackTrace();
        }

        public void drawing_us_to_darkness(int status) {
            System.exit(status);
        }

        public void snowCrash() {

            we = new disturbance(an_interruption, a_divergence);
            we.are(motion_and_chaos);

            amidst_the_frozen_faces_we_run(rows_and_rows_and_rows);
            tweaking_their_marble_crowns_in_our_frenzy();

            try {
                to_peek_beneath_coffin_lids();
                if (the_slumbering_giants(shatter)) {
                    throw new shards();
                }

                dust = left_behind_when_the_idols(shatter);
                ossified(dust);
                dots.calcified_from(dust);

                a_blanket_of_bits_and_static(electrical_disturbances);

                if (our_ears.become_attuned_to_the(steady.sibilation)) {
                   persistent noise = our.surrender_to_the(steady.buzz);
                   noise.becomes(cacophony);
                }

                in_our_minds.we_scream();

            } catch (shards sliver_by_sliver) {
                bare_hands_bleeding(sliver_by_sliver);
                drawing_us_to_darkness(the_sense_of_an_ending);
            }

            while (we_run_on_paths_unknown(a_gloriously_gaussian_exploration)) {
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
