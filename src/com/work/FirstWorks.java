package com.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FirstWorks {

    private static String[][] str;

    /**
     * 创建一个数组用来存储1-100之间的奇数
     */
    public static void demo1(){
        int[] arr = new int[50];
        int i = 0;
        for(int j=1;j<=100;j++){
            if(j%2 != 0){//判定为奇数
                arr[i] = j;
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 给定两个数组，将两个数组内的元素对应位置互换
     */
    public static void demo2(){
        int a[] = {1,2,3},b[] = {4,5,6};
        int i = a.length;
        int k = b.length;
        int temp = 0;
        if(i<=k){
            for(int j=0;j<i;j++){
                temp = a[j];
                a[j] = b[j];
                b[j] = temp;
            }
        }else{
            for(int j=0;j<k;j++){
                temp = a[j];
                a[j] = b[j];
                b[j] = temp;
            }
        }
        System.out.println("a[]="+Arrays.toString(a)+",b[]="+Arrays.toString(b));
    }

    /**
     * 给定一个数组，将数组中元素头尾互换位置
     */
    public static void demo3(){
        int a[] = {1,2,3,4,5,6};
        int len = a.length;
        int temp = 0;
        temp = a[0];
        a[0] = a[len-1];
        a[len-1] = temp;
        System.out.println("a[]="+Arrays.toString(a));
    }

    /**
     * 计算数组中所有元素的平均值
     */
    public static void demo4(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数组长度：");
        int num = input.nextInt();
        int arr[] = new int[num];
        System.out.println("请输入数组：");
        for(int i=0;i<num;i++){
            arr[i] = input.nextInt();
        }
        System.out.println("数组："+Arrays.toString(arr));
        int sum = 0;
        for (int i=0;i<num;i++) {
            sum += arr[i];
        }
        System.out.println("数组平均值："+(sum/num));
    }

    /**
     * 合并两个数组
     */
    public static void demo5(){
        String[] a = {"张三","李四","王五"};
        String[] b = {"Bob","Tom","json"};
        int alen = a.length;
        int blen = b.length;
        a = Arrays.copyOf(a,alen+blen);//给数组增长
        System.arraycopy(b,0,a,alen,blen);
        System.out.println("a[]="+Arrays.toString(a));
    }

    /**
     * 按照数组中最大值，从最大值位置拆分成两个数组
     */
    public static void demo6(){
        int []arr = {2,54,4,7,1,34,89,43,32,44};
        int len = arr.length;
        int temp = 0;
        for(int i=1;i<len;i++){
            if(arr[temp]<arr[i]){
                temp=i;
            }
        }
        System.out.println("最大值"+arr[temp]);
        int []a = Arrays.copyOf(arr,temp);
        int []b = Arrays.copyOfRange(arr,temp,len);
        System.out.println("a[]="+Arrays.toString(a));
        System.out.println("b[]="+Arrays.toString(b));
    }
    /**
     * 去掉数组中的某一个元素
     */
    public static void demo7(){
        int[] arr = {6,7,0,56,0,44,3,5,7,0};
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要删除的元素：");
        int number = input.nextInt();
        List<Integer> list = new ArrayList<>();
        int len =arr.length;
        for (int i = 0;i<len;i++){
            if(number == arr[i]){
                continue;
            }
            list.add(arr[i]);
        }
        arr = new int[list.size()];
        int x = 0;
        for(int in:list){
            arr[x] = in;
            x++;
        }
        System.out.print(" "+Arrays.toString(arr));
    }

    /**
     * 创建一个数组存储1-100之间的质数
     */
    public static void demo8(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for(int i=3;i<=100;i++){
            boolean br = false;
            for(int j=2;j<=i/2;j++){
                if(i%j==0){
                    br = true;
                    break;
                }
            }
            if(!br){
                list.add(i);
            }
        }
        System.out.println(list);
        int[] arr = new int[list.size()];
        int x = 0;
        for(int i:list){
            arr[x] = i;
            x++;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 验证用户登录（集合泛型方式）
     * @param list
     */
    public static void demo9(List<Users> list){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = input.nextLine();
        System.out.println("请输入密码：");
        String password = input.nextLine();
        Users us = new Users();
        for(Users u:list){
           if(username.equals(u.getUsername()) && password.equals(u.getPassword())){
               us.setUsername(u.getUsername());
               us.setPassword(u.getPassword());
           }
        }
       if(us.getUsername()!= null && us.getPassword() != null){
           System.out.println("验证成功！");
       }else {
           System.out.println("验证失败！用户名或密码错误！");
       }

    }

    /**
     * 用数组方式
     */
    public static void demo91(String str[][]){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String username = input.nextLine();
        System.out.print("请输入密码：");
        String password = input.nextLine();
        String user[] = new String[]{username,password};
//        System.out.println(Arrays.toString(user));
        int line = str.length;
        int lineTwo = 0;
        boolean flag = false;
        for (int i = 0; i < line; i++) {
//            System.out.println(Arrays.toString(str[i]).toString());
            if(Arrays.equals(user,str[i])){
                flag = true;
                break;
            }
        }
        if(flag){
            System.out.println("登录成功！");
        }else {
            System.out.println("用户名或密码错误！");
        }
    }
    /**
     * 排水问题
     */
    public static void demo12(){
        int num = 120,in = 18,out = 30,time = 0;
        while (num > 0){
            num -= out;
            num += in;
            time++;
            System.out.println("经过"+time+"小时,剩余水位："+num);
        }
        System.out.println(time);
    }
    /**
     * 九九乘法表
     */
    public static void demo13(){
        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+"*"+i+"="+(j*i)+" ");
            }
            System.out.println();
        }
    }

    /**
     * *三角形
     */
    public static void demo132(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入行数：");
        int line = input.nextInt();
        int cen = (line*2-1)/2;
        String[][] strings = new String[line][line*2-1];
        strings[0][cen] = "*";
        int key = 1;//控制行数
        for(int i = 1;i<line;i++){//行数
            for(int j = 0;j < line*2-1;j++){
                strings[i][j]=strings[i-1][j];
            }
             strings[i][cen-key] = "* ";
             strings[i][cen+key] = " *";
             key++;
            }
        for(int y = 0;y<line;y++){
            if(y == 0){//控制第一行间隔
                for (int i = 0; i <= line; i++) {
                    System.out.print(" ");
                }
            }
            for (int z = 0;z<line*2-1;z++){
                if(null == strings[y][z]){
                    System.out.print(" ");
                }else {
                    System.out.print(strings[y][z]);
                }
            }
            System.out.println();
            for(int c=y;c<line;c++){//控制间隔
                System.out.print(" ");
            }
        }

    }

    /**
     * 简化奇数个数杨辉三角形
     */
    public static void demo133(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入杨辉三角形的行数：");
        int number = input.nextInt();
        int linelen = number*2-1;
        int arr[][] = new int[number][linelen];
        for(int i = 0;i<number;i++){//控制行数
            arr[i][linelen/2]= i+1;
            for(int k = 1;k <= i;k++){
                arr[i][linelen/2-k] = i+1-k;
                arr[i][linelen/2+k] = i+1-k;
            }
        }
        for (int x = 0;x<number;x++){
            if(x==0){
                for (int m = 0;m<=linelen/2+1;m++){
                    System.out.print(" ");
                }
            }
            for(int y = 0;y < linelen;y++){
                if(0 == arr[x][y]){
                    System.out.print(" ");
                }else {
                    System.out.print(arr[x][y]+" ");
                }
            }
            System.out.println();
            for (int k=x;k<number;k++){
                System.out.print(" ");
            }
        }
    }

    /**
     * a-b相距1000千米，小明a->b：7km.h；哥哥b->a：18km.h；多长时间相遇。
     */
    public static void demo14(){
        int distance = 1000,xm = 7,gg = 18;
        int sun = xm + gg;
        float time = 1000/sun;
        System.out.println("相遇时间："+time);
    }

    public static void main(String []args){
        long startTime = System.currentTimeMillis();
//        demo1();
//        demo2();
//        demo3();
//        demo4();
//        demo5();
//        demo6();
//        demo7();
//        demo8();

//        List<Users> list = new ArrayList<>();
//        Users user1 = new Users("张三","123");
//        Users user2 = new Users("李四","456");
//        Users user3 = new Users("王五","789");
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        demo9(list);

          str = new String[][]{{"张三","123"},{"李四","456"},{"王五","789"},{"李四","234"}};
          demo91(str);

//        demo12();
//        demo13();
//        demo132();
//        demo133();
//        demo14();
        System.out.println("消耗时间："+(System.currentTimeMillis()-startTime)+"ms");
    }
}
