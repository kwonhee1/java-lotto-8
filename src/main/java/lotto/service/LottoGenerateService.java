package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.vo.LottoPurchaseCount;

public class LottoGenerateService {

    public List<Lotto> generateLottos(LottoPurchaseCount tryCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < tryCount.value(); i++){
            List<Integer> randomIntegers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(randomIntegers));
        }

        return lottos;
    }

}
