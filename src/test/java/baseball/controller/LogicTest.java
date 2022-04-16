package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LogicTest {

    @Test
    void test_singleton() {
        BaseBallLogic first = BaseBallLogic.getInstance();
        BaseBallLogic second = BaseBallLogic.getInstance();
        assertThat(first.equals(second)).isTrue();
    }

    @Test
    void test_answer_length() {
        BaseBallLogic logic = BaseBallLogic.getInstance();
        logic.generateAnswer();
    }
}
