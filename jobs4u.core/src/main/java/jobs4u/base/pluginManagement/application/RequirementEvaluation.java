package jobs4u.base.pluginManagement.application;

import java.io.IOException;
import java.io.InputStream;

public interface RequirementEvaluation {


    //product owner saide that generate can be hardcoded in the plugin so only the evaluate is needed


    /**
     * This method evaluates the requirements of the candidate
     *
     * @param answerPath the path to the file with the answers of the candidate
     * @return true if the candidate meets the requirements, false otherwise
     */
    public boolean evaluate(InputStream answerPath) throws IOException;


}
