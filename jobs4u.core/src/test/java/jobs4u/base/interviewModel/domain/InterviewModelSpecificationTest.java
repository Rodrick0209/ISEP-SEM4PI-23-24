package jobs4u.base.interviewModel.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InterviewModelSpecificationTest {
    @Test
    public void ensureInterviewModelSpecificationIsConfiguredSuccessfully(){
        InterviewModelSpecificationIdentifier interviewModelSpecificationIdentifier = InterviewModelSpecificationIdentifier.valueOf("teste");
        InterviewModelSpecification interviewModelSpecification = new InterviewModelSpecification(interviewModelSpecificationIdentifier, "com.example.teste");
        assertNotNull(interviewModelSpecification);
    }

    @Test
    public void ensureInterviewModelSpecificationNotConfiguredWithoutTheIdentifier(){
        assertThrows(IllegalArgumentException.class, () -> {
            InterviewModelSpecificationIdentifier.valueOf(null);
        });
    }

    @Test
    public void ensureInterviewModelSpecificationNotConfiguredWithoutTheClassName(){
        InterviewModelSpecificationIdentifier interviewModelSpecificationIdentifier = InterviewModelSpecificationIdentifier.valueOf("teste");
        assertThrows(IllegalArgumentException.class, () -> {
            new InterviewModelSpecification(interviewModelSpecificationIdentifier, null);
        });
    }

}
