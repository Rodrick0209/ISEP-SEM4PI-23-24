package jobs4u.base.jobApplications.utils;

import jobs4u.base.jobApplications.domain.JobApplication;

import java.util.Comparator;

public class JobApplicationInterviewPointsComparator implements Comparator<JobApplication> {
    @Override
    public int compare(JobApplication o1, JobApplication o2) {
        return Double.valueOf(o1.interview().points().toString()).compareTo(Double.valueOf(o2.interview().points().toString()));
    }
}
