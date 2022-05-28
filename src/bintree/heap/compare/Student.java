package bintree.heap.compare;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Waterless
 * @Date: 2022/05/18/14:27
 * @Description:
 */

//这个类是根据年龄越大就越大进行比较
class StudentSec implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }


}

//这个类是根据年龄越小反而越大进行比较
class StudentDesc implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.getAge() - o1.getAge();
    }
}


public class Student {
    private int age;

    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    //    @Override
//    public int compareTo(Student o) {
//        return o.age - this.age;
//    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Student[] students = new Student[] {
                new Student(18,"张三"),
                new Student(19,"李四"),
                new Student(21,"王五")
        };
        //Student这个类不具备比较能力，传入一个该类的比较器对象
        Arrays.sort(students,new StudentDesc());
        System.out.println(Arrays.toString(students));
    }
}
