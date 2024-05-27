package jobs4u.base.rankManagement.application;


import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.rankManagement.domain.Rank;
import jobs4u.base.rankManagement.domain.RankDTO;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RankJobOpeningController {

    private final AuthorizationService authz =
            AuthzRegistry.authorizationService();

    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    private final JobApplicationRepository jobApplicationRepository = PersistenceContext.repositories().jobApplications();

    private final RankingService rankCandidateService = new RankingService();;

    public List<JobOpening> getjobOpeningsInAnalysisPhaseForCustomerManager() {
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.CUSTOMER_MANAGER);

        Optional<SystemUser> user = authz.loggedinUserWithPermissions(Jobs4uRoles.CUSTOMER_MANAGER);

        return jobOpeningRepository.findByCustomerManagerAndInAnalysisPhase(user.get());
    }


    public List<Candidate> getJobOpeningCandidates(JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.CUSTOMER_MANAGER);
        List<JobApplication> jobApplicationList = jobApplicationRepository.findJobApplicationsByJobOpening(jobOpening);
        List<Candidate> candidates = new ArrayList<>();

        for (JobApplication jobApplication : jobApplicationList) {
            candidates.add(jobApplication.getCandidate());
        }
        return candidates;
    }


    public Rank rankCandidates(JobOpening jobOpening, String emails){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.CUSTOMER_MANAGER);
        return rankCandidateService.rankCandidates(jobOpening, emails);
    }

    public RankDTO getRankAsDTO(JobOpening job) {
        return job.getRank().toDTO();
    }

}
