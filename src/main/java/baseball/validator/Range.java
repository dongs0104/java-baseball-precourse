package baseball.validator;

import java.util.Arrays;

public class Range implements Validator{

    @Override
    public boolean isValid(String input) throws IllegalArgumentException {
        if(3 != input.split("").length || input.contains("0")) {
            throw new IllegalArgumentException(message + "범위를 벗어난 숫자입니다.");
        }
        return true;
    }

    @Override
    public boolean isValid(Integer[] input) throws IllegalArgumentException {
        if(3 != input.length || Arrays.asList(input).contains(0)) {
            throw new IllegalArgumentException(message + "범위를 벗어난 숫자입니다.");
        }
        return true;
    }
}
