package bintree.map_set;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Waterless
 * @Date: 2022/05/18/22:53
 * @Description:
 */
public class HashMapTest {
    public static void main(String[] args) {
        //key不重复，value可以重复
//        Map<Integer,Integer> hashmap = new HashMap<>();
//        System.out.println(hashmap.put(1, 10));
//        System.out.println(hashmap.put(1, 20));
//        System.out.println(hashmap.put(2, 30));
//        System.out.println(hashmap.put(3, 40));
//        System.out.println(hashmap.containsKey(3));
//        System.out.println(hashmap.containsValue(10));
//        for (Map.Entry<Integer,Integer> entry : hashmap.entrySet()) {
//            System.out.println(entry.getKey() + " —— " + entry.getValue());
//        }
        Map<Student,String> hashmap2 = new HashMap<>();
        hashmap2.put(new Student(),"李四");
        System.out.println(hashmap2.toString());
        Map<String,String> hashmap = new HashMap<>();
        hashmap.put(null,null);
//        hashmap.put(null,"test");
        hashmap.put("及时雨","送姜");
        hashmap.put("豹子头","零充");
        hashmap.put("阿水","杰克爱");
        System.out.println(hashmap.put("及时雨", "宋江"));
        System.out.println(hashmap.toString());
        //遍历输出所有的key值
        Set<String> keys = hashmap.keySet();
        for (String i : keys) {
            System.out.print(i+" ");
        }
        //遍历输出所有的value值
        Collection<String> value = hashmap.values();
        for (String j : value) {
            System.out.print(j + " ");
        }
    }
}
class Student {

}