import java.util.*;

public class Main {
    public static void main(String[] args){
        //Part II
//        Predicate<String> p1 = s -> s.length() < 20;
//        Predicate<String> p2 = s -> s.length() > 5;
//        Predicate<String> p3 = p1.and(p2);
//
//        boolean b = p1.test("Hello");
//        System.out.println("Hello is shorter than 20 chars : " + b);
//        System.out.println("P3 for good morning: " + p3.test("Good morning"));
//        System.out.println("P3 for good morning genttlemen: " + p3.test("Good morning gentlemen"));
//
//        Predicate<String> p4 = p1.or(p2);
//        System.out.println("Hello is shorter than 20 chars : " + b);
//        System.out.println("P4 for good morning: " + p4.test("Good morning"));
//        System.out.println("P4 for good morning genttlemen: " + p4.test("Good morning gentlemen"));
//
//        Predicate<String> p5 = Predicate.isEqualTo("Yes");
//        System.out.println("P5 for yes: " + p5.test("Yes"));
//        System.out.println("P5 for no: " + p5.test("no"));

        //Part III
        Person p1 = new Person("Alice", 23);
        Person p2 = new Person("Brian", 56);
        Person p3 = new Person("Chelsea", 46);
        Person p4 = new Person("David", 28);
        Person p5 = new Person("Erica", 37);
        Person p6 = new Person("Francisco", 18);

        List<Person> people = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6));
        people.removeIf(person -> person.getAge() < 30);
        people.replaceAll(person -> new Person(person.getFirstName().toUpperCase(), person.getAge()));
        //people.sort(Comparator.comparing(Person::getAge));
        people.forEach(System.out::println);
        City NewYork = new City("New York");
        City Shanghai = new City("Shanghai");
        City Paris = new City("Paris");
        Map<City, List<Person>> map = new HashMap<>();
        map.putIfAbsent(Paris, new ArrayList<>());
        map.get(Paris).add(p1);
        map.computeIfAbsent(NewYork, city -> new ArrayList<>()).add(p2);
        map.computeIfAbsent(NewYork, city -> new ArrayList<>()).add(p3);

        System.out.println("Map 1");
        map.forEach((city, person) -> System.out.println(city + " : " + person));

        Map<City, List<Person>> map2 = new HashMap<>();
        map2.computeIfAbsent(NewYork, city -> new ArrayList<>()).add(p4);
        map2.computeIfAbsent(Shanghai, city -> new ArrayList<>()).add(p5);
        map2.computeIfAbsent(Shanghai, city -> new ArrayList<>()).add(p6);

        System.out.println("Map 2");
        map2.forEach((city, person) -> System.out.println(city + " : " + person));

        map2.forEach(
                (city, person) -> {
                    map.merge(
                            city, person,
                            (peopleFromMap1, peopleFromMap2) -> {
                                peopleFromMap1.addAll(peopleFromMap2);
                                return peopleFromMap1;
                            }
                    );
                }
        );
        System.out.println();
        map.forEach(
                (city, person) -> System.out.println(city + ":" + person)
        );
    }
}
