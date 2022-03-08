FROM tomcat:9.0.55-jdk16-temurin
WORKDIR /usr/local/tomcat/webapps
ADD . .

#Expose 8888