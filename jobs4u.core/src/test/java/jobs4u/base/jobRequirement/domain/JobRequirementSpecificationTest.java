package jobs4u.base.jobRequirement.domain;

import jobs4u.base.pluginManagement.domain.JobRequirementSpecification;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecificationIdentifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JobRequirementSpecificationTest {
    @Test
    public void ensureJobRequirementSpecificationIsConfiguredSuccessfully(){
        JobRequirementSpecificationIdentifier identifier = JobRequirementSpecificationIdentifier.valueOf("teste");
        JobRequirementSpecification specification = new JobRequirementSpecification(identifier.toString(), "com.example.Teste");
        assertNotNull(specification);
    }

    @Test
    public void ensureJobRequirementSpecificationNotConfiguredWithoutIdentifier(){
        assertThrows(IllegalArgumentException.class, () -> {
            JobRequirementSpecificationIdentifier.valueOf(null);
        });
    }

    @Test
    public void ensureJobRequirementSpecificationNotConfiguredWithoutClassName(){
        JobRequirementSpecificationIdentifier identifier = JobRequirementSpecificationIdentifier.valueOf("teste");
        assertThrows(IllegalArgumentException.class, () -> {
            new JobRequirementSpecification(identifier.toString(), null);
        });
    }
}
