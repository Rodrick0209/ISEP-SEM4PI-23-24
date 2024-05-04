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
package jobs4u.base.infrastructure.persistence;

import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.pluginManagement.repositories.InterviewModelSpecificationRepository;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.pluginManagement.repositories.JobRequirementSpecificationRepository;
import jobs4u.base.jobs4uusermanagement.repositories.ClientUserRepository;
import jobs4u.base.jobs4uusermanagement.repositories.SignupRequestRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     *
     * @param autoTx
     *            the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     *
     * @param autoTx
     *            the transactional context to enroll
     * @return
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ClientUserRepository clientUsers();

    JobOpeningRepository jobOpenings();

    JobApplicationRepository jobApplications(TransactionalContext autoTx);

    JobApplicationRepository jobApplications();


    ClientRepository clients();

    ClientRepository clients(TransactionalContext autoTx);


    CandidateRepository candidates();

    CandidateRepository candidates(TransactionalContext autoTx);

    JobRequirementSpecificationRepository jobRequirementsSpecification();

    JobRequirementSpecificationRepository jobRequirementsSpecification(TransactionalContext autoTx);

    InterviewModelSpecificationRepository interviewModelsSpecification();

    InterviewModelSpecificationRepository interviewModelsSpecification(TransactionalContext autoTx);

}