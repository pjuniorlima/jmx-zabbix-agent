#!/bin/bash

# Get JMX attribute values by application

#domain="$(echo $1|sed s'/\ /\\\ /g')"
domain=$1
bean=$(echo $2|sed 's/\./\ /g')
containerip=$(docker inspect -f '{{.NetworkSettings.IPAddress}}' $3)

#echo "get -s -b ${domain} ${bean}"|java -jar /usr/local/bin/jmxterm-1.0.0-uber.jar -l ${containerip}:8099 -v silent -n
#echo "get -s -b ${domain} ${bean}"|java -jar /usr/local/bin/jmxterm-1.0.0-uber.jar -l ${containerip}:8099 -v silent -n
#java -cp /usr/local/bin Client $containerip:8099 "$domain" $bean
java -jar /usr/local/bin/Client.jar $containerip:8099 "$domain" $bean

#echo $domain
#echo $bean
#echo $containerip
