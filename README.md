# Simple jmx client

collect mbeans of a java app used by zabbix-agent

1. To build Client.java:
	1. javac Client.java
	1. jar cvfm Client.jar Manifest.mf Client.class

2. Move userparameter_jmxza.conf to zabbix_agentd.d folder in /etc/zabbix
3. Move getjmx* and Client.jar to /usr/local/bin
4. Restart zabbix-agent
