package com.company;

import java.awt.image.BufferedImage;

public class World extends BufferedImage {


    public World(int width, int height) {
        super(width, height, BufferedImage.TYPE_INT_RGB);
    }

    public int creates_change_from(int x, int y) {
        return getRGB(x, y);
    }

    public int feeding_on(int x, int y) {
        return creates_change_from(x, y);
    }

    public void is_moved_by(int x, int y, int color) {
        setRGB(x, y, color);
    }
}


