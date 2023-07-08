@echo off
setlocal

call classpath

REM SET DEBUG_OPTS=-classic -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5001 -DXL.RedirectSysOutErrToFile=TRUE -DXL.SysOutErrLogFile=.\logs\Client.System.Out.Err.log

REM Make sure to remove java.naming.provider.url and read it from the configuration
REM once the JNDI Profiles are implemented.
REM make sure you are using j2sdk1.4.2_05

java -jar dist\apps.jar

endlocal
