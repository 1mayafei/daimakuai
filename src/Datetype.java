import java.math.BigDecimal;

public class Datetype {
    static byte b;
    static short s;
    static int i;
    static Integer in;//int的包装类；
    static long l;
    static char c;
    static float f;
    static double d;
    static boolean bl;
    static BigDecimal big;
    public static void main(String[] args){
        System.out.println(BigDecimal.ROUND_UNNECESSARY);
        System.out.println("byte的大小："+Byte.SIZE+" ，默认值："+b+" ,范围："+Byte.MIN_VALUE+"->"+Byte.MAX_VALUE);
        System.out.println("short的大小："+Short.SIZE+" ，默认值："+s+" ,范围："+Short.MIN_VALUE+"->"+Short.MAX_VALUE);
        System.out.println("int的大小："+Integer.SIZE+" ，默认值："+i+" ,范围："+Integer.MIN_VALUE+"->"+Integer.MAX_VALUE);
        System.out.println("Integer默认值："+in);
        System.out.println("long的大小："+Long.SIZE+" ，默认值："+l+" ,范围："+Long.MIN_VALUE+"->"+Long.MAX_VALUE);
        System.out.println("char的大小："+Character.SIZE+" ，默认值："+c+" ,范围："+Character.MIN_VALUE+"->"+Character.MAX_VALUE);
        System.out.println("float的大小："+Float.SIZE+" ，默认值："+f+" ,范围："+Float.MIN_VALUE+"->"+Float.MAX_VALUE);
        System.out.println("double的大小："+Double.SIZE+" ，默认值："+d+" ,范围："+Double.MIN_VALUE+"->"+Double.MAX_VALUE);
        System.out.println("boolean的大小："+Byte.SIZE+" ，默认值："+bl+" ,范围："+Byte.MIN_VALUE+"->"+Byte.MAX_VALUE);

        System.out.println("-------int和Integer区别--------");
        //对象是一些API类中的对象，“==”比较的是地址值是否相等，而equals()比较的是内容是否相等。
        //由于Integer变量实际上是对一个Integer对象的引用，所以两个通过new生成的Integer变量永远是不相等的（因为new生成的是两个对象，其内存地址不同）。
        Integer in = new Integer(100);
        Integer inr = new Integer(100);
        System.out.println("Interget地址比较："+(in==inr));
        System.out.println("Integer内容比较："+in.equals(inr));
        Integer i = 1000;
        Integer j = 1000;
        System.out.println("Integet地址比较："+(i==j));//若值范围在-128到127之间，i==j输出true
        System.out.println("Integer内容比较："+i.equals(j));

        Integer integer = new Integer(144);
        Integer integer1 = 144;//编译后：Integer integer1 = Integer.valueOf(144);
        //new Integer()生成的变量和非new生成的Integer变量比较“==”永远为false；
        //因为非new生成的Integer变量指向的是java常量池中的对象，而new Integer()生成的变量指向堆中新建的对象，两者在内存中的地址不同。
        System.out.println("new一个Integer和直接Integer赋值比较："+(integer==integer1));
        System.out.println("new一个Integer和直接Integer赋值比较："+(integer.equals(integer1)));

        //包装类Integer和基本数据类型int比较时，java会自动拆包装为int，然后进行比较，实际上就变为两个int变量的比较。
        Integer il = 1000;
        int is = 1000;
        System.out.println("Integet与int比较：" +(il==is));
        System.out.println("Integer与int比较："+il.equals(is));
        //如果比较的是基本类型，则比较的是变量的数值是否相等
        System.out.println("--------基本类型比较---------");
        int zs = 100;
        int lishi = 100;
        System.out.println(zs == lishi);
    }
}
