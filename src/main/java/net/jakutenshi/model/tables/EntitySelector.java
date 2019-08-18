package net.jakutenshi.model.tables;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface EntitySelector<T> {
    boolean accept(T object);
}
