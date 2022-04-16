package baseball.validator;

public interface Validator {

    String message = "[ERROR]";
    void setNext(Validator nextValidator);
    boolean isValid(String input) throws IllegalArgumentException;
    boolean isValid(Integer []input) throws IllegalArgumentException;
}
