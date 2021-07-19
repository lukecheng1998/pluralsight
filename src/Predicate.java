import java.util.Objects;

@FunctionalInterface
public interface Predicate<T> {
    public boolean test(T t);
//    public default Predicate<T> and(Predicate<T> other){
//        return t -> test(t) && other.test(t);
//    }
    public default Predicate<T> and (Predicate<T> other){
        Objects.requireNonNull(other);
        return (T t) -> {
            return this.test(t) && other.test(t);
        };
    }
    public default Predicate<T> negate() {
        return (T t) -> !this.test(t);
    }
    public default Predicate<T> or(Predicate<T> other){
        return t -> test(t) || other.test(t);
    }
    public static <U> Predicate<U> isEqualTo(U string){
        return s -> s.equals(string);
    }
}
