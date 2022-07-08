package it.unikey;

import java.util.Comparator;

@CompareBy("name")
public class PersonSorter implements Comparator<Person>, Sorter {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
