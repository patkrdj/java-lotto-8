package lotto.View;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while (true) {
            try {
                return validatePurchaseAmount(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]: " + e.getMessage());
            }
        }
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<String> input =  List.of(Console.readLine().split(","));
        return input.stream().map(Integer::parseInt).collect(Collectors.toList());

    }

    public int readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public int validatePurchaseAmount(String purchaseAmountInput) {
        try {
            int purchaseAmount = Integer.parseInt(purchaseAmountInput);
            if (purchaseAmount <= 0)
                throw new IllegalArgumentException("양수 값이 아닌 값이 입력되었습니다.");
            if (purchaseAmount % 1000 != 0)
                throw new IllegalArgumentException("1,000원으로 나누어 떨어지지 않는 금액입니다.");
            return purchaseAmount / 1000;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자값이 아닌 값이 입력되었습니다.");
        }
    }
}
