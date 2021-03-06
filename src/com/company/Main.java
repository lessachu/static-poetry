/*
 * Author: Jan Chong (@lessachu)
 * Date: Feb 2021
 */

package com.company;

import javax.swing.SwingUtilities;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int size = 4;
        int mode = StaticPanel.GRAYSCALE;
        int font_size = 100;
        int poem = 1;
        int speed = 60;
        boolean streak = false;
        float volume = -0.0f;

        Map<String, String> argsMap = new HashMap<>();
        for (String arg: args) {
            String[] parts = arg.split("=");
            if (parts.length > 1) {
                argsMap.put(parts[0], parts[1]);
            } else {
                argsMap.put(parts[0], "true");
            }
        }

        System.out.println(argsMap);

        if (argsMap.get("--size") != null) {
           size = Integer.parseInt(argsMap.get("--size"));
       }

       if (argsMap.get("--color") != null) {
           mode = StaticPanel.COLOR;
       }

        if (argsMap.get("--font_size") != null) {
            font_size = Integer.parseInt(argsMap.get("--font_size"));
        }

        if (argsMap.get("--poem") != null) {
            poem = Integer.parseInt(argsMap.get("--poem"));
        }

        if (argsMap.get("--speed") != null) {
            speed = Integer.parseInt(argsMap.get("--speed"));
        }

        if (argsMap.get("--streak") != null ) {
            streak = true;
        }

        if (argsMap.get("--volume") != null ) {
            volume = Float.parseFloat(argsMap.get("--volume"));
        }

        if (argsMap.get("--help") != null) {
            System.out.println("Reads in the poem from poem1.txt or poem2.txt");
            System.out.println("Supported options include:");
            System.out.println("--word_file=[text] sets the file to read words from (poem1.txt by default)");
            System.out.println("--size=[number] sets the size of each pixel");
            System.out.println("--color populates the randomly with color");
            System.out.println("--font_size=[number] sets the font size of the word");
            System.out.println("--poem=[number] switches between poem 1 or 2");
            System.out.println("--speed=[number] sets the speed of the overall animation");
            System.out.println("--streak does the horizontal streak effect (recommended with --size=50)");
            System.out.println("--volume=[float] sets the volume (range from -80.0f to 6.0f)");
            return;
        }

        SwingUtilities.invokeLater(new MyRunnable(poem, mode, size, font_size, speed, streak, volume));
    }
}
