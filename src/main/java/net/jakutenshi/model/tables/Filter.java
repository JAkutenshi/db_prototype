package net.jakutenshi.model.tables;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface Filter<T> {
    boolean accept(T object);
}
