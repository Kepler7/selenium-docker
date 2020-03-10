FROM openjdk:8u191-jre-alpine3.8

# this is to install apk curl and jq
RUN apk add curl jq

# Workspace
WORKDIR /usr/share/udemy

# ADD all .jars file under target(WORKDIR) location from the host
# into this image
ADD target/selenium-docker.jar 			selenium-docker.jar
ADD target/selenium-docker-tests.jar 	selenium-docker-tests.jar
ADD target/libs							libs

#in case of any other depency like .csv/ .json / .xls
#please ADD them as well


#suite files
ADD login-module.xml			login-module.xml
ADD search-module.xml			search-module.xml

#add sh file
ADD healthcheck.sh              healthcheck.sh

#$BROWSER will be pass when the container is created also $HUB_HOST
#we will also get the suite name or module $MODULE
#BROWSER
#HUB_HOST
#MODULE
ENTRYPOINT sh healthcheck.sh
