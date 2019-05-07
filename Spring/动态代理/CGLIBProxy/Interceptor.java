package CGLIBProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Interceptor implements MethodInterceptor {

    private Object target;
    private Transaction transaction;

    public Interceptor(Object target, Transaction transaction) {
        this.target = target;
        this.transaction = transaction;
    }

    public Object createProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(target.getClass());
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        this.transaction.beginTransaction();
        method.invoke(target);
        this.transaction.commit();
        return null;
    }
}
