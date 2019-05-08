/**
 * 饿汉式
 *      1、类初始化时就创建对象
 *      2、没有实现懒加载
 *      3、线程安全
 */
public class Singleton {
    private final static Singleton instance = new Singleton();
    private Singleton(){
    }
    public static Singleton getInstance(){
        return instance;
    }
}
