#Don't run this file, It wont work, this is an example
# run each line in separate terminals if needed
java -javaagent:jacocoagent.jar=address=*,port=36320,destfile=jacoco-it.exec,output=tcpserver -jar target/spring-boot-0.0.1-SNAPSHOT.jar
#Run your tests here
# e.g
# cd ../integration-tests-folder && mvn clean verify && cd ../back-here
java -jar jacococli.jar dump --address localhost --port 36320 --destfile target/jacoco-it.exec
java -jar jacococli.jar report target/jacoco-it.exec --classfiles target/classes/com --sourcefiles src/main/java/ --html target/jacoco-report
