package jobs4u.server.deamon.followup.server;

import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;

import java.util.List;

public class ResultEmailRequest extends FollowUpRequest{


    private final JobOpeningRepository jobOpeningRepository;
    private final EmailService emailService;
    private final CandidateSelectionService candidateSelectionService;
    private final JobReference jobRef;

    public ResultEmailRequest(String jobRef) {
        super(null, null);
        this.jobRef = new JobReference(jobRef);
        this.jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
        this.candidateSelectionService = new CandidateSelectionService();

        this.emailService = new EmailService();
    }

    @Override
    public byte[] execute() {


        JobOpening jobOpening = jobOpeningRepository.findByJobReference(jobRef);

        List<String> approvedCandidates = candidateSelectionService.getApprovedCandidatesEmail(jobOpening);
        List<String> rejectedCandidates = candidateSelectionService.getRejectedCandidatesEmail(jobOpening);
        String customerEmail = jobOpening.getClient().getUser().email().toString();

        for(String candidateEmail : approvedCandidates){
            emailService.sendApprovedResultEmail(candidateEmail, jobRef.getJobReference());
        }

        for(String candidateEmail : rejectedCandidates){
            emailService.sendRejectedResultEmail(candidateEmail, jobRef.getJobReference());
        }

        emailService.sendResultsEmail(customerEmail, jobRef.getJobReference(), candidateSelectionService.getApprovedCandidates(jobOpening));

        final var response = new byte[4];
        response[0] = VERSION;
        response[1] = ACK;
        response[2] = 0;
        response[3] = 0;


        return response;

    }
}
