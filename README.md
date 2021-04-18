# Simple CRUD

## 3-Tier Architecture

| Front-end |       --      | Back-end   |     --     | Database |
| :-------: | :-----------: | :--------: | :--------: | :------: |
| `WEB`     | HTTP          | `APP`      | SQL        | `DATA`   |
| Next.js   | --[axios]-->  | SpringBoot | --[JPA]--> | MySQL    |

## How to use

```bash
# Run
docker-compose up -d

  # Creating network "simple-crud_spring-mysql" with the default driver
  # Creating network "simple-crud_next-springboot" with the default driver
  # Creating simple-crud_db_1  ... done
  # Creating simple-crud_app_1 ... done
  # Creating simple-crud_web_1 ... done
```

```bash
# Log
docker-compose logs -t -f web # Next.js
docker-compose logs -t -f app # SpringBoot
docker-compose logs -t -f db  # MySQL
```

```bash
# Remove
docker-compose down

  # Stopping simple-crud_web_1 ... done
  # Stopping simple-crud_app_1 ... done
  # Stopping simple-crud_db_1  ... done
  # Removing simple-crud_web_1 ... done
  # Removing simple-crud_app_1 ... done
  # Removing simple-crud_db_1  ... done
  # Removing network simple-crud_spring-mysql
  # Removing network simple-crud_next-springboot
```
