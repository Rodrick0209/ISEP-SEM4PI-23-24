@echo off
REM set the class path,
REM assumes the build was executed with maven copy-dependencies
set JOBS4U_CP=jobs4u.deamon.followup\target\jobs4u.deamon.followup-0.1.0.jar;jobs4u.deamon.followup\target\dependency\*;

REM set the main class
java -cp %JOBS4U_CP% jobs4u.deamon.followup.FollowUpDeamon