package baseball.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UniqueTest {

    final Validator unique = new Unique();


    @ParameterizedTest
    @ValueSource(strings = {"111", "121", "1334", "999", "998", "9987"})
    void ntest_str_value_unique(String test_input) {
        assertThatIllegalArgumentException().isThrownBy(() -> unique.isValid(test_input));
    }

    @Test
    void ntest_arr_value_unique() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> unique.isValid(new Integer[]{1, 2, 2}));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "124", "432", "981"})
    void test_str_value_unique(String test_input) {
        assertThat(unique.isValid(test_input)).isTrue();
    }

    @Test
    void test_arr_value_unique() {
        assertThat(unique.isValid(new Integer[]{1, 2, 3})).isTrue();
    }
}
