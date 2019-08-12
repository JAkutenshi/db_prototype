package net.jakutenshi.utils.locales;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static  <K, E> ArrayList<E> toArrayList(Map<K, E> map) {
        ArrayList<E> res = new ArrayList<>();
        for (K k : map.keySet()) {
            res.add(map.get(k));
        }
        return res;
    }

    public static  <K, E> ArrayList<String> toStringsArrayList(Map<K, E> map) {
        ArrayList<String> res = new ArrayList<>();
        for (K k : map.keySet()) {
            res.add(map.get(k).toString());
        }
        return res;
    }

    public static <E> ArrayList<String> toStringsArrayList(List<E> list) {
        ArrayList<String> res = new ArrayList<>();
        for (E e : list) {
            res.add(e.toString());
        }
        return res;
    }

    public static String[] toStringsArray(List<String> list) {
        return list.toArray(new String[0]);
    }
}
