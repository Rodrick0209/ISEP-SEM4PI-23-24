package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.candidateManagement.domain.CandidateDTO;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.BooleanUtils.forEach;

@UseCaseController
public class ListJobOpeningContoller {

    private final JobOpeningMapper jobOpeningMapper = new JobOpeningMapper();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    public List<JobOpeningDTO> jobOpeningsFromRepository() {

        Optional<SystemUser> user = authz.loggedinUserWithPermissions(Jobs4uRoles.CUSTOMER_MANAGER, Jobs4uRoles.POWER_USER);
        ArrayList<JobOpeningDTO> jobOpenings = new ArrayList<>();

        jobOpeningRepository.findByCustomerManager(user.get()).forEach(jobOpening -> {
            jobOpenings.add(jobOpeningMapper.toDTO(jobOpening));
        });

        return jobOpenings;

    }

    public List<JobOpeningDTO> jobOpeningsInDateRange(LocalDate startDate, LocalDate endDate) {
        List<JobOpeningDTO> allJobOpenings = jobOpeningsFromRepository();

        List<JobOpeningDTO> filteredJobOpenings = allJobOpenings.stream()
                .filter(jobOpening -> {
                    LocalDate creationDate = LocalDate.parse(jobOpening.creationDate);
                    return (creationDate.isAfter(startDate) || creationDate.isEqual(startDate))
                            && (creationDate.isBefore(endDate) || creationDate.isEqual(endDate));
                })
                .collect(Collectors.toList());

        return filteredJobOpenings;
    }


//    public List<JobOpeningDTO> activeJobOpenings() {
//        List<JobOpeningDTO> allJobOpenings = jobOpeningsFromRepository();
//
//        List<JobOpeningDTO> activeJobOpenings = allJobOpenings.stream()
//                .filter(jobOpening -> jobOpening.state == 1)
//                .collect(Collectors.toList());
//
//        return activeJobOpenings;
//    }

}
