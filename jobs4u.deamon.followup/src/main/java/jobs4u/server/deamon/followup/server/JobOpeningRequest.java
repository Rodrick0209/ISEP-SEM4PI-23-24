package jobs4u.server.deamon.followup.server;

import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;

public class JobOpeningRequest  extends FollowUpRequest{
    protected final static int DATA1_PREFIX = 4;
    protected final static int DATA2_PREFIX = DATA1_LEN_M * 256 + DATA1_LEN_L + 2;



    Iterable<JobOpening> jobOpenings;

    public JobOpeningRequest(Iterable<JobOpening> jobs) {
        super(null, null);
        jobOpenings = jobs;
    }

    @Override
    public byte[] execute() {


        byte [] response = new byte[4+ DATA1_LEN_L + DATA1_LEN_M * 256 + DATA2_LEN_L + DATA_LEN_M * 256];;
        response[0] = VERSION;
        response[1] = GET_JOB_OPENINGS;
        response[2] = DATA1_LEN_L;
        response[3] = DATA1_LEN_M;

        response[DATA1_PREFIX - 2] = DATA2_LEN_L;
        response[DATA1_PREFIX - 1] = DATA_LEN_M;

        int length=0;
        String concatjob ="";


        if (jobOpenings!=null) {
            for (JobOpening jobOpening : jobOpenings) {
                concatjob = concatjob.concat(jobOpening.jobReference().toString()).concat("\n");
                concatjob = concatjob.concat(jobOpening.function().toString()).concat("\n");
                concatjob = concatjob.concat(jobOpening.getRecruitmentProcess().applicationPhase().startDate().toString()).concat("\n");
                JobApplicationRepository repo = PersistenceContext.repositories().jobApplications();
                concatjob = concatjob.concat(String.valueOf(repo.findJobApplicationsByJobOpening(jobOpening).size())).concat("\n\t");
            }
            length = concatjob.length();
            System.arraycopy(concatjob.getBytes(), 0, response, DATA1_PREFIX, length);


        }

        return response;

    }

}
