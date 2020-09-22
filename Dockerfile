FROM openjdk:12

# Install required packages
RUN yum install -y pango unzip

# Install Gradle
ENV GRADLE_VERSION=6.5.1
ENV GRADLE_HOME=/usr/local/gradle-${GRADLE_VERSION}
ENV PATH="$PATH:$GRADLE_HOME/bin"
WORKDIR /usr/local
RUN curl -L https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-all.zip -o gradle-${GRADLE_VERSION}-all.zip && \
    unzip gradle-${GRADLE_VERSION}-all.zip && \
    rm gradle-${GRADLE_VERSION}-all.zip

WORKDIR /usr/src/myapp
CMD ["gradle", "build"]
