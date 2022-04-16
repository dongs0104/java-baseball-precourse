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
        while (play()) {
        }
    }

    private boolean play() {
        logic.generateAnswer();
        Integer[] compareResults;
        do {
            String input = prompt.prompt(Constants.INPUT_MESSAGE.getValue());
            validator.isValid(input);
            compareResults = logic.compare(input);
            System.out.println(prompt.hintGenerator(compareResults));
        } while (3 != compareResults[1]);
        return prompt.confirm(Constants.ENDING_MESSAGE.getValue());
    }
}
