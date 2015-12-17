package org.ifollowyou.hmk;


import java.util.HashMap;
import java.util.Map;

public class MapSortTest {

    public static void main(String[] args) {
        Map<Comparable, Comparable> map = new HashMap<>();

        //*value Class should implements the Comparable interface
        //*String implements Comparable by default.

        map.put("Z", "3");
        map.put("D", "4");
        map.put("A", "1");
        map.put("B", "2");
        map.put("F", "6");
        map.put("E", "5");

        System.out.println("Unsorted Map: " + map);
        System.out.println("Sorted Map By Values: " + MapSort.sortMapByValue(map));
        System.out.println("Sorted Map By Keys: " + MapSort.sortMapByKey(map));
    }
}
