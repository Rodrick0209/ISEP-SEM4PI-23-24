package jobs4u.base.utils;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.regex.Pattern;

@Embeddable
public final class PhoneNumber implements ValueObject, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile("^(91|96|93)[0-9]{7}$");
    private final String number;

    protected PhoneNumber(final String number) {
        Preconditions.nonEmpty(number, "Phone number should neither be null nor empty");
        Preconditions.matches(VALID_PHONE_NUMBER_REGEX, number, "Invalid Phone Number: " + number);
        this.number = number;
    }

    protected PhoneNumber() {
        this.number = "";
    }

    public static PhoneNumber valueOf(final String number) {
        return new PhoneNumber(number);
    }

    public String number() {
        return this.number;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PhoneNumber)) {
            return false;
        } else {
            PhoneNumber other = (PhoneNumber) o;
            return this.number.equals(other.number);
        }
    }

    @Override
    public int hashCode() {
        return this.number.hashCode();
    }
}