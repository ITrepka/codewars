package exercises;

import java.util.ArrayList;
import java.util.List;

public class MexicanWave {
    public static String[] wave(String hello) {
        List<String> waves = new ArrayList<>();
        for (int i = 0; i < hello.length(); i++) {
            StringBuilder sb = new StringBuilder();
            if (hello.charAt(i) == ' ') {
                continue;
            }

            if (i > 0) {
                sb.append(hello.substring(0, i));
            }

            sb.append(hello.substring(i,i + 1).toUpperCase());
            sb.append(i != hello.length() ? hello.substring(i + 1) : "'");

            waves.add(sb.toString());
        }

        return waves.toArray(new String[0]);
    }
}
