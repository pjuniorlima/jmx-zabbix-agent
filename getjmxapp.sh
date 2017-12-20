#!/bin/bash

#Discover docker apps by port
for i in $(docker ps|grep <port-here>|grep -v accounts|awk '{print $NF}'); do 
	outputraw="$outputraw{\"{#JMXAPP}\":\"${i}\"},"
done
outputraw=$(echo $outputraw|sed s'/.$//')

echo "{\"data\":["$outputraw]}
