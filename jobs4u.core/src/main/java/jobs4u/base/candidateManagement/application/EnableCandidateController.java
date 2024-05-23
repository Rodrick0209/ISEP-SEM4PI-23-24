package jobs4u.base.candidateManagement.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.UserManagementService;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.util.List;

public class EnableCandidateController {

    private final AuthorizationService authz;
    private final UserManagementService uvc;
    private final CandidateRepository repository;
    private final FilterCandidateUserService filter;

    public EnableCandidateController(AuthorizationService authz, UserManagementService uvc, CandidateRepository repository, FilterCandidateUserService filter){
        this.authz = authz;
        this.uvc = uvc;
        this.repository = repository;
        this.filter = filter;
    }

    public List<SystemUser> disabledCandidates(){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.OPERATOR);

        Iterable<Candidate> candidates = repository.findAll();
        Iterable<SystemUser> deactivatedUsers = uvc.deactivatedUsers();
        return filter.filterCandidateUsers(candidates, deactivatedUsers);
    }

    public SystemUser enable(SystemUser candidateUser){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.OPERATOR);

        return uvc.activateUser(candidateUser);
    }

}
