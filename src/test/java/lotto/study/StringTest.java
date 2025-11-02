package lotto.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringTest {
    @Test
    void split_test_1() {
        String string = "1,2";
        assertThat(string.split(",")).contains("1", "2");
    }

    @Test
    void split_test_2() {
        String string = "1";
        assertThat(string.split(",")).containsExactly("1");
    }

    @Test
    void substring_test() {
        String string = "(1,2)";
        assertThat(string.substring(1, string.length() - 1)).contains("1,2");
    }

    @DisplayName("String의 CharAt의 OutOfBound Exception 확인하기")
    @Test
    void charAt_test() {
        String string = "abc";

        assertThatThrownBy(() -> { string.charAt(-1);
        }).isInstanceOf(IndexOutOfBoundsException.class);

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
            .isThrownBy(() -> { string.charAt(-1); });
    }
}
