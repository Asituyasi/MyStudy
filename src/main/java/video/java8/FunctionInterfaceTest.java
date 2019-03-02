package video.java8;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Created by tiantian on 2019/1/20
 */
public class FunctionInterfaceTest {

    public static void main(String[] args) {
        FunctionInterfaceTest test = new FunctionInterfaceTest();

        System.out.println(test.biFunc(2,3, (value1,value2) -> value1 + value2));
    }
    
    public int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    } 
    
    public int composeFunc(int a, Function<Integer, Integer> func1, Function<Integer, Integer> func2) {
        return func1.compose(func2).apply(a);
    }
    
    public int andThenFunc(int a, Function<Integer, Integer> func1, Function<Integer, Integer> func2) {
        return func1.andThen(func2).apply(a);
    }
    
    public int biFunc(int a, int b, BiFunction<Integer, Integer, Integer> biFunc) {
        return biFunc.apply(a, b);
    }
}
