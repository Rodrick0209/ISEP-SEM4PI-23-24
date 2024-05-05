package jobs4u.base.infrastructure.smoketests;

import eapli.framework.actions.Action;
import jobs4u.base.pluginManagement.domain.RequirementSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class PluginRequirementIntegrationSmokeTest implements Action {

    private static final Logger LOGGER = LogManager.getLogger(PluginRequirementIntegrationSmokeTest.class);


    @Override
    public boolean execute(){

        RequirementSpecification requirementSpecification =  new RequirementSpecification("testePlugin","jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementService");
        try {
            System.out.println(  requirementSpecification.buildEvaluator().evaluate(InputStream.nullInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return true;
    }


}
