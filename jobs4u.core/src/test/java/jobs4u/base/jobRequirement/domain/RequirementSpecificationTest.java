package jobs4u.base.jobRequirement.domain;

import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecificationIdentifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RequirementSpecificationTest {
    @Test
    public void ensureJobRequirementSpecificationIsConfiguredSuccessfully(){
        JobRequirementSpecificationIdentifier identifier = JobRequirementSpecificationIdentifier.valueOf("teste");
        RequirementSpecification specification = new RequirementSpecification(identifier.toString(), "com.example.Teste");
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
            new RequirementSpecification(identifier.toString(), null);
        });
    }

    @Test
    public void testIsRecognisingPlugin() {
        JobRequirementSpecificationIdentifier identifier = JobRequirementSpecificationIdentifier.valueOf("teste");
        RequirementSpecification specification = new RequirementSpecification(identifier.toString(), "jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementService");
        //assertNotNull(specification.buildEvaluator());
    }

}
