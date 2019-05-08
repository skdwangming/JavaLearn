/**
 * 懒汉式:
 *      1、懒加载
 *      2、不适用多线程
 *      3、不常用
 */
public class Singleton2 {
    private Singleton2(){}

    private static Singleton2 instance;

    public static Singleton2 getInstance(){ // 添加synchronized实现线程安全
        if (instance == null){
            return new Singleton2();
        }else{
            return instance;
        }
    }
}
