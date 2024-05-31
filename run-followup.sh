#!/bin/bash
# set the class path,
# assumes the build was executed with maven copy-dependencies
JOBS4U_CP="jobs4u.deamon.followup/target/followup-0.1.0.jar:jobs4u.deamon.followup/target/dependency/*"

# call the java VM, e.g,
java -cp $JOBS4U_CP jobs4u.server.deamon.FollowUpDeamon