package com.Cswork;

/**
 * @ClassNamePerson
 * @Description
 * @Author
 * @Date2019/12/11 15:06
 * @Version V1.0
 */
public class Person {
    public Person(){
        func();
    };
    public void func(){
        System.out.println("1");
    }
}
class Person_A extends Person{
    public Person_A(){super();}
    public Person_A(int a){
        System.out.println(a);
    }
    public void func(){
        System.out.println("2");
    }

    public static void main(String[] args) {
        Person_A pa = new Person_A();
        Person_A pb = new Person_A(3);
    }
        }
