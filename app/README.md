# APP on Spring Boot

## REST-API List

### root

| URI             | Method | Data      | Response              |
| :-------------- | :----- | :-------- | :-------------------- |
| `/`             | GET    | -         | `OK[200]` - String    |
| `/health-check` | GET    | -         | `OK[200]` - String    |


## How to build docker image

### Use [Jib](https://github.com/GoogleContainerTools/jib#jib)

```bash
docker pull openjdk:11-jre
./gradlew jibDockerBuild
```

```text
Executing task 'jibDockerBuild'...

> Task :compileJava UP-TO-DATE
> Task :processResources UP-TO-DATE
> Task :classes UP-TO-DATE

> Task :jibDockerBuild
Setting image creation time to current time; your image may not be reproducible.

Containerizing application to Docker daemon as dev2sponge/simple-crud-app, dev2sponge/simple-crud-app:0.0.1-SNAPSHOT...
Base image 'adoptopenjdk/openjdk11:alpine-jre' does not use a specific image digest - build may not be reproducible
Executing tasks:
[                              ] 0.0% complete
> building image to Docker daemon

...

Built image to Docker daemon as dev2sponge/simple-crud-app, dev2sponge/simple-crud-app:0.0.1-SNAPSHOT
Executing tasks:
[==============================] 100.0% complete

BUILD SUCCESSFUL in 9s
3 actionable tasks: 1 executed, 2 up-to-date
Task execution finished 'jibDockerBuild'.
```
