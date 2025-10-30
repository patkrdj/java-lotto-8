package lotto.View;

import camp.nextstep.edu.missionutils.Console;

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
