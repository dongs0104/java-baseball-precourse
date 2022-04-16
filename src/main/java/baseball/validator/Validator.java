package baseball.validator;

public interface Validator {

    String message = "[ERROR]";

    boolean isValid(String input) throws IllegalArgumentException;
    boolean isValid(Integer []input) throws IllegalArgumentException;
}
