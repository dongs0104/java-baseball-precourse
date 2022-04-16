package baseball;

import java.util.Arrays;

public class Utils {

    public static Integer[] stringToIntegers(String str) {
        Integer[] rets = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            rets[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return rets;
    }

    public static int contains(Integer[] inputs, Integer target) {
        if (Arrays.asList(inputs).contains(target)) {
            return 1;
        }
        return 0;
    }

    private Utils() {
    }
}
