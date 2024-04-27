package jobs4u.base.lprog.InterviewManagement.InterviewGenerator.application;

import jobs4u.base.lprog.InterviewManagement.InterviewGenerator.service.InterviewGenerator;

import java.util.Map;

public class GenerateInterviewTemplateController {


    private final InterviewGenerator interviewGenerator = new InterviewGenerator();

    public GenerateInterviewTemplateController() {
    }


    public void generateInterviewTemplate(Map<String, Map<String, String>> map, String fileName) {
        interviewGenerator.generateInterview(map, fileName);
    }

}
