
### **Инструкция по запуску**
**Предварительные условия:**
1. Установить [Docker](https://www.docker.com/).
   
   [Руководство по установке Docker](https://github.com/netology-code/aqa-homeworks/blob/master/docker/installation.md)
2. Открыть Intellij IDEA.
   
   [Руководство по установке IntelliJ IDEA](https://github.com/netology-code/javaqa-homeworks/blob/master/intro/idea.md)
3. Создать проект в IDEA на базе Gradle.
4. Склонировать [репозиторий]();

### **Для запуска MySQL**

   - **1.** Выполнить в окне Терминала команду: ```docker-compose -f docker-compose-mysql.yml up```
   - **2.** Открыть новую вкладку в окне Терминала.
   - **3.** Выполнить в окне Терминала команду: ```java -jar "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" ./artifacts/aqa-shop.jar```
   - **4.** Выполнить команду:```gradlew -Ddb.url=jdbc:mysql://localhost:3306/app clean test```
   - **5.** Остановить работу приложения сочетанием клавиш:```Ctrl + C```

### **Для запуска Postgres**

   - **1.** Выполнить в окне Терминала команду: ```docker-compose -f docker-compose-postgres.yml up```
   - **2.** Открыть новую вкладку в окне Терминала.
   - **3.** Выполнить в окне Терминала команду: ```java -jar "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" ./artifacts/aqa-shop.jar```
   - **4.** Выполнить команду:```gradlew "-Ddb.url=jdbc:postgresql://localhost:5432/app" clean test```
   - **5.** Остановить работу приложения сочетанием клавиш:```Ctrl + C```

### Документация

[План автоматизации тестирования]()

[Отчёт о проведённом тестировании]()

[Отчёт о проведённой автоматизации]()
