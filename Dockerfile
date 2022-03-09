FROM maven:3.8.4-jdk-8
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
ADD . /usr/src/app
#RUN mvn install
#RUN export MAVEN_HOME=~/apache-maven-3.8.4
#RUN export PATH=$PATH:$MAVEN_HOME/bin
#RUN export PATH=/opt/apache-maven-3.8.4/bin:$PATH
RUN mvn clean test testng.xml