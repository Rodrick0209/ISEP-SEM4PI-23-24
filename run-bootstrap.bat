@echo off
REM set the class path,
REM assumes the build was executed with maven copy-dependencies
set JOBS4U_CP=jobs4u.app.bootstrap\target\jobs4u.app.bootstrap-0.1.0.jar;jobs4u.app.bootstrap\target\dependency\*;jobs4u.integration.plugins\target\jobs4u.integration.plugins.Programador2AnosExperienciaRequirement-0.1.0.jar;jobs4u.integration.plugins\target\jobs4u.integration.plugins.QuimicoInterview-0.1.0.jar;

REM call the java VM, e.g,
java -cp %JOBS4U_CP% jobs4u.base.app.bootstrap.BaseBootstrap