package jobs4u.base.jobAplications.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jobs4u.base.utils.Path;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@Entity
@EqualsAndHashCode
public class JobApplicationFile implements ValueObject, Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Path path;

    public JobApplicationFile(String name, Path path) {
        this.name = name;
        this.path = path;
    }

    public JobApplicationFile() {
        // for ORM
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Path getPath() {
        return path;
    }
}
