package jobs4u.server.deamon.followup.server;

import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.RequirementResult;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.rankManagement.domain.Position;

import java.util.ArrayList;
import java.util.List;



public class CandidateSelectionService {

    private final JobApplicationRepository jobApplicationRepository;

    public CandidateSelectionService() {
        this.jobApplicationRepository = PersistenceContext.repositories().jobApplications();
    }



    public List<String> getApprovedCandidatesEmail(JobOpening jobOpening){
        // get approved candidates
        List<Candidate> candidates = getApprovedCandidates(jobOpening);
        List<String> acceptedJobApplications = new ArrayList<>();

        for(Candidate c : candidates){
            acceptedJobApplications.add(c.emailAddress().toString());
        }

        return acceptedJobApplications;
    }

    public List<String> getRejectedCandidatesEmail(JobOpening jobOpening){
        // get rejected candidates
        List<Position> rejectedJobApplications = jobOpening.getRank().rank().subList(jobOpening.nrVacancy().hashCode(), jobOpening.getRank().rank().size()-1);
        List<String> rejectedJobApplicationsEmails = new ArrayList<>();

        for(Position position : rejectedJobApplications){
            rejectedJobApplicationsEmails.add(position.getCandidate().emailAddress().toString());
        }

        return rejectedJobApplicationsEmails;
    }

    public List<Candidate> getApprovedCandidates(JobOpening jobOpening){
        // get approved candidates
        List<Position> acceptedJobApplications = jobOpening.getRank().rank().subList(0, jobOpening.nrVacancy().hashCode()-1);
        List<Candidate> acceptedJobApplicationsCandidates = new ArrayList<>();

        for(Position position : acceptedJobApplications){
            acceptedJobApplicationsCandidates.add(position.getCandidate());
        }

        return acceptedJobApplicationsCandidates;
    }

    public List<String> getVerifiedCandidatesEmail(JobOpening jobOpening) {
        // get approved candidates
        List<JobApplication> jobApps = jobApplicationRepository.findJobApplicationsByJobOpening(jobOpening);

        List<String> verifiedCandidates = new ArrayList<>();
        for (JobApplication jobApp : jobApps) {
            if (jobApp.getRequirementAnswer().result().equals(RequirementResult.ACCEPTED)) {
                verifiedCandidates.add(jobApp.getCandidate().emailAddress().toString());
            }
        }

        return verifiedCandidates;
    }

    public List<String> getUnverifiedCandidatesEmail(JobOpening jobOpening) {
        // get rejected candidates
        List<JobApplication> jobApps = jobApplicationRepository.findJobApplicationsByJobOpening(jobOpening);

        List<String> rejectedCandidates = new ArrayList<>();
        for (JobApplication jobApp : jobApps) {
            if (jobApp.getRequirementAnswer().result().equals(RequirementResult.REJECTED)) {
                rejectedCandidates.add(jobApp.getCandidate().emailAddress().toString());
            }
        }

        return rejectedCandidates;
    }



}
