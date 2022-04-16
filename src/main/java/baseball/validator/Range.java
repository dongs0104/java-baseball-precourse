package baseball.validator;

import baseball.Utils;

public class Range implements Validator {

    private Validator nextValidator;

    @Override
    public void setNext(Validator nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public boolean isValid(String input) throws IllegalArgumentException {
        if (3 != input.split("").length || input.contains("0")) {
            throw new IllegalArgumentException(message + " 범위를 벗어난 입력입니다.");
        }
        if (nextValidator != null) {
            return nextValidator.isValid(input);
        }
        return true;
    }

    @Override
    public boolean isValid(Integer[] inputs) throws IllegalArgumentException {
        if (3 != inputs.length || Utils.contains(inputs, 0) == 1) {
            throw new IllegalArgumentException(message + "범위를 벗어난 입력입니다.");
        }
        if (nextValidator != null) {
            return nextValidator.isValid(inputs);
        }
        return true;
    }
}
