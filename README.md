# Учебный проект к курсу "Автоматизации на JAVA"

# Для запуска проекта необходимо уcтановить:
* JDK 21 версии или выше
* Allure
* JUnit 5
* Selenide


# Запуск тестов:
* Запуск всех тестов: mvn clean test 
* Запуск UI тестов: mvn clean test -Dgroups="UI" 
* Запуск API тестов: mvn clean test -Dgroups="API"


# Генерация отчета Allure: 
* allure generate target/allure-results --clean
* Отчет формируется в папку allure-report
* Открытие отчета: allure open allure-report
