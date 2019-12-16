package com.work;

import java.util.Scanner;

/**
 * @ClassNameCompertor
 * @Description
 * @Author mayafei
 * @Date2019/12/12 8:49
 * @Version V1.0
 */
public class Compertor {
    public static void main(String[] args) {
        try {
        CalcuImpl calcu = new CalcuImpl();
        double num1 = new Scanner(System.in).nextDouble();//输入第一个数字
        boolean flag = true;
        while (flag) {
            String operactor = new Scanner(System.in).next();//输入符号
            if ("add".equals(operactor) || "sub".equals(operactor) || "mul".equals(operactor) || "div".equals(operactor) || "rem".equals(operactor)) {//英文符号控制
                num1 = calcu.operator(num1, operactor, new Scanner(System.in).nextDouble());//进入运算，返回最后结果
                System.out.println("现在得结果为：" + num1);
            } else if ("+".equals(operactor) || "-".equals(operactor) || "*".equals(operactor) || "/".equals(operactor) || "%".equals(operactor)) {//运算符号得控制
                Operact operact = new Operact(operactor);
                operactor = operact.replace();//符号的转化
                num1 = calcu.operator(num1, operactor, new Scanner(System.in).nextDouble());
                System.out.println("现在得结果为：" + num1);
            } else if ("end".equals(operactor)) {
                System.exit(0);//退出程序
            } else {
                System.out.println("请输入正确得符号！");
            }
        }
        }catch (java.util.InputMismatchException e){
            System.out.println("输入的double数字类型有误!程序结束！请重新开始！");
        }
    }
}


class Operact {
    private String operactor;
    Operact(){}
    Operact(String operactor) {
        this.operactor = operactor;
    }

    public String replace() {//符号替换
        if ("+".equals(operactor)) {
            operactor = "add";
        } else if ("-".equals(operactor)) {
            operactor = "sub";
        } else if ("*".equals(operactor)) {
            operactor = "mul";
        } else if ("/".equals(operactor)) {
            operactor = "div";
        } else if ("%".equals(operactor)){
            operactor = "rem";
        }
        return operactor;
    }
}

interface Operator {
    public double add(double num1, double num2);

    public double sub(double num1, double num2);

    public double mul(double num1, double num2);

    public double div(double num1, double num2);

    public double rem(double num1,double num2);
}

class Operatorimpl implements Operator {//运算

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double sub(double num1, double num2) {
        return num1 - num2;
    }

    public double mul(double num1, double num2) {
        return num1 * num2;
    }

    public double div(double num1, double num2) {
        return num1 / num2;
    }

    @Override
    public double rem(double num1, double num2) {
        return num1 % num2;
    }
}

interface Calculactor {
    public double operator(double num1, String operators, double num2);
}

class CalcuImpl implements Calculactor {//根据符号进行相应逻辑运算
    Operator operator = new Operatorimpl();

    @Override
    public double operator(double num1, String operators, double num2) {
        switch (operators) {
            case "add":
                num1 = operator.add(num1, num2);
                break;
            case "sub":
                num1 = operator.sub(num1, num2);
                break;
            case "mul":
                num1 = operator.mul(num1, num2);
                break;
            case "div":
                num1 = operator.div(num1, num2);
                break;
            case "rem":
                num1 = operator.rem(num1,num2);
                break;
        }
        return num1;
    }
}
