package com.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassNameThereWork
 * @Description
 * @Author
 * @Date2019/12/7 14:34
 * @Version V1.0
 */
public class ThereWork {

    /**
     * 创建一个数组来存储1-100之间的奇数
     */
    public static void demo1() {
        int number = 100;
        int odd[] = new int[number / 2];
        int k = 0;
        for (int i = 1; i < number; i++) {
            if (i % 2 != 0) {
                odd[k] = i;
                k++;
            }
        }
        System.out.println(Arrays.toString(odd));
    }

    /**
     * 给定两个数组a{1,2,3,4} b{5,6,7,8}将这两个数组中的对应位置互换
     */
    public static void demo2() {
        int a[] = {1, 2, 3, 4};
        int b[] = {5, 6, 7, 8};
        int alen = a.length;
        int blen = b.length;
        if (alen > blen) {
            for (int i = 0; i < blen; i++) {//不用过中间变量交换
                a[i] = a[i] + b[i];
                b[i] = a[i] - b[i];
                a[i] = a[i] - b[i];
            }
            System.out.println("a[]=" + Arrays.toString(a) + ",b[]=" + Arrays.toString(b));
        } else {
            for (int i = 0; i < alen; i++) {//通过异或的方式交换
                a[i] = a[i] ^ b[i];
                b[i] = a[i] ^ b[i];
                a[i] = a[i] ^ b[i];
            }
            System.out.println("a[]=" + Arrays.toString(a) + ",b[]=" + Arrays.toString(b));
        }
    }

    /**
     * 给定一个数组a{1,2,3,4,5,6}将这个数组中的元素头尾对应位置互换
     */
    public static void demo3() {
        int a[] = {1, 2, 3, 4, 5, 6};
        int temp = 0;
        int len = a.length;
        for (int i = 0; i < len / 2; i++) {//通过中间变量交换
            temp = a[i];
            a[i] = a[len - 1 - i];
            a[len - 1 - i] = temp;
        }
        System.out.println("a[]=" + Arrays.toString(a));
    }

    /**
     * 给定一个数组a{1,2,3,4,5,6}计算数组所有元素的平均值
     */
    public static void demo4() {
        int a[] = {1, 2, 3, 4, 5, 6};
        int len = a.length;
        int sum = 0;
        double svn = 0;
        for (int i = 0; i < len; i++) {
            sum += a[i];
        }
        svn = sum / len;
        System.out.println("a[]数组元素的平均数：" + svn);
    }

    /**
     * 给定一个数组a{4,5,2,1,8,63,0,2,5,4,78}找寻数组中的最大值和最小值
     */
    public static void demo5() {
        int a[] = {4, 5, 2, 1, 8, 63, 0, 2, 5, 4, 78};
        int maxIndex = 0;//记录最大值下标
        int minIndex = 0;//记录最小值下标
        int len = a.length;
        //最大值
        for (int i = 0; i < len - 1; i++) {
            if (a[maxIndex] < a[i + 1]) {
                maxIndex = i + 1;
            }
        }
        System.out.println("最大值：" + a[maxIndex]);
        //最小值
        for (int i = 0; i < len - 1; i++) {
            if (a[minIndex] > a[i + 1]) {
                minIndex = i + 1;
            }
        }
        System.out.println("最小值：" + a[minIndex]);
    }

    /**
     * 给定两个数组a{1,2,3,4} b{5,6,7,8}合并两个数组
     */
    public static void demo6() {
        int a[] = {1, 2, 3, 4};
        int b[] = {5, 6, 7, 8};
        int alen = a.length;//数组a的长度
        int blen = b.length;//数组b的长度
        a = Arrays.copyOf(a, alen + blen);//给数组增加长度
        System.arraycopy(b, 0, a, alen, blen);//System的arraycopy的静态方法，用于数组的复制
        System.out.println("合并后的数组:" + Arrays.toString(a));
    }

