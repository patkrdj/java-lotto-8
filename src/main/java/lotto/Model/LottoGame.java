package lotto.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoGame {
    public enum LottoPrice {
        FIRST(2_000_000_000),
        SECOND(30_000_000),
        THIRD(1_500_000),
        FOURTH(50_000),
        FIFTH(5_000),
        MISS(0);

        private final long price;

        LottoPrice(long price) {
            this.price = price;
        }

        public long getPrice() {
            return price;
        }

        public static LottoPrice valueOf(long matches, boolean bonusMatch) {
            if (matches == 6) {
                return FIRST;
            }
            if (matches == 5) {
                return (bonusMatch) ? SECOND : THIRD;
            }
            if (matches == 4) {
                return FOURTH;
            }
            if (matches == 3) {
                return FIFTH;
            }
            return MISS;
        }
    }

    private final int lottoCount;
    private List<Lotto> lottos = new ArrayList<>();
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoGame(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoCount = lottos.size();
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<LottoPrice, Long> getWinningCount() {
        return lottos.stream()
                .map(lotto -> {
                    long matches = lotto.compareWinningNumbers(winningNumbers);
                    boolean bonusMatch = lotto.compareBonusNumber(bonusNumber);
                    return LottoPrice.valueOf(matches, bonusMatch);
                })
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    private long getWinnings(Map<LottoPrice, Long> winnings) {
        return winnings.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public float getTotalReturns() {
        long totalWinnings = getWinnings(getWinningCount());
        return (float) totalWinnings / (float) lottoCount * 1000;
    }
}
