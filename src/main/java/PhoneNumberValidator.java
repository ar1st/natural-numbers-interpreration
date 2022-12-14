import java.util.HashSet;
import java.util.Set;

public class PhoneNumberValidator {

    private static final String COUNTRY_CODE = "0030";
    public static final String MOBILE_NUMBER_PREFIX = "69";
    public static final String LANDLINE_NUMBER_PREFIX = "2";

    private static final String GREEK_MOBILE_PHONE_PREFIX = COUNTRY_CODE + MOBILE_NUMBER_PREFIX;
    private static final String GREEK_LANDLINE_PHONE_PREFIX = COUNTRY_CODE + LANDLINE_NUMBER_PREFIX;

    public Set<String> getValidNumbers(Set<String> phoneNumbers) {
        Set<String> validPhoneNumbers = new HashSet<>();

        for (String phoneNumber : phoneNumbers) {
            if (isValidPhoneNumber(phoneNumber)) {
                validPhoneNumbers.add(phoneNumber);
            }
        }

        return validPhoneNumbers;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        int phoneNumberLength = phoneNumber.length();

        if (phoneNumberLength == 14) {
            return isValidFourteenDigitsPhone(phoneNumber);
        } else if (phoneNumberLength == 10) {
            return isValidTenDigitsPhone(phoneNumber);
        }

        return false;
    }

    private boolean isValidTenDigitsPhone(String phoneNumber) {
        return phoneNumber.startsWith(MOBILE_NUMBER_PREFIX) || phoneNumber.startsWith(LANDLINE_NUMBER_PREFIX);
    }

    private boolean isValidFourteenDigitsPhone(String phoneNumber) {
        return phoneNumber.startsWith(GREEK_MOBILE_PHONE_PREFIX)
                       || phoneNumber.startsWith(GREEK_LANDLINE_PHONE_PREFIX);
    }


}