    /**
     * 给定一个数组a{4,5,2,1,8,63,0,2,5,4,78}按照数组中的最大位置，拆分两个数组
     */
    public static void demo7() {
        int a[] = {4, 5, 2, 1, 8, 63, 0, 2, 5, 4, 78};
        int maxIndex = 0;//记录最大元素的下标
        int len = a.length;
        for (int i = 1; i < len; i++) {
            if (a[maxIndex] < a[i]) {
                maxIndex = i;
            }
        }
        int x[] = Arrays.copyOf(a, maxIndex);//从最大值复制到新数组
        a = Arrays.copyOfRange(a, maxIndex, len);//将固定范围复制给新数组
        System.out.println("最大数位置拆分成两个数组：" + Arrays.toString(x) + "," + Arrays.toString(a));
    }

    /**
     * 给定一个数组a{4,5,2,1,8,63,0,2,5,4,78}去掉数组中的某个元素或者某区间元素
     */
    public static void demo8(int a[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要删除的方式：1.去除数组某个元素；2.去掉某区间的元素（最小值<最大值）");
        int type = scanner.nextInt();
        int temp = 0;//记录删除的个数
        if (1 == type) {
            System.out.println("请输入要删除的元素：");
            int del = scanner.nextInt();
            del(del, temp, a);
        } else if (2 == type) {
            System.out.println("请输入区间最小值：");
            int mix = scanner.nextInt();
            System.out.println("请输入区间最大值：");
            int max = scanner.nextInt();
            if (mix >= max) {
                System.out.println("请输入正确的区间!");
                demo8(a);
            } else {
                qjdel(mix, max, temp, a);
            }
        } else {
            System.out.println("请输入正确的类型!");
            demo8(a);
        }
    }

    /**
     * 删除数组具体元素
     *
     * @param del
     * @param temp
     * @param a
     */
    public static void del(int del, int temp, int a[]) {
        int len = a.length;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            if (del == a[i]) {
                a[i] = a[len - 1];
                flag = true;
                break;
            }
        }
        if (flag) {
            a = Arrays.copyOf(a, len - 1);
            temp++;
            System.out.println("以删除个数:" + temp + ",a[]=" + Arrays.toString(a));
            del(del, temp, a);
        } else {
            System.out.println("已经删除完成！");
        }
    }

