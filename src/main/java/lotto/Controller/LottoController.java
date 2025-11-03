package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.NumberGenerator;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    public void run() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int lotto = inputView.readPurchaseAmount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lotto; i++) {
            lottos.add(new Lotto(NumberGenerator.generateNumbers()));
        }

        outputView.printLottoNumbers(lottos);

    }
}
