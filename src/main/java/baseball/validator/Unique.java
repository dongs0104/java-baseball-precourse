package baseball.validator;


import java.util.Arrays;
import java.util.LinkedHashSet;


public class Unique implements Validator {

    private Validator nextValidator;

    @Override
    public void setNext(Validator nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public boolean isValid(String input) throws IllegalArgumentException {
        LinkedHashSet<String> orderedSet = new LinkedHashSet<>(Arrays.asList(input.split("")));
        if (3 != orderedSet.size() || 3 != input.length()) {
            throw new IllegalArgumentException(message + "입력하신 숫자가 동일하여 프로그램을 종료합니다.");
        }
        if (nextValidator != null) {
            return nextValidator.isValid(input);
        }
        return true;
    }

    @Override
    public boolean isValid(Integer[] input) throws IllegalArgumentException {
        LinkedHashSet<Integer> orderedSet = new LinkedHashSet<>(Arrays.asList(input));
        if (3 != orderedSet.size()) {
            throw new IllegalArgumentException(message + "입력하신 숫자가 동일하여 프로그램을 종료합니다.");
        }
        if (nextValidator != null) {
            return nextValidator.isValid(input);
        }
        return true;
    }
}
