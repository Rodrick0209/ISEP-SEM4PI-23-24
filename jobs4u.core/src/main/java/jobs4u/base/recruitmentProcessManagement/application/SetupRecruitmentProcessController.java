/*
package jobs4u.base.recruitmentProcessManagement.application;

import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.recruitmentProcessManagement.domain.Phase;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcess;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SetupRecruitmentProcessController {

    private AuthorizationService authz;


    private JobOpeningRepository jobOpeningRepository;


    public SetupRecruitmentProcessController(JobOpeningRepository jobOpeningRepository, AuthorizationService authz) {
        this.jobOpeningRepository = jobOpeningRepository;
        this.authz = authz;
    }

    public void ensureJobOpeningSelectedIsAvailableForRecruitmentProcess(JobOpening jobOpening) {
        jobOpening.validateCanAddOrChangeRecruitmentProcess();
    }


    public void createRecruitmentProcess(Map<Phases, Map<String, LocalDate>> phaseDates, JobOpening jobOpening) {
        List<Phase> list = new ArrayList<>();
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.CUSTOMER_MANAGER, Jobs4uRoles.ADMIN);
        ensureJobOpeningSelectedIsAvailableForRecruitmentProcess(jobOpening);
        for (Map.Entry<Phases, Map<String, LocalDate>> entry : phaseDates.entrySet()) {
            Phases phase = entry.getKey();
            Map<String, LocalDate> dates = entry.getValue();
            LocalDate startDate = dates.get("start");
            LocalDate endDate = dates.get("end");
            Phase newPhase = new Phase(phase, startDate, endDate);
            list.add(newPhase);
        }
        RecruitmentProcess recruitmentProcess = new RecruitmentProcess(list);
        jobOpening.addRecruitmentProcess(recruitmentProcess);

        jobOpeningRepository.save(jobOpening);

    }
}
*/

