package jobs4u.base.jobOpeningsManagement.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.Description;
import eapli.framework.general.domain.model.Designation;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;
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
    private JobOpeningRepository jobOpeningRepository;
    private ClientRepository clientRepository;

    public EditJobOpeningController(AuthorizationService authz, JobOpeningRepository jobOpeningRepository, ClientRepository clientRepository){
        this.authz = authz;
        this.jobOpeningRepository = jobOpeningRepository;
        this.clientRepository = clientRepository;
    }

    public List<JobOpening> listInactiveJobOpenings(){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        return jobOpeningRepository.findAllInactiveJobOpenings();
    }

    public Iterable<Client> listClients(){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        return clientRepository.findAll();
    }

    public JobOpening editWorkingMode(JobOpening jobOpening, WorkingMode newWorkingMode){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        jobOpening.editWorkingMode(newWorkingMode);
        return jobOpeningRepository.save(jobOpening);
    }

    public JobOpening editNumberVacancies(JobOpening jobOpening, NrVacancy newNrVacancy){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        jobOpening.editNumberVacancies(newNrVacancy);
        return jobOpeningRepository.save(jobOpening);
    }

    public JobOpening editAddress(JobOpening jobOpening, PostalAddress newAddress){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        jobOpening.editAddress(newAddress);
        return jobOpeningRepository.save(jobOpening);
    }

    public JobOpening editDescription(JobOpening jobOpening, Description newDescription){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        jobOpening.editDescription(newDescription);
        return jobOpeningRepository.save(jobOpening);
    }

    public JobOpening editFunction(JobOpening jobOpening, Designation newFunction){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        jobOpening.editFunction(newFunction);
        return jobOpeningRepository.save(jobOpening);
    }

    public JobOpening editContractType(JobOpening jobOpening, ContractType newContractType){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        jobOpening.editContractType(newContractType);
        return jobOpeningRepository.save(jobOpening);
    }

    public JobOpening editClient(JobOpening jobOpening, Client newClient){
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER, Jobs4uRoles.CUSTOMER_MANAGER);

        jobOpening.editClient(newClient);
        return jobOpeningRepository.save(jobOpening);
    }
}
