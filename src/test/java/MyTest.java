import java.io.IOException;
import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * desc :
 * Created by tiantian on 2018/12/10
 */
public class MyTest {

    public static void main(String[] args) throws IOException {
       
        //test1();
        MyTest myTest = new MyTest();
        myTest.test2();
        
    }
    
    public void test2() {
        System.out.println(this.getClass().getClassLoader());
        System.out.println(this.getClass().getClassLoader().getParent());
        System.out.println(this.getClass().getClassLoader().getParent().getParent());
    }
    
    public static void test1() {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            int rand = new SecureRandom().nextInt(20);
            intBuffer.put(rand);
        }
        
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