    /**
     * 删除数组区间元素
     *
     * @param mix
     * @param max
     * @param temp
     * @param a
     */
    public static void qjdel(int mix, int max, int temp, int a[]) {
        int len = a.length;
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            if (a[i] >= mix && a[i] <= max) {
                a[i] = a[len - 1];
                flag = true;
                break;
            }
        }
        if (flag) {
            a = Arrays.copyOf(a, len - 1);
            temp++;
            System.out.println("以删除个数:" + temp + ",a[]=" + Arrays.toString(a));
            qjdel(mix, max, temp, a);
        } else {
            System.out.println("已删除完成！");
        }
    }

    /**
     * 创建一个数组，存储100之间的素数
     */
    public static void demo9() {
        int len = 100;
        boolean flag;
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= 100; i++) {
            flag = false;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(i);
            }
        }
        int num = list.size();
        int a[] = new int[num];
        int temp = 0;
        for (Integer i : list) {
            a[temp] = i;
            temp++;
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 数组元素的排序（冒泡，快速，插入，选择，希尔，堆排序，桶排序，归并排序，递归..）
     */
    public static void demo10() {//冒泡排序(比较相邻两个元素，小的放前面，大的放后面，依次)
        int a[] = {5, 3, 6, 2, 7, 8, 54, 7, 43, 74, 3, 1};
        Arrays.sort(a);
        int len = a.length;
        int temp;
        for (int i = 0; i < len - 1; i++) {//控制排序次数
            temp = 0;
            for (int j = 0; j < len - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 快速排序法
     * 先以第一个为中间值，将比中间值小的放在左边，大得放在右边；然后二分左右，按该方法依次排下去
     */
    public static void demo102() {
        int a[] = {23, 3, 6, 8, 2, 1, 62, 4, 54, 6, 43, 24};
        quicksort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public static void quicksort(int a[], int left, int right) {
        int point;
        if (left < right) {
            point = partition(a, left, right);
            quicksort(a, left, point - 1);
            quicksort(a, point + 1, right);
        }
    }

    public static int partition(int a[], int left, int right) {
        int key = a[left];//以数组第一个值为基准
        while (left < right) {
            while (left < right && a[right] >= key) {//从右向左，直到找到比key小得数
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= key) {//从左向右，直到找到比key大得数
                left++;
            }
            a[right] = a[left];
        }
        a[left] = key;
        System.out.println("左key+" + key + ",left=" + left + ",right=" + right + ",a[left]=" + a[left] + ",a[right]=" + a[right] + ",a[]=" + Arrays.toString(a));
        return left;
    }

    /**
     * 插入排序
     * 依次把该元素插入到相应得位置
     */
    public static void demo103() {
        int a[] = {23, 3, 6, 8, 2, 1, 62, 4, 54, 6, 43, 24};
        int len = a.length;
        int temp;
        for (int i = 1; i < len; i++) {//控制循环次数
            for (int j = i; j > 0; j--) {//依次向前插入
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 选择排序
     * 依次选择最小或最大得数排序
     */
    public static void demo104() {
        int a[] = {23, 3, 6, 8, 2, 1, 62, 4, 54, 6, 43, 24};
        int len = a.length;
        int leni = len - 1;
        for (int i = 0; i < leni; i++) {//控制循环次数
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;//记录最小元素下标
                }
            }
            if (minIndex != i) {
                a[i] = a[i] ^ a[minIndex];
                a[minIndex] = a[i] ^ a[minIndex];
                a[i] = a[i] ^ a[minIndex];
            }
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 希尔排序
     * 首先确定一个间隔长度，将每个间隔长度的元素进行排序，最后在缩短间距
     */
    public static void demo105() {
        int a[] = {23, 3, 6, 8, 2, 1, 62, 4, 54, 6, 43, 24};
        int len = a.length;
        int gap = len / 2;
        while (gap > 0) {//控制间隔长度
            for (int i = gap; i < len; i++) {//控制每次排序元素的长度
                int j = i;
                while (i >= gap && a[i] < a[i - gap]) {
                    a[i] = a[i] + a[i - gap];
                    a[i - gap] = a[i] - a[i - gap];
                    a[i] = a[i] - a[i - gap];
                    i -= gap;
                }
            }
            gap /= 2;
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 堆排序(完全二叉树:除了最后一列，其他为全满状态)
     */
    public static void demo106() {
        int a[] = {23, 3, 6, 8, 2, 1, 62, 4, 54, 6, 43, 24};
        //构建大顶堆
        for (int i = a.length / 2 - 1; i >= 0; i--) {//从第一个非子叶点，从上到下，从左到右排序
            adjustHead(a, i, a.length);
        }
        //调整堆顶结构，交换顶节点与末尾节点位置
        for (int i = a.length - 1; i > 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustHead(a, 0, i);//重新对堆进行调整
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 调整对顶结构
     */
    public static void adjustHead(int a[], int i, int length) {
        int temp = a[i];
        for (int j = i * 2 + 1; j < length; j = i * 2 + 1) {//开始从左节点进行调整
            if (j + 1 < length && a[j] < a[j + 1]) {//如果左节点小于父指节点，指向右指节点
                j++;
            }
            if (a[j] > temp) {//如果左节点大于父节点，将左节点给父节点
                a[i] = a[j];
                i = j;
            } else {
                break;
            }
        }
        a[i] = temp;//将父节点复值到对应位置
    }

    public static void demo11() {
        String username[] = {"张三", "李四", "王五", "李四"};
        String password[] = {"123", "456", "789", "234"};
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String usernames = input.nextLine();
        System.out.println("请输入密码：");
        String passwords = input.nextLine();
        int lenname = username.length;
        boolean flag = false;
        for (int i = 0; i < lenname; i++) {
            if (usernames.equals(username[i])) {
                if (passwords.equals(password[i])) {
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("登录成功！");
        } else {
            System.out.println("用户名或密码错误！");
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        demo1();
//        demo2();
//        demo3();
//        demo4();
//        demo5();
//        demo6();
//        demo7();

//        int a[] = {4,5,2,1,8,63,0,2,5,4,78};
//        demo8(a);

//        demo9();

//        demo10();
//        demo102();
//        demo103();
//        demo104();

//        demo105();
//        demo106();
        demo11();
        System.out.println("消耗时长：" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
