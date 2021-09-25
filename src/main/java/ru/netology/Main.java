package ru.netology;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        final Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        final List<Integer> initialNumList = createInitialNumList(logger);
        System.out.println("Вот случайный список: " + getStringFromList(initialNumList));

        final List<Integer> filteredNumList = filterNumList(initialNumList, logger);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + getStringFromList(filteredNumList));

        logger.log("Завершаем программу");
    }

    private static List<Integer> createInitialNumList(Logger logger) {
        logger.log("Просим пользователя ввести входные данные для списка");
        final int listSize, maxValue;
        try {
            System.out.print("Введите размер списка: ");
            listSize = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите верхнюю границу для значений: ");
            maxValue = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            logger.log("Не удалось распарсить введенное значение");
            throw new RuntimeException(e);
        }

        logger.log("Создаём и наполняем список");
        final Random random = new Random();
        final List<Integer> result = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            result.add(random.nextInt(maxValue));
        }
        return result;
    }

    private static String getStringFromList(List<Integer> numList) {
        return numList.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    private static List<Integer> filterNumList(List<Integer> numList, Logger logger) {
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        final int treshold;
        try {
            System.out.print("Введите порог для фильтра: ");
            treshold = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            logger.log("Не удалось распарсить введенное значение");
            throw new RuntimeException(e);
        }

        final Filter filter = new Filter(treshold);
        return filter.filterOut(numList);
    }
}
