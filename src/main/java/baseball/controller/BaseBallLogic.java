package baseball.controller;


import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import baseball.Utils;
import java.util.LinkedHashSet;

public class BaseBallLogic {

    //Instance
    private static BaseBallLogic instance;
    private Integer[] answer = new Integer[3];

    //private construct
    private BaseBallLogic() {
    }

    public static BaseBallLogic getInstance() {
        if (instance == null) {
            instance = new BaseBallLogic();
        }
        return instance;
    }

    public void generateAnswer() {
        LinkedHashSet<Integer> ret = new LinkedHashSet<>();
        do {
            ret.add(pickNumberInRange(1, 9));
        } while (ret.size() != 3);
        answer = ret.toArray(answer);
    }

    public Integer[] compare(String input) {
        Integer[] rets = new Integer[]{0, 0};
        Integer[] inputs = Utils.stringToIntegers(input);

        rets[1] = getStrike(inputs);
        rets[0] = getExistsBallCount(inputs) - rets[1];
        return rets;
    }

    private Integer getExistsBallCount(Integer[] inputs) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            count += Utils.contains(inputs, answer[i]);
        }
        return count;
    }


    private Integer getStrike(Integer[] inputs) {
        Integer count = 0;
        for (int i = 0; i < 3; i++) {
            if (answer[i].equals(inputs[i])) {
                count++;
            }
        }
        return count;
    }
}
