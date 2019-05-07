/**
 * Array初始化时需要声明长度，不可变，只能存储一种数据类型
 * ArrayList是一个集合，可以存储不同数据类型的数据，长度可变
 *
 * 不同点：
 *      1、实现：ArrayList的内部是由Array实现的
 *      2、类型安全：ArrayList支持泛型，可以在编译时检查类型是否正确。Array不支持泛型， 所以会抛出异常。
 *      3、灵活性：ArrayList比较灵活，可以增加、删除
 *      4、基本类型：ArrayList不支持基本数据类型，但支持包装类
 *      5、迭代：ArrayList支持Iterator
 *
 *
 */
public class ArrayDemo {

    public static void main(String[] args) {
        //两种创建数组的方式
        String[] array = new String[3];
        String[] array2 = {"A","B","C"};

        //增删改查
        array[0] = "D";
        array[1] = "E";
    }
}
