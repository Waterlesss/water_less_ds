package com.zy;

public class binarySearch {

    public static void main(String[] args) {
        /**
         * 给定一个有序整型数组, 实现二分查找
         */
        int[] arr = new int[]{1, 5, 7, 9, 16, 19};

        //System.out.println(binarySearch(arr, 16));
        System.out.println(recur(arr, 19, 0, arr.length - 1));
    }

    //    public static int binarySearch(int[] arr, int toFind) {
//        int left = 0;
//        int right = arr.length - 1;
//        int count = 0;
//        //循环的终止条件 left > right
//        while (left <= right) {
//            count++;
//            int mid = (left + right) >> 1;
//            if (toFind < arr[mid]) {
//                //小于右区间的所有元素，在左区间进行查找
//                right = mid - 1;
//            } else if (toFind > arr[mid]) {
//                //大于左区间的所有元素，在右区间查找
//                left = mid + 1;
//            } else {
//                System.out.println("找到了！");
//                System.out.println("查找了" + count +"次");
//                return mid;
//            }
//        }
//        return -1;
//    }
    public static int recur(int[] arr, int toFind, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >> 1;
        if (toFind == arr[mid]) {
            System.out.print("找到了！数组索引为：");
            return mid;
        } else if (toFind < arr[mid]) {
            return recur(arr, toFind, left, mid - 1);
        } else {
            return recur(arr, toFind, left, right + 1);
        }
    }

}
