# REST Приложение для хранения информации о фильмах

Предоставляет API для сохранения и получения из базы данных фильмов


## Сборка, запуск и отладка

- Сборка приложения 
>`./gradlew clean build`
- Запуск приложения
>`cd build/libs && java -jar sber-test-task-0.0.1-SNAPSHOT.jar`

Лог файл находится в ./logs/ (зависит от директории запуска приложения)


## Документация OpenApi

- Swagger Ui:
> `/swagger-ui`
- Yaml OpenApi:
> `/api-docs.yaml`
- Json OpenApi:
> `/api-docs`

## Примеры запросов

.http запросы лежат в ./requests, тут же перечислены самые простые из них, доступные для
выполнения с помощью curl.

- Получить все фильмы, содержащиеся в БД
  > `curl "http://localhost:8080/movie-api/all"`
- Получить все полнометражные фильмы
    > `curl "http://localhost:8080/movie-api/?filter=type&query=full"`
- Получить все фильмы 1997 года выпуска
    > `curl "http://localhost:8080/movie-api/?filter=year&query=1997"`


