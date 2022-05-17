/*
package problemSet_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class Test22222 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "aaryanna",
                "aayanna",
                "airianna",
                "alassandra",
                "allanna",
                "allannah",
                "allessandra",
                "allianna",
                "allyanna",
                "anastaisa",
                "anastashia",
                "anastasia",
                "annabella",
                "annabelle",
                "annebelle"
        );


        names.stream()
                .filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
                //.map(Mapper.getDistinctCharactersCount())
                .forEachOrdered(System.out::println);
    }

    public static Predicate<String> nameStartingWithPrefix(String age)
    {
        return p -> p.startsWith(age);
    }






    static class Filter {

        public static Predicate<String> nameStartingWithPrefix(String k)
        {
            return p -> p.startsWith(k);
        }
    }

    static class Mapper {
        public static Predicate<String> getDistinctCharactersCount(){
            final Predicate<String> length = String::length;
            return length;
        }
    }

*/
/*    class BiggerThanFive<E> implements Predicate<String> {

        @Override
        public boolean test(String v) {
            return word ->

            Predicate<String> hasThreeChars = word -> word.startsWith(v);

            Integer five = 5;

            return v > five;
        }
    }*//*


}
*/
