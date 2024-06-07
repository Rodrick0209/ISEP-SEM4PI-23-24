/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package jobs4u.base.persistence.impl.inmemory;

import eapli.framework.infrastructure.repositories.impl.inmemory.InMemoryDomainRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.RequirementResult;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge Santos ajs@isep.ipp.pt 02/04/2016
 */
public class InMemoryJobApplicationRepository
        extends InMemoryDomainRepository<JobApplication, Long>
        implements JobApplicationRepository {

    static {
        InMemoryInitializer.init();
    }


    @Override
    public Iterable<JobApplication> findJobApplicationsByCandidate(Candidate candidate) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication jobApplication : this) {
            if (jobApplication.candidate().emailAddress().equals(candidate.emailAddress())) {
                result.add(jobApplication);
            }
        }
        return result;
    }

    @Override
    public List<JobApplication> findJobApplicationsByJobOpening(JobOpening jobOpening) {
        return null;
    }

    @Override
    public List<JobApplication> findJobApplicationsByJobOpeningWithRequirementAnswerFile(JobOpening jobOpening){
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication jobApplication : this) {
            if(jobApplication.jobOpening().jobReference().toString().equals(jobOpening.jobReference().toString())){
                if(jobApplication.requirementAnswer() != null){
                    if(jobApplication.requirementAnswer().result() == null)
                        result.add(jobApplication);
                }
            }
        }
        return result;
    }

    @Override
    public List<JobApplication> findJobApplicationByJobOpeningWithInterviewAnswerFileWithoutInterviewPointsAndRequirementResultAccepted(JobOpening jobOpening) {
        List<JobApplication> result = new ArrayList<>();
        for (JobApplication jobApplication : this) {
            if(jobApplication.jobOpening().jobReference().toString().equals(jobOpening.jobReference().toString())){
                if(jobApplication.interview().answer() != null){
                    if(jobApplication.interview().points() == null){
                        if(jobApplication.requirementAnswer().result().equals(RequirementResult.ACCEPTED)) {
                            result.add(jobApplication);
                        }
                    }
                }
            }
        }
        return result;
    }

}
