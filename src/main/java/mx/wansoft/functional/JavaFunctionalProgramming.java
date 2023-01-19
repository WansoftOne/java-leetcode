package mx.wansoft.functional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class JavaFunctionalProgramming {
    // Interfaz funcional solo tiene 1 metodo abstracto. 

    public static void main(String[] args) {
        MyFunctionalInterface myfuntionalInterface = (number) -> {
            System.out.println(number);
        };
    
        Predicate<String> numerosMoyeresQue5 = (name) -> {
            return name.length() > 5;
        };
    
        Consumer<String> printName = (val) -> {
            System.out.println(val);
        };
    
        Supplier<List<String>> supplier = () -> {
           return Arrays.asList("Juan", "Jaciel", "Armando");
        };
    
        Function<Integer, String> function = (number) -> {
            return number.toString();
        };

        List<String> names = Arrays.asList("Juan", "Jaciel", "Armando");
        forEach(names, printName);
    }
    
    public static void forEach(List<String> list, Consumer<String> consumer) {
        for (String s: list) {
            consumer.accept(s);
        }
    }
}
