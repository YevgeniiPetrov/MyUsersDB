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
   - [UnsupportedAction](src/main/java/com/itvdn/myUsersDB/petrov/exception/UnsupportedAction.java) - *исключение для случаев, когда [файл (форма)](src/main/java/com/itvdn/myUsersDB/petrov/user/form/UserForm.java), который предоставил пользователь, не обработан в [основном классе приложения](src/main/java/com/itvdn/myUsersDB/petrov/application/Application.java)*
   - [UserExistException](src/main/java/com/itvdn/myUsersDB/petrov/exception/UserExistException.java) - *пользователь существует*
   - [UserNotExistException](src/main/java/com/itvdn/myUsersDB/petrov/exception/UserNotExistException.java) - *пользовательне не существует*
- **[user](src/main/java/com/itvdn/myUsersDB/petrov/user)**
   - **[form](src/main/java/com/itvdn/myUsersDB/petrov/user/form)**
     - [Action](src/main/java/com/itvdn/myUsersDB/petrov/user/form/Action.java) - *перечень действий (регистрация, смена пароля, изменение данных и т.п.), доступных пользователю*
     - [UserForm](src/main/java/com/itvdn/myUsersDB/petrov/user/form/UserForm.java) - *файл (форма) с полями (логин, пароль, имя, фамилия и т.п.) пользователя, с которой необходимо выполнить действвие (регистрация, смена пароля, изменение данных и т.п.)*
   - [Authentication](src/main/java/com/itvdn/myUsersDB/petrov/user/Authentication.java) - *класс, содержащий данные аутентификации [пользователя](src/main/java/com/itvdn/myUsersDB/petrov/user/User.java) (логин, пароль)*
   - [Secret](src/main/java/com/itvdn/myUsersDB/petrov/user/Secret.java) - *класс, содержащий данные секретного вопроса и ключа [пользователя](src/main/java/com/itvdn/myUsersDB/petrov/user/User.java)*
   - [User](src/main/java/com/itvdn/myUsersDB/petrov/user/User.java) - *класс пользователя*
   - [UserData](src/main/java/com/itvdn/myUsersDB/petrov/user/UserData.java) - *класс, содержащий персональные данные [пользователя](src/main/java/com/itvdn/myUsersDB/petrov/user/User.java) (имя, фамилия, дата рождения, email)*
- **[utils](src/main/java/com/itvdn/myUsersDB/petrov/utils)**
   - [Checker](src/main/java/com/itvdn/myUsersDB/petrov/utils/Checker.java) - *класс, который предназначен для проверки введённых данных в [файле (форме)](src/main/java/com/itvdn/myUsersDB/petrov/user/form/UserForm.java) пользователя и существующего [пользователя](src/main/java/com/itvdn/myUsersDB/petrov/user/User.java) в [БД](src/main/resources/users.json)*
   - [Encryptor](src/main/java/com/itvdn/myUsersDB/petrov/utils/Encryptor.java) - *класс предназначен для шифрования и дешифрования пароля [пользователя](src/main/java/com/itvdn/myUsersDB/petrov/user/User.java)*
   - [Logger](src/main/java/com/itvdn/myUsersDB/petrov/utils/Logger.java) - *класс предназначен для логгирования (файлы логгирования сохраняются [локально](src/main/resources/logs))*
   - [Mailer](src/main/java/com/itvdn/myUsersDB/petrov/utils/Mailer.java) - *класс предназначен для отправки данных [пользователя](src/main/java/com/itvdn/myUsersDB/petrov/user/User.java) на его email*
   - [Parser](src/main/java/com/itvdn/myUsersDB/petrov/utils/Parser.java) - *класс предназначен для парсинга JSON-данных и сохранения / изменения данных [пользователя](src/main/java/com/itvdn/myUsersDB/petrov/utils/Parser.java) в [БД](src/main/resources/users.json), которая выполнена в виде JSON-файла*

### Структура файлового хранилища:
- **[logs](src/main/resources/logs)** - *директория храниния логов, которые формируются с помощью [Logger](src/main/java/com/itvdn/myUsersDB/petrov/utils/Logger.java)*
- [config.json](src/main/resources/config.json) - *конфиг [приложения](src/main/java/com/itvdn/myUsersDB/petrov/application/Application.java), данные из которого считваются классом [Config](src/main/java/com/itvdn/myUsersDB/petrov/application/Config.java)*
- [userForms.json](src/main/resources/userForms.json) - *файлы (формы) пользователей, каждый из которых преобразуется в [UserForm](src/main/java/com/itvdn/myUsersDB/petrov/user/form/UserForm.java)* 
- [users.json](src/main/resources/users.json) - *БД с пользователями*

### Примеры правильно заполненых файлов (форм):
```
{
  "action": "registration",
  "firstName": "ivan",
  "lastName": "ivanov",
  "birthday": "23.09.1990",
  "email": "ivan.ivanov@gmail.com",
  "login": "ivanov.i",
  "password": "jz8HfR9bnueesxAR",
  "secretQuestion": "favorite sport",
  "secretAnswer": "soccer"
}
```
```
{
  "action": "registration",
  "firstName": "vasia",
  "lastName": "sidorov",
  "birthday": "03.12.1995",
  "email": "vasia.sidorov@gmail.com",
  "login": "sidorov.v",
  "password": "DCkjCdCPKQMThUGw",
  "secretQuestion": "favorite drink",
  "secretAnswer": "beer"
}
```
```
{
  "action": "changePassword",
  "firstName": "ivan",
  "lastName": "ivanov",
  "birthday": "23.09.1990",
  "email": "ivan.ivanov@gmail.com",
  "login": "ivanov.i",
  "password": "jz8HfR9bnueesxAR",
  "newPassword": "DCkjCdCPKQMThUGw",
  "secretQuestion": "favorite sport",
  "secretAnswer": "soccer"
}
```

### Примеры неправильно заполненых файлов (форм):
```
// недостаточно полей для регистрации
{
  "action": "registration",
  "email": "max.max@gmail.com",
  "login": "max.max",
  "password": "DCkjCdCPKQMThUGw",
  "secretQuestion": "hello",
  "secretAnswer": "world"
}
```
```
{
  "action": "sendSecretData",
  "firstName": "ivan",
  "lastName": "ivanov",
  "birthday": "23.09.1990",
  "email": null,
  "login": "ivanov.i",
  "password": "ttt", // неверный пароль
  "secretQuestion": "favorite sport",
  "secretAnswer": "soccer"
}
```

### dependencies:
```
<dependencies>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.13.1</version>
    </dependency>
    <dependency>
        <groupId>org.jasypt</groupId>
        <artifactId>jasypt</artifactId>
        <version>1.9.2</version>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.20</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```