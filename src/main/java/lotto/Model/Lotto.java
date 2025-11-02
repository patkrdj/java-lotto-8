package lotto.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 숫자는 1에서 45사이의 값이어야 합니다.");
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> nonDuplicatedNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!nonDuplicatedNumbers.add(number)) {
                throw new IllegalArgumentException("[Error] 숫자가 중복되었습니다.");
            }
        }
    }

    public long compareWinningNumbers(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean compareBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
