package racingcar.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarGameValidatorTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외 발생")
    void validateCarsName_lengthOverFive() {
        List<String> carNames = List.of("abcdef");

        assertThatThrownBy(() -> CarGameValidator.validateCarsName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("5자 이하");
    }

    @Test
    @DisplayName("자동차 이름이 빈칸이면 예외 발생")
    void validateCarsName_blank() {
        List<String> carNames = List.of(" ");

        assertThatThrownBy(() -> CarGameValidator.validateCarsName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈칸");
    }

    @Test
    @DisplayName("자동차 이름에 특수문자가 포함되면 예외 발생")
    void validateCarsName_specialChar() {
        List<String> carNames = List.of("car@");

        assertThatThrownBy(() -> CarGameValidator.validateCarsName(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("특수문자");
    }

    @Test
    @DisplayName("라운드 횟수가 0 이하이면 예외 발생")
    void validateRoundTimes_zeroOrNegative() {
        assertThatThrownBy(() -> CarGameValidator.validateRoundTimes("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0 이상");
    }

    @Test
    @DisplayName("라운드 횟수가 숫자가 아니면 예외 발생")
    void validateRoundTimes_notNumber() {
        assertThatThrownBy(() -> CarGameValidator.validateRoundTimes("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("정수");
    }
}
