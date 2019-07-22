import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Array初始化时需要声明长度，不可变，只能存储一种数据类型
 * ArrayList是一个集合，可以存储不同数据类型的数据，长度可变
 * <p>
 * 不同点：
 * 1、实现：ArrayList的内部是由Array实现的
 * 2、类型安全：ArrayList支持泛型，可以在编译时检查类型是否正确。Array不支持泛型， 所以会抛出异常。
 * 3、灵活性：ArrayList比较灵活，可以增加、删除
 * 4、基本类型：ArrayList不支持基本数据类型，但支持包装类
 * 5、迭代：ArrayList支持Iterator
 */
public class ArrayDemo {

    public static void main(String[] args) {
        //两种创建数组的方式
        String[] array = new String[3];
        String[] array2 = {"A", "B", "C"};

        //增删改查
        array[0] = "D";
        array[1] = "E";
    }

    /**
     * 编译器在编译时只会检测类型之间是否含有继承关系，有则通过。运行时才会检查它的真实类型。
     *
     * 所以在继承时，子类可以自动转型为父类，但父类强制转换为子类时，只有引用类型的真实身份是子类时，才可以转换成功。
     *
     */
    @Test
    public void test() {
        Object obj = new Object();
        ArrayList list = (ArrayList) obj;//不能直接向下转型

        Object list2 = new ArrayList<>();
        ArrayList list3 = (ArrayList) list2;//可以向下转型
    }
}
