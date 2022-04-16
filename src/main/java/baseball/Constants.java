package baseball;

public enum Constants {
    INPUT_MESSAGE("숫자를 입력해주세요 : "),
    ENDING_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;

    }
}