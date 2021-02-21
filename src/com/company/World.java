/*
 * Author: Jan Chong (@lessachu)
 * Date: Feb 2021
 */

package com.company;

import java.awt.image.BufferedImage;

public class World extends BufferedImage {

    Integer override_color;


    public World(int width, int height) {
        super(width, height, BufferedImage.TYPE_INT_RGB);

        override_color = null;
    }

    public void setColor(int color) {  this.override_color = new Integer(color); }


    public int creates_change_from(int x, int y) {
        return getRGB(x, y);
    }

    public int feeding_on(int x, int y) {
        return creates_change_from(x, y);
    }

    public void is_moved_by(int x, int y, int color) {
        if( this.override_color != null) {
            setRGB(x, y, this.override_color.intValue());
        } else {
            setRGB(x, y, color);
        }
    }
}


