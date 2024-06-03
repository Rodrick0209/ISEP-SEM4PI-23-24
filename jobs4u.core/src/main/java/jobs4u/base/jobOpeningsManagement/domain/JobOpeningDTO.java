package jobs4u.base.jobOpeningsManagement.domain;

import lombok.Setter;

@Setter
public class JobOpeningDTO {

    public String JobReference;
    public String workingMode;
    public String nrVacancy;
    public String address;
    public String description;
    public String function;
    public String contractType;
    public String creationDate;
    public String status;

    public JobOpeningDTO(String jobReference) {
        JobReference = jobReference;
    }

    public JobOpeningDTO() {
    }

}
