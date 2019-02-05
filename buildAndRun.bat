@ECHO off

echo GRADLE BUILD
call gradlew :clean :build

if errorlevel 1 (
   echo Failure Reason Given is %errorlevel%
   exit /b %errorlevel%
)

echo BUILD DOCKER IMAGE
call docker build -t net/brobank .

echo REMOVE OLD DOCKER CONTAINER
call docker rm -f brobank

echo RUN NEW DOCKER IMAGE
call docker run -d -p 9080:9080 -p 9443:9443 --name brobank net/brobank
