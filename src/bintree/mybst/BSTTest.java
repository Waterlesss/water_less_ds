package bintree.mybst;

/**
 * @Author: Waterless
 * @Date: 2022/05/21/11:35
 * @Description:
 */
public class BSTTest {
    public static void main(String[] args) {
        MyBinSearchTree mbst = new MyBinSearchTree();
        mbst.add(41);
        mbst.add(58);
        mbst.add(50);
        mbst.add(60);
        mbst.add(42);
        mbst.add(53);
        mbst.add(59);
        mbst.add(63);

//        System.out.println(mbst.contains(42));
//        System.out.println(mbst.contains(10));
        System.out.println(mbst);
        System.out.println("——————————————————————");
//        System.out.println(mbst.findMin());
//        System.out.println(mbst.findMax());
//        System.out.println(mbst.removeMin());
//        System.out.println(mbst.findMin());
        mbst.remove(58);
        System.out.println(mbst);
    }
}
