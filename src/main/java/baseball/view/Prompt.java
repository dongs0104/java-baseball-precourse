package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Prompt {

    //Instance
    private static Prompt instance;

    //private construct
    private Prompt() {
    }

    public static Prompt getInstance() {
        if (instance == null) {
            instance = new Prompt();
        }
        return instance;
    }


    public String prompt(String prompt_str) {
        System.out.print(prompt_str);
        return Console.readLine();
    }

    public String hintGenerator(Integer[] answers) {
        // 힌트 문장을 만드는 함수
        StringBuilder ret = new StringBuilder();
        return ret.toString();
    }
}