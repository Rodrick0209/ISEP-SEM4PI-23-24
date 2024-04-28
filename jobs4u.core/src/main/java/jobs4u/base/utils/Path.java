package jobs4u.base.utils;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class Path  implements ValueObject, Serializable, Comparable<Path> {
    private static final long serialVersionUID = 1L;

    @Column(name = "Path")
    private final String value;

    protected Path() {
        // for ORM
        value = null;
    }

    public Path(final String path) {
        Preconditions.ensure(StringPredicates.isNonEmpty(path),
                "File path should not be null or empty");
        this.value = path;
    }

    /**
     * Factory method.
     *
     * @param path
     *
     * @return a new Username object
     */
    public static Path valueOf(final Path path) {
        return new Path(path.value);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public int compareTo(final Path o) {
        return value.compareTo(o.value);
    }

}
