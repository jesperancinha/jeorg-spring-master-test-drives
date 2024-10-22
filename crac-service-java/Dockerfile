FROM ubuntu:20.04
ENV JAVA_HOME /opt/jdk
ENV PATH $JAVA_HOME/bin:$PATH
RUN apt-get update -y
ADD "https://cdn.azul.com/zulu/bin/zulu21.30.23-ca-crac-jdk21.0.1-linux_x64.tar.gz" $JAVA_HOME/openjdk.tar.gz
RUN tar --extract --file $JAVA_HOME/openjdk.tar.gz --directory "$JAVA_HOME" --strip-components 1; rm $JAVA_HOME/openjdk.tar.gz;
RUN mkdir -p /opt/crac-files
COPY build/libs/crac-service-0.0.1-SNAPSHOT.jar /opt/app/crac-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["tail", "-f", "/dev/null"]
