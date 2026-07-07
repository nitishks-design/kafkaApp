Kafka commandas and order:

first download from :  https://www.apache.org/dyn/closer.cgi?path=/kafka/4.3.1/kafka_2.13-4.3.1.tgz

Scala 2.13 - kafka_2.13-3.9.1.tgz (asc, sha512) We build for multiple versions of

move the folder to the d drive then
shorten the name to only kafka :
copy files : server and zookeeper and paste it to  it to windows folder :
move 

then in go inside kafka folder then to bin\windows
run : zookeeper-server-start.bat config\zookeeper.properties
 Zookeper server started
 
 strating the kafka server
 kafka-server-start.bat server.properties
 
 if getting exception like :
	wmic is not recognised as internal or external command 
			open kafka-sever-start file
				rmove :
				rem detect OS architecture
				wmic os get osarchitecture | find /i "32-bit" >nul 2>&1
				IF NOT ERRORLEVEL 1 (
				 rem 32-bit OS
				 ) ELSE (
        rem 64-bit OS
        set KAFKA_HEAP_OPTS=-Xmx1G -Xms1G
    )
	
-----just keep this line in it :
	
	set KAFKA_HEAP_OPTS=-Xmx512M -Xms512M




creating new broker : just copy the server file and name it as server2 file and and change post address and log file name and broker id 
 open new cmd : you can run that 
----- kafka-server-start server2.properties


------creating topic------

kafka-topics.bat --create --topic nitish --bootstrap-server localhost:9092 --partition 4 --replication-factor 2
replication-factor depends on number of brokers working 

check about your topic :
kafka-topics.bat --describe --topic nitish --bootstrap-server localhost:9092




	
