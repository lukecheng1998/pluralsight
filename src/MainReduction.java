import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class MainReduction {
    public static int reduce(List<Integer> values, int valueIfEmpty, BinaryOperator<Integer> reduction){
        int result = valueIfEmpty;
        for(int value : values){
            result = reduction.apply(result, value);
        }
        return result;
    }

    public static void main(String[] args){
        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(5, 6, 7, 8, 9);
        BinaryOperator<Integer> cp = (i1, i2) -> (i1 + i2) / 2; //May not always be associative be careful
        int reduction1 = reduce(ints1, 0, cp);
        int reduction2 = reduce(ints2, 0, cp);
        //int reduction = reduce(Arrays.asList(reduction1, reduction2), 0, cp); //parallel
        int reduction = reduce(ints, 0, cp); //series
        System.out.println("Reduction: " + reduction);
    }
}
