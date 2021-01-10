package com.company;

import javax.swing.SwingUtilities;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Main {


    public static void main(String[] args) {
        String seed = "snowcrash";
        int size = 4;
        int mode = StaticPanel.GRAYSCALE;
        int pause = 20;
        int font_size = 250;
        int speed = 60;

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

        if (argsMap.get("--seed") != null) {
            seed = argsMap.get("--seed");
        }

        if (argsMap.get("--size") != null) {
           size = Integer.parseInt(argsMap.get("--size"));
       }

       if (argsMap.get("--color") != null) {
           mode = StaticPanel.COLOR;
       }

       if (argsMap.get("--pause") != null) {
            pause = Integer.parseInt(argsMap.get("--pause"));
       }

        if (argsMap.get("--font_size") != null) {
            font_size = Integer.parseInt(argsMap.get("--font_size"));
        }
        if (argsMap.get("--speed") != null) {
            speed = Integer.parseInt(argsMap.get("--speed"));
        }

        SwingUtilities.invokeLater(new MyRunnable(seed, mode, size, pause, font_size, speed));

    }
}
