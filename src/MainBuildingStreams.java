import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainBuildingStreams {
    public static void main(String[] args){
        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4);
        Stream<Integer> stream1 = ints.stream();
        Stream<Integer> stream = Stream.of(0, 1, 2, 3, 4);
        stream.forEach(System.out::println);

        Stream<String> streamOfStrings = Stream.generate(() -> "one");

        streamOfStrings.limit(5).forEach(System.out::println);
        Stream<String> streamOfStrings2 = Stream.iterate("+", s -> s + "+");//should grow a list of pluses
        streamOfStrings2.limit(5).forEach(System.out::println);

        IntStream streamOfInt = ThreadLocalRandom.current().ints();//Local to a thread, used for multithreaded environments
        streamOfInt.limit(5).forEach(System.out::println);//Generate random streams
    }
}
