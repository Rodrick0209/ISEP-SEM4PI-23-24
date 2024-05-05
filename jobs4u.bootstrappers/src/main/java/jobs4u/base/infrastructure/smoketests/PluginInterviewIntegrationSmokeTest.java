package jobs4u.base.infrastructure.smoketests;

import eapli.framework.actions.Action;
import jobs4u.base.pluginManagement.domain.InterviewModelSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;

public class PluginInterviewIntegrationSmokeTest implements Action {

    private static final Logger LOGGER = LogManager.getLogger(PluginInterviewIntegrationSmokeTest.class);


    @Override
    public boolean execute(){

        InterviewModelSpecification interviewModelSpecification =  new InterviewModelSpecification("testePlugin","jobs4u.integration.plugins.QuimicoInterview.InterviewManagement.InterviewService");
        try {
            System.out.println(  interviewModelSpecification.buildEvaluator().evaluate(InputStream.nullInputStream()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return true;
    }


}
