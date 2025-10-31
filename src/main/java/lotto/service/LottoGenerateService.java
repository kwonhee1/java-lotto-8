package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoGenerateService {

    public List<Lotto> generateLottos(int count) {
        validateLottoTryCount(count);

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++){
            List<Integer> randomIntegers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(randomIntegers));
        }

        return lottos;
    }

    private void validateLottoTryCount(int count) {
        if(count < 1)
            throw new IllegalLottoTryCountException();
    }

}
