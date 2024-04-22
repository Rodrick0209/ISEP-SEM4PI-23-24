package jobs4u.base.interviewModel.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InterviewModel {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
