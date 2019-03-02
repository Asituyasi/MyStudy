package video.java8;

import java.util.Optional;

/**
 * Created by tiantian on 2019/1/20
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.empty();
        
        optional.ifPresent(item -> System.out.println(item));
    }
    
    
}
