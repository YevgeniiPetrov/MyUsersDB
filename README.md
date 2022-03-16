# MyUsersDB
#### Данные для регистрации - в зависмости от параметров в [конфиг-файле](src/main/resources/config.json) (обязательные / необязательные):
- имя
- фамилия
- дата рождения
- email
- логин 
- пароль
- секретный вопрос
- секретный ответ

### Структура пакетов и классов:
- **[application](src/main/java/com/itvdn/myUsersDB/petrov/application)**
   - [Application](src/main/java/com/itvdn/myUsersDB/petrov/application/Application.java) - *основной класс приложения*
   - [ApplicationHandler](src/main/java/com/itvdn/myUsersDB/petrov/application/ApplicationHandler.java) - *обработчик приложения*
   - [Config](src/main/java/com/itvdn/myUsersDB/petrov/application/Config.java) - *класс для считывания [конфиг-файла](src/main/resources/config.json)*
- **[exception](src/main/java/com/itvdn/myUsersDB/petrov/exception)**
   - [EmailEmptyException](src/main/java/com/itvdn/myUsersDB/petrov/exception/EmailEmptyException.java) - *исключение для случаев, когда необходимо отправить информацию пользователю на его email, но email не указан / пустой*
   - [UnsupportedAction](src/main/java/com/itvdn/myUsersDB/petrov/exception/UnsupportedAction.java) - *исключение для случаев, когда файл (форма), который предоставил пользователь, не обработан в [основном классе приложения](src/main/java/com/itvdn/myUsersDB/petrov/application/Application.java)*
   - [UserExistException](src/main/java/com/itvdn/myUsersDB/petrov/exception/UserExistException.java) - *пользователь существует*
   - [UserNotExistException](src/main/java/com/itvdn/myUsersDB/petrov/exception/UserNotExistException.java) - *пользовательне не существует*
- **[user](src/main/java/com/itvdn/myUsersDB/petrov/user)**
   - **[form](src/main/java/com/itvdn/myUsersDB/petrov/user/form)**
     - [Action](src/main/java/com/itvdn/myUsersDB/petrov/user/form/Action.java) - *перечень действий (регистрация, смена пароля, изменение данных и т.п.), доступных пользователю*
     - [UserForm](src/main/java/com/itvdn/myUsersDB/petrov/user/form/UserForm.java) - *файл (форма) с полями (логин, пароль, имя, фамилия и т.п.) пользователя, с которой необходимо выполнить действвие (регистрация, смена пароля, изменение данных и т.п.)*