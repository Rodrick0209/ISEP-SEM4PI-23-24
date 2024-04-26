package jobs4u.base.lprog.Utils;

import java.util.ArrayList;
import java.util.List;

public class InterviewQuestions {

    private List<Question> questions = new ArrayList<>();

    public InterviewQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
