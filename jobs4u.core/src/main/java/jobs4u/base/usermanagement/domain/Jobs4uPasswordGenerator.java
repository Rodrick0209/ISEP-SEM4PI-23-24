package jobs4u.base.usermanagement.domain;

import java.util.Random;

public class Jobs4uPasswordGenerator {
    //TODO: Tests

    private static final String CAPITAL_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final int PASSWORD_LENGTH = 8;
    private static final Jobs4uPasswordPolicy passwordPolicy = new Jobs4uPasswordPolicy();

    public String generatePassword() {
        Random random = new Random();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        // Ensure at least one capital letter
        password.append(CAPITAL_CHARS.charAt(random.nextInt(CAPITAL_CHARS.length())));

        // Ensure at least one digit
        password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));

        // Fill the rest with random capital letters or digits
        for (int i = 2; i < PASSWORD_LENGTH; i++) {
            int randomIndex;
            if (random.nextBoolean()) {
                randomIndex = random.nextInt(CAPITAL_CHARS.length());
                password.append(CAPITAL_CHARS.charAt(randomIndex));
            } else {
                randomIndex = random.nextInt(NUMBERS.length());
                password.append(NUMBERS.charAt(randomIndex));
            }
        }

        if (validatePasswordPolicy(password)) {
            return password.toString();
        }else {
            return generatePassword();
        }

    }


    private boolean validatePasswordPolicy(StringBuilder password) {
        return passwordPolicy.isSatisfiedBy(password.toString());
    }
}
