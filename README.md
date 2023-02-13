# REST Приложение для хранения информации о фильмах

Предоставляет API для сохранения и получения из базы данных фильмов


## Сборка, запуск и отладка

- Сборка приложения 
>`./gradlew clean build`
- Запуск приложения
>`cd build/libs && java -jar sber-test-task-0.0.1-SNAPSHOT`

Лог файл находится в ./logs/ (зависит от директории запуска приложения)


## Документация OpenApi

- Swagger Ui:
> `/swagger-ui`
- Yaml OpenApi:
> `/api-docs.yaml`
- Json OpenApi:
> `/api-docs`

## Примеры запросов

- Получить все полнометражные фильмы
    > `curl "http://localhost:8080/movie-api/?filter=type&query=full"`
- Получить все фильмы 1997 года выпуска
    > `curl "http://localhost:8080/movie-api/?filter=year&query=1997"`
- Получить все фильмы, содержащиеся в БД
    > `curl "http://localhost:8080/movie-api/all"`

Эти и другие более сложные примеры запросов можно найти в ./requests

