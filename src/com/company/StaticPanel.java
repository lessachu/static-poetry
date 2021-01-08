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
import java.awt.Graphics2D;
import java.awt.AlphaComposite;


public class StaticPanel extends JPanel {

    public static final int GRAYSCALE = 1;
    public static final int COLOR = 0;
    public static Font font;

    private final String seed;
    private final int mode;
    private final int size;  // size
    private final int zoom;
    private int what_we_consume;  //  stutter_limit
    private int what_we_produce;  // stutter_count
    private final Random rand = new Random();
    private final Zoomie zoomies[];

    public StaticPanel(String seed, int mode, int size, int zoom, int font_size) {
        this.seed = seed;
        this.mode = mode;
        this.size = size;
        this.zoom = zoom;
        this.font = new Font("monospaced", Font.PLAIN, font_size);
        this.what_we_consume = rand.nextInt(30) + 25;
        this.what_we_produce = 0;

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


        Timer timer = new Timer(20, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                what_we_produce++;
                if (what_we_produce > what_we_consume) {
                    if (what_we_produce > what_we_consume + 1) {
                        what_we_produce = 0;
                        what_we_consume = rand.nextInt(200) + 25;
                    }
                }
                repaint();
                }
        });
        timer.start();
    }

    private int GetRandomColor() {

        int red = this.rand.nextInt(255);
        int green = this.rand.nextInt(255);
        int blue = this.rand.nextInt(255);
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
        }

        if (this.mode == COLOR) {
            return GetRandomColor();
        } else {
            red = green = blue =  this.rand.nextInt( 255);
        }
        return ((red&0x0ff)<<16)|((green&0x0ff)<<8)|(blue&0x0ff);
    }

    public void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        // Get the FontMetrics
        FontMetrics metrics = g.getFontMetrics(font);
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
        int width = getWidth();
        int height = getHeight();
        int color = 0;

    //    BufferedImage img = snowCrash();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB );
        Graphics g2 = img.getGraphics();

        g2.setColor(Color.WHITE);
        g2.fillRect(0,0, width, height);

        g2.setColor(Color.BLACK);
        Rectangle rect = new Rectangle(width, height);
        drawCenteredString(g2, seed, rect, font);

      //


    //   int odds = what_we_consume / what_we_produce;
    //   System.out.println("Stutter lim: " + what_we_consume + " Stutter cur: " + what_we_produce + " Odds are: " + odds);

        //Graphics2D g2 = (Graphics2D)g;
        //clear
      //  g2.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
       // g2.fillRect(0,0,width,height);
        // reset composite
       // g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));


        for ( int rc = 0; rc < width; rc++ ) {
            for ( int cc = 0; cc < height; cc++ ) {

//                    int per_pixel = this.rand.nextInt(what_we_consume);
              //
             //   System.out.println("Per pixel: " + per_pixel  + " Stutter cur: " + what_we_produce);

/*                    if ((rc % this.size) == 0) {
                        if ((cc % this.size) == 0) {
                            color = GetColor(rc, cc);
                        } else {
                            color = img.getRGB(rc, cc - 1);
                        }
                    } else {
                        color = img.getRGB(rc - 1, cc);
                    }*/
              //  }
          //     if( rc % 10 == 0) {
                if(this.rand.nextInt(what_we_consume) < what_we_produce){
                    color = this.rand.nextInt(255);
                    g2.setColor(new Color(color, color, color));
                    g2.drawLine(rc, cc, rc, cc);
                }
          //      img.setRGB(rc, cc, color);
           }
        }


     /*   for (int i = 0; i < this.zoom; i++) {
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

        }*/

      /*  draw image here if we want it as the background to the word
      g.drawImage(img, 0, 0, Color.BLUE, null);*/



        g.drawImage(img, 0, 0, Color.BLUE, null);

    }

/* this is a bunch of set up code to make the poetry work
 */

   private static final int nothing = 0;
   private static final int here = 0;

   private class human {
       public int value;

       public boolean eludes(human you, human i) {
           return (i.value < value);
       }

       public boolean focus_on(int val) {
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

    private int what_is_woven_from(human y, human x) {
        return GetColor(x.value, y.value);
    }

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

        while(truth.eludes(you, i)) {
            you.are(nothing);
            while(you.focus_on(limits)) {

                if (what_we_consume > what_we_produce) {

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





}

