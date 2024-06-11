package jobs4u.server.deamon.followup.server;

import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;


import java.util.List;


public class NotifyCandidatesRequest extends FollowUpRequest{

    private final JobReference jobRef;
    private final EmailService emailService;
    private final JobOpeningRepository jobOpeningRepository;
    private final CandidateSelectionService candidateSelectionService;


    public NotifyCandidatesRequest(String jobRef) {
        super(null, null);
        this.jobRef = new JobReference(jobRef);
        this.jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
        this.emailService = new EmailService();
        this.candidateSelectionService = new CandidateSelectionService();

    }

    @Override
    public byte[] execute() {

        JobOpening jobOpening = jobOpeningRepository.findByJobReference(jobRef);

        /*List<String> verifiedCandidates = candidateSelectionService.getVerifiedCandidatesEmail(jobOpening);
        List<String> rejectedCandidates = candidateSelectionService.getRejectedCandidatesEmail(jobOpening);

        for(String candidateEmail : verifiedCandidates){
            emailService.sendVerificationEmail(candidateEmail, jobRef.getJobReference());
        }
        for (String candidateEmail : rejectedCandidates){
            emailService.sendRejectedResultEmail(candidateEmail, jobRef.getJobReference());
        }*/

        emailService.sendApprovedResultEmail("1221276@isep.ipp.pt", jobRef.toString());
        emailService.sendRejectedResultEmail("1221276@isep.ipp.pt", jobRef.toString());

        byte [] response = new byte[4];

        response[0] = 1;
        response[1] = ACK;
        response[2] = 0;
        response[3] = 0;

        return response;
    }
}
