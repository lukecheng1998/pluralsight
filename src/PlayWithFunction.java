import org.w3c.dom.ls.LSOutput;

public class PlayWithFunction {
    public static void main(String[] args){
        Meteo meteo = new Meteo(20);

        Function<Meteo, Integer> readCelcius = m -> m.getTemperature();
        Function<Integer, Double> celciusToFahrenheit = t -> t * 9d/5d + 32d;

        Function<Meteo, Double> readFahrenheit = readCelcius.andThen(celciusToFahrenheit);
        readFahrenheit = celciusToFahrenheit.composing(readCelcius);
        System.out.println("Meteo in F is " + readFahrenheit.apply(meteo));
    }


}
