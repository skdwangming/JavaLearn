package CGLIBProxy;

/**
 * 1、生成的代理类是目标类的子类
 * 2、不需要接口
 * 3、生成的代理类重写了父类的各个方法
 */
public class TestCGLIBProxy {
    public static void main(String[] args) {
        Object target = new PersonDaoImpl();
        Transaction transaction = new Transaction();
        Interceptor interceptor = new Interceptor(target, transaction);
        PersonDaoImpl personDaoImpl = (PersonDaoImpl) interceptor.createProxy();
        personDaoImpl.savePerson();
    }
}
