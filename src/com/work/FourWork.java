package com.work;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassNameFourWork
 * @Description
 * @Author
 * @Date2019/12/9 14:47
 * @Version V1.0
 */
public class FourWork {
    /**
     * 模拟班级小组换座位
     */
    public static void demo1(int group[][],int week){
        int len = group.length;//获取组数
        System.out.println("第"+week+"周座位顺序：");
        for (int i = 0; i < len; i++) {//打印座位顺序
            System.out.print(Arrays.toString(group[i]).toString());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n下一周座位请输入1！上一周座位请输入2！结束程序0！");
        int change = scanner.nextInt();
        if (1 == change){//下周座位顺序
            int temp[] = group[len-1];
            for (int i = len-1; i > 0; i--) {//元素依次向后移
                group[i] = group[i-1];
            }
            group[0] = temp;//将最后一组赋值给第一组
            week++;
            demo1(group,week);
        }else if (2 == change){//上一周座位顺序
            if (week>1){
            int temp[] = group[0];//记录第一个元素
            for (int i = 1; i < len; i++) {//元素依次向前移动
                group[i-1] = group[i];
            }
            group[len-1] = temp;//将第一个元素赋值给最后一个
            week--;
            demo1(group,week);
            }else {
                System.out.println("已经是第一周的座位顺序了！");
                demo1(group,week);
            }
        }else if (0 == change){
            System.exit(0);//退出程序
        }else {
            System.out.println("请输入正确的操作！");
            demo1(group,week);
        }
    }
    public static void demo2(String login[][]){
         FirstWorks.demo91(login);
    }
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int group[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int week = 1;
        demo1(group,week);

//        String login[][] = {{"aaa","111"},{"bbb","222"},{"ccc","333"}};
//        demo2(login);
        System.out.println("消耗时长："+(System.currentTimeMillis()-startTime)+"ms");
    }
}
