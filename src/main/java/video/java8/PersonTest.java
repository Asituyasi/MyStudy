package video.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tiantian on 2019/1/20
 */
public class PersonTest {

    public static void main(String[] args) {
        Person p1 = new Person("zhangsan", 21);
        Person p2 = new Person("lisi", 43);
        Person p3 = new Person("wangwu", 22);

        List<Person> peoples = Arrays.asList(p1, p2, p3);
        
        peoples = peoples.stream().filter(person -> person.getName().equals("zhangsan")).collect(Collectors.toList());
        
        peoples.forEach(person -> System.out.println(person.name));

    }
}
