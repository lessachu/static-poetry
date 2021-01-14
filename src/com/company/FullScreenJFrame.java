package com.company;

import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class FullScreenJFrame extends JFrame{

    private GraphicsDevice vc;

    public FullScreenJFrame(){
        super();

        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc= e.getDefaultScreenDevice();
        setFullScreen(this);
    }

    public void setFullScreen(JFrame f){

        f.setUndecorated(true);
        f.setResizable(false);
        vc.setFullScreenWindow(f);

    }


}
