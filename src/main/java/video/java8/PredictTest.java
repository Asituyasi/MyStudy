package video.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by tiantian on 2019/1/20
 */
public class PredictTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> predicate = p -> p%2==0;
        Predicate<Integer> predicate2 = p -> p>5;
        
        PredictTest test = new PredictTest();
        test.findByCondition(list, predicate, predicate2);

        System.out.println(test.testEquals("test").test("test"));


    }
    
    public void findByCondition(List<Integer> list, Predicate<Integer> predicate, Predicate predicate2) {
        for (Integer i : list) {
            if (predicate.and(predicate2).test(i)) {
                System.out.println(i);
            }
        }
    }
    
    public Predicate<String> testEquals(Object object) {
        return Predicate.isEqual(object);
    }
}
