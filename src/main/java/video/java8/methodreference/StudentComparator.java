package video.java8.methodreference;

/**
 * Created by tiantian on 2019/1/21
 */
public class StudentComparator {

    public int compareByname(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }

}
