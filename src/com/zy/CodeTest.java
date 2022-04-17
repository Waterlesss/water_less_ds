package com.zy;

public class CodeTest {
    static {
        System.out.println("静态代码块");
    }
    public static void main(String[] args) {
        System.out.println("进入主方法");
        // Animal ani = new Animal();
        //Animal ani1 = new Animal();
        Animal ani1 = new Animal("小狗");
        Animal ani2 = new Animal();
        //System.out.println(ani1.name);
        System.out.println(new Animal());
    }
}
class Animal {
    String name;
    {
        name = "test";
        //构造块，也叫成员代码块
        System.out.println("2.animal的构造块");
    }
    //    public String toString () {
//        String ret = "name = " + name;
//        return ret;
//    }
    public Animal () {
        System.out.println("1.animal的无参构造");
    }
    public Animal (String name) {
        this.name = name;
        System.out.println("1.有参构造");
    }
    static {
        //静态块
        System.out.println("3.animal的静态代码块");
    }
}