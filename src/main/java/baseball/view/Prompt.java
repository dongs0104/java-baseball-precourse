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

    public String hintGenerator(Integer[] results) {
        StringBuilder ret = new StringBuilder();
        if (results[0] > 0) {
            ret.append(results[0]);
            ret.append("볼 ");
        }
        if (results[1] > 0) {
            ret.append(results[1]);
            ret.append("스트라이크");
        }
        if (results[1] == 3) {
            ret.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (ret.length() == 0) {
            ret.append("낫싱");
        }
        return ret.toString();
    }

    public Boolean confirm(String prompt_str) {
        System.out.print(prompt_str);
        String r = Console.readLine();
        return !"2".equals(r);
    }
}