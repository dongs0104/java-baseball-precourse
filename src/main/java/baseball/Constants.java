package baseball;

public enum Constants {
    INPUT_MESSAGE("숫자를 입력해주세요 : ");
    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;

    }
}