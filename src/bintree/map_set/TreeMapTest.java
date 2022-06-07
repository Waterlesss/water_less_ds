package bintree.map_set;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: Waterless
 * @Date: 2022/05/18/23:32
 * @Description:
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Map<String,String> treemap = new TreeMap<>();
        //TreeMap不能保存null作为key值,value可以为空
        try{
            treemap.put("张三",null);
            treemap.put(null,null);
        }catch (NullPointerException e) {
            System.err.println("key is null");
        }

//        treemap.put("及时雨","送姜");
//        treemap.put("豹子头","零充");
//        treemap.put("阿水","杰克爱");
        System.out.println(treemap.toString());
//          Map<Person,String> treemap = new TreeMap<>();
//          treemap.put(new Person(),"张三");
    }
}
class Person {

}