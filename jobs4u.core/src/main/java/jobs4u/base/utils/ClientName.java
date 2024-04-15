package jobs4u.base.utils;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public final class ClientName implements ValueObject, Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;

    protected ClientName(final String name) {
        Preconditions.nonEmpty(name, "Name should neither be null nor empty");
        this.name = name;
    }

    protected ClientName() {
        this.name = "";
    }

    public static ClientName valueOf(final String name) {
        return new ClientName(name);
    }

    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ClientName)) {
            return false;
        } else {
            ClientName other = (ClientName) o;
            return this.name.equals(other.name);
        }
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}