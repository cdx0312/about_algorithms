package tmp;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by cdx0312
 * 2018/3/30
 */
public class TimeHandler implements InvocationHandler{

    private Object target;

    public TimeHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("time start!");
        method.invoke(target);
        System.out.println("time end!");
        return null;
    }
}
