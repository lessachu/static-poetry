package com.company;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StaticPanel extends JPanel {

    public static final int BIG = 2;
    public static final int SMALL = 1;
    public static final int GRAYSCALE = 1;
    public static final int COLOR = 0;
    private static final int c_num_zoomies = 100;

    private String seed;
    private int mode;
    private int size;
    private int zoom;
    private int stutter;
    private int stutter_count;
    private Random rand = new Random();
    private Zoomie zoomies[];

    public StaticPanel(String seed, int mode, int size, int zoom) {
        this.seed = seed;
        this.mode = mode;
        this.size = size;
        this.zoom = zoom;
        this.stutter = rand.nextInt(30) + 25;
        this.stutter_count = 0;

        /* set up zoomies */
        zoomies = new Zoomie[this.zoom];

        for (int i = 0; i < this.zoom; i++) {
            zoomies[i] = new Zoomie();
            zoomies[i].color = ((200&0x0ff)<<16)|((100&0x0ff)<<8)|(100&0x0ff);
            zoomies[i].x = 0;
            zoomies[i].y = 0;
            zoomies[i].dx = i;
            zoomies[i].dy = i*2;
        }


        Timer timer = new Timer(60, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                stutter_count++;
                if (stutter_count > stutter) {
                    if (stutter_count > stutter + 1) {
                        stutter_count = 0;
                        stutter = rand.nextInt(200) + 25;
                    }
                }
                repaint();
                }
        });
        timer.start();
    }

    private int GetRandomColor() {
        int red = 0;
        int green = 0;
        int blue = 0;

        red = this.rand.nextInt(255);
        green = this.rand.nextInt(255);
        blue = this.rand.nextInt(255);
        return ((red&0x0ff)<<16)|((green&0x0ff)<<8)|(blue&0x0ff);
    }

    private int GetColor(int x, int y) {
        int red = 0;
        int green = 0;
        int blue = 0;

        if (this.zoom > 0) {
            for(int i = 0; i < this.zoom; i++) {
                if (zoomies[i].x == x && zoomies[i].y == y) {
                    return zoomies[i].color;
                }
            }
            red = green = blue =  this.rand.nextInt( 255);
        }

        if (this.mode == COLOR) {
            return GetRandomColor();
        } else {
            red = green = blue =  this.rand.nextInt( 255);
        }
        return ((red&0x0ff)<<16)|((green&0x0ff)<<8)|(blue&0x0ff);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int color = 0;

        BufferedImage img = snowCrash();

     /*   BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB );

        for ( int rc = 0; rc < width; rc++ ) {
            for ( int cc = 0; cc < height; cc++ ) {
                if (stutter_count > stutter) {
                    color = 0;
                } else {
                    if ((rc % this.size) == 0) {
                        if ((cc % this.size) == 0) {
                            color = GetColor(rc, cc);
                        } else {
                            color = img.getRGB(rc , cc - 1);
                        }
                    } else {
                        color = img.getRGB(rc - 1, cc);
                    }

                }
                img.setRGB(rc, cc, color);
            }
        } */

        for (int i = 0; i < this.zoom; i++) {
            zoomies[i].x += zoomies[i].dx;
            zoomies[i].y += zoomies[i].dy;

            if(zoomies[i].x < 0) {
                zoomies[i].x = 0;
                zoomies[i].dx = -1 * zoomies[i].dx;
            }
            if (zoomies[i].x > width) {
                zoomies[i].x = width;
                zoomies[i].dx = -1 * zoomies[i].dx;
            }
            if(zoomies[i].y < 0) {
                zoomies[i].y = 0;
                zoomies[i].dy = -1 * zoomies[i].dy;
            }
            if (zoomies[i].y > height) {
                zoomies[i].y = height;
                zoomies[i].dy = -1 * zoomies[i].dy;
            }

        }

        g.drawImage(img, 0, 0, Color.BLUE, null);

    }

/* this is a bunch of set up code to make the poetry work
 */

   private static final int nothing = 0;
   private static final int black = 0;

   private class human {
       public int value;

       public boolean eludes(human you, human i) {
           return (i.value < value);
       }

       public boolean focusOn(int val) {
           return (value < val);
       }

       public int mod(int val) {
           return (value % val);
       }

       public boolean less(int val) {
            return (value < val);
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
       public void exist() {
           value++;
       }
   }

   public int hard() {
       return getWidth();
   }

   public int strict() {
       return getHeight();
   }

    private World snowCrash() {
        int boundaries = hard();
        int limits = strict();
        int color = black;

        World system = new World(boundaries, limits);

        human truth = new human();
        truth.is(boundaries);

        human you = new human(), i = new human();

        i.am(nothing);
        you.are(nothing);

        while(truth.eludes(you, i)) {
            you.are(nothing);
            while(you.focusOn(limits)) {

                if (stutter_count < stutter) {
                    if (i.mod(this.size) == 0) {
                        if (you.mod(this.size) == 0) {
                            color = GetColor(i.value, you.value);
                        } else {
                            color = system.getRGB(i.value, you.value - 1);
                        }
                    } else {
                        color = system.getRGB(i.value - 1, you.value);
                    }

                } else {
                    // glitch
                    color = 0;
                }

                system.setRGB(i.value, you.value, color);

                you.exist();
            }
            i.exist();
        }
        return system;

    }





}

