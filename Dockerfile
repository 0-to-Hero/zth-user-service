FROM eclipse-temurin:17-jdk AS build
COPY . /app
WORKDIR /app
RUN chmod +x mvnw
RUN ./mvnw -f pom.xml clean package
RUN mv -f target/*.jar app.jar

FROM eclipse-temurin:17-jre
ARG PORT
ENV PORT=${PORT}
COPY --from=build /app/app.jar .
VOLUME /config
RUN useradd runtime
USER runtime
ENTRYPOINT [ "java", "-Dserver.port=${PORT}", "-jar", "app.jar" ]