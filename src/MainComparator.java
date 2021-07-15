import java.util.function.Function;

public class MainComparator {
    public static void main(String[] args){
        //Part 1
        Comparator<Person> cmpAge = (p1, p2) -> p2.getAge() - p1.getAge();
        Comparator<Person> cmpFirstName = (p1, p2) -> p2.getFirstName().compareTo(p1.getFirstName());
        Comparator<Person> cmpLastName = (p1, p2) -> p2.getLastName().compareTo(p1.getLastName());

        Function<Person, Integer> f1 = p-> p.getAge();
        Function<Person, String> f2 = p -> p.getLastName();
        Function<Person, String> f3 = p -> p.getFirstName();

        Comparator<Person> cmpPersonAge = Comparator.comparing(Person::getAge);
        Comparator<Person> cmpPersonLastName = Comparator.comparing(Person::getLastName);

        Comparator<Person> cmp = cmpPersonAge.thenComparing(Person::getLastName).thenComparing(Person::getFirstName).thenComparing(Person::getAge);


    }
}
