package jobs4u.base.infrastructure.smoketests;

import eapli.framework.actions.Action;
import jobs4u.base.pluginManagement.domain.JobRequirementSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PluginIntegrationSmokeTest implements Action {

    private static final Logger LOGGER = LogManager.getLogger(PluginIntegrationSmokeTest.class);


    @Override
    public boolean execute(){

        JobRequirementSpecification jobRequirementSpecification =  new JobRequirementSpecification("testePlugin","jobs4u.integration.plugins.Programador2AnosExperienciaRequirement.RequirementManagement.RequirementService");
        System.out.println(  jobRequirementSpecification.buildEvaluator().evaluate("aa"));


        return true;
    }


}
