# 프리코스 1주차
2022년 4월 18일(월) 23시 59분까지 GitHub을 통한 미션 제출과 [프리코스 1차 구글 폼](https://docs.google.com/forms/d/e/1FAIpQLSdoJ_IgpluMAmzRt626e4zgm_SikX8u9KJluC2heOTuftRqOA/viewform)까지 제출 완료해야 한다.

## 숫자야구게임
1부터 9까지 서로 다른 수로 이루어진 "3자리" 수를 맞추는 게임

### 기능 요구사항
- 1부터 9까지 "서로 다른" 수로 이루어진 "3자리" 수를 맞추는 게임
- 컴퓨터는 1에서 9까지 서로 다른 임의의 수 출력
  - `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()` 사용
- 플레이어는 3개의 숫자를 입력하고 입력된 숫자와 결과를 비교해 힌트 제공, [#힌트](#힌트) 참고
- 3개의 숫자가 다 맞을 시 게임 종료
- 게임 종료 후 재시작 또는 완전히 종료를 선택
- 사용자가 잘못된 값 입력 시 `IllegalArgumentException` 발생 후 프로그램 종료

### 힌트
1. 같은 수가 같은 자리는 스트라이크
2. 같은 수가 다른 자리에 있으면 볼
3. 같은 수가 없으면 낫싱 
- \[예시] 정답: `425`
  - 입력: `123` > `1스트라이크`
  - 입력: `456` > `1볼 1스트라이크`
  - 입력: `789` > `낫싱`

### 제약사항
- 숫자 야구게임을 실행하는 시작점은 `src/main/java` 폴더의 baseball.Application의 main()이다.
- 숫자 야구게임은 `JDK 8` 버전에서 실행가능해야 한다. JDK 8에서 정상 동작하지 않을 경우 0점 처리한다. 
- <b> JDK에서 제공하는 `Random` 및 `Scanner API` 대신 `camp.nextstep.edu.missionutils`에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다. </b>

  - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
- 프로그램 구현을 완료했을 때 `src/test/java` 폴더의 `baseball.ApplicationTest`에 있는 2개의 Test Case가 성공해야 한
다. 테스트가 실패할 경우 0점 처리한다.
- `ApplicationTest`에서 제공하는 2개의 Test Case는 숫자 야구게임 구현을 위한 최소한의 Test Case이다.
- 필수 요구사항은 아니지만 제공하는 소스 코드를 참고해 숫자 야구게임을 위한 모든 Test Case를 추가해 보는 것도
테스트에 대한 좋은 연습이 될 수 있다.
- [자바 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)을 지키면서 프로그래밍한다. 
- indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다. 
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메소드)를 분리하면 된다.
- 자바 8에 추가된 stream api를 사용하지 않고 구현해야 한다. 단, 람다는 사용 가능하다.
- else 예약어를 쓰지 않는다.
  - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외

### 과제 진행 요구사항
- 미션은 https://github.com/next-step/java-baseball-precourse 저장소를 fork/clone해 시작한다.
- 기능을 구현하기 전에 `docs/README.md` 파일에 구현할 기능 목록을 정리해 추가한다. 
- git의 commit 단위는 앞 단계에서 `docs/README.md` 파일에 정리한 기능 목록 단위 또는 의미있는 단위로 Commit
한다.

#### 기능 목록
1. 유효 난수 생성
2. 입력 프롬프트 출력
3. 입력값 검증 로직
4. 난수와 입력 값 비교
5. 힌트/종료 멘트 출력

```
BaseBallGame // 야구게임 어플리케이션
  run // 외부에서 게임을 수행 시키기 위한 함수
  play // 실제 게임이 구동 및 종료 확인

BaseBallGameLogic
  compareAnswer // 사용자 입력과 정답 비교
  generateAnswer // 컴퓨터 정답 생성
  
Validator // 유효성 체크 인터페이스
  RangeValidator // 숫자 범위 체크(Same Number)
  InputValidator // 입력값 검증(Except Digits)
 
Prompt // 입/출력 위해 모니터에 출력 클래스
  + getInstance // 싱글톤 구현 입출력 클래스 단일화
  + prompt // 사용자의 입력을 받기 메시지를 출력하고 입력을 받는 함수
  + printResult // 힌트 문장 출력
  + confirm // 사용자의 종료 입력을 받기 위한 함수
  - hintGenerate // 힌트 문장 생성
```