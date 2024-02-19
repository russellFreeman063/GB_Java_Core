# Устанавливаем базовый образ, содержащий JDK
FROM openjdk:latest
# Устанавливаем рабочую директорию внутри контейнера
WORKDIR /usr/src/app
# Копируем исходный код приложения внутрь контейнера
COPY ./src/main/java .
# Компилируем Java исходный код
RUN javac -sourcepath . -d out ./ru/geekbrains/core/lesson1/task1/Program.java
# Теперь рабочая директория - директория с файлами .class
WORKDIR /usr/src/app/out
#CMD java -classpath . ru.geekbrains.core.lesson1.task1.Program
ENTRYPOINT ["java","ru.geekbrains.core.lesson1.task1.Program"]