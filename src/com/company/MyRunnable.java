package com.company;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import java.util.List;
import java.util.Arrays;

public class MyRunnable implements Runnable {
    private int size;
    private int mode;
    private int zoom;

    public MyRunnable(int mode, int size, int zoom) {
        this.mode = mode;
        this.size = size;
        this.zoom = zoom;
    }

    public void run() {

        var panel = new StaticPanel("test", this.mode , this.size, this.zoom);
        panel.setBackground(Color.GREEN.darker());
        var frame = new JFrame("");
        frame.setSize(900, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

