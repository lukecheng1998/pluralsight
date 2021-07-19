import java.util.Objects;

public interface Consumer<T> {
    void accept(T t);
    default Consumer<T> andThen(Consumer<T> other){
        Objects.requireNonNull(other);//prevent null consumer
        return (T t) -> {
            this.accept(t);
            other.accept(t);
        };
    }
}
