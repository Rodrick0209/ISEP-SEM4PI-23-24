package jobs4u.base.candidateManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.util.List;

public class DisableCandidateController {

    private final AuthorizationService authz;
    private final UserManagementService uvc;
    private final CandidateRepository repository;
    private final FilterCandidateUserService filter;

    public DisableCandidateController(AuthorizationService authz, UserManagementService uvc, CandidateRepository repository){
        this.authz = authz;
        this.uvc = uvc;
        this.repository = repository;
        filter = new FilterCandidateUserService();
    }

    public List<SystemUser> enabledCandidates(){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.OPERATOR);

        Iterable<Candidate> candidates = repository.findAll();
        Iterable<SystemUser> activeUsers = uvc.activeUsers();
        return filter.filterCandidateUsers(candidates, activeUsers);
    }

    public SystemUser disable(SystemUser userCandidate){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.OPERATOR);

        return uvc.deactivateUser(userCandidate);
    }
}
