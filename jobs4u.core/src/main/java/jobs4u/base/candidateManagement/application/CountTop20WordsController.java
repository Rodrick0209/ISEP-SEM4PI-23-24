package jobs4u.base.candidateManagement.application;

import jobs4u.base.candidateManagement.domain.WordsCount;
import jobs4u.base.jobApplications.domain.JobApplication;

import java.util.List;

public class CountTop20WordsController {

    public List<WordsCount> countTop20Words(JobApplication jobApplication) throws InterruptedException {
            CountTop20WordsService countTop20WordsService = new CountTop20WordsService();
            return countTop20WordsService.countTop20Words(jobApplication);
    }
}
