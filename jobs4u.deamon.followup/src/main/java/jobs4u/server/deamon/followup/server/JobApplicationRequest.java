package jobs4u.server.deamon.followup.server;

import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;

import static jobs4u.server.deamon.followup.server.FollowUpMessageParser.GET_APPLICATION_CANDIDATE;

public class JobApplicationRequest extends FollowUpRequest{
    protected final static int DATA1_PREFIX = 4;
    protected final static int DATA2_PREFIX = DATA1_LEN_M * 256 + DATA1_LEN_L + 2;



    Iterable<JobApplication> jobApplications;

    public JobApplicationRequest(Iterable<JobApplication> jobs) {
        super(null, null);
        jobApplications = jobs;
    }

    @Override
    public byte[] execute() {


        byte [] response = new byte[4+ DATA1_LEN_L + DATA1_LEN_M * 256 + DATA2_LEN_L + DATA_LEN_M * 256];;
        response[0] = VERSION;
        response[1] = GET_APPLICATION_CANDIDATE;
        response[2] = DATA1_LEN_L;
        response[3] = DATA1_LEN_M;

        response[DATA1_PREFIX - 2] = DATA2_LEN_L;
        response[DATA1_PREFIX - 1] = DATA_LEN_M;

        int length=0;
        String concatjob ="";


        if (jobApplications !=null) {
            for (JobApplication jobApplication : jobApplications) {
                concatjob = concatjob.concat(jobApplication.jobOpening().jobReference().getJobReference()).concat("\n");
                concatjob = concatjob.concat(jobApplication.getState().toString()).concat("\n");
                JobApplicationRepository repo = PersistenceContext.repositories().jobApplications();
                concatjob = concatjob.concat(String.valueOf(repo.findJobApplicationsByJobOpening(jobApplication.getJobOpening()).size())).concat("\n\t");
            }
            length = concatjob.length();
            System.arraycopy(concatjob.getBytes(), 0, response, DATA1_PREFIX, length);


        }

        return response;

    }

}
