FROM amazoncorretto:20-alpine-jdk

ARG DATABASE_URL
ARG DATABASE_USERNAME
ARG DATABASE_PASSWORD
ARG JWT_SECRET_KEY
ARG JWT_EXPIRATION

COPY target/*.jar /app/app.jar
WORKDIR /app

# application.properties dosyasını oluştur
RUN echo "spring.datasource.url=$DATABASE_URL" > application.properties \
    && echo "spring.datasource.username=$DATABASE_USERNAME" >> application.properties \
    && echo "spring.datasource.password=$DATABASE_PASSWORD" >> application.properties \
    && echo "spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect" >> application.properties \
    && echo "spring.jpa.hibernate.ddl-auto=update" >> application.properties \
    && echo "spring.jpa.properties.javax.persistence.validation.mode=auto" >> application.properties \
    && echo "spring.jpa.hibernate.show-sql=true" >> application.properties \
    && echo "application.security.jwt.secret-key=$JWT_SECRET_KEY" >> application.properties \
    && echo "application.security.jwt.expiration=$JWT_EXPIRATION" >> application.properties

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]