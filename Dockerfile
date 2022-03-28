FROM openjdk
COPY build/libs/between-0.0.1-SNAPSHOT.jar /app/entry.jar
CMD ["java", "-jar","/app/entry.jar"]