package JDKProxy;

import java.lang.reflect.Proxy;

/**
 * 1、目标类必须实现接口
 * 2、功能比较单一，一般只能处理事务
 */
public class TestJDKProxy {
    public static void main(String[] args) {
        Object target = new PersonDaoImpl();
        Transaction transaction = new Transaction();
        Interceptor interceptor = new Interceptor(target, transaction);
        PersonDao personDao = (PersonDao)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), interceptor);
        personDao.savePerson();
    }
}
