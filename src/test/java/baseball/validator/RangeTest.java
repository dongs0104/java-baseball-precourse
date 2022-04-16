package baseball.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RangeTest {

    final Validator range = new Range();


    @ParameterizedTest
    @ValueSource(strings = {"0", "012", "1234", "123456789"})
    void ntest_str_value_range(String test_input) {
        assertThatIllegalArgumentException().isThrownBy(() -> range.isValid(test_input));
    }

    @Test
    void ntest_include_0_value_range() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> range.isValid(new Integer[]{0, 1, 2}));
    }

    @Test
    void ntest_arr_value_range() {
        assertThatIllegalArgumentException().isThrownBy(
            () -> range.isValid(new Integer[]{1, 2}));
        assertThatIllegalArgumentException().isThrownBy(
            () -> range.isValid(new Integer[]{1, 2, 3, 4}));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "234", "111", "456"})
    void test_str_value_range(String test_input) {
        assertThat(range.isValid(test_input)).isTrue();
    }

    @Test
    void test_arr_value_range() {
        assertThat(range.isValid(new Integer[]{1, 2, 3})).isTrue();
    }
}
