package lotto.View;

import lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
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
