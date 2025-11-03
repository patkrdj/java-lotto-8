package lotto.Model;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Map.entry;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        lottos.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        lottos.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        lottos.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        lottos.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        lottos.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        lottos.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        lottos.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));

        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;

        lottoGame = new LottoGame(lottos, winningNumbers, bonusNumber);
    }

    @Test
    void 당첨_내역_확인하기() {
        assertThat(lottoGame.getWinningCount()).contains(
                entry(LottoGame.LottoPrice.FIFTH, 1L)
        );
    }

    @Test
    void 총_당첨_금액_확인하기() {
        assertThat(lottoGame.getWinnings(lottoGame.getWinningCount())).isEqualTo(5000);
    }

    @Test
    void 수익률_확인하기() {
        assertThat(lottoGame.getTotalReturns()).isCloseTo(0.625f, Percentage.withPercentage(0.001f));
    }
}
