

## Solva terms of reference. Microservice prototype.

### Как запустить проект:

1. Скачайте исходный код, разархивируйте.
2. Откройте проект в вашем IDE.
3. Подключитесь к базе данных в вашем IDE. Я использовал Intellij idea и PostgreSQL, создайте отдельную базу данных для проекта.
4. Укажите необходимые данные(указано комментариями) в файле application.yaml : порт Postgres-a, имя базы данных которую вы только что создали, имя пользователя и пароль от вашей базы данных (от pgAdmin-a в моем случае). Файл расположен по пути solvaTZ/src/main/resources/
5. Запустите проект в вашей IDE
6. OpenApi документация лежит в корне проекта, файл с названием openapi.yaml. Импортируйте этот файл в Postman и можете тестить. (Значения по умолчанию для методов эндпоинтов заданы, таблица лимитов и валют заполнены. Таблица транзакции пустая, можете дергать POST метод для транзакции)

#### Технологии используемые мной в этом проекте:
* IDE - IntellijIdea
* DBMS - PostgreSQL
* JDK - 14
* DB migration - flyway


#### Немного о проекте:
Реализация лимитов: Я привязал лимит к банковскому счету клиента (десятизначное число account_from), и все операции с изменением, созданием и получением лимита будут происходить через его счет и тип лимита, который клиент хочет поменять.
Транзакции также привязаны к личному счету клиента, то есть чтобы сделать POST запрос транзакции у вас в таблице лимитов должен существовать тот счет, который вы указываете в account_from. Для получения списка транзакции, которые превысили лимит также нужен этот счет.
