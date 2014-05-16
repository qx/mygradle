@echo off

git status
if "%errorlevel%"=="1"  echo fail
if errorlevel 0 goto add

:add
echo This bat will add all file? Please press any key to continue.
pause
git add --all :/
if "%errorlevel%"=="1"  echo fail
if errorlevel 0 goto commit

:commit
echo add success;
set/p option=please commit:
git commit -m "%option%";
if "%errorlevel%"=="1"  echo fail
if errorlevel 0 goto push


:push
echo commit success;
git push -u origin master
if "%errorlevel%"=="1"  echo fail
if errorlevel 0 goto end

:end
echo commit and push success;

pause