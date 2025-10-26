package racingcar.validator;

import java.util.List;

public class CarGameValidator {

    public static void validateCarsName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하이어야 합니다.");
            }

            if (carName.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 빈칸일 수 없습니다.");
            }

            // 공백은 허용
            if (!carName.matches("^[a-zA-Z가-힣0-9 ]+$")) {
                throw new IllegalArgumentException("자동차 이름은 특수문자가 포함될 수 없습니다.");
            }
        }
    }

    public static void validateRoundTimes(String times) {
        if (times == null) {
            throw new IllegalArgumentException("라운드 횟수를 입력해야 합니다.");
        }

        try {
            int integerTimes = Integer.parseInt(times);
            if (integerTimes <= 0){
                throw new IllegalArgumentException("라운드 횟수는 0 이상이어야 합니다.");
            }
            // 사실 NumberFormatException은 IllegalArgumentException의 자식 클래스이므로 굳이 감싸지 않아도 되긴 한다.
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("라운드 횟수는 정수여야 합니다.");
        }
    }

}
