import tree.Tree;

import java.util.*;

public class PhoneNumberInterpreter {

    public Set<String> interpretPhoneNumber(String providedPhoneNumber) {
        final String[] digits = providedPhoneNumber.split(" ");

        Tree tree = new Tree();

        for (String digit : digits) {
            tree.add(digit);
        }

        //get all paths

        return new HashSet<>();
    }


}
