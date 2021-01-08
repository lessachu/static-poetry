package com.company;

import javax.swing.SwingUtilities;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Main {


    public static void main(String[] args) {
        int size = 4;
        int mode = StaticPanel.GRAYSCALE;
        int zoom = 0;

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

        if (argsMap.get("--size") != null) {
           size = Integer.parseInt(argsMap.get("--size"));
       }

       if (argsMap.get("--color") != null) {
           mode = StaticPanel.COLOR;
       }

       if (argsMap.get("--zoom") != null) {
           zoom = Integer.parseInt(argsMap.get("--zoom"));
       }

        SwingUtilities.invokeLater(new MyRunnable(mode, size, zoom));

    }
}
