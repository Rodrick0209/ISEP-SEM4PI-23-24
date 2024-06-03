#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export JOBS4U_CP=jobs4u.app.customer.console/target/jobs4u.app.customer.console-0.1.0.jar:jobs4u.app.customer.console/target/dependency/*;

#REM call the java VM, e.g,
java -cp $JOBS4U_CP jobs4u.app.customer.console.BaseCustomer