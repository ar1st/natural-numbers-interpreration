import java.util.Set;

public class NaturalNumbersInterpretationApp {

    public static void main(String[] args) {

        if (args.length != 1) {
            throw new RuntimeException("Expecting phone number");
        }

        PhoneNumberInterpreter interpreter = new PhoneNumberInterpreter();
        PhoneNumberValidator validator = new PhoneNumberValidator();

        String providedPhoneNumber = args[0];

        final Set<String> phoneNumbers = interpreter.interpretPhoneNumber(providedPhoneNumber);

        final Set<String> validNumbers = validator.getValidNumbers(phoneNumbers);

        for (String phoneNumber : phoneNumbers) {
            if (validNumbers.contains(phoneNumber)) {
                System.out.println(phoneNumber + ": VALID");
            } else {
                System.out.println(phoneNumber + ": INVALID");
            }
        }
    }
}
