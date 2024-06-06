package jobs4u.base.jobApplications.application;

import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.FileName;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EvaluateListOfApplicationsService {


    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();


    public void evaluateListOfApplications(List<JobApplication> list) {

        try {
            for (JobApplication jobApplication : list) {
                JobOpening jobOpening = jobApplication.getJobOpening();
                if (!jobOpening.getRecruitmentProcess().returnNotClosedPhase().designation().toString().equals("Interview"))
                    throw new IllegalStateException("The recruitment process is not in the interview phase");

                InputStream inputStream = jobApplication.getRequirementAnswer().inputStreamFromResourceOrFile();
                boolean result = jobOpening.requirementSpecification().buildEvaluator().evaluate(inputStream);
                jobApplication.getRequirementAnswer().defineResult(result);
                jobApplicationRepository.save(jobApplication);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
