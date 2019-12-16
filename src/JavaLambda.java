import java.util.Arrays;
import java.util.Comparator;

public class JavaLambda {
    public static void main(String[] args){
        String[] strarr = {"ma","ya","fei","zhen","shuai"};
        //传统方法（匿名内部类）
        Arrays.sort(strarr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(),o1.length());
            }
        });
        for(String s:strarr){
            System.out.println(s);
        }
        System.out.println("-----------------------");
        //lambda表达式
        Arrays.sort(strarr,(o1,o2)->Integer.compare(o2.length(),o1.length()));
        for(String s:strarr){
            System.out.println(s);
        }
    }
}
