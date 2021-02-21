/*
 * Author: Jan Chong (@lessachu)
 * Date: Feb 2021
 */

package com.company;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Type;

import java.util.ArrayList;

import java.awt.*;
import javax.swing.JFrame;
import java.awt.Toolkit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class MyRunnable implements Runnable {
    private int size;
    private int mode;
    private int font_size;
    private int speed;
    private String word_file;
    private Boolean streak;
    private Float volume;

    public MyRunnable(int poem, int mode, int size, int font_size, int speed, Boolean streak, Float volume) {
        this.word_file = "poem" + Integer.toString(poem);
        this.mode = mode;
        this.size = size;
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

        ArrayList<Effect> words = initializePoem(this.word_file + ".txt");

        for(Effect word : words) {
            System.out.println(word.getWord());
            System.out.println("duration: " + Integer.toString(word.getDuration()));
        }

        var panel = new StaticPanel(words, this.mode, this.size, this.font_size, font, this.speed, this.streak);
        panel.setBackground(Color.WHITE);
        var frame = new FullScreenJFrame(this.volume);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(d.width, d.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public ArrayList<Effect> initializePoem(String word_file) {

        try {
            FileReader reader = new FileReader(word_file);
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();

            Gson gson = builder.create();

            Type effectListType = new TypeToken<ArrayList<Effect>>(){}.getType();

            ArrayList<Effect> poem = gson.fromJson(reader, effectListType);

            return poem;

         } catch (FileNotFoundException e) {
            System.out.println("File " + word_file + " not found.");
            e.printStackTrace();
            System.exit(1);
        } catch (JsonIOException jie) {
            System.out.println("Error reading from file: " + word_file);
            jie.printStackTrace();
            System.exit(1);
        } catch (JsonSyntaxException jse) {
            System.out.println("Error reading from file: " + word_file);
            jse.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}

