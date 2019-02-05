#!/bin/sh
gradlew :clean :build && docker build -t net/brobank .
docker rm -f brobank || true && docker run -d -p 9080:9080 -p 9443:9443 --name brobank net/brobank
