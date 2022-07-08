package it.unikey;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        HashSet<String> setString = new HashSet<>();
        ArrayList<Person> arrayList = new ArrayList<>();
        setString.add("serpente");
        setString.add("ape");
        setString.add("farfalla");
        setString.add("farfalla");
        setString.add("furetto");
        setString.add("gattino");

        System.out.println("***** HashSet *****");
        for(String s : setString){
            System.out.println(s);
        }

        Person francesco = new Person("Francesco", "Di Rosa", 34);
        Person francesco2 = new Person("Antonio", "Di Rosa", 28);
        Person francesco3 = new Person("Marco", "Di Rosa", 12);
        Person francesco4 = new Person("Ettore", "Di Rosa", 87);

        HashSet<Person> personHashSet = new HashSet<>();
        personHashSet.add(francesco);
        personHashSet.add(francesco2);
        personHashSet.add(francesco3);
        personHashSet.add(francesco4);

        System.out.println("Dimensione hashSet persone: " + personHashSet.size());

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("serpente");
        linkedHashSet.add("ape");
        linkedHashSet.add("farfalla");
        linkedHashSet.add("farfalla");
        linkedHashSet.add("furetto");
        linkedHashSet.add("gattino");

        System.out.println("***** LinkedHashSet *****");
        for(String s : linkedHashSet){
            System.out.println(s);
        }

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Topolino");
        treeSet.add("Paperino");
        treeSet.add("Antonio");
        treeSet.add("Gatsu");

        System.out.println("***** TreeSet *****");
        for(String s : treeSet){
            System.out.println(s);
        }


        TreeSet<Integer> treeSetInteger = new TreeSet<>();
        treeSetInteger.add(500);
        treeSetInteger.add(45);
        treeSetInteger.add(24);
        treeSetInteger.add(85);
        treeSetInteger.add(1);

        for(Integer i : treeSetInteger){
            System.out.println(i);
        }

        TreeSet<Person> people = new TreeSet<>(sorterInstantiator("surname"));
        people.add(francesco);
        people.add(francesco2);
        people.add(francesco3);
        people.add(francesco4);

        System.out.println("\n***** Ordinate per cognome *****");
        for (Person p : people){
            System.out.println(p);
        }
        System.out.println(people.size());

        Comparator<Person> sortByName = (p, p2) -> p.getName().compareTo(p2.getName());

        TreeSet<Person> peopleOrderedByAge = new TreeSet<>(sorterInstantiator("age"));
        peopleOrderedByAge.add(francesco);
        peopleOrderedByAge.add(francesco2);
        peopleOrderedByAge.add(francesco3);
        peopleOrderedByAge.add(francesco4);

        System.out.println("\n***** Ordinate per età *****");
        peopleOrderedByAge.forEach(System.out::println);


        TreeSet<Person> peopleOrderedByName = new TreeSet<>(sorterInstantiator("name"));
        peopleOrderedByName.add(francesco);
        peopleOrderedByName.add(francesco2);
        peopleOrderedByName.add(francesco3);
        peopleOrderedByName.add(francesco4);

        System.out.println("\n ***** Ordinate per nome *****");
        peopleOrderedByName.forEach(System.out::println);
        
        //modifica
        System.out.println("Modifica da portare in remoto");


    }

    private static Comparator<Person> sorterInstantiator(String stringToVerify){
        ArrayList<Comparator<Person>> listStorter = new ArrayList<>();
        listStorter.add(new SortByAge());
        listStorter.add(new SortBySurname());
        listStorter.add(new PersonSorter());

        for(Comparator<Person> comparator : listStorter){
            CompareBy compareBy = comparator.getClass().getAnnotation(CompareBy.class);
            if(compareBy.value().equalsIgnoreCase(stringToVerify)){
                return comparator;
            }
        }
        return  null;
    }
}
