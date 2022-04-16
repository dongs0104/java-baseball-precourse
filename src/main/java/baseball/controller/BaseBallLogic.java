package baseball.controller;


import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.LinkedHashSet;

public class BaseBallLogic {

    //Instance
    private static BaseBallLogic instance;

    //private construct
    private BaseBallLogic() {
    }

    public static BaseBallLogic getInstance() {
        if (instance == null) {
            instance = new BaseBallLogic();
        }
        return instance;
    }

    public Integer[] generateAnswer() {
        LinkedHashSet<Integer> ret = new LinkedHashSet<>();
        while (true) {
            ret.add(pickNumberInRange(1, 9));
            if (ret.size() == 3) {
                break;
            }
        }
        Integer[] ints = new Integer[ret.size()];
        ints = ret.toArray(ints);

        return ints;
    }
}
