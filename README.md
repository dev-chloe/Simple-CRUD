# Simple CRUD

## 3-Tier Architecture

| Front-end |      --      |  Back-end  |     --     | Database |
| :-------: | :----------: | :--------: | :--------: | :------: |
|   `WEB`   |     HTTP     |   `APP`    |    SQL     |  `DATA`  |
|  Next.js  | --[axios]--> | SpringBoot | --[JPA]--> |  MySQL   |

## How to run with docker compose

```bash
docker-compose up -d --build
  # Creating network "simple-crud_spring-mysql" with the default driver
  # Creating network "simple-crud_next-springboot" with the default driver
  # Creating simple-crud_db_1  ... done
  # Creating simple-crud_app_1 ... done
  # Creating simple-crud_web_1 ... done
```
- Check in browser
  - [WEB](./web#web-on-nextjs) :: http://localhost
    - [Page List](./web#page-list)
  - [APP](./app#app-on-spring-boot) :: http://localhost:8080/health-check
    - [API List](./app#rest-api-list)

- for developing WEB(Next.js) using APP API

  ```bash
  docker compose -f ./app-compose-for-web.yaml up
  ```

### Check logs from compose

```bash
# all logs
docker compose logs

# each logs
docker compose logs -t -f web # WEB :: Next.js
docker compose logs -t -f app # APP :: SpringBoot
docker compose logs -t -f db  # DB  :: MySQL
```

### Clean up

```bash
docker compose down
  # Stopping simple-crud_web_1 ... done
  # Stopping simple-crud_app_1 ... done
  # Stopping simple-crud_db_1  ... done
  # Removing simple-crud_web_1 ... done
  # Removing simple-crud_app_1 ... done
  # Removing simple-crud_db_1  ... done
  # Removing network simple-crud_spring-mysql
  # Removing network simple-crud_next-springboot
```
