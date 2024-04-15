package jobs4u.base.utils;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public final class ClientCode implements ValueObject, Serializable, Comparable<ClientCode> {
    private static final long serialVersionUID = 1L;
    private final String code;

    protected ClientCode(final String code) {
        Preconditions.nonEmpty(code, "Code should neither be null nor empty");
        Preconditions.ensure(code.length() <= 10, "Code should not have more than 10 characters");
        this.code = code;
    }

    protected ClientCode() {
        this.code = "";
    }

    public static ClientCode valueOf(final String code) {
        return new ClientCode(code);
    }

    public String code() {
        return this.code;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ClientCode)) {
            return false;
        } else {
            ClientCode other = (ClientCode) o;
            return this.code.equals(other.code);
        }
    }

    @Override
    public int hashCode() {
        return this.code.hashCode();
    }

    @Override
    public int compareTo(ClientCode o) {
        return this.code.compareTo(o.code);
    }
}