import HashMap.HashMapDemo;
import org.junit.Test;

import java.util.HashSet;

/**
 * 初始化时，其实是创建了一个HashMap，将需要存储的值放在key，value是一个Object。
 * 常用的方法都是使用的HashMap的方法
 */
public class HashSetDemo {
    @Test
    public void test1(){
        HashSet<String> strings = new HashSet<>();
        strings.add("A");
        strings.add("B");
    }

}
