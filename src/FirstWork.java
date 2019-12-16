public class FirstWork {
    /**
     *运算符
     * @param
     */
    public static void yunshuan(){
        int a = 0,b = 0;
        boolean t = a+++a+++b+++a>b;
        a = 0;b = 0;
        int i = a+++a+++b+++a>b?a:b;
        System.out.println(t);
        System.out.println(i);

        System.out.println("------a+=b与a=a+b区别---------");
        a = 0;b = 0;
        a+=b;
        System.out.println("a+=b:"+a);
        a = 0;b = 0;
        a=a+b;
        System.out.println("a=a+b:"+a);

        System.out.println("--------循环----------");
        a = 1;
        for(int j=0;j<100;j++){
            a=a++;
        }
        System.out.println("a="+a);
    }

    public static void main(String[] args){
        yunshuan();
    }
}
