package lotto.Controller;

import lotto.View.InputView;

public class LottoController {
    public void run() {
        InputView inputView = new InputView();

        int lotto = inputView.readPurchaseAmount();
    }
}
