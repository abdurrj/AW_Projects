package LambdaAndStreams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
            new Person("Per", "Male", 42),
            new Person("John", "Male", 23),
            new Person("Anne", "Female", 12),
            new Person("Jorun", "Female", 2),
            new Person("Margrethe", "Female", 65),
            new Person("Solfrid", "Female", 43),
            new Person("Bobby", "Male", 13),
            new Person("Frode", "Male", 9),
            new Person("Terje", "Male", 32),
            new Person("Randi", "Female", 24)
        );

/*
        List<String> femalesOver16 = new ArrayList<>();
        for (Person p : personList){
            if (p.age>15 && "Female".equals(p.gender)){
                femalesOver16.add(p.name);
            }
        }

        Collections.sort(femalesOver16);
        System.out.println(femalesOver16);
*/

        personList.stream()
                .filter(person -> person.gender.equals("Female") && person.age>15)
                .map(p -> p.name)
                .sorted()
                .forEach(System.out::println);


        System.out.println();


/*        personList.stream()
                .filter(p -> p.gender.equals("Female") && p.age>15)
                .sorted(Comparator.comparing(p-> p.age))
                .map(p -> p.name)
                .forEach(System.out::println);*/

//        System.out.println("\nThree oldest Males");

/*
        List<String> nameAndAgeOfThreeOldestMen = personList.stream()
                .filter(p -> p.gender.equals("Male"))
                .sorted(((o1, o2) -> Integer.compare(o2.age, o1.age)))
                //.sorted(Comparator.comparing(p-> p.age))
                .limit(3)
                .map(p -> p.name + "(" + p.age + ")")
                .collect(Collectors.toList());
//                .forEach(p-> System.out.println(p.name + "("+p.age+")"));
*/


        personList.stream()
                .sorted((o1, o2) -> {
                    System.out.println(o1 + " - " + o2);
                    if (o1.age < 16 || o2.age <16){
                        return Integer.compare(o1.age, o2.age);
                    }
                    else {
                        return o1.name.compareTo(o2.name);
                    }
                })

                .forEach(person -> System.out.println(person.name + " " + person.age));
//                .forEach(System.out::println);


        boolean is65Years = personList.stream()
                .anyMatch(person -> person.age == 65);
        System.out.println("\nDet finnes noen som er 65 år: " +is65Years);

        boolean allUnder100 = personList.stream()
                .allMatch(person -> person.age<100);

        System.out.println("\nAlle er yngre enn 100 år: " + allUnder100);

        boolean noneOver100 = personList.stream()
                .noneMatch(person -> person.age>=100);
        System.out.println("\nAlle er fortsatt yngre enn 100 år: " + noneOver100);

        System.out.println("\n");


        // Summere aldrene på kvinnene

        int sumOfFemaleAge = personList.stream()
                .filter(p -> p.gender.equals("Female"))
                .collect(Collectors.summingInt(p->p.age));

        System.out.println(sumOfFemaleAge);


        // Gjennomsnittsalder på alle menn

        double averageAgeOfMen = personList.stream()
                .filter(p -> p.gender.equals("Male"))
                .collect(Collectors.averagingInt(p->p.age));

        System.out.println(averageAgeOfMen);


        String namesWithJ = personList.stream()
                .filter(p-> p.name.startsWith("J"))
                .map(p-> p.name)
                .collect(Collectors.joining(", "));

        System.out.println(namesWithJ);



    }
}

/*
personList.stream()
        .sorted((o1, o2) -> {
//                    System.out.println(o1 + " - " + o2);
        if (o1.age < 16 && o2.age <16){
        if (o1.age>o2.age) return 1;
        if (o1.age<o2.age) return-1;
        else               return 0;
        }
        if (o1.age<16 && o2.age>16){
        return-1;
        }
        else if (o1.age>16 && o2.age<16){
        return 1;
        }
        else {
        return o1.name.compareTo(o2.name);
        }
        })
        .forEach(System.out::println);*/
