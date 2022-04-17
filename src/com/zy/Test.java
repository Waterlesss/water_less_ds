package com.zy;

public class Test {
    public static void main(String[] args) {
        Person per = new Person();
        Person per1 = new Person("张三");
        Person per2 = new Person("女",18);
    }
}
class Person {
    private String name;
    private int age;
    private String sex;
    public Person () {
        System.out.println("perosn的无参构造");
    }
    public Person (String n) {
        // name = null; age = 0; sex = null;
        name = n;
        System.out.println("名字：" + name);
        System.out.println("年龄：" + age);
        System.out.println("性别：" +sex);
        System.out.println("姓名 = " + name);
        System.out.println("person的一个参数的构造方法");
    }
    public Person (String n,int a) {
        sex = n;
        age = a;
        System.out.println("性别是：" + sex + " 年龄是：" + age);
        System.out.println("person的两个参数的有参构造");
    }
}