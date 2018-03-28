call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openbrowser
echo.
echo RUNCRUD has errors - breaking work
goto fail

:openbrowser
start "C:\Program Files (x86)\Google\Chrome\Application" "http://localhost:8080/crud/v1/task/getTasks"
if "%ERRORLEVEL%" == "0" goto stoptomcat
echo Cannot open browser
goto fail

:stoptomcat
call %CATALINA_HOME%\bin\shutdown.bat

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished