package com.company;

import javax.sound.sampled.*;
import java.nio.ByteBuffer;
import java.util.Random;

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

    public MyRunnable(String word_file, int mode, int size, int pause, int font_size, int speed, Boolean streak) {
        this.word_file = word_file;
        this.mode = mode;
        this.size = size;
        this.pause = pause;
        this.speed = speed;
        this.font_size = font_size;
        this.streak = streak;
    }

    public void run() {

        var panel = new StaticPanel(this.word_file, this.mode, this.size, this.pause, this.font_size, this.speed, this.streak);
        panel.setBackground(Color.WHITE);
        var frame = new FullScreenJFrame();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d.width, d.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}

