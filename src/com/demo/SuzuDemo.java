package com.demo;

import java.util.Arrays;

/**
 * @ClassNameSuzuDemo
 * @Description
 * @Author
 * @Date2019/12/7 9:52
 * @Version V1.0
 */
public class SuzuDemo {

    /**
     * 基本数据类型的值传递，不改变原始值，因为方法调用后就会弹栈，局部变量随之消失。
     * @param a
     * @param b
     */
    public static void change(int a,int b){
        System.out.println("a="+a+",b="+b);//将主函数的a，b值赋值给change()方法中的a，b；此时值相等，但是不是同一组值
        a=a+b;
        System.out.println("a="+a+",b="+b);
    }

    /**
     * 引用类型的值传递，该表原始值，因为即使方法弹栈，但是堆内存数组对象还在，可以通过地址继续访问。
     * @param arr
     */
    public static void change1(int arr[]){
        int len = arr.length;
        for(int i =1;i<len;i++){
            if(0 == arr[i]%2){
                arr[i] *= 2;
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        int a =10;
//        int b = 20;
//        System.out.println("a="+a+",b="+b);
//        change(a,b);
//        System.out.println("a="+a+",b="+b);

//        int arr[] = new int[]{1,2,3,4,5,6};
//        change1(arr);
//        System.out.println(Arrays.toString(arr));

//        int []x,y[];
//        x = new int[10];
//        y = new int[10][];
//        System.out.println(Arrays.toString(y[1]).toString());

        System.out.println("该程序耗时："+(System.currentTimeMillis()-startTime)+"ms");
    }
}
