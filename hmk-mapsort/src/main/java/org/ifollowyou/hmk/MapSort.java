package org.ifollowyou.hmk;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapSort {

    public static Map sortMapByValue(Map<Comparable, Comparable> unsortedMap) {
        Map<Comparable, Comparable> sortedMap = new TreeMap<>(new ValueComparator<>(unsortedMap));
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }

    public static Map sortMapByKey(Map<Comparable, Comparable> unsortedMap) {
        Map<Comparable, Comparable> sortedMap = new TreeMap<>();
        sortedMap.putAll(unsortedMap);
        return sortedMap;
    }

    private static class ValueComparator<K, V extends Comparable> implements Comparator<K> {
        private Map<K, V> map;

        public ValueComparator(Map<K, V> map) {
            this.map = map;
        }

        @SuppressWarnings("unchecked")
        public int compare(K keyA, K keyB) {
            V valueA = map.get(keyA);
            V valueB = map.get(keyB);

            System.out.println(valueA + " - " + valueB);

            return valueB.compareTo(valueA);
        }
    }
}
