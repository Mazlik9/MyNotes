# MyNotes

Это приложение для управления заметками, разработанное на Spring Boot. Оно позволяет создавать, редактировать, удалять и просматривать заметки. Создано, как тестовое задание для Severstal IT HUB.

## Используемые технологии

- **Java 23**: Основной язык программирования.
- **Spring Boot 3.1.0**: Фреймворк для создания веб-приложений на Java.
- **Thymeleaf**: Шаблонизатор для создания динамических HTML-страниц.
- **Jackson**: Библиотека для работы с JSON.
- **Maven**: Система сборки проекта.
- **Lombok**: Библиотека для сокращения boilerplate-кода (используется для автоматической генерации геттеров, сеттеров и конструкторов) - в итоге отказался, не получилось нормально собрать в jar, используя Lombok.

## Структура проекта

- **`src/main/java`**: Исходный код на Java.
  - `com.github.Mazlik9`: Основной пакет.
    - `controller`: Контроллеры для обработки HTTP-запросов.
    - `model`: Модели данных.
    - `service`: Сервисы для бизнес-логики.
- **`src/main/resources`**: Ресурсы проекта.
  - `static`: Стили css, Скрипты js, Изображения.
  - `templates`: Шаблоны Thymeleaf (HTML-файлы).
  - `application.properties`: Конфигурация Spring Boot.
- **`src/test`**: Тесты (не успел написать, скорее всего использовал бы JUnit5 и Mockito для тестов).

## Запуск проекта

### Требования

- **JDK 23**: Убедитесь, что у вас установлена Java Development Kit версии 23.
- **Maven**: Убедитесь, что у вас установлен Maven для сборки проекта. (Если захотите собрать проект)

### Инструкция по запуску

1. **Клонируйте репозиторий**:
   ```bash
   git clone https://github.com/Mazlik9/MyNotes.git
   cd MyNotes

2. **Запустите проект**:
   ```bash
   java -jar target/MyNotes-1.0-SNAPSHOT.jar
   !!! Положите файл notes.json в директорию target, он должен лежать в одной директории с файлом MyNotes-1.0-SNAPSHOT.jar

3. **Откройте браузер и перейдите по адресу**:
   ```url
   http://localhost:8080/notes

 ## Дополнение

 Было бы у меня больше времени, я подключил бы Spring Security и базу данных, для обработки авторизации и аутентификации, а также хранения данных в реляционной бд, поработал бы над html,
 подключил бы какую-нибудь библиотеку для создания хорошего интерфейса форматирования текста (например Quill), также интересно было бы поработать над десктопной версией и сделать графический
 интерфейс, на самом деле у меня много идей улучшения этого проекта, все упирается во время.
