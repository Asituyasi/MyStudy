package video.java8.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by tiantian on 2019/1/21
 */
public class MethodReferenceTese {

    public static void main(String[] args) {
        Student s3 = new Student("wangwu", 45);
        Student s1 = new Student("zhangsan", 12);
        Student s2 = new Student("lisi", 23);
        Student s4 = new Student("zhaoliu", 65);

        List<Student> students = Arrays.asList(s1, s2, s3, s4);
        
        // 方式一
//        students.sort((student1,student2)->Student.compareByScore(student1, student2));
//        students.forEach(student -> System.out.println(student.getScore()));
        
        // 方式二
//        students.sort(Student::compareByScore);
//        students.forEach(student -> System.out.println(student.getScore()));
        
//        students.sort((student1, student2)->new StudentComparator().compareByname(student1, student2));
        
//        students.sort(new StudentComparator()::compareByname);
        
//        students.sort(Student::compareByStuScore);
//        students.forEach(student -> System.out.println(student.getScore()));
        
        List<String> cities = Arrays.asList("beijing", "shanghai", "shenzhen", "hangzhou");
        //cities.sort((c1,c2) -> c1.compareTo(c2));
        cities.sort(String::compareToIgnoreCase);
        cities.forEach(city -> System.out.println(city));

        System.out.println(MethodReferenceTese.getString(String::new));

        System.out.println(MethodReferenceTese.getString2("world", String::new));

    }
    
    public static String getString(Supplier<String> supplier) {
        return supplier.get() + "hello";
    }
    
    public static String getString2(String s, Function<String, String> function) {
        return function.apply(s);
    }
}
