package hash;

/**
 * @Author: Waterless
 * @Date: 2022/05/22/16:16
 * @Description:
 */
public class MyHashMapTest {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,10);
        map.put(2,20);
        map.put(3,30);
        map.put(17,100);
        map.put(18,200);
        map.put(1,55);
        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue(200));
        System.out.println(map.contains(18,200));
        System.out.println(map.contains(19,100));
    }
}
