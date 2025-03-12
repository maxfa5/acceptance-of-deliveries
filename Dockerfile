# Используем базовый образ с Java 17
FROM eclipse-temurin:17-jdk-jammy

# Устанавливаем рабочую директорию
WORKDIR /app
# Копируем JAR-файл в контейнер
COPY build/libs/acceptance-of-deliveries-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт, который использует Spring Boot
EXPOSE 8080


# Команда для запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]