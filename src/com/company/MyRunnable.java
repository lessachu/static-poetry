/*
 * Author: Jan Chong (@lessachu)
 * Date: Feb 2021
 */

package com.company;

import java.io.File;
import java.io.IOException;

import java.awt.*;
import javax.swing.JFrame;
import java.awt.Toolkit;

public class MyRunnable implements Runnable {
    private int size;
    private int mode;
    private int pause;
    private int font_size;
    private int speed;
    private String word_file;
    private Boolean streak;
    private Float volume;

    public MyRunnable(String word_file, int mode, int size, int pause, int font_size, int speed, Boolean streak, Float volume) {
        this.word_file = word_file;
        this.mode = mode;
        this.size = size;
        this.pause = pause;
        this.speed = speed;
        this.font_size = font_size;
        this.streak = streak;
        this.volume = volume;
    }

    public Font getFont(int font_size) {
        try {
            GraphicsEnvironment ge =
                    GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("OCR-A.ttf")));

            return new Font("OCR-A", Font.BOLD, font_size);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
            System.out.println("Unable to load: OCR-A.ttf");
            return new Font("Monospaced", Font.BOLD, font_size);
        }
    }

    public void run() {

        Font font = getFont(this.font_size);
        var panel = new StaticPanel(this.word_file, this.mode, this.size, this.pause, this.font_size, font, this.speed, this.streak);
        panel.setBackground(Color.WHITE);
        var frame = new FullScreenJFrame(this.volume);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d.width, d.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}

