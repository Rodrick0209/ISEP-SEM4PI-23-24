package jobs4u.base.lprog;

import jobs4u.base.lprog.Utils.PluginQuestions;

import java.util.Map;

public interface Plugin {



//    public void generateTemplate(Map<String, Map<String, String>> questions, String fileName) throws Exception;


    public void evaluate(String templatePath, String answerPath) throws Exception;






}
