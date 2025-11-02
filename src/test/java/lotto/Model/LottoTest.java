package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @Test
    void 로또_번호를_정상적으로_입력한다() {
        assertThatCode(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호의_범위가_1과_45_사이가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자는 1에서 45사이의 값이어야 합니다.");
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자는 1에서 45사이의 값이어야 합니다.");
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호와_비교해서_동일한_번호의_개수를_얻는다() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareWinningNumbers(List.of(1, 2, 3, 4, 5, 6)))
                .isEqualTo(6);
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareWinningNumbers(List.of(1, 2, 3, 4, 5, 45)))
                .isEqualTo(5);
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareWinningNumbers(List.of(1, 2, 3, 4, 44, 45)))
                .isEqualTo(4);
    }

    @Test
    void 보너스_번호와_동일한_번호가_있는지_확인한다() {
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareBonusNumber(1))
                .isTrue();
        assertThat(new Lotto(List.of(1, 2, 3, 4, 5, 6)).compareBonusNumber(45))
                .isFalse();
    }
}
