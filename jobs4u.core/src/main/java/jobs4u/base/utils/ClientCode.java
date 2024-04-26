package jobs4u.base.utils;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public final class ClientCode implements ValueObject, Serializable, Comparable<ClientCode> {
    private static final long serialVersionUID = 1L;


    private final String clientCode;

    protected ClientCode(final String clientCode) {
        Preconditions.nonEmpty(clientCode, "Code should neither be null nor empty");
        Preconditions.ensure(clientCode.length() <= 10, "Code should not have more than 10 characters");
        this.clientCode = clientCode;
    }

    protected ClientCode() {
        this.clientCode = "";
    }

    public static ClientCode valueOf(final String code) {
        return new ClientCode(code);
    }

    public String code() {
        return this.clientCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ClientCode)) {
            return false;
        } else {
            ClientCode other = (ClientCode) o;
            return this.clientCode.equals(other.clientCode);
        }
    }

    @Override
    public int hashCode() {
        return this.clientCode.hashCode();
    }

    @Override
    public int compareTo(ClientCode o) {
        return this.clientCode.compareTo(o.clientCode);
    }

    @Override
    public String toString() {
        return this.clientCode;
    }
}