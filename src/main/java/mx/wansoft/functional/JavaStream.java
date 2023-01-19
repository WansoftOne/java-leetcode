package mx.wansoft.functional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStream {
    int count = 0;
    public static void main(String[] args) {
        List<Integer> numbs = Arrays.asList(1,6,20,5,0,8);
        Stream<Integer> myStream = numbs.stream();
        myStream.forEach((x) -> System.out.println(x));
        myStream.forEach((x) -> System.out.println(x));
        String x = "";
        final Map<String,String> m = new HashMap<>();

        List<Integer> filteredList = myStream
            .filter((n) -> {
                return n >= 5;
            })
            .map((n) -> {
                Integer r = n * 2;
                System.out.println( n + "*2: " + r);
                return r;
            })
            //.flatMap(null)
            .collect(Collectors.toList());
            //forEach((n) -> System.out.println("consumer"))            

            System.out.println(Objects.toString(filteredList));

    }


}
