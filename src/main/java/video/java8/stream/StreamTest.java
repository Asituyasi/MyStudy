package video.java8.stream;

import video.java8.methodreference.Student;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by tiantian on 2019/1/21
 */
public class StreamTest {

    public static void main(String[] args) {
//        Stream stream = Stream.of("hello", "world");
//        
//        IntStream.range(1,9).forEach(System.out::println);
//        
//        IntStream.rangeClosed(1,9).forEach(System.out::println);
//
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
//        System.out.println(list.stream().map(i -> i * 2).reduce(0, Integer::sum));
        
        //test();
        //newTest();
        
        test2();
        
        
    }
    
    public static void test() {
        Stream<String> stream = Stream.of("hello", "world", "nihao");
//        String[] array = stream.toArray(length -> new String[length]);
//        Arrays.asList(array).forEach(System.out::println);
//        String[] strings = stream.toArray(String[]::new);

//        List<String> strings = stream.collect(Collectors.toList());
        
//        List<String> strings = stream.collect(ArrayList::new, List::add, List::addAll);
//        String result = stream.collect(Collectors.joining());
//        System.out.println(result);

//        List<String> strings = stream.map(String::toUpperCase).collect(Collectors.toList());
//        strings.forEach(System.out::println);
        
//        Stream.iterate(1, item -> item+2).limit(5).forEach(System.out::println);

        Stream<Integer> stream2 = Stream.iterate(1, item -> item+2).limit(8);
        //stream2.forEach(System.out::println);
        int sum = stream2.filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum();
        System.out.println(sum);

    }
    
    public static void newTest() {
        List<String> strings = Arrays.asList("hello,world", "world,hello", "helloworld,nihao");
        List<String> collect = strings.stream()
                .map(item -> item.split(","))
                .flatMap(Arrays::stream).distinct()
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
        
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        IntSummaryStatistics statistics = numbers.stream().filter(item -> item > 1).mapToInt(item -> item).summaryStatistics();
        System.out.println("ave:" +statistics.getAverage());
        System.out.println("max:" +statistics.getMax());
        System.out.println("min:" +statistics.getMin());
    }
    
    public static void test2() {
        System.out.println("扁平化处理");
        List<String> hellos = Arrays.asList("hello", "nihao", "你好");
        List<String> names = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
        List<String> result = hellos.stream().flatMap(item -> names.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        result.forEach(System.out::println);

        Student student1 = new Student("zhangsan", 77);
        Student student2 = new Student("lisi", 99);
        Student student3 = new Student("wangwu", 99);
        Student student4 = new Student("zhangsan", 90);

        System.out.println("--------");
        // 分组
        System.out.println("分组");
        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map.toString());
        System.out.println(map.size());
        System.out.println("--------");

        Map<Integer, Long> res = students.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.counting()));
        System.out.println(res);
        System.out.println("--------");

        System.out.println("分区（分组的特殊情况)");
        Map<Boolean, List<Student>> partRes = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
        System.out.println(partRes);
        System.out.println("~_~");

    }
    
  
}
