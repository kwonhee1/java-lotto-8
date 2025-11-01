package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public Integer inputPurchaseLottoPrice() {
        System.out.println(InputViewMessage.PURCHASE_PRICE.getMessage());
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningLottoNumbers() {
        System.out.println(InputViewMessage.WINNING_NUMBER.getMessage());
        String[] inputNumbers =  Console.readLine().split(",");
        return Arrays.stream(inputNumbers)
                .map(Integer::parseInt)
                .toList();
    }

    public Integer inputBonusNumber() {
        System.out.println(InputViewMessage.BONUS_NUMBER.getMessage());
        return Integer.parseInt(Console.readLine());
    }

}
