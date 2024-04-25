package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import jobs4u.base.candidateManagement.domain.CandidateDTO;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobOpeningStatus;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.BooleanUtils.forEach;

@UseCaseController
public class ListJobOpeningContoller {

    private final JobOpeningMapper jobOpeningMapper = new JobOpeningMapper();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();
    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    public List<JobOpening> jobOpeningsFromRepository() {

        Optional<SystemUser> user = authz.loggedinUserWithPermissions(Jobs4uRoles.CUSTOMER_MANAGER, Jobs4uRoles.POWER_USER);
        ArrayList<JobOpening> jobOpenings = new ArrayList<>();

        jobOpeningRepository.findByCustomerManager(user.get()).forEach(jobOpening -> {
            jobOpenings.add(jobOpening);
        });

        return jobOpenings;

    }



    public List<JobOpening> jobOpeningsInDateRange(Calendar startDate, Calendar endDate) {
        List<JobOpening> allJobOpenings = jobOpeningsFromRepository();

        List<JobOpening> filteredJobOpenings = allJobOpenings.stream()
                .filter(jobOpening -> {
                    Calendar creationDate = jobOpening.creationDate();
                    return (creationDate.after(startDate) || creationDate.equals(startDate))
                            && (creationDate.before(endDate) || creationDate.equals(endDate));
                })
                .collect(Collectors.toList());

        return filteredJobOpenings;
    }

    public List<JobOpening> activeJobOpenings() {
        List<JobOpening> allJobOpenings = jobOpeningsFromRepository();

        List<JobOpening> activeJobOpenings = allJobOpenings.stream()
                .filter(jobOpening -> jobOpening.status() == JobOpeningStatus.ACTIVE)
                .collect(Collectors.toList());

        return activeJobOpenings;
    }

    public List<JobOpening> activeJobOpeningsInDateRange(Calendar startDate, Calendar endDate) {
        List<JobOpening> allJobOpenings = jobOpeningsFromRepository();

        List<JobOpening> activeJobOpeningsInDateRange = allJobOpenings.stream()
                .filter(jobOpening -> jobOpening.status() == JobOpeningStatus.ACTIVE)
                .filter(jobOpening -> {
                    Calendar creationDate = jobOpening.creationDate();
                    return (creationDate.after(startDate) || creationDate.equals(startDate))
                            && (creationDate.before(endDate) || creationDate.equals(endDate));
                })
                .collect(Collectors.toList());

        return activeJobOpeningsInDateRange;
    }

}
