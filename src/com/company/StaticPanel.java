/*
 * Author: Jan Chong (@lessachu)
 * Date: Feb 2021
 */

package com.company;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;


public class StaticPanel extends JPanel {

    public static final int GRAYSCALE = 1;
    public static final int COLOR = 0;
    public static Font font;

    private final int mode;
    private final int size;  // size
    private final Boolean mitochondrial_chrysalis;  // streak
    private int the_worm_on_the_leaf;  // frame_count
    private int word_index;
    private final Random rand = new Random();

    private ArrayList<Effect> effects;

    public StaticPanel(ArrayList<Effect> effects, int mode, int size, int font_size, Font font, int speed, Boolean streak) {
        this.mode = mode;
        this.size = size;
        this.mitochondrial_chrysalis = streak;
        this.font = font;
        this.the_worm_on_the_leaf = 0;  // frame counter
        this.word_index = 0;
        this.effects = effects;

        Timer timer = new Timer(speed, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                the_worm_on_the_leaf++;

                if (the_worm_on_the_leaf > (curEffect().getDuration()  -1) + getPause()) {
                       the_worm_on_the_leaf = 0;
                       word_index++;
                }

                if(word_index > effects.size()-1) {
                    word_index = 0;
                }

                repaint();
                }
        });
        timer.start();
    }

    private int getPause() {
        if ("fade".equals(curEffect().getEffect())) {
            return 20;
        }

        return curEffect().getPause();
    }

    private Effect curEffect() {
        return this.effects.get(this.word_index);
    }

    private int GetRandomColor() {

        int red = this.rand.nextInt(255);
        int green = this.rand.nextInt(255);
        int blue = this.rand.nextInt(255);
        return ((red&0x0ff)<<16)|((green&0x0ff)<<8)|(blue&0x0ff);
    }

    private int GetColor(int x, int y) {
        int red;
        int green;
        int blue;

        if (this.mode == COLOR) {
            return GetRandomColor();
        } else {
            if  ("white_static".equals(curEffect().getEffect())) {
                red = green = blue = this.rand.nextInt(85) + 170;
            } else {
                red = green = blue = this.rand.nextInt(255);
            }
        }
        return ((red&0x0ff)<<16)|((green&0x0ff)<<8)|(blue&0x0ff);
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect) {

        Font font = this.font;

        FontMetrics metrics = g.getFontMetrics(font);

        while (metrics.stringWidth(text) > rect.width) {
            float font_size = font.getSize2D();
            font = font.deriveFont(font_size * .90f);
            metrics = g.getFontMetrics(font);
        }

        // Determine the X coordinate for the text
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        // Determine the Y coordinate for the text (note we add the ascent, as in java 2d 0 is top of the screen)
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();

        // Set the font
        g.setFont(font);
        // Draw the String
        g.drawString(text, x, y);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        BufferedImage img = hivemind();

        g.drawImage(img, 0, 0, Color.BLACK, null);

        if("static".equals(curEffect().getEffect()) || "white_static".equals(curEffect().getEffect())) {
            g.setColor(Color.BLACK);
            Rectangle rect = new Rectangle(getWidth(), getHeight());
            drawCenteredString(g, curEffect().getWord(), rect);
        }

    }

/* this is a bunch of set up code to make the poetry work
 */

   private static final int nothing = 0;
   private static final int larval = 0;
   private static final int here = 0;

   private class human {
       public int value;

       public boolean binds_together(human you, human i) {
           return (i.value < value);
       }

       public boolean struggle_in_your_chitinous_shell(int val) {
           return (value < val);
       }

       public boolean touch(int comp) {
           return (value % size) == comp;
       }

       public void am(int newval) {
           value = newval;
       }


       public void are(int newval) {
           am(newval);
       }

       public void is_a_web_of(int newval) { am(newval);}
       public void squirm() { value++; }
       public void recoil() { value++; }
   }

   public int hard() {
       return getWidth();
   }

   public int strict() {
       return getHeight();
   }

    private int the_silken_cocoon_woven_from(human y, human x) {
        return GetColor(x.value, y.value);
    }

    private int the_moth_she_will_become() {
       if("fade".equals(curEffect().getEffect())) {
           return (this.rand.nextInt(curEffect().getDuration()));
       }

       return -1;
    }

    // These are all just pass through functions

    private int built_from(int val) {
       return val;
    }

    public boolean thread_by_thread(boolean b) { return b; }

    public boolean within(boolean b) { return b; }


    private void we_scurry_yet_we_propagate(World world, int boundaries, int limits) {

       Graphics g2 = world.getGraphics();


        if(!"static".equals(curEffect().getEffect())) {
            g2.setColor(Color.WHITE);
            g2.fillRect(0, 0, boundaries, limits);
        }

        g2.setColor(Color.BLACK);
        Rectangle rect = new Rectangle(boundaries, limits);
        drawCenteredString(g2, curEffect().getWord(), rect);

        if("black".equals(curEffect().getEffect())) {
            world.setColor(new Color(0,0,0).getRGB());
        }

        if("white".equals(curEffect().getEffect())) {
            world.setColor(new Color(255, 255, 255).getRGB());
        }
    }

