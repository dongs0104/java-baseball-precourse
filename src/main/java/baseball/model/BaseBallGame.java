package baseball.model;

import baseball.Constants;
import baseball.controller.BaseBallLogic;
import baseball.validator.Range;
import baseball.validator.Unique;
import baseball.validator.Validator;
import baseball.view.Prompt;

public class BaseBallGame {

    private final BaseBallLogic logic;
    private final Prompt prompt;
    private final Validator validator;

    public BaseBallGame() {
        logic = BaseBallLogic.getInstance();
        prompt = Prompt.getInstance();
        validator = new Range();
        validator.setNext(new Unique());
    }

    public void run() {
        while (true) {
            if (play(logic.generateAnswer())) {
                break;
            }
        }
    }

    private boolean play(Integer[] answer) {
        while (true) {
            String input = prompt.prompt(Constants.INPUT_MESSAGE.getValue());
            try {
                if (validator.isValid(input)) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw e;
            }
        /*
            4. 난수와 입력 값 비교
            5. 힌트/종료 멘트 출력
        */
        }
        return false;
    }
}
