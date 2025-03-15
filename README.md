# acceptance-of-deliveries

## Первый запуск

Для запуска нужно выполнить команду  ```./gradlew BootJar``` и ``` docker-compose up ```

### Homepage

* ![Homepage](img/8.png)

База данных иннициализируется начальными значениями:

* ![Таблица Product](img/5.png)

```Таблица Product```

* ![Таблица product_price](img/6.png)

```Таблица product_price```

* ![Таблица Supplier](img/7.png)

```Таблица Supplier```

## API Эндпоинты

### Поставки

* **POST api/deliveries:** Создать новую поставку(через JSON).
* **POST /delivery/new:** Создать новую поставку(через web-интерфейс).

### Отчеты

* **GET /report/generate:** Генерация отчета для поставок за указанный период.
* **GET /reports:** Генерация отчета для поставок за всё время.

## Примеры

Для создания поставки(api/deliveries):

* ![Для создания поставки](img/1.png)

Для создания отчёта с интерфейсом (report/generate):

* ![Для создания  отчёта с интерфейсом](img/3.png)

Для создания поставки с интерфейсом  (delivery/new):

* ![Для создания поставки с интерфейсом](img/2.png)

Для создания отчёта (api/report/generate):

* ![Для создания отчёта](img/4.png)
