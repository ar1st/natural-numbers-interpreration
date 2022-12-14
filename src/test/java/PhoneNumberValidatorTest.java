import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Set;

class PhoneNumberValidatorTest {

    private final PhoneNumberValidator validator = new PhoneNumberValidator();

    @Test
    void testEmptyList() {
        Set<String> actual = validator.getValidNumbers(Collections.emptySet());

        Assertions.assertThat(actual.size())
                  .isEqualTo(0);
    }

    @Test
    void testPhoneNumbersSize() {
        String elevenDigitsPhone = "21021021021";
        String nineDigitsPhone = "210210210";
        String tenDigitsPhone = "2102102101";
        String fourteenDigitsPhone = "00302102102101";
        String fifteenDigitsPhone = "210210210121211";

        Set<String> actual = validator.getValidNumbers(Set.of(elevenDigitsPhone, nineDigitsPhone,
                                                                tenDigitsPhone, fourteenDigitsPhone, fifteenDigitsPhone));

        Assertions.assertThat(actual)
                  .hasSize(2)
                  .containsExactlyInAnyOrder(tenDigitsPhone, fourteenDigitsPhone);
    }

    @Test
    void testFourteenDigitsPhoneNumber() {
        String validFourteenDigitsLandlinePhone = "00302102102101";
        String validFourteenDigitsMobilePhone = "00306902102101";
        String invalidFourteenDigitsLandlinePhone = "00312102102101";
        String invalidFourteenDigitsMobilePhone = "00306802102101";
        String invalidCountryCodePhone = "00526902102101";

        Set<String> actual = validator.getValidNumbers(Set.of(validFourteenDigitsLandlinePhone, validFourteenDigitsMobilePhone,
                                                                invalidFourteenDigitsLandlinePhone, invalidFourteenDigitsMobilePhone,
                                                                invalidCountryCodePhone));

        Assertions.assertThat(actual)
                  .hasSize(2)
                  .containsExactlyInAnyOrder(validFourteenDigitsLandlinePhone, validFourteenDigitsMobilePhone);
    }

    @Test
    void testTenDigitsPhoneNumber() {
        String validTenDigitsLandlinePhone = "2102102101";
        String validTenDigitsMobilePhone = "6902102101";
        String invalidTenDigitsLandlinePhone = "5102102101";
        String invalidTenDigitsMobilePhone = "6802102101";

        Set<String> actual = validator.getValidNumbers(Set.of(validTenDigitsLandlinePhone, validTenDigitsMobilePhone,
                                                                invalidTenDigitsLandlinePhone, invalidTenDigitsMobilePhone));

        Assertions.assertThat(actual)
                  .hasSize(2)
                  .containsExactlyInAnyOrder(validTenDigitsLandlinePhone, validTenDigitsMobilePhone);
    }


}