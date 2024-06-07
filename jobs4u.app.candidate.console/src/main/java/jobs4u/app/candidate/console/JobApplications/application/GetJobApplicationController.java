package jobs4u.app.candidate.console.JobApplications.application;

import eapli.framework.general.domain.model.EmailAddress;
import jobs4u.app.candidate.console.client.FollowUpServerProxy;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationDTO;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;
import jobs4u.base.utils.ClientCode;

import java.io.IOException;

public class GetJobApplicationController {
    private final FollowUpServerProxy proxy = new FollowUpServerProxy();


    public Iterable<JobApplicationDTO> getJobApplicationsForCandidate(final EmailAddress emailAddress)
            throws IOException {
        return proxy.getJobApplicationForCandidate(emailAddress);
    }

}
