public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(){

    }
    public Person(String firstName, int age){
        this.firstName = firstName;
        this.age = age;
    }
    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "Person(" + "firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ")";
    }
}
