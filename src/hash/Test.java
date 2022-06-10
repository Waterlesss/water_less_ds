package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: Waterless
 * @Date: 2022/05/25/22:35
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
//        Test test1 = new Test();
//        Test test2 = new Test();
//        Test test3 = test1;
//        System.out.println(test1.hashCode());
//        System.out.println(test2.hashCode());
//        System.out.println(test3.hashCode());
        Student stu1 = new Student("张三",18);
        Student stu2 = new Student("李四",18);
        Student stu3 = new Student("张三",18);
        Map<Student,String> map = new HashMap<>();
        map.put(stu1,"111");
        map.put(stu2,"222");
        map.put(stu3,"333");
        System.out.println(map);
    }
}
class Student {
    int age;
    String name;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Student) {
            Student student = (Student) o;
            return this.age == student.age && name.equals(student.name);
        }
        return false;
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
////        return 0;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}