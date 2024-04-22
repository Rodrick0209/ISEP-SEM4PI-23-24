package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.application.UseCaseController;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;

@UseCaseController
public class SelectInterviewModelForJobOpening {
    private JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();


}
