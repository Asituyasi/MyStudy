package video.java8.methodreference;

/**
 * Created by tiantian on 2019/1/21
 */
public class Student {
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
    
    public int compareByname(Student s1, Student s2) {
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
    
    public static int compareByScore(Student s1, Student s2) {
        return s1.getScore() - s2.getScore();
    }

    public int compareByStuScore(Student s1) {
        return this.getScore() - s1.getScore();
    }
}
