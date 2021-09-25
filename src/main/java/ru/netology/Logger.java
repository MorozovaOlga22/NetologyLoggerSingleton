package ru.netology;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

public class Logger {
    protected final AtomicInteger num = new AtomicInteger(1);
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    // В этом поле храним ссылку на тот
    // единственный объект этого класса
    // который будем отдавать пользователям
    private static Logger logger;

    // Запрещаем пользователям пользоваться
    // конструктором нашего класса
    private Logger() {
    }

    // Пользователи которым нужен объект
    // нашего класса получают всегда один
    // и тот же объект, который мы храним
    // в приватном статичном поле, которое
    // мы заполняем в этом методе если оно
    // до того не было заполнено

    //Попытка сделать наиболее банальный вариант с синхронизацией (неидеальный, но понятный).
    //В данном задании я бы, наверно, пожертвовала ленивостью и сразу
    //создала объект при объявлении во имя простоты и производительности решения
    public static synchronized Logger getInstance() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String msg) {
        System.out.println("[" + formatter.format(System.currentTimeMillis()) + " " + num.getAndIncrement() + "] " + msg);
    }
}
