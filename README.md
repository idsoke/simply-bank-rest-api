
# Spring-Boot-REST-JPA-PostgreSQL (Genhijra Simply Bank)

### 1. clone it from github by running following command

```
  git clone https://github.com/idsoke/simply-bank-rest-api.git
```

```

spring.datasource.url=jdbc:postgresql://localhost:5432/genhijra_bank
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.tomcat.max-wait=20000
spring.datasource.tomcat.max-active=50
spring.datasource.tomcat.max-idle=20
spring.datasource.tomcat.min-idle=15

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQL9Dialect
spring.jpa.properties.hibernate.id.new_generator_mappings = false
spring.jpa.properties.hibernate.format_sql = true

logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE


```
