package it.unikey;

import java.util.Comparator;

@CompareBy("age")
public class SortByAge implements Comparator<Person>, Sorter {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
