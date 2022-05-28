package bintree.heap.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Waterless
 * @Date: 2022/05/19/10:20
 * @Description:
 */
public class Person implements Comparable<Person> {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
//        List<Person> arr = new ArrayList<>();
        Person[] per = new Person[]{
                new Person(16, "张三"),
                new Person(20, "王五"),
                new Person(18, "李四"),
        };
        int[] arr = {2,4,1,3,6,15,8,5,10,9,};

        Arrays.sort(per);
        for (Person o : per) {
            System.out.println(o);
        }
//        bubbleSort(arr);
//        System.out.println(Arrays.toString(arr));
    }
//    public static void bubbleSort(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length -1 ; j++) {
//                if (arr[j] > arr[j+1]) {
//                    int tmp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = tmp;
//                }
//            }
//        }
//    }
}
