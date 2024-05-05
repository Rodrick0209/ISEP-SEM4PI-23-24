package jobs4u.base.pluginManagement.application;

import java.io.IOException;
import java.io.InputStream;

public interface InterviewEvaluation {


//    public void generateTemplate(Map<String, Map<String, String>> questions, String fileName) throws Exception;


    public double evaluate(InputStream answer) throws IOException;






}
