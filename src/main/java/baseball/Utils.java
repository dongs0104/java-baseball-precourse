package baseball;

public class Utils {

    public static Integer[] stringToIntegers(String str) {
        Integer[] rets = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            rets[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return rets;
    }

    public static int contains(Integer[] inputs, Integer target) {
        int count = 0;
        for (Integer i : inputs) {
            if (target == i) {
                count++;
            }
        }
        return count;
    }

    private Utils() {
    }
}
