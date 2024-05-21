package jobs4u.base.candidateManagement.application;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.candidateManagement.domain.Candidate;

import java.util.*;

public class FilterCandidateUserService {

    public List<SystemUser> filterCandidateUsers(Iterable<Candidate> candidates, Iterable<SystemUser> users) {
        Set<String> candidateEmails = new HashSet<>();
        for (Candidate candidate : candidates) {
            candidateEmails.add(candidate.emailAddress().toString());
        }

        List<SystemUser> candidateUsers = new ArrayList<>();
        for (SystemUser user : users) {
            if (candidateEmails.contains(user.username().toString())) {
                candidateUsers.add(user);
            }
        }

        return candidateUsers;
    }
}
