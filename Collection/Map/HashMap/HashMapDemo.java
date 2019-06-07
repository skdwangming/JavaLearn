package HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * HashMap原理
 * 		初始化时，默认创建16长度的的数组，加载因子0.75。
 * 		put：先通过hash方法计算key的hash值，然后根据数组长度取余得到存储索引，如果该位置已经有值，
 * 			则循环对比该位置以及next关联的值，如果hash、值、地址，全部相等则覆盖value，
 * 			否则将该位置的元素替换为刚才put的元素，然后将next指向之前的元素。
 * 		get：根据key的hash值计算索引位置，循环该位置的数据，如果相同则取出value
 * 		rehash：当元素个数大于长度*加载因子时，数组长度会翻倍，然后重新计算每个元素位置，然后放进去，十分消耗性能。
 * 		hashCode()方法的实现原理：
 * 			在Object中是一个native方法，由c实现的。HashMap中的hash（）方法，
 * 			先调用了传入对象的hashCode（）方法，然后采用位运算符的方式，分散数据存储的位置。
 *
 *
 * 	* hashCode（）方法与equals（）方法
 *      为什么要重写这两个方法？
 *          Object中的hashCode方法，用的是native关键字修饰，说明是用c/c++实现的，在不同操作系统实现是不一样的。
 *          java程序运行时，无论何时多次调用同一个对象的hashCode（）方法，返回的值必须相同
 *          如果两个对象equals（）返回true，则hashCode（）方法必须返回相同的数值
 *          如果两个对象equals（）返回false，则hashCode（）方法必须返回不同的值
 *          所以重写equals（）方法后，必须重写hashCode（）方法
 *      什么情况需要重写？
 *          自定义的一个类，需要存放在集合中时，需要重写，集合有两种List、Set
 */
public class HashMapDemo {
    public static void main(String[] args) {

        HashMap<String, String> hm = new HashMap<>();
        hm.put("","wangming");
//        hm.put("sex","man");
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            String s = hm.get(next);
            System.out.println(s);
        }
    }

}
