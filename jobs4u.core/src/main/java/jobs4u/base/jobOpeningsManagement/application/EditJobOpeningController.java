package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.NrVacancy;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import jobs4u.base.utils.PostalAddress;

import java.util.List;

@UseCaseController
public class EditJobOpeningController {
    private AuthorizationService authz;
    private JobOpeningRepository repository;
    private ClientRepository clientRepository;

    public EditJobOpeningController(AuthorizationService authz, JobOpeningRepository repository, ClientRepository clientRepository){
        this.authz = authz;
        this.repository = repository;
        this.clientRepository = clientRepository;
    }

    public List<JobOpening> inactiveJobOpenings(){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        return repository.findInInactiveState();
    }

    public JobOpening edit(JobOpening jobOpening, Object attribute){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        if(attribute instanceof WorkingMode){
            jobOpening.editWorkingMode((WorkingMode) attribute);
        } else if (attribute instanceof NrVacancy) {
            jobOpening.editNumberVacancies((NrVacancy) attribute);
        } else if (attribute instanceof PostalAddress) {
            jobOpening.editAddress((PostalAddress) attribute);
        } else if (attribute instanceof Description) {
            jobOpening.editDescription((Description) attribute);
        } else if (attribute instanceof Designation) {
            jobOpening.editFunction((Designation) attribute);
        } else if (attribute instanceof ContractType) {
            jobOpening.editContractType((ContractType) attribute);
        }

        return repository.save(jobOpening);
    }
}
