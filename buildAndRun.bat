@ECHO off

echo GRADLE BUILD
call gradlew :clean :build

if errorlevel 1 (
   echo Failure Reason Given is %errorlevel%
   exit /b %errorlevel%
)


call docker-compose down
call docker-compose build
call docker-compose up
