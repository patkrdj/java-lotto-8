package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.LottoGame;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            String numbers = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("[" + numbers + "]");
        });
    }

    public void printWinningCounts(Map<LottoGame.LottoPrice, Long> winningCounts) {
        System.out.println("당첨 통계\n---");
        List<LottoGame.LottoPrice> winnings = List.of(
                LottoGame.LottoPrice.FIFTH,
                LottoGame.LottoPrice.FOURTH,
                LottoGame.LottoPrice.THIRD,
                LottoGame.LottoPrice.SECOND,
                LottoGame.LottoPrice.FIRST
        );
        for (LottoGame.LottoPrice winning : winnings) {
            System.out.printf( "%s (%,d원)", winning.getDescription(), winning.getPrice());
            System.out.print(" - ");
            System.out.println(winningCounts.get(winning) + "개");
        }
    }

    public void printTotalReturns(LottoGame lottoGame) {
        System.out.printf("총 수익률은 %,.1f%%입니다.%n", lottoGame.getTotalReturns() * 100);
    }
}
