#!/bin/bash
# set the class path,
# assumes the build was executed with maven copy-dependencies
JOBS4U_CP="jobs4u.app.backoffice.console/target/jobs4u.app.backoffice.console-0.1.0.jar:jobs4u.app.backoffice.console/target/dependency/*:jobs4u.integration.plugins/target/jobs4u.integration.plugins.Programador2AnosExperienciaRequirement-0.1.0.jar"

# call the java VM, e.g,
java -cp $JOBS4U_CP jobs4u.base.app.backoffice.console.BaseBackoffice