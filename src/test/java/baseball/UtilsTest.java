package baseball;

import static baseball.Utils.contains;
import static baseball.Utils.stringToIntegers;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class UtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"123,3,1", "4444,4,4", "0000,1,0"})
    void test_contains(String test_input, String test_target, String excepted_count) {
        assertThat(contains(stringToIntegers(test_input), Integer.parseInt(test_target))).isEqualTo(Integer.parseInt(excepted_count));
    }

    @ParameterizedTest
    @CsvSource(value = {"123,3", "1234,4", "0000,4"})
    void test_string_to_integers(String test_input, String excepted_length) {
        assertThat(stringToIntegers(test_input).length).isEqualTo(Integer.parseInt(excepted_length));
    }
}
