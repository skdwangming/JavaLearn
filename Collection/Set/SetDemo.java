import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;


public class SetDemo {
    /**
     * 初始化时，其实是创建了一个HashMap，将需要存储的值放在key，value是一个Object。
     * 常用的方法都是使用的HashMap的方法
     */
    @Test
    public void hashSetDemo(){
        HashSet<String> strings = new HashSet<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("watermelon");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }

    /**
     * 根据插入顺序，迭代输出
     */
    @Test
    public void linkedHashSet(){
        LinkedHashSet<String> strings = new LinkedHashSet<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("watermelon");
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }

}