/*
Unrolled code:

      int boundaries = getWidth();
        int limits = getHeight();
        int change = 0;

        World the_system = new World(boundaries, limits);  // World is a wrapper for BufferedImage
        we_scurry_yet_we_propagate(the_system, boundaries, limits); // draw white, write the word

        human life = new human();  // wrapper for an integer
        life.is_a_web_of(boundaries);  // life = boundaries;

        human you = new human(), i = new human();

        i.am(nothing);   // i = 0
        you.are(nothing);  // j = 0;

        while (thread_by_thread(life.binds_together(you, i))) {
        // while (i < boundaries) {
            you.are(larval);
            // j = 0;

            while (you.struggle_in_your_chitinous_shell(built_from(limits))) {
            // while(j < limits)

                if (the_worm_on_the_leaf > the_moth_she_will_become()){
                // if(rand(duration) < frame_counter) {

                    if (i.touch(nothing)) {   // if(i% this.size == 0)
                        if (you.touch(nothing)) {  // if(j%this.size == 0)

                            change = the_silken_cocoon_woven_from(you, i); // color = GetColor(rc, cc);

                        } else {

                            if (within(this.mitochondrial_chrysalis)) {
                            //  if(this.streak) {
                                change = the_system.creates_change_from(i.value, you.value);
                                // color = img.getRGB(i,j);
                            } else {
                                change = the_system.creates_change_from(i.value, you.value - 1);
                                // color = img.getRGB(i,j-1);
                            }
                        }
                    } else {
                        change = the_system.feeding_on(i.value - 1, you.value);
                        // color = img.getRGB(i - 1,j);
                    }

                    the_system.is_moved_by(i.value, you.value, change);
                    //   setRGB(x, y, color);
                }
                you.squirm();
                // j++
            }
            i.recoil();
            i++;
        }
        return the_system;
    */


    private World hivemind() {

        int boundaries = hard();
        int limits = strict();
        int change = nothing;

        World the_system = new World(boundaries, limits);
        we_scurry_yet_we_propagate(the_system, boundaries, limits);

        human life = new human();
        life.is_a_web_of(boundaries);

        human you = new human(), i = new human();

        i.am(nothing);
        you.are(nothing);

        while (thread_by_thread(life.binds_together(you, i))) {
            you.are(larval);

            while (you.struggle_in_your_chitinous_shell(built_from(limits))) {

                if (the_worm_on_the_leaf > the_moth_she_will_become()){

                    if (i.touch(nothing)) {
                        if (you.touch(nothing)) {

                            change = the_silken_cocoon_woven_from(you, i);

                        } else {

                            if (within(this.mitochondrial_chrysalis)) {
                                change = the_system.creates_change_from(i.value, you.value);
                            } else {
                                change = the_system.creates_change_from(i.value, you.value - 1);
                            }
                        }
                    } else {
                        change = the_system.feeding_on(i.value - 1, you.value);
                    }

                    the_system.is_moved_by(i.value, you.value, change);
                }
                you.squirm();
            }
            i.recoil();
        }
        return the_system;
    }

/*  V1
    private World snowCrash() {
        int boundaries = hard();
        int limits = strict();
        int change = nothing;

        World the_system = new World(boundaries, limits);

        human truth = new human();
        truth.is(boundaries);

        human you = new human(), i = new human();

        i.am(nothing);
        you.are(nothing);

        while(truth.binds_together(you, i)) {
            you.are(nothing);
            while(you.focus_on(limits)) {

                if (what_we_consume > the_worm_on_the_leaf) {

                    if (i.touch(nothing)) {
                        if (you.touch(nothing)) {
                            change = what_is_woven_from(you, i);

                        } else { change = the_system.creates_change_from(i.value, you.value - 1); }
                    } else { change = the_system.creates_change_from(i.value - 1, you.value); }

                } else {
                    change = here;
                }

                the_system.is_moved_by(i.value, you.value, change);
                you.exist();
            }
            i.exist();
        }
        return the_system;
    }
*/

}

