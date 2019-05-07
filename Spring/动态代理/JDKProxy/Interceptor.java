package JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Interceptor implements InvocationHandler {

    private Object target;
    private Transaction transaction;

    public Interceptor(Object target, Transaction transaction) {
        this.target = target;
        this.transaction = transaction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.transaction.beginTransaction();
        method.invoke(target);
        this.transaction.commit();
        return null;
    }
}
