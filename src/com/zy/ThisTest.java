package com.zy;

public class ThisTest {
    public static void main(String[] args) {
        // Student stu = new Student("张三", 18,"男");
        Student stu1 = new Student();
        System.out.println(stu1);
        stu1.whoami();
        Student stu2 = new Student("李四");
        System.out.println(stu2);
        stu2.whoami();
        //Student stu3 = new Student("李四",18);
        //stu.show();
        //stu.fun();
    }
}
class Student {
    private String name;
    private  int age;
    private String sex;
    public void whoami () {
        System.out.println(this);
    }
    public Student () {
        System.out.println("---------------------");
    }
    public Student (String name) {
        //调用无参构造
        this();
        this.name = name;
    }
    public Student (String name,int age) {
        //调用一个参数的有参构造
        this(name);
        this.age = age;
    }

    public void test () {
        System.out.println("student的test成员方法");
    }
    public void fun () {
        this.test();
        System.out.println("student的fun成员方法");
    }
    public Student (String name,int age,String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        System.out.println("Student类的有参构造");
    }
    public void show () {
        System.out.println("名字：" + name +" 年龄：" + age + " 性别：" + sex);
    }
}
