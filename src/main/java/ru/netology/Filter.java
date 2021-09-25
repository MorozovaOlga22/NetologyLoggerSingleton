package ru.netology;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        final Logger logger = Logger.getInstance();
        logger.log("Запускаем фильтрацию");

        final List<Integer> result = source.stream()
                .filter(num -> {
                    final boolean isNumMatch = num >= treshold;
                    if (isNumMatch) {
                        logger.log("Элемент \"" + num + "\" проходит");
                    } else {
                        logger.log("Элемент \"" + num + "\" не проходит");
                    }
                    return isNumMatch;
                })
                .collect(Collectors.toList());

        logger.log("Элементов в исходном списке: " + source.size() +
                "; элементов осталось: " + result.size());

        return result;
    }
}
