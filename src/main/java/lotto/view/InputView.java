package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.util.SplitUtil;

public class InputView {

    public Integer inputPurchaseLottoPrice() {
        System.out.println(InputViewMessage.PURCHASE_PRICE.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningLottoNumbers() {
        System.out.println(InputViewMessage.WINNING_NUMBER.getMessage());
        String input = Console.readLine();
        return SplitUtil.split(input, SplitUtil.COMMA, Integer::parseInt);
    }

    public Integer inputBonusNumber() {
        System.out.println(InputViewMessage.BONUS_NUMBER.getMessage());
        return Integer.parseInt(Console.readLine());
    }

}
