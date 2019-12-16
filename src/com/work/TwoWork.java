package com.work;

import java.util.Scanner;

/**
 * @ClassNameTwoWork
 * @Description
 * @Author
 * @Date2019/12/4 17:25
 * @Version V1.0
 */
public class TwoWork {
    /**
     * a,b都是整型，写出将a，b两个变量中的值互换的程序
     */
    public static void demo1(){
        long a=1,b=2;
        //使用中间变量
        long temp = 0;
        temp = a;
        a = b;
        b =temp;
        System.out.println("使用中间变量交换：a="+a+",b="+b);
        //不使用中间变量
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("不使用中间变量交换：a="+a+",b="+b);
        //使用异或
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("使用异或交换：a="+a+",b="+b);
    }

    /**
     * 给定一个0-1000的整数，求各位数的和，例如345的结果是3+4+5=12 注：分解数字既可以先除后模哦也可以先模后除（知识点：变量和运算符综合运用）
     */
    public static void demo2(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个0-1000之内的整数：");
        int number = input.nextInt();
        int sum = 0;
        if(number>=1000 && number<0){
            System.out.println("请输入规定范围内的整数！");
        }else {
            int num = (number+"").length();
            for(int i=0;i<num;i++){
                sum += number%10;
                number = number/10;
            }
            System.out.println("该数各位数和："+sum);
        }
    }

    /**
     * 华氏温度和摄氏温度互相转换，
     * 提示：从华氏度变成摄氏度你只要减去32，乘以5再除以9就行了，将摄氏温度转为华氏度，直接乘以9，除以5，再加上32即可
     */
    public static void demo3(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入化氏摄氏度(以。C/。c结尾)：");
        String hs = input.nextLine();
        String end = hs.substring(hs.length()-2,hs.length());//取出后字符串两位
        if("。C".equals(end) || "。c".equals(end)){
            String start = hs.substring(0,hs.length()-2);
            double de = Double.parseDouble(start);
            //华氏摄氏度转换成摄氏温度
            double ss = (de - 32)*5/9;
            String hsd = ss + "。h";
            System.out.println("华氏度："+hsd);
        }else{
            System.out.println("请输入正确的格式!");
        }
    }

    /**
     * 给定一个任意的字母A~Z，转换为小写字母
     */
    public static void demo4(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("情输入字母:");
        String s = scanner.nextLine();
        System.out.println("大写转小写："+s.toLowerCase());
        System.out.println("小写转大写："+s.toUpperCase());
    }

    /**
     * 猴子第一天摘下若干个桃子，当天吃了一半，还不过瘾，又多吃了一个。以后每天早上都吃了前一天剩下的一半零一个。到第十天早上想再吃时，见只剩一个桃子了。求第一天共摘了多少？
     * 方法1：（使用while循环）
     * 方法2：（使用for循环）
     */
    public static void demo5(){
         int ls = 1;
         for (int i=1;i<10;i++){
             ls = (ls+1)*2;
         }
        System.out.println("第一天共摘："+ls);
         int i =1;
         while(i<10){
             ls = ls/2-1;
             i++;
         }
        System.out.println("第十天早上还剩："+ls);
    }

    /**
     * 给定一个成绩a，使用switch结构求出a的等级。A：90-100，B:80-89 ，C:70-79, D:60-69 ，E:0-59:
     */
    public static void demo6(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入1-100的成绩：");
        int great = input.nextInt();
        String type = "";
        if(great<=100 && great>=90){
            type="A";
        }else if(great<90 && great>=80){
            type="B";
        }else if(great<80 && great>=70){
            type="C";
        }else if(great<70 && great>=60){
            type="D";
        }else if(great<60 && great>=0){
            type="E";
        }
        switch (type){
            case "A":
                System.out.println("成绩等级为A!");
                break;
            case "B":
                System.out.println("成绩等级为B!");
                break;
            case "C":
                System.out.println("成绩等级为C!");
                break;
            case "D":
                System.out.println("成绩等级为D!");
                break;
            case "E":
                System.out.println("成绩等级为E!");
                break;
            default:
                System.out.println("该成绩有误！");
                break;
        }
    }

    /**
     *求1到100之间所有能被3整除的整数的和
     */
    public static void demo7(){
        int sum = 0;
        for(int i=1;i<=100;i++){
            if(i%3 == 0){
                sum = sum+i;
            }
        }
        System.out.println("被3整除的整数和："+sum);
    }

    /**
     * 如果是5，输出x=5，如果是10，输出x=10,除了以上几个值，都输出x=none
     */
    public static void demo8(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个数：");
        String s = input.nextLine();
        if("5".equals(s)){
            System.out.println("x="+s);
        }else if("10".equals(s)){
            System.out.println("x="+s);
        }else {
            System.out.println("x=none");
        }
    }
    public static void main(String[] args){
//        demo1();
//        demo2();
//        demo3();
//        demo4();
//        demo5();
//        demo6();
//        demo7();
//        demo8();
    }
}
