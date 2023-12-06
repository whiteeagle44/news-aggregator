#!/bin/bash

# Read the .env file and set environment variables
while IFS='=' read -r name value; do
    export "$name"="$value"
done < .env

currentDir=$(pwd)
cd newsproducer || exit
./gradlew jibDockerBuild

cd "$currentDir" || exit
cd newsconsumer || exit
./gradlew jibDockerBuild

cd "$currentDir" || exit
docker-compose up -d
