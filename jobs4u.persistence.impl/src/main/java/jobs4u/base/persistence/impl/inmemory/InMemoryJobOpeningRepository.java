package jobs4u.base.persistence.impl.inmemory;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobOpeningStatus;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import jobs4u.base.recruitmentProcessManagement.utils.State;
import jobs4u.base.utils.ClientCode;

import java.util.ArrayList;
import java.util.List;

class InMemoryJobOpeningRepository extends InMemoryDomainRepository<JobOpening, JobReference> implements JobOpeningRepository {


    static {
        InMemoryInitializer.init();
    }

    @Override
    public List<JobOpening> findByCustomerManager(SystemUser customerManager) {
        List<JobOpening> result = new ArrayList<>();
        for (JobOpening jobOpening : this) {
            if (jobOpening.getClient().getCustomerManagerEmail().equals(customerManager.email())) {
                result.add(jobOpening);
            }
        }
        return result;
    }

    @Override
    public List<JobOpening> findByCustomer(ClientCode client) {
        List<JobOpening> result = new ArrayList<>();
        for (JobOpening jobOpening : this) {
            if (jobOpening.getClient().clientCode().equals(client)) {
                result.add(jobOpening);
            }
        }
        return result;
    }

    @Override
    public int countForClientCode(ClientCode clientCode) {
        int count = 0;
        for (JobOpening jobOpening : this) {
            if (jobOpening.jobReference().getJobReference().startsWith(clientCode.code() + "-")) {
                count++;
            }
        }
        return count;
    }


    @Override
    public List<JobOpening> findByCustomerManagerAndInAnalysisPhase(SystemUser customermanager) {
        List<JobOpening> result = new ArrayList<>();
        for (JobOpening jobOpening : this) {
            if (jobOpening.getClient().getCustomerManagerEmail().equals(customermanager.email())) {
                if (jobOpening.getRecruitmentProcess().returnNotClosedPhase().equals(Phases.ANALYSIS)) {
                    result.add(jobOpening);
                }
            }

        }
        return result;
    }

    @Override
    public List<JobOpening> findInInactiveState() {
        List<JobOpening> result = new ArrayList<>();
        for (JobOpening jobOpening : this){
            if(jobOpening.getStatus().equals(JobOpeningStatus.INACTIVE)){
                result.add(jobOpening);
            }
        }
        return result;
    }

    @Override
    public List<JobOpening> findInAnalysisPhaseAndHadInterviewPhase() {
        List<JobOpening> result = new ArrayList<>();
        for (JobOpening jobOpening : this){
            if(jobOpening.getRecruitmentProcess().returnNotClosedPhase().designation().equals(Phases.ANALYSIS)){
                if(jobOpening.getRecruitmentProcess().interviewsPhase() != null){
                    result.add(jobOpening);
                }
            }
        }
        return result;
    }


    @Override
    public List<JobOpening> findJobOpeningsWithInterviewPhaseByCustomer(SystemUser customer) {
        List<JobOpening> result = new ArrayList<>();
        for (JobOpening jobOpening : this) {
            if (jobOpening.getClient().getCustomerManagerEmail().equals(customer.email()) &&
                    jobOpening.getRecruitmentProcess().hasInterviewPhase()) {
                result.add(jobOpening);
            }
        }
        return result;
    }

    @Override
    public List<JobOpening> findInInterviewPhase() {
        List<JobOpening> result = new ArrayList<>();
        for(JobOpening jobOpening : this){
            if(jobOpening.getRecruitmentProcess().interviewsPhase().state().equals(State.OPEN) || jobOpening.getRecruitmentProcess().interviewsPhase().state().equals(State.ACTIVE)){
                result.add(jobOpening);
            }
        }
        return result;
    }

    public List<JobOpening> findInResultPhase() {
        List<JobOpening> result = new ArrayList<>();
        for(JobOpening jobOpening : this){
            if(jobOpening.getRecruitmentProcess().returnNotClosedPhase().designation().equals(Phases.RESULT)){
                result.add(jobOpening);
            }
        }
        return result;
    }

    @Override
    public JobOpening findByJobReference(JobReference jobReference) {
        for (JobOpening jobOpening : this) {
            if (jobOpening.jobReference().equals(jobReference)) {
                return jobOpening;
            }
        }
        return null;
    }

    @Override
    public List<JobOpening> findInFinishedScreeningPhase() {
        List<JobOpening> result = new ArrayList<>();
        for(JobOpening jobOpening : this){
            if(jobOpening.recruitmentProcess().returnNotClosedPhase().designation().equals(Phases.RESUME_SCREEN)){
                if(jobOpening.recruitmentProcess().returnNotClosedPhase().state().equals(State.FINISHED)){
                    result.add(jobOpening);
                }
            }
        }
        return result;
    }
}
