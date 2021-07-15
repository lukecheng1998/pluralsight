import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PlayWithReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        String personClassName = "Person";
        Class<?> personClass = Class.forName(personClassName);
        System.out.println("Person class = " + personClass);

        Field[] fields = personClass.getFields();
        System.out.println("Fields");
        System.out.println(Arrays.toString(fields));

        Field[] declaredFields = personClass.getDeclaredFields();
        System.out.println("Declared Fields");
        System.out.println(Arrays.toString(declaredFields));

        Method[]  methods = personClass.getMethods();
        System.out.println("Methods");
        System.out.println(Arrays.toString(methods));

        Method[]  declaredMethods = personClass.getDeclaredMethods();
        System.out.println("Declared Methods");
        System.out.println(Arrays.toString(declaredMethods));

        System.out.println();
        Arrays.stream(declaredMethods)
                .filter(m -> Modifier.isStatic(m.getModifiers()))
                .forEach(System.out::println);
    }
}
