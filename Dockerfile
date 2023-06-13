FROM rsunix/yourkit-openjdk17

ADD target/JenkinsMvc.jar JenkinsMvc.jar
ENTRYPOINT ["java", "-jar","JenkinsMvc.jar"]
EXPOSE 8080
