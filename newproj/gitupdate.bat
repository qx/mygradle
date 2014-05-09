cls
@echo off

:start
git reset HEAD --hard
if "%errorlevel%"=="1"  echo fail
if errorlevel 0 goto pull


:pull
git pull
if "%errorlevel%"=="1"  echo fail
if errorlevel 0 goto end

:end
echo update success;
