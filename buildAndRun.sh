#!/usr/bin/env bash
./gradlew :clean :build

docker-compose down
docker-compose build
docker-compose up
