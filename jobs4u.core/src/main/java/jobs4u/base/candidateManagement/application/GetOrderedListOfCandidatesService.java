package jobs4u.base.candidateManagement.application;

import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.utils.JobApplicationInterviewPointsComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class GetOrderedListOfCandidatesService {
    public List<Candidate> getOrderedListOfCandidatesBasedOnInterviewPoints(Iterable<JobApplication> jobApplications){
        List<Candidate> orderedCandidates = new ArrayList<>();
        List<JobApplication> orderedJobApplications = getOrderedListOfJobApplicationsBasedOnInterviewPoints(jobApplications);

        for(JobApplication jobApplication : orderedJobApplications){
            orderedCandidates.add(jobApplication.candidate());
        }

        return orderedCandidates;
    }

    private List<JobApplication> getOrderedListOfJobApplicationsBasedOnInterviewPoints(Iterable<JobApplication> jobApplications) {
        return StreamSupport.stream(jobApplications.spliterator(), false).sorted(new JobApplicationInterviewPointsComparator().reversed()).collect(Collectors.toList());
    }
}
