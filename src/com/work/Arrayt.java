package com.work;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassNameArrayt
 * @Description
 * @Author mayafei
 * @Date2019/12/12 9:36
 * @Version V1.0
 */
public class Arrayt {
    public static void main(String[] args) {
        Operate operate = new OperateImpl();
        operate.operateImpl();
    }
}

interface Arrayre {
    long[] setLongArray(long... num);

    String[] setStringArray(String... num);

    String[] getStringArray();
    String[] delStringArray(String num);
}

class ArrayBox implements Arrayre {
    private static long longArray[] = new long[0];
    private static String stringArray[] = new String[0];

    @Override
    public long[] setLongArray(long... num) {//将元素给Long数组储存
        int longLength = longArray.length;
        longArray = Arrays.copyOf(longArray, longLength + num.length);//数组增长
        System.arraycopy(num, 0, longArray, longLength, num.length);
        System.out.println(Arrays.toString(longArray));
        System.out.println("此刻存入的数组" + Arrays.toString(longArray));
        return longArray;
    }

    @Override
    public String[] setStringArray(String... num) {//将元素给String数组储存
        int stringLength = stringArray.length;
        stringArray = Arrays.copyOf(stringArray, stringLength + num.length);
        System.arraycopy(num, 0, stringArray, stringLength, num.length);
        System.out.println("此刻存入的数组" + Arrays.toString(stringArray));
        return stringArray;
    }

    @Override
    public String[] getStringArray() {
        Arrays.sort(stringArray);
        System.out.println("该数组元素："+Arrays.toString(stringArray));
        return stringArray;
    }

    @Override
    public String[] delStringArray(String num) {
        int index[] = new int[0];
        int len = stringArray.length;
        for (int i = 0; i < len; i++) {//查看数组中有多少个该元素
            if (num.equals(stringArray[i])){
                index = Arrays.copyOf(index,index.length+1);
                index[index.length-1] = i;
                continue;
            }
        }
        if (1 < index.length){//数组中有多个元素
            Utils.delArraysdata(index,stringArray,len);
        }else if (1 == index.length){//只有一个的时候
            Utils.delArrayOne(index,stringArray,len);
        }else {
            System.out.println("该数组没有该元素！");
        }
        return stringArray;
    }
}

interface Operate {
    public void operateImpl();
}

class OperateImpl implements Operate {
    @Override
    public void operateImpl() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要执行的操作：1.添加数据；2.查询元素；3.删除元素;end;結束程序");
        String operate = scanner.nextLine();
        String num[] = new String[0];
        switch (operate) {
            case "1"://添加元素
                boolean flag = true;
                while (flag) {
                    System.out.println("请输入要添加的元素：(若要结束输入，请输入====)");
                    String date = scanner.nextLine();
                    if ("====".equals(date)) {
                        Arrayre arrayre = new ArrayBox();
                        arrayre.setStringArray(num);
                        flag = false;
                    } else {
                        int len = num.length;//本此存入的值长度
                        num = Arrays.copyOf(num, len + 1);
                        num[len] = date;
                        System.out.println("已经添加的元素：" + Arrays.toString(num));
                    }
                }
                break;
            case "2"://查询元素
                Arrayre arrayres = new ArrayBox();
                arrayres.getStringArray();
                break;
            case "3"://删除元素
                Arrayre arrayre = new ArrayBox();
                System.out.println("请输入需要删除的数据：");
                String data = scanner.nextLine();
                arrayre.delStringArray(data);
                break;
            case "end"://退出程序
                System.exit(0);
            default:
                System.out.println("請輸入正確的操作！");
                break;
        }
        operateImpl();
    }
}
class Utils{
    /**
     * 删除一个元素
     * @param index
     * @param stringArray
     * @param len
     */
    static void sinpledel(int index[],String stringArray[],int len){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要删除的下标号:");
        int delInput = scanner.nextInt();
        boolean flag = false;
        for (int i = 0; i < index.length; i++) {
            if (delInput == index[i]){
                flag = true;
            }
        }
        if (flag){
            for (int i = delInput; i < len-1; i++) {
                stringArray[i] = stringArray[i+1];
            }
            stringArray = Arrays.copyOf(stringArray,len-1);
            System.out.println("删除成功！剩下数组元素:"+Arrays.toString(stringArray));
        }else {
            System.out.println("请输入正确的下标！");
            sinpledel(index,stringArray,len);
        }
    }

    /**
     * 删除数组中含有多个元素的操作
     * @param index
     * @param stringArray
     * @param len
     */
    static void delArraysdata(int index[],String stringArray[],int len){
        System.out.println("该数组中有该元素："+index.length+"个,元素下标是："+Arrays.toString(index));
        Scanner scanner = new Scanner(System.in);
        System.out.println("存在多个该元素，是否全部删除：1.是；2.否;end.退出程序；====.返回主页");
        String operact = scanner.nextLine();
        if ("1".equals(operact)){//全部删除
            int temp = 0;
            for (int i = 0; i < index.length; i++) {
                int indexs = index[i]-temp;
                for (int j = indexs; j < len-1; j++) {
                    stringArray[j] = stringArray[j+1];
                }
                temp++;
            }
            stringArray = Arrays.copyOf(stringArray,len-index.length);
            System.out.println("删除成功！剩下数组元素:"+Arrays.toString(stringArray));
        } else if ("2".equals(operact)){//删除一个元素
            Utils.sinpledel(index,stringArray,len);
        } else if ("====".equals(operact)){
            System.out.println("退出程序");
            System.exit(0);
        } else if ("===".equals(operact)){
            System.out.println("返回主页");
        }else {//操作错误
            System.out.println("请输入正确的操作！");
            delArraysdata(index,stringArray,len);
        }
    }

    /**
     * 删除数组中的一个元素
     * @param index
     * @param stringArray
     * @param len
     */
    static void delArrayOne(int index[],String stringArray[],int len){
        int indexs = index[index.length-1];
        for (int i = indexs; i < len-1; i++) {
            stringArray[i] = stringArray[i+1];
        }
        stringArray = Arrays.copyOf(stringArray,len-1);
        System.out.println("删除成功！剩下数组元素:"+Arrays.toString(stringArray));
    }
}
