#!/usr/bin/env bash

export JOBS4U_CP="jobs4u/target/jobs4u.deamon.followup-0.1.0.jar:jobs4u.deamon.followup/target/dependency/*;"


java -cp $JOBS4U_CP jobs4u.deamon.followup/src/main/java/jobs4u/base/FollowUpDeamon.java
