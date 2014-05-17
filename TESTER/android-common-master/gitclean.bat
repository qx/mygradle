cls
@echo off

:clear
adb shell pm clear com.cfz.android
if "%errorlevel%"=="1"  echo fail
if errorlevel 0 goto end

:end
echo commit and push success;
