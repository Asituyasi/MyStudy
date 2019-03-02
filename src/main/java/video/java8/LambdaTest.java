package video.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Created by tiantian on 2019/1/19
 */
public class LambdaTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        testSort();
    }
    
    public static void test() {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(String::toUpperCase).forEach(i-> System.out.printf(i));
        Function<String, String> toUpercase = String::toUpperCase;
        System.out.printf("\n");
        System.out.println(toUpercase.getClass().getInterfaces()[0]);
        System.out.println(toUpercase.getClass());
    }
    
    public static void testSort() {
        List<String> list = Arrays.asList("aa", "bb", "cc");
        Collections.sort(list, Comparator.reverseOrder());

        System.out.println(list);
    }
    
    public static void convert(String s) {
        //System.out.printf(s.toUpperCase());
    }
}


