package com.Cswork;

/**
 * @ClassNamePerson1
 * @Description
 * @Author
 * @Date2019/12/11 15:14
 * @Version V1.0
 */
public class Person1 {
    {
        System.out.println("父类代码块");
    }
    int m = f();
    int f(){
        System.out.println("父类非静态变量");
        return 1;
    }
    static int n = g();
    static {
        System.out.println("父类静态变量块");
    }
    static int g(){
        System.out.println("父类静态变量");
        return 2;
    }
    Person1(){
        System.out.println("A Person1");
    }
}
class Chinese extends Person1{
    {
        System.out.println("子类代码块");
    }
    int k = k();
    int k(){
        System.out.println("子类非静态变量");
        return 3;
    }
    static int i = i();
    static int i(){
        System.out.println("子类静态变量");
        return 4;
    }
    static {
        System.out.println("子类静态代码块");
    }
    Chinese(){
        super();
        System.out.println("A chinese");
    }

    public static void main(String[] args) {
        Chinese obj = new Chinese();
        boolean b = obj instanceof Chinese;
        System.out.println(b);
    }
}