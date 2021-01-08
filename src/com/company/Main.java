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
        int zoom = 0;
        int font_size = 250;

        List<String> argList = Arrays.asList(args);

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

       if (argsMap.get("--zoom") != null) {
            zoom = Integer.parseInt(argsMap.get("--zoom"));
       }

        if (argsMap.get("--font_size") != null) {
            zoom = Integer.parseInt(argsMap.get("--font_size"));
        }

        SwingUtilities.invokeLater(new MyRunnable(seed, mode, size, zoom, font_size));

    }
}
