package it.unikey;

import java.util.Comparator;

@CompareBy("surname")
public class SortBySurname implements Comparator<Person>, Sorter {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
