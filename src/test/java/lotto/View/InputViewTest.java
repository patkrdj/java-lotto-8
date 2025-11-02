package lotto.View;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @Test
    void 복권_정상_구매() {
        assertThat(new InputView().validatePurchaseAmount("12000"))
                .isEqualTo(12);
    }

    @Test
    void 예외_복권_구매_금액_정수값_아님() {
        assertThatThrownBy(() -> new InputView().validatePurchaseAmount("ss"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_복권_구매_금액_음수() {
        assertThatThrownBy(() -> new InputView().validatePurchaseAmount("-2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_복권_구매_금액_공백() {
        assertThatThrownBy(() -> new InputView().validatePurchaseAmount(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_복권_구매_금액_1000으로_나누어_떨어지지_않음() {
        assertThatThrownBy(() -> new InputView().validatePurchaseAmount("1200"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
