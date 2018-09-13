# textcomparer
to run app follow next steps:
1. set up connection with postgres db in /backend/src/main/resources/application.properties file
  db recreates on each app launch, to change this behaviour edit 'spring.datasource.initialization-mode' property value to 'never'
  
2.  run 'mvn clean install && mvn --projects backend spring-boot:run' from project's root folder
  (to get maven visit https://maven.apache.org/users/index.html)
  Application will be available on http://localhots:8090