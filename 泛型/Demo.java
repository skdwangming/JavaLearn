/**
 * 泛型：泛指的类型
 * 例子：public class ArrayList<E> extends AbstractList<E>
 * 特点：
 *      1、不支持基本数据类型
 * 通配符
 *      上界通配符：<? extends T>
 *      下界通配符：<? super T>
 * @param <T>
 */
public class Demo<T> {
    T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public static void main(String[] args) {
        Demo<String> stringDemo = new Demo<>();
        stringDemo.setT("字符串");
        String t = stringDemo.getT();
        System.out.println(t);
    }
}
