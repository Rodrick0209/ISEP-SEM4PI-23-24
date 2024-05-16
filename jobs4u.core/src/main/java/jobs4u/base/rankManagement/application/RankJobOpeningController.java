package jobs4u.base.rankManagement.application;


import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.rankManagement.domain.Rank;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.util.List;
import java.util.Optional;

public class RankJobOpeningController {

    private final AuthorizationService authz =
            AuthzRegistry.authorizationService();

    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    private final RankingService rankCandidateService = new RankingService();;

    public List<JobOpening> getjobOpeningsInAnalysisPhaseForCustomerManager() {
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.CUSTOMER_MANAGER);

        Optional<SystemUser> user = authz.loggedinUserWithPermissions(Jobs4uRoles.CUSTOMER_MANAGER);

        //TODO: should call the findByCustomerManagerAndInAnalysisPhase (test purposes only)
        return jobOpeningRepository.findByCustomerManager(user.get());
    }


    public List<Candidate> getJobOpeningCandidates(JobOpening jobOpening) {
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.CUSTOMER_MANAGER);
        return jobOpening.getCandidates();
    }


    public Rank rankCandidates(JobOpening jobOpening, String emails){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.CUSTOMER_MANAGER);
        return rankCandidateService.rankCandidates(jobOpening, emails);
    }




}
