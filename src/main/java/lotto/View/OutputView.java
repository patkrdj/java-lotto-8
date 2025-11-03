package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.LottoGame;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printLottoNumbers(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.forEach(lotto -> {
            System.out.print('[');
            for (int number : lotto.getNumbers()) {
                System.out.print(number + " ,");
            }
            System.out.println(']');
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
            System.out.print(winning.getDescription() + " (" + winning.getPrice() + "원)");
            System.out.print(" - ");
            System.out.println(winningCounts.get(winning) + "개");
        }
    }

    public void printTotalReturns(LottoGame lottoGame) {
        System.out.println(String.format("총 수익률은 %.2f%입니다.", lottoGame.getTotalReturns()));
    }
}
