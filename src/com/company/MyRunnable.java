package com.company;


import java.awt.*;
import javax.swing.JFrame;
import java.awt.Toolkit;

public class MyRunnable implements Runnable {
    private int size;
    private int mode;
    private int pause;
    private int font_size;
    private int speed;
    private String seed;

    public MyRunnable(String seed, int mode, int size, int pause, int font_size, int speed) {
        this.seed = seed;
        this.mode = mode;
        this.size = size;
        this.pause = pause;
        this.speed = speed;
        this.font_size = font_size;
    }

    public void run() {

        var panel = new StaticPanel(this.seed, this.mode , this.size, this.pause, this.font_size, this.speed);
        panel.setBackground(Color.WHITE);
        var frame = new JFrame("");
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d.width,d.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

