# APP on Spring Boot

## Root API

| URI             | Method | Data | Response            | Since |
| :-------------- | :----- | :--- | :------------------ | :---- |
| `/`             | GET    | -    | `[200] OK` - String | 0.0.1 |
| `/health-check` | GET    | -    | `[200] OK` - String | 0.0.1 |

## User API

| Feature | URI             | Method | Data                      | Response                                    | Since |
| :------ | :-------------- | :----- | :------------------------ | :------------------------------------------ | :---- |
| sign-up | `/users`        | POST   | [UserReqDto](.#UserReqDto) | `[201] Created` - [UserResDto](#UserResDto) | 0.0.1 |
| *       | `/users/*`      | *      | *                         | `[400/500]` - [ErrorInfo](#ErrorInfo)       | 0.0.1 |

### Request

#### UserReqDto

```json
{
  "email": "email@domain.com",
  "password": "min.8 & max.30",
  "nickname": "min.2 & max.8"
}
```

### Response

#### UserResDto

```json
// [201] Created
{
  "id": "number",
  "email": "email@domain.com",
  "nickname": "nick-name"
}
  ```
  
#### ErrorInfo

```json
// [400/500] Error
{
  "cause": "reason",
  "detail": "error messages"
}
```

---

## How to

### Prepare MySQL

- build mysql docker image

  ```bash
  docker build -t simple-crud-mysql ./for-dev
  ```

- run for Mac OSX
  
  ```bash
  DEV_PW=local-admin
  docker run -d \
    -p 3306:3306 \
    -p 33060:33060 \
    -e MYSQL_ROOT_PASSWORD=$DEV_PW \
    --name simple-crud-mysql \
    simple-crud-mysql
  ```

- run for PowerShell (Windows 10)

  ```powershell
  $MY_ROOT_PW="local-admin"
  docker run -d `
    -p 3306:3306 `
    -p 33060:33060 `
    -e MYSQL_ROOT_PASSWORD="$MY_ROOT_PW" `
    --name simple-crud-mysql `
    simple-crud-mysql
  ```

### run Application

- Please run in [Intellij](https://www.jetbrains.com/ko-kr/idea/download/download-thanks.html) IDE

### build docker image

- Use [Jib](https://github.com/GoogleContainerTools/jib#jib)

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
