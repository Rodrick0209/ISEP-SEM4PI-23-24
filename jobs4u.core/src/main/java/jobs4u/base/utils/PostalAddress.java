package jobs4u.base.utils;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.regex.Pattern;

@Embeddable
public final class PostalAddress implements ValueObject, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Pattern VALID_POSTAL_CODE_REGEX = Pattern.compile("^[0-9]{4}-[0-9]{3}$");
    private final String address;

    protected PostalAddress(final String address) {
        Preconditions.nonEmpty(address, "Address should neither be null nor empty");
        Preconditions.matches(VALID_POSTAL_CODE_REGEX, address, "Invalid Postal Code: " + address);
        this.address = address;
    }

    protected PostalAddress() {
        this.address = "";
    }

    public static PostalAddress valueOf(final String address) {
        return new PostalAddress(address);
    }

    public String address() {
        return this.address;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PostalAddress)) {
            return false;
        } else {
            PostalAddress other = (PostalAddress) o;
            return this.address.equals(other.address);
        }
    }

    @Override
    public int hashCode() {
        return this.address.hashCode();
    }
}