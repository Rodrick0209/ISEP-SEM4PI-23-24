package jobs4u.base.jobOpeningsManagement.application;

import jobs4u.base.candidateManagement.domain.CandidateDTO;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;

import java.util.ArrayList;
import java.util.List;

public class ListJobOpeningContoller {

    private final JobOpeningMapper jobOpeningMapper = new JobOpeningMapper();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();


    private List<JobOpeningDTO> jobOpeningsFromRepository() {

        ArrayList<JobOpeningDTO> jobOpenings = new ArrayList<>();

        jobOpeningRepository.findAll().forEach(jobOpening -> {
            jobOpenings.add(jobOpeningMapper.toDTO(jobOpening));
        });

        return jobOpenings;

    }
}
