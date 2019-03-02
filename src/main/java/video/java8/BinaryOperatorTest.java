package video.java8;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * Created by tiantian on 2019/1/20
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {
        BinaryOperatorTest test = new BinaryOperatorTest();
        BinaryOperator<Integer> operator = (x, y)->x+y;
        Integer applyRes = test.compute(3, 4, operator);
        System.out.println(applyRes);

        Comparator<Integer> comparator = (a, b)->a.compareTo(b);
        System.out.println(comparator.compare(1,2));
    }
    
    public Integer compute(int a, int b, BinaryOperator<Integer> operator) {
        Integer result = operator.apply(a, b);

        return result;
    }
}
