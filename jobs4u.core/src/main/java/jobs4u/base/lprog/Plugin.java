package jobs4u.base.lprog;

import jobs4u.base.lprog.Utils.PluginQuestions;

public interface Plugin {


    public PluginQuestions checkTemplateSyntax(String template) throws Exception;

    public void evaluate(String templatePath, String answerPath) throws Exception;






}
