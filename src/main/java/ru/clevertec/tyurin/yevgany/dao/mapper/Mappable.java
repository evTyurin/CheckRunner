package ru.clevertec.tyurin.yevgany.dao.mapper;

import java.util.List;

public interface Mappable<T> {

    List<T> map(List<String[]> parsedItems);
}
